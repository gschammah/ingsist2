package ar.edu.uade.ingsoft.model;

import java.util.ArrayList;
import java.util.List;

import server.VO.articulos.ArticuloVO;

public class DataProvider {

	public static DataProvider INSTANCE = new DataProvider();
	
	private List<ArticuloVO> articulos = new ArrayList<ArticuloVO>();
	
	public List<ArticuloVO> getArticulos() {
	    return articulos;
	}
	
	public void addArticulo(ArticuloVO a) {
        articulos.add(a);
    }
}
