package model.airplane;

import java.io.Serializable;

public class Carcas implements Serializable {
    private static final long serialVersionUID = 3047927192537360204L;
    private double wingSpan;
    private double overallLength;
    private double tailHeight;
    private double interiorCabinWidth;

    public Carcas() {
	super();
    }

    public Carcas(double wingSpan, double overallLength, double tailHeight,
	    double interiorCabinWidth) {
	super();
	this.wingSpan = wingSpan;
	this.overallLength = overallLength;
	this.tailHeight = tailHeight;
	this.interiorCabinWidth = interiorCabinWidth;
    }

    public double getInteriorCabinWidth() {
	return interiorCabinWidth;
    }

    public double getOverallLength() {
	return overallLength;
    }

    public double getTailHeight() {
	return tailHeight;
    }

    public double getWingSpan() {
	return wingSpan;
    }

    public void setInteriorCabinWidth(double interiorCabinWidth) {
	this.interiorCabinWidth = interiorCabinWidth;
    }

    public void setOverallLength(double overallLength) {
	this.overallLength = overallLength;
    }

    public void setTailHeight(double tailHeight) {
	this.tailHeight = tailHeight;
    }

    public void setWingSpan(double wingSpan) {
	this.wingSpan = wingSpan;
    }

    @Override
    public String toString() {
	return "BasicDimensions" + "[" + "wingSpan=" + wingSpan + "m"
		+ ", overallLength=" + overallLength + "m" + ", tailHeight="
		+ tailHeight + "m" + ", interiorCabinWidth="
		+ interiorCabinWidth + "m" + "]";
    }

}
