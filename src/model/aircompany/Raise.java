package model.aircompany;

import java.io.Serializable;

import model.airplane.Airplane;

/**
 * @author ...
 * 
 *         Extend me hard!
 */
public class Raise implements Serializable {
    private static final long serialVersionUID = 943544571397446788L;
    private Airplane airplane;

    // private Long raiseCode;

    public Raise(Airplane airplane) {
	this.setAirplane(airplane);
    }

    public Airplane getAirplane() {
	return airplane;
    }

    public void setAirplane(Airplane airplane) {
	this.airplane = airplane;
    }

    @Override
    public String toString() {
	return "Raise [airplane=" + airplane + "]";
    }

}
