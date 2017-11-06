package com.packtpublishing.tddjava.ch04ship;

public class Ship {

    private final Location location;
    private Planet planet;

    public Ship(Location location, Planet planet) {
        this.location = location;
        this.planet = planet;
    }

    public Location getLocation() {
        return location;
    }

    public Ship(Location location) {
        this.location = location;
    }


    public boolean moveForward() {
        return location.forward(planet.getMax());
    }

    public boolean moveBackward() {
        return location.backward(planet.getMax());
    }

    public void turnLeft() {
        location.turnLeft();
    }

    public void turnRight() {
        location.turnRight();
    }

    public void receiveCommand(String command) {
        switch (command) {
            case "f":
                moveForward();
                break;
            case "b":
                moveBackward();
                break;
            case "l":
                turnLeft();
                break;
            case "r":
                turnRight();
                break;
            default:
                System.out.println("There is no such direction! stupid!");
                break;
        }
    }

    public void receiveCommands(String commands) {
        for(int i=0; i<commands.length();i++) {
            String command = Character.toString(commands.charAt(i));
            receiveCommand(command);
        }
    }

    public Planet getPlanet() {
        return planet;
    }
}
