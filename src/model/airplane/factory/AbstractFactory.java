package model.airplane.factory;

import model.airplane.CargoAirplane;
import model.airplane.PassengerAirplane;

abstract class AbstractFactory {
    abstract public CargoAirplane createRandomCargoAirplane();

    abstract public PassengerAirplane createRandomPassagerAirplane();
}
