package ec.edu.epn.rrhh.entities;

import java.io.Serializable;
import javax.persistence.*;

import java.sql.Timestamp;


/**
 * The persistent class for the unomb database table.
 * 
 */
@Entity

@Table(name="unomb", catalog = "bddcorpepn", schema = "`Rrhh`")
public class Unomb implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name="frige_nomb")
	private Timestamp frigeNomb;

	@Id
	private String nced;

    public Unomb() {
    }

	public Timestamp getFrigeNomb() {
		return this.frigeNomb;
	}

	public void setFrigeNomb(Timestamp frigeNomb) {
		this.frigeNomb = frigeNomb;
	}

	public String getNced() {
		return this.nced;
	}

	public void setNced(String nced) {
		this.nced = nced;
	}

}