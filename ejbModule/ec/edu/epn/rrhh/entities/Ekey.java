package ec.edu.epn.rrhh.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the ekey database table.
 * 
 */
@Entity
@Table(name = "ekey", catalog = "bddcorpepn", schema = "`Rrhh`")
public class Ekey implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private EkeyPK id;

	private String a;

	private String b;

	private String c;
	private String d;

	private String e;

	private String f;

//	private String g;
//
//	private String h;
//
//	private String i;
//
//	private String j;

    public Ekey() {
    }

	public EkeyPK getId() {
		return this.id;
	}

	public void setId(EkeyPK id) {
		this.id = id;
	}
	
	public String getA() {
		return this.a;
	}

	public void setA(String a) {
		this.a = a;
	}

	public String getB() {
		return this.b;
	}

	public void setB(String b) {
		this.b = b;
	}

	public String getC() {
		return this.c;
	}

	public void setC(String c) {
		this.c = c;
	}

	public String getE() {
		return this.e;
	}

	public void setE(String e) {
		this.e = e;
	}

	public String getF() {
		return this.f;
	}

	public void setF(String f) {
		this.f = f;
	}

//	public String getG() {
//		return this.g;
//	}
//
//	public void setG(String g) {
//		this.g = g;
//	}
//
//	public String getH() {
//		return this.h;
//	}
//
//	public void setH(String h) {
//		this.h = h;
//	}
//
//	public String getI() {
//		return this.i;
//	}
//
//	public void setI(String i) {
//		this.i = i;
//	}
//
//	public String getJ() {
//		return this.j;
//	}
//
//	public void setJ(String j) {
//		this.j = j;
//	}
//
	public String getD() {
		return d;
	}

	public void setD(String d) {
		this.d = d;
	}

}