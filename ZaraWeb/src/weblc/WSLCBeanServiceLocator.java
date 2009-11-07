/**
 * WSLCBeanServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package weblc;

public class WSLCBeanServiceLocator extends org.apache.axis.client.Service implements weblc.WSLCBeanService {

    public WSLCBeanServiceLocator() {
    }


    public WSLCBeanServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public WSLCBeanServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for WSLCBeanPort
    private java.lang.String WSLCBeanPort_address = null;

    public java.lang.String getWSLCBeanPortAddress() {
        return WSLCBeanPort_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String WSLCBeanPortWSDDServiceName = "WSLCBeanPort";

    public java.lang.String getWSLCBeanPortWSDDServiceName() {
        return WSLCBeanPortWSDDServiceName;
    }

    public void setWSLCBeanPortWSDDServiceName(java.lang.String name) {
        WSLCBeanPortWSDDServiceName = name;
    }

    public weblc.WSLCBean getWSLCBeanPort() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(WSLCBeanPort_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getWSLCBeanPort(endpoint);
    }

    public weblc.WSLCBean getWSLCBeanPort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            weblc.WSLCBeanBindingStub _stub = new weblc.WSLCBeanBindingStub(portAddress, this);
            _stub.setPortName(getWSLCBeanPortWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setWSLCBeanPortEndpointAddress(java.lang.String address) {
        WSLCBeanPort_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (weblc.WSLCBean.class.isAssignableFrom(serviceEndpointInterface)) {
                weblc.WSLCBeanBindingStub _stub = new weblc.WSLCBeanBindingStub(new java.net.URL(WSLCBeanPort_address), this);
                _stub.setPortName(getWSLCBeanPortWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("WSLCBeanPort".equals(inputPortName)) {
            return getWSLCBeanPort();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://weblc/", "WSLCBeanService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://weblc/", "WSLCBeanPort"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("WSLCBeanPort".equals(portName)) {
            setWSLCBeanPortEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
