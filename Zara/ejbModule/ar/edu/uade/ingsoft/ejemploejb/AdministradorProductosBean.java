/*
 * Ingenieria de Sistemas II - 1C2009
 * Marzo/2009
 * 
 * Ejercicio 14 - Persistencia simple (servidor)
 *  
 */

package ar.edu.uade.ingsoft.ejemploejb;

import java.util.Hashtable;
import java.util.List;
import java.util.Vector;

import javax.annotation.PostConstruct;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import ar.edu.uade.ingsoft.entidades.Producto;
import ar.edu.uade.ingsoft.utils.ProductoVO;

/**
 * Bean Stateful que administra productos
 *
 */
@Stateful
public  class AdministradorProductosBean implements AdministradorProductos {

	@PersistenceContext(unitName="AdministradorProductos")
	private EntityManager manager; 
	
	Producto[] listaProductos;
	
	public void inicializarListaProductos() {
		listaProductos = new Producto[5];
		listaProductos[0]= new Producto(1,"MICRO.PHILCO AMP-80","PHILCO","Rep. CD, CD-R/RW. Radio AM/FM estéreo digital. Función X-BASS. Display LCD. Control remoto",40,259);
		listaProductos[1]= new Producto(2,"MICRO.WATSON SJ-1906 CD DIGITAL", "WATSON", "Reproduce CD-R/RW. Radio digital AM/FM. Función Bass Boost. Cassettera. Control remoto",88, 299);
		listaProductos[2]= new Producto(3,"MICRO.AKAI QX-D3500", "AKAI", "Potencia de 1000w / 5 x 2 w RMS. Carga superior de CD. Pantalla LCD. Reproductor de CD-R/RW. Memoria de CD programable (20). Radio digital. Control remoto.", 25, 359);
		listaProductos[3]= new Producto(4,"MICRO.ADMIRAL SJ1909 MP3CD DIG","ADMIRAL","Reproduce MP3. Lee CD-R / CD-RW. 3 modos de pre sintonía. Cassettera con auto stop. Control remoto full.",48,379);
		listaProductos[4]= new Producto(5,"MICRO.HITACHI CX-350","HITACHI", "Reproduce CD/CD-R. Bass Boost. Sistema dinámico reforzador de bajos. Sintonizador AM/FM Stereo Digital. Memoria p/ 20 estaciones. Control remoto full.",39,399);
		manager.persist(listaProductos[0]);
		manager.persist(listaProductos[1]);
		manager.persist(listaProductos[2]);
		manager.persist(listaProductos[3]);
		manager.persist(listaProductos[4]);
	}

	public void setStock(ProductoVO pr){
		Producto p = manager.find(Producto.class, pr.getProductoId());
		p.setVO(pr);
		manager.persist(p);
	} 

	public Vector getListaProductos() {
		if (listaProductos == null)
			inicializarListaProductos();
		Vector aux = new Vector();
		Query q = manager.createQuery("SELECT a FROM Producto a");
		List l = q.getResultList();
		for (int i=0; i< l.size(); i++){
			aux.addElement(((Producto)l.get(i)).getVO());
		}
		return aux; 
	}
}
