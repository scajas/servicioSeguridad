package ec.edu.epn.saew.Tesis;

import java.rmi.RemoteException;
import java.util.List;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;



public class TesisClientRequest {
	
	private DatosTesisWS_Service service;
    
    private DatosTesisWSSoap port;
    
    private XStream xstream;

	public TesisClientRequest() {
		service = new DatosTesisWS_Service();
		port = service.getDatosTesisWSSoap12();
		xstream =  new XStream(new DomDriver());
		
		xstream.alias("NewDataSet", DatosTesisResultList.class);
		xstream.alias("Table", Tesis.class);
		xstream.addImplicitCollection(DatosTesisResultList.class, "tesis");
		xstream.aliasField("CódigoProfesor", Tesis.class, "CódigoProfesor");
		xstream.aliasField("NroTesis", Tesis.class, "NroTesis");
		xstream.aliasField("Tesis", Tesis.class, "Tesis");
		xstream.aliasField("CodigoEstudiante", Tesis.class, "CodigoEstudiante");
		xstream.aliasField("DefensaOral", Tesis.class, "DefensaOral");
		xstream.aliasField("PeríodoGrado", Tesis.class, "PeríodoGrado");
		xstream.aliasField("Codcar", Tesis.class, "Codcar");
		xstream.aliasField("Carrera", Tesis.class, "Carrera");
		xstream.aliasField("Facultad", Tesis.class, "Facultad");
		xstream.aliasField("Nivel", Tesis.class, "Nivel");
		
	}
	
	
	public List<Tesis> conusltarTersisXML(String cedula) throws RemoteException
	{
		
		
		String xml = port.datosTesisWS(cedula);
		System.out.println("xml");
		return  ((DatosTesisResultList)xstream.fromXML(xml)).getTesis();
		
	
	}
	

	public String getXMLFromUserList(List<Tesis> list) {
		DatosTesisResultList slist = new DatosTesisResultList();
		slist.setTesis(list);
		return xstream.toXML(slist);

	}
	
    
    
    
    
    
    

}
