package ar.edu.uade.ingsoft.servlets;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import server.VO.articulos.ArticuloVO;
import server.VO.clientes.ClienteVO;
import server.VO.ventas.ItemVentaVO;
import server.VO.ventas.VentaVO;
import ar.edu.uade.ingsoft.model.DatosT;
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
	  } else if (req.getParameter("cmd") != null && req.getParameter("cmd").equals("precio")) {
		  long ref = new Long(req.getParameter("ref"));
		  int oferta = new Integer(req.getParameter("checked"));
		  
		  for (ItemVentaVO item : articulos) {
			  if (item.getArticulo().getReferencia() == ref) {
				  if (oferta == 1) { 
					  item.setPrecio(item.getArticulo().getPrecioOferta());					  
				  } else {
					  item.setPrecio(item.getArticulo().getPrecioLista());					  
				  }
				  req.setAttribute("currentArt", item.getArticulo());				  				 
			  }
		  }
		  ses.setAttribute("articulos", articulos);
	  } else if (req.getParameterMap().size() == 0) {
		  ses.removeAttribute("articulos");
		  articulos = null;
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
			
			long referencia = 0; 
			int cant;
			
			try {
				cant = new Integer(req.getParameter("cantidad"));
				referencia = new Long(req.getParameter("referencia"));				
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
						
		} else if (req.getParameter("generar") != null) {
			
			try {
			
			String cuit = req.getParameter("cuit");
			char tipoFact = req.getParameter("tipoFact").charAt(0);
			SimpleDateFormat format = new SimpleDateFormat("dd/mm/yyyy");
			Date fecha = format.parse(req.getParameter("fecha"));
			String cli = req.getParameter("cliente");
			String razon = req.getParameter("razonSocial");
			String direccion = req.getParameter("direccion");
			
			DatosT total = this.getTotal(req, res);
			
			VentaVO venta = new VentaVO();
			ClienteVO cliente = new ClienteVO();
			cliente.setCuit(cuit);
			cliente.setDireccion(direccion);
			cliente.setNombre(cli);
			cliente.setRazonSocial(razon);
			venta.setCliente(cliente);
			venta.setTotal(total.getTotal());
			venta.setSubTotal(total.getSubTotal());
			venta.setIva(total.getIva());					
			venta.setFecha(fecha);
			venta.setTipoFactura(tipoFact);
			venta.setItems(articulos);
			
			modelo.getFachada().nuevaVenta(venta);
			
			req.setAttribute("venta", venta);
			
			} catch (Exception e) {
				e.printStackTrace();
			}
			getServletConfig().getServletContext().getRequestDispatcher("/factura.jsp").forward(req, res);
			
		}				
	}
	
	private void muestraPagina(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
														
		req.setAttribute("total", this.getTotal(req, res));
		
		String pagina = (req.getParameter("json") != null) ? "/ventas_ajax.jsp" : "/ventas.jsp";		
		getServletConfig().getServletContext().getRequestDispatcher(pagina).forward(req, res);
	}

	private DatosT getTotal(HttpServletRequest req, HttpServletResponse res) {
		HttpSession ses = req.getSession(true);
		Collection<ItemVentaVO> articulos = (Collection<ItemVentaVO>) ses.getAttribute("articulos");
		DatosT total = new DatosT();		
		
		if (articulos != null) {
			for (ItemVentaVO item : articulos) {
				float actual = (item.getPrecio() * item.getCantidad());
				float nuevo, iva = 0;
				
				if (req.getParameter("tipoFact") != null && req.getParameter("tipoFact").equals("A")) {
					nuevo = (float) (actual / 1.21);
					iva = actual - nuevo;					
				} else {
					nuevo = actual;
				}
				
				total.setSubTotal(nuevo + total.getSubTotal());
				total.setIva(iva + total.getIva());
			}
		}
		
		total.setTotal(total.getSubTotal() + total.getIva());
		return total;
	}
}