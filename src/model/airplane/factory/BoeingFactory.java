package model.airplane.factory;

import java.util.Random;

import model.airplane.Carcas;
import model.airplane.CargoAirplane;
import model.airplane.PassengerAirplane;
import model.airplane.PassengerAirplane.PassengerBuilder;

public class BoeingFactory extends AbstractFactory {
    private static Random rand = new Random();
    private static PassengerBuilder pb = new PassengerAirplane.PassengerBuilder();

    public static Random getRand() {
	return rand;
    }

    public CargoAirplane createRandomCargoAirplane() {
	// TODO: Create new exception for this stuff. Like NotSupportedBlaBlaBla
	throw new RuntimeException("Cargo airplanes is not supported");
    }

    public PassengerAirplane createRandomPassagerAirplane() {
	pb.setModelTitle("RandomPassBoeing" + getRand().nextInt(1000));
	// configuring Engine parameters
	pb.setEngineModelName("CFM" + getRand().nextInt(99) + "-"
		+ getRand().nextInt(10));
	pb.setMaximumEngineThrust(10000 + getRand().nextInt(50000));
	// configuring Dimensions parameters
	pb.setDimensions(new Carcas(30.0 + getRand().nextDouble() * 10.,
		30.0 + getRand().nextDouble() * 10., 30.0 + getRand()
			.nextDouble() * 10.,
		30.0 + getRand().nextDouble() * 10.));
	pb.setCargo(400 + getRand().nextInt(1000));
	pb.setPassengersCount(100 + getRand().nextInt(500));
	pb.setMaximumFuelCapacity(2000 + getRand().nextInt(5000));
	pb.setMaximumRange(5000 + getRand().nextInt(5000));
	pb.setMaximumTakeoffWeight(40000 + getRand().nextInt(50000));
	pb.setTypicalCruiseSpeed(20000 + getRand().nextInt(50000));
	return (PassengerAirplane) pb.build();
    }

    public void setRand(Random rand) {
	BoeingFactory.rand = rand;
    }
}
