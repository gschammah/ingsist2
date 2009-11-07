package ar.edu.uade.ingsoft.servlets;

import java.io.IOException;
import java.util.Collection;
import java.util.Date;

import javax.naming.NamingException;
import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import server.VO.PALC.ItemPALCVO;
import server.VO.PALC.PALCVO;
import server.VO.PALC.PalcPropuestoVO;
import tools.WSPalc;
import tools.ParseXML;
import ar.edu.uade.ingsoft.model.ZaraModel;

 public class PalcServlet extends HttpServlet implements Servlet {

	private static final long serialVersionUID = 1L;

	private ZaraModel modelo;
	private String pagina;
	
	public PalcServlet() {
		super();
	}   	
	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		super.init(config);
		try {
			modelo = new ZaraModel();
			
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		HttpSession ses = req.getSession(true);
		Collection<PalcPropuestoVO> palc = (Collection<PalcPropuestoVO>) ses.getAttribute("palc");
		
		if (req.getParameter("xml") == null && req.getParameter("enviar") == null) {
			palc = modelo.getFachada().getPALC();
			ses.setAttribute("palc", palc);
			pagina = "/palc.jsp";
		} 
		//JMS
		else if (req.getParameter("enviar") != null) {
			PALCVO pvo = (PALCVO) ses.getAttribute("pvo");
			String mensaje = null;
			try {
				WSPalc.enviarPalc(ParseXML.generaPALC(pvo));
				mensaje = "Se ha enviado correctamente el PALC";
			} catch (Exception e) {
				// TODO Auto-generated catch block
				mensaje = "Se ha producido un error al enviar el PALC";
			}
			req.setAttribute("mensaje", mensaje);
			pagina = "/palc_ok.jsp";
		}
		//XML
		else {						
			resp.setHeader("Content-Disposition", "attachment; filename=palc.xml" );
			pagina = "/palc_xml.jsp";
			PALCVO pvo = (PALCVO) ses.getAttribute("pvo");
			try {
				req.setAttribute("xml", ParseXML.generaPALC(pvo));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} 																		
		
	  muestraPagina(req, resp);

	}  	
	
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession ses = req.getSession(true);
		Collection<PalcPropuestoVO> palc = (Collection<PalcPropuestoVO>) ses.getAttribute("palc");
		
		if (req.getParameter("agregar") != null) {
			
			
			boolean existe = false;
			
			
			long referencia;
			try {
				referencia = new Long(req.getParameter("referencia"));
			
			
			PalcPropuestoVO nuevo = modelo.getFachada().getPALC(referencia);
			
			if (nuevo != null) {															
				
				for (PalcPropuestoVO item : palc) {
					if (item.getArticulo().getReferencia() == nuevo.getArticulo().getReferencia()) {
						existe = true;
					}											
				}
				
				if (!existe) {
					palc.add(nuevo);
				}else{
					req.setAttribute("error", "El articulo ya figura en la lista");
				}
				
				
												
			} 
			  else if (nuevo == null)	
			{
				req.setAttribute("error", "El artículo ingresado no existe");
			}
			
			} catch (NumberFormatException e) {
				req.setAttribute("error", "Referencia no valida");
				e.printStackTrace();
			}
			

			ses.setAttribute("palc", palc);
			req.setAttribute("palc", palc);	
			pagina = "/palc.jsp";
			
		}
		if (req.getParameter("confirmar") != null) {
								
				PALCVO pvo = new PALCVO();
				pvo.setEstado("Emitido");
				pvo.setFecha(new Date());
								
				for ( PalcPropuestoVO item : palc){
					
					if (req.getParameter(((Long)item.getArticulo().getReferencia()).toString()) != null) {
					ItemPALCVO itemp = new ItemPALCVO();
					itemp.setCantidadSolicitada(Integer.parseInt(req.getParameter(((Long)item.getArticulo().getReferencia()).toString())));
					itemp.setArticulo(item.getArticulo());									
					pvo.addItem(itemp);
					}
				}
				modelo.getFachada().registraPALC(pvo);
								
				ses.setAttribute("pvo", pvo);
				ses.setAttribute("palc", palc);
				req.setAttribute("lista", pvo.getArticulos());
				
				pagina = "/confirmaPalc.jsp";				
		}		
		
		muestraPagina(req, resp);
		
	}   	  	    
	
	private void muestraPagina(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{		
		getServletConfig().getServletContext().getRequestDispatcher(pagina).forward(req, res);
	}
}