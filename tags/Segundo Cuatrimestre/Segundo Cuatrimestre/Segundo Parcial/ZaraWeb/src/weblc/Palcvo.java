/**
 * Palcvo.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package weblc;

public class Palcvo  extends weblc.BaseVO  implements java.io.Serializable {
    private java.lang.String estado;

    private java.lang.Integer idPedido;

    private java.lang.Integer idTienda;

    private weblc.ItemPedidoVO[] itemsPedido;

    public Palcvo() {
    }

    public Palcvo(
           java.lang.String estado,
           java.lang.Integer idPedido,
           java.lang.Integer idTienda,
           weblc.ItemPedidoVO[] itemsPedido) {
        this.estado = estado;
        this.idPedido = idPedido;
        this.idTienda = idTienda;
        this.itemsPedido = itemsPedido;
    }


    /**
     * Gets the estado value for this Palcvo.
     * 
     * @return estado
     */
    public java.lang.String getEstado() {
        return estado;
    }


    /**
     * Sets the estado value for this Palcvo.
     * 
     * @param estado
     */
    public void setEstado(java.lang.String estado) {
        this.estado = estado;
    }


    /**
     * Gets the idPedido value for this Palcvo.
     * 
     * @return idPedido
     */
    public java.lang.Integer getIdPedido() {
        return idPedido;
    }


    /**
     * Sets the idPedido value for this Palcvo.
     * 
     * @param idPedido
     */
    public void setIdPedido(java.lang.Integer idPedido) {
        this.idPedido = idPedido;
    }


    /**
     * Gets the idTienda value for this Palcvo.
     * 
     * @return idTienda
     */
    public java.lang.Integer getIdTienda() {
        return idTienda;
    }


    /**
     * Sets the idTienda value for this Palcvo.
     * 
     * @param idTienda
     */
    public void setIdTienda(java.lang.Integer idTienda) {
        this.idTienda = idTienda;
    }


    /**
     * Gets the itemsPedido value for this Palcvo.
     * 
     * @return itemsPedido
     */
    public weblc.ItemPedidoVO[] getItemsPedido() {
        return itemsPedido;
    }


    /**
     * Sets the itemsPedido value for this Palcvo.
     * 
     * @param itemsPedido
     */
    public void setItemsPedido(weblc.ItemPedidoVO[] itemsPedido) {
        this.itemsPedido = itemsPedido;
    }

    public weblc.ItemPedidoVO getItemsPedido(int i) {
        return this.itemsPedido[i];
    }

    public void setItemsPedido(int i, weblc.ItemPedidoVO _value) {
        this.itemsPedido[i] = _value;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Palcvo)) return false;
        Palcvo other = (Palcvo) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.estado==null && other.getEstado()==null) || 
             (this.estado!=null &&
              this.estado.equals(other.getEstado()))) &&
            ((this.idPedido==null && other.getIdPedido()==null) || 
             (this.idPedido!=null &&
              this.idPedido.equals(other.getIdPedido()))) &&
            ((this.idTienda==null && other.getIdTienda()==null) || 
             (this.idTienda!=null &&
              this.idTienda.equals(other.getIdTienda()))) &&
            ((this.itemsPedido==null && other.getItemsPedido()==null) || 
             (this.itemsPedido!=null &&
              java.util.Arrays.equals(this.itemsPedido, other.getItemsPedido())));
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = super.hashCode();
        if (getEstado() != null) {
            _hashCode += getEstado().hashCode();
        }
        if (getIdPedido() != null) {
            _hashCode += getIdPedido().hashCode();
        }
        if (getIdTienda() != null) {
            _hashCode += getIdTienda().hashCode();
        }
        if (getItemsPedido() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getItemsPedido());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getItemsPedido(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Palcvo.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://weblc/", "palcvo"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("estado");
        elemField.setXmlName(new javax.xml.namespace.QName("", "estado"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idPedido");
        elemField.setXmlName(new javax.xml.namespace.QName("", "idPedido"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idTienda");
        elemField.setXmlName(new javax.xml.namespace.QName("", "idTienda"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("itemsPedido");
        elemField.setXmlName(new javax.xml.namespace.QName("", "itemsPedido"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://weblc/", "itemPedidoVO"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
    }

    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

    /**
     * Get Custom Serializer
     */
    public static org.apache.axis.encoding.Serializer getSerializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanSerializer(
            _javaType, _xmlType, typeDesc);
    }

    /**
     * Get Custom Deserializer
     */
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanDeserializer(
            _javaType, _xmlType, typeDesc);
    }

}
