package weblc;

public class WSLCBeanProxy implements weblc.WSLCBean {
  private String _endpoint = null;
  private weblc.WSLCBean wSLCBean = null;
  
  public WSLCBeanProxy() {
    _initWSLCBeanProxy();
  }
  
  public WSLCBeanProxy(String endpoint) {
    _endpoint = endpoint;
    _initWSLCBeanProxy();
  }
  
  private void _initWSLCBeanProxy() {
    try {
      wSLCBean = (new weblc.WSLCBeanServiceLocator()).getWSLCBeanPort();
      if (wSLCBean != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)wSLCBean)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)wSLCBean)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (wSLCBean != null)
      ((javax.xml.rpc.Stub)wSLCBean)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public weblc.WSLCBean getWSLCBean() {
    if (wSLCBean == null)
      _initWSLCBeanProxy();
    return wSLCBean;
  }
  
  public boolean recibirPALCweb(weblc.Palcvo arg0) throws java.rmi.RemoteException{
    if (wSLCBean == null)
      _initWSLCBeanProxy();
    return wSLCBean.recibirPALCweb(arg0);
  }
  
  
}