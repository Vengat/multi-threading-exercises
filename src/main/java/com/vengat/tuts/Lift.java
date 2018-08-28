package com.vengat.tuts;

public class Lift {

    public int noOfFloors;
    public int lowestFloor;
    public int highestFloor;

    public Lift() {}

    public Lift(int noOfFloors,int lowestFloor, int highestFloor) throws Exception {
        this.noOfFloors = noOfFloors;
        this.lowestFloor = lowestFloor;
        this.highestFloor = highestFloor;
    }

    public synchronized boolean enter() throws Exception {
        if (this.isOpen()) {
            Thread.sleep(10000);
            this.close();
        }
        return true;
    }

    public synchronized boolean exit() throws Exception {
        if (this.isOpen()) {
            Thread.sleep(10000);
            this.close();
        }
        return true;
    }

    public synchronized boolean stop(int floor) throws Exception {
        return true;
    }

    public synchronized boolean open() throws Exception {
        return true;

    }

    public synchronized boolean isOpen() throws Exception {
        return true;

    }

    public synchronized boolean close() throws Exception {
        return true;
    }

    public boolean isClosed() throws Exception {
        return true;
    }

    public boolean isDestinationFloor(int destinationFloor) throws Exception {
        return true;
    }

    public synchronized boolean moveUp(int destinationFloor) throws Exception {
        return true;
    }

    public synchronized boolean moveDown(int destinationFloor) throws Exception {
        return true;
    }

    public int getCurrentFloor() throws Exception {
        return 0;
    }

    public synchronized void boardLift() {

    }

    public synchronized void alightLift() {

    }
}
