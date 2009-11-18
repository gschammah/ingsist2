/**
 * ItemPedidoVO.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package weblc;

public class ItemPedidoVO  extends weblc.BaseVO  implements java.io.Serializable {
    private java.lang.Integer cantidadSolicitada;

    private java.lang.Integer referencia;

    public ItemPedidoVO() {
    }

    public ItemPedidoVO(
           java.lang.Integer cantidadSolicitada,
           java.lang.Integer referencia) {
        this.cantidadSolicitada = cantidadSolicitada;
        this.referencia = referencia;
    }


    /**
     * Gets the cantidadSolicitada value for this ItemPedidoVO.
     * 
     * @return cantidadSolicitada
     */
    public java.lang.Integer getCantidadSolicitada() {
        return cantidadSolicitada;
    }


    /**
     * Sets the cantidadSolicitada value for this ItemPedidoVO.
     * 
     * @param cantidadSolicitada
     */
    public void setCantidadSolicitada(java.lang.Integer cantidadSolicitada) {
        this.cantidadSolicitada = cantidadSolicitada;
    }


    /**
     * Gets the referencia value for this ItemPedidoVO.
     * 
     * @return referencia
     */
    public java.lang.Integer getReferencia() {
        return referencia;
    }


    /**
     * Sets the referencia value for this ItemPedidoVO.
     * 
     * @param referencia
     */
    public void setReferencia(java.lang.Integer referencia) {
        this.referencia = referencia;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ItemPedidoVO)) return false;
        ItemPedidoVO other = (ItemPedidoVO) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.cantidadSolicitada==null && other.getCantidadSolicitada()==null) || 
             (this.cantidadSolicitada!=null &&
              this.cantidadSolicitada.equals(other.getCantidadSolicitada()))) &&
            ((this.referencia==null && other.getReferencia()==null) || 
             (this.referencia!=null &&
              this.referencia.equals(other.getReferencia())));
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
        if (getCantidadSolicitada() != null) {
            _hashCode += getCantidadSolicitada().hashCode();
        }
        if (getReferencia() != null) {
            _hashCode += getReferencia().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ItemPedidoVO.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://weblc/", "itemPedidoVO"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cantidadSolicitada");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cantidadSolicitada"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("referencia");
        elemField.setXmlName(new javax.xml.namespace.QName("", "referencia"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
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
