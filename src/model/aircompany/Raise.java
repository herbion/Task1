package model.aircompany;

import java.io.Serializable;
import java.util.Comparator;

import model.airplane.Airplane;

/**
 * @author ...
 * 
 *         Extend me hard!
 */
public class Raise implements Serializable {
    private static final long serialVersionUID = 943544571397446788L;
    private Airplane airplane;
    private Long raiseCode;
    public static Comparator<Raise> COMPARE_BY_FLIGHT_RANGE = new Comparator<Raise>() {
	@Override
	public int compare(Raise o1, Raise o2) {
	    return (int) (o1.getAirplane().getMaximumRange() - o2.getAirplane()
		    .getMaximumRange());
	}
    };
    public static Comparator<Raise> COMPARE_BY_RAISE_ID = new Comparator<Raise>() {
	@Override
	public int compare(Raise o1, Raise o2) {
	    return (int) (o1.raiseCode - o2.raiseCode);
	}
    };
    public Raise(Airplane airplane, Long airplaneCode) {
	super();
	this.setAirplane(airplane);
	this.setAirplaneCode(airplaneCode);
    }

    public Airplane getAirplane() {
	return airplane;
    }

    public Long getAirplaneCode() {
	return raiseCode;
    }

    public void setAirplane(Airplane airplane) {
	this.airplane = airplane;
    }

    public void setAirplaneCode(Long airplaneCode) {
	this.raiseCode = airplaneCode;
    }

    @Override
    public String toString() {
	return "Raise [airplane=" + airplane + ", raiseCode=" + raiseCode + "]";
    }

}
