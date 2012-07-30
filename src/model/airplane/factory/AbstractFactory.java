package model.airplane.factory;

import model.airplane.CargoAirplane;
import model.airplane.PassengerAirplane;

abstract class AbstractFactory {
    abstract public PassengerAirplane createRandomPassagerAirplane();
    abstract public CargoAirplane createRandomCargoAirplane();
}
