/*
 * Ingenieria de Sistemas II - 1C2009
 * Marzo/2009
 * 
 * Ejercicio 14 - Persistencia simple (cliente)
 *  
 */
package aplicProductos.modelos;

import framework.modeloCliente.*;

import java.util.*;

import javax.naming.Context;
import javax.naming.InitialContext;

import ar.edu.uade.ingsoft.ejemploejb.AdministradorProductos;
import ar.edu.uade.ingsoft.utils.ProductoVO;


 
public class ProxyModeloAdmProductos extends ProxyModelo {
	private AdministradorProductos modServidor;
	private Vector listaProductos;
	private ProductoVO productoVisible;
	
	public ProxyModeloAdmProductos(){
		super(); 
		getConnection();
	}
	
	public void setStock(String prod, int st){
		productoVisible.setStock(st);
		modServidor.setStock(productoVisible);
    } 

	public int getStock(String prod){
		return productoVisible.getStock();
	}
 
	public Vector getListaNombresProductos() {
		listaProductos = modServidor.getListaProductos();
		Vector listaNombres = new Vector();
		for (int i=0; i<listaProductos.size(); i++) {
			listaNombres.add(((ProductoVO)(listaProductos.elementAt(i))).getNombre());
		};
		productoVisible = (ProductoVO) listaProductos.elementAt(0);
		return listaNombres;
	}
	
	public String getDetallesProducto(String prod) {
		return productoVisible.getDetalles();
	}

	public void setProductoVisible(String prod) {
		ProductoVO aux;
		for (int i=0; i<listaProductos.size(); i++) {
			aux = (ProductoVO)listaProductos.elementAt(i);
			if (aux.getNombre().equals(prod)){
				productoVisible = aux;
				return; 
			}
		}
	}
	
    protected void getConnection() {
        try {
        	InitialContext initContext;
        	
        	//Context jndiContext = getInitialContext();
			Hashtable props = new Hashtable();
			props.put(InitialContext.INITIAL_CONTEXT_FACTORY,"org.jnp.interfaces.NamingContextFactory");
			//Url completa de ubicacion del servidor de aplicaciones
			props.put(InitialContext.PROVIDER_URL,"jnp://127.0.0.1:1099");
			//Objeto del tipo InitialContext
			initContext = new InitialContext(props);

			modServidor = (AdministradorProductos)initContext.lookup("ZaraEAR/AdministradorProductosBean/remote");
        } catch (Exception e) {
        	e.printStackTrace(); 
        }
    }    
	 
    private static Context getInitialContext() throws javax.naming.NamingException {
        return new javax.naming.InitialContext();
    }

}