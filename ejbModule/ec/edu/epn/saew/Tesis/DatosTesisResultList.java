package ec.edu.epn.saew.Tesis;

import java.util.ArrayList;
import java.util.List;

public class DatosTesisResultList {
	
	private List<Tesis> tesis = new ArrayList<Tesis>();

	public DatosTesisResultList()
	{
		super();
		
	}
	
	public void add (Tesis tes)	
	{
		tesis.add(tes);
	}
	
	
	
	public List<Tesis> getTesis() {
		return tesis;
	}

	public void setTesis(List<Tesis> tesis) {
		this.tesis = tesis;
	}
	

}
