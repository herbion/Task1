package view.util;

import java.util.Collection;

import model.aircompany.Raise;
import model.airplane.Airplane;
// TODO: Ugly. Think about how to let user Customize format.
// TODO: add functionality that prints only several fields from Raise.
public class Printer {
    public static final String RAISE_TITLE_FORMAT = "%-5s%-25s%-5s%-7s%-10s%-10s%-10s%-10s%-10s%-10s%-10s%-10s%-10s%-10s\n";
    public static final String RAISE_DETAILED_DATA_FORMAT = "%-5d%-25s%-5d%-7d%-10s%-10d%-10.2f%-10.2f%-10.2f%-10.2f%-10d%-10d%-10d%-10d\n";
    
    public static void print(Collection<Raise> raises) {
	print(raises, RAISE_DETAILED_DATA_FORMAT);
    }
    
    public static void print(Collection<Raise> raises, String FORMAT) {
	System.out.printf(RAISE_TITLE_FORMAT, "id", "modelTitle", "pers", "cargo", "engine",
		"Thrust", "Wing", "Overall", "Tail", "Cabin", "Fuel",
		"TakeOff", "Speed", "Range");

	for (Raise raise : raises) {
	    Airplane airPlane = raise.getAirplane();
	    System.out.printf(FORMAT, 
		    raise.getAirplaneCode(), 
		    airPlane.getModelTitle(),
		    airPlane.getPassengersCount(), 
		    airPlane.getCargoWeight(), 
		    airPlane.getEngine().getEngineModelName(), 
		    airPlane.getEngine().getMaximumEngineThrust(), 
		    airPlane.getDimensions().getWingSpan(),
		    airPlane.getDimensions().getOverallLength(), 
		    airPlane.getDimensions().getTailHeight(), 
		    airPlane.getDimensions().getInteriorCabinWidth(), 
		    airPlane.getMaximumFuelCapacity(), 
		    airPlane.getMaximumTakeoffWeight(), 
		    airPlane.getTypicalCruiseSpeed(), 
		    airPlane.getMaximumRange()
	    );
	}
    }
    public static void printById(Collection<Raise> raises, int id) {
	for (Raise raise : raises) {
	    if (raise.getAirplaneCode() == id)
		System.out.println(raise);
//		print(Arrays.asList(raise));
	}
    }
}
