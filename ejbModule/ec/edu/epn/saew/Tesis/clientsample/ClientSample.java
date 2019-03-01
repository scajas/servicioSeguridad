package ec.edu.epn.saew.Tesis.clientsample;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import ec.edu.epn.saew.Tesis.*;

public class ClientSample {

	public static void main(String[] args) throws RemoteException {
		System.out.println("***********************");
		System.out.println("Create Web Service Client...");
		DatosTesisWS_Service service1 = new DatosTesisWS_Service();
		System.out.println("Create Web Service...");
		DatosTesisWSSoap port1 = service1.getDatosTesisWSSoap12();
		System.out.println("Call Web Service Operation...");
		// System.out.println("Server said: " +
		// port1.datosTesisWS("1706583174"));

		String tesis = "";
		tesis = port1.datosTesisWS("1704435930");
		System.out.println("te" + tesis);

		// TesisClientRequest request = new TesisClientRequest();
		// System.out.println("request" + request);
		//
		// List<Tesis> te = new ArrayList<Tesis>();
		// te = request.conusltarTersisXML("1704435930");
		// System.out.println("Tamaño de los datos" + te.size());
		//
		// for(Tesis te1: te)
		// {
		//
		// System.out.println(" Nº" + te1.getTesis() + " " + te1.getNroTesis() +
		// "" +te1.getDefensaOral());
		// }

		// Please input the parameters instead of 'null' for the upper method!

		// System.out.println("Create Web Service...");
		// DatosTesisWSSoap port2 = service1.getDatosTesisWSSoap12();
		// System.out.println("Call Web Service Operation...");
		// System.out.println("Server said: " + port2.datosTesisWS(null));
		// //Please input the parameters instead of 'null' for the upper method!
		//
		// System.out.println("Create Web Service...");
		// DatosTesisWSSoap port3 = service1.getDatosTesisWSSoap();
		// System.out.println("Call Web Service Operation...");
		// System.out.println("Server said: " + port3.datosTesisWS(null));
		// //Please input the parameters instead of 'null' for the upper method!
		//
		// System.out.println("Create Web Service...");
		// DatosTesisWSSoap port4 = service1.getDatosTesisWSSoap();
		// System.out.println("Call Web Service Operation...");
		// System.out.println("Server said: " + port4.datosTesisWS(null));
		// //Please input the parameters instead of 'null' for the upper method!
		//
		System.out.println("***********************");
		System.out.println("Call Over!");
	}

}
