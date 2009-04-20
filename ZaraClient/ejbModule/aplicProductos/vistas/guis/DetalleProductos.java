/*
 * Ingenieria de Sistemas II - 1C2009
 * Marzo/2009
 * 
 * Ejercicio 14 - Persistencia simple (cliente)
 *  
 */
package aplicProductos.vistas.guis;

import javax.swing.JPanel;
import java.awt.GraphicsConfiguration;
import java.awt.HeadlessException;

import javax.swing.JFrame;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;

import aplicProductos.vistas.*;
import aplicProductos.modelos.*;
import aplicProductos.controladores.*;

import java.util.Vector;

public class DetalleProductos extends JFrame {

	private JPanel jContentPane = null;
	private JComboBox comboProductos = null;
	private JLabel labelProductos = null;
	private JLabel labelStock = null;
	private JTextField textStock = null;
	private JButton buttonDetalles = null;
	private JTextArea areaProducto = null;
	private VistaAdmProductos vistaPadre = null;
	
	private boolean detalles = false; 
	 
	public DetalleProductos(VistaAdmProductos vap) throws HeadlessException {
		super();
		// TODO Auto-generated constructor stub
		vistaPadre = vap;
		initialize();
	}

	public DetalleProductos(GraphicsConfiguration arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
		initialize();
	}

	public DetalleProductos(String arg0) throws HeadlessException {
		super(arg0);
		// TODO Auto-generated constructor stub
		initialize();
	}

	public DetalleProductos(String arg0, GraphicsConfiguration arg1) {
		super(arg0, arg1);
		// TODO Auto-generated constructor stub
		initialize();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(364, 242);
		this.setPreferredSize(new java.awt.Dimension(364,242));
		this.setMinimumSize(new java.awt.Dimension(364,242));
		this.setMaximumSize(new java.awt.Dimension(364,242));
		this.setContentPane(getJContentPane());
		this.setTitle("Información de Productos");
	}

	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			labelStock = new JLabel();
			labelStock.setBounds(new java.awt.Rectangle(224,30,54,26));
			labelStock.setText("Stock:");
			labelProductos = new JLabel();
			labelProductos.setBounds(new java.awt.Rectangle(15,5,108,24));
			labelProductos.setText("Producto:");
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			jContentPane.add(getComboProductos(), null);
			jContentPane.add(labelProductos, null);
			jContentPane.add(labelStock, null);
			jContentPane.add(getTextStock(), null);
			jContentPane.add(getButtonDetalles(), null);
			jContentPane.add(getAreaProducto(), null);
		} 
		return jContentPane;
	}

	/**
	 * This method initializes comboProductos	
	 * 	
	 * @return javax.swing.JComboBox	
	 */
	private JComboBox getComboProductos() {
		if (comboProductos == null) {
			Vector prods = ((ProxyModeloAdmProductos)(this.getVistaPadre().getModelo())).getListaNombresProductos();
			comboProductos = new JComboBox(prods);
			comboProductos.setBounds(new java.awt.Rectangle(15,30,196,26));
			comboProductos.setFont(new java.awt.Font("Dialog", java.awt.Font.PLAIN, 10));
			comboProductos.addActionListener(new java.awt.event.ActionListener(){
				public void actionPerformed (java.awt.event.ActionEvent e){
					String it =  (String)comboProductos.getSelectedItem();
					((ControladorAdmProductos)(vistaPadre.getControlador())).doNuevoProductoSeleccionado(it);
				}
			});
		}
		return comboProductos;
	}

	/**
	 * This method initializes textStock	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getTextStock() {
		if (textStock == null) {
			textStock = new JTextField();
			textStock.setBounds(new java.awt.Rectangle(286,30,53,28));
			textStock.addActionListener(new java.awt.event.ActionListener(){
				public void actionPerformed (java.awt.event.ActionEvent e){
					String it =  (String)comboProductos.getSelectedItem();
					int st =  (new Integer(textStock.getText())).intValue();
					((ControladorAdmProductos)(vistaPadre.getControlador())).doActualizarStock(it,st);
				}
			});
		}
		return textStock;
	}

	/**
	 * This method initializes buttonDetalles	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getButtonDetalles() {
		if (buttonDetalles == null) {
			buttonDetalles = new JButton();
			buttonDetalles.setBounds(new java.awt.Rectangle(15,66,149,20));
			buttonDetalles.setFont(new java.awt.Font("Dialog", java.awt.Font.PLAIN, 10));
			buttonDetalles.setText("Detalles del Producto");
			buttonDetalles.addActionListener(new java.awt.event.ActionListener(){
				public void actionPerformed (java.awt.event.ActionEvent e){
					String it =  (String)comboProductos.getSelectedItem();
					((ControladorAdmProductos)(vistaPadre.getControlador())).doMostrarDetallesProducto(it);
				}
			});
		}
		return buttonDetalles;
	}

	/**
	 * This method initializes areaProducto	
	 * 	
	 * @return javax.swing.JTextArea	
	 */
	private JTextArea getAreaProducto() {
		if (areaProducto == null) {
			areaProducto = new JTextArea();
			areaProducto.setBounds(new java.awt.Rectangle(15,90,320,105));
			areaProducto.setLineWrap(true);
		}
		return areaProducto;
	}

	public VistaAdmProductos getVistaPadre() {
		return vistaPadre;
	}

	public void actualizar() {
		//colocar nuevo valor de stock
		textStock.setText(
				String.valueOf(((ProxyModeloAdmProductos)(this.getVistaPadre().getModelo())).getStock((String)(comboProductos.getSelectedItem()) )));
		if (detalles)
			areaProducto.setText(((ProxyModeloAdmProductos)(this.getVistaPadre().getModelo())).getDetallesProducto((String)(comboProductos.getSelectedItem()) ));
		else
			areaProducto.setText("");
		this.invalidate();
	}

	public void setDetalles(boolean flag){
		detalles = flag;
	}

}  //  @jve:decl-index=0:visual-constraint="25,16"
