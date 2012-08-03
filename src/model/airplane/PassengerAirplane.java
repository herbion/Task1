package model.airplane;

public class PassengerAirplane extends Airplane {
    public static class PassengerBuilder extends Airplane.AbstractBuilder {
	@Override
	public PassengerAirplane build() {
	    return new PassengerAirplane(this);
	}
    }

    private static final long serialVersionUID = -5642724605225244311L;

    public PassengerAirplane(PassengerBuilder builder) {
	super(builder);
    }

    @Override
    public void flightTo(String coordinates) {
	System.out.println("Whoa " + this.getModelTitle() + ". Flying to:"
		+ coordinates);
    }

    @Override
    public void loadCargo(int weight) {
	if (this.getCargoWeight() < weight) {
	    System.out.println("Cargo is too heavy.");
	    return;
	} else
	    System.out.println("Cargo loaded succesfully.");
    }
}
