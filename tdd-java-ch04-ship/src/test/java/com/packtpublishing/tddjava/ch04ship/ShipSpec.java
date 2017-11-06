package com.packtpublishing.tddjava.ch04ship;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

@Test
public class ShipSpec {

    private Ship ship;
    private Location location;
    private Planet planet;

    @BeforeMethod
    public void beforeTest() {
        Point max = new Point(50,50);
        location = new Location(new Point(21,13), Direction.NORTH);
        planet = new Planet(max);
        ship = new Ship(location,planet);
    }

    public void whenInstantiatedThenSetLocation() {
        assertEquals(ship.getLocation(), location);

    }
    //North is on negative y
    //East on positive x
    public void whenMoveForwardsThenForward() {
        Location expected = location.copy();
        expected.forward();
        ship.moveForward();
        assertEquals(ship.getLocation(), expected);
    }

    public void whenMoveBackwardsThenBackward() {
        Location expected = location.copy();
        expected.backward();
        ship.moveBackward();
        assertEquals(ship.getLocation(), expected);
    }

    public void whenTurnLeftThenLeft() {
        Location expected = location.copy();
        expected.turnLeft();
        ship.turnLeft();
        assertEquals(ship.getLocation(), expected);
    }

    public void whenTurnRightThenRight() {
        Location expected = location.copy();
        expected.turnRight();
        ship.turnRight();
        assertEquals(ship.getLocation(), expected);
    }

    public void whenReceiveCommandFThenForward() {
        Location expected = location.copy();
        expected.forward();
        ship.receiveCommand("f");
        assertEquals(ship.getLocation(), expected);
    }

    public void whenReceivedCommandsThenAllAreExecuted() {
        Location expected = location.copy();
        expected.turnRight();
        expected.turnLeft();
        expected.forward();
        expected.backward();
        ship.receiveCommands("rlfb");
        assertEquals(ship.getLocation(), expected);
    }

    public void whenInstantiatedThenPlanetIsStored() {
        assertEquals(ship.getPlanet(), planet);
    }

    public void overpassEastBoundary() {
        location.setDirection(Direction.EAST);
        location.getPoint().setX(planet.getMax().getX());
        ship.receiveCommand("f");
        assertEquals(location.getX(), 1);
    }
}
