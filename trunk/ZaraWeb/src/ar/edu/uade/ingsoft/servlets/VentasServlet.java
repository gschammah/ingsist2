package ar.edu.uade.ingsoft.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import server.VO.EnvT.ItemEnvTVO;
import server.VO.articulos.ArticuloVO;
import server.VO.ventas.ItemVentaVO;
import server.entidades.EnvT.ItemEnvT;
import ar.edu.uade.ingsoft.model.ZaraModel;

 public class VentasServlet extends HttpServlet implements Servlet {

	private static final long serialVersionUID = 1L;
	private ZaraModel modelo; 

	public VentasServlet() {
		super();
	}
	
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		
		try {
			modelo = new ZaraModel();

		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
			  
	  HttpSession ses = req.getSession(true);
	  Collection<ItemVentaVO> articulos = (Collection<ItemVentaVO>) ses.getAttribute("articulos");
	  
	  //borro el articulo si tengo este parametro
	  if (req.getParameter("cmd") != null && req.getParameter("cmd").equals("del") && articulos != null) {
		  int id = new Integer (req.getParameter("id"));
		  ItemVentaVO itemD = null;
		  
		  for (ItemVentaVO item : articulos) {
			  if (item.getArticulo().getReferencia() == id) {
				  itemD = item;
			  }
		  }
		  
		  if (itemD != null) {
			  articulos.remove(itemD);
			  ses.setAttribute("articulos", articulos);			  
		  }		  
	  }
	  req.setAttribute("articulos", articulos);
	  muestraPagina(req, res);

	}  	
	
	
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		boolean flag = false;
		boolean hayStock = true;
		
		HttpSession ses = req.getSession(true);
		Collection<ItemVentaVO> articulos = (Collection<ItemVentaVO>) ses.getAttribute("articulos");
		
		if (articulos == null) {
			articulos = new ArrayList<ItemVentaVO>();
		}
		
		if (req.getParameter("agregar") != null) {
			
			long referencia = new Long(req.getParameter("referencia"));
			int cant;
			
			try {
				cant = new Integer(req.getParameter("cantidad"));
			} catch (Exception e) {
				cant = -1;				
			}
			ArticuloVO art = modelo.getFachada().buscarArticuloVO(referencia);
			
			if (art != null && cant > -1) {															
				
				for (ItemVentaVO item : articulos) {
					if (item.getArticulo().getReferencia() == art.getReferencia()) {
						if (item.getArticulo().getStock() - item.getCantidad() - cant >= 0) {
							item.setCantidad(item.getCantidad() + cant);
							flag = true;						
						} else {
							flag = true;
							hayStock = false;
						}
					}											
				}
				
				if (!flag) {
					if (art.getStock() - cant >= 0) {
						ItemVentaVO i = new ItemVentaVO();
						i.setArticulo(art);
						i.setCantidad(cant);
						i.setPrecio(art.getPrecioLista());
						articulos.add(i);
					} else {
						hayStock = false;
					}
				}
				
				req.setAttribute("currentArt", art);
												
			} else if (cant == -1) {			
				req.setAttribute("error", "Por favor ingrese una cantidad válida");
			}
			  else if (art == null)	
			{
				req.setAttribute("error", "El artículo ingresado no existe");
			}
			
			if (!hayStock) {
				req.setAttribute("error", "No hay stock para el artículo seleccionado");
			}
			
			ses.setAttribute("articulos", articulos);
			req.setAttribute("articulos", articulos);
			
			muestraPagina(req, res);
		}		
	}
	
	private void muestraPagina(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
		String pagina = "/ventas.jsp";
		getServletConfig().getServletContext().getRequestDispatcher(pagina).forward(req, res);
	}
}