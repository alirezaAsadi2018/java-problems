package ir.javacup.elevatorTest;

public class Elevator {
    private boolean open = true;
    private boolean underMaintenance;
    private int floorNumber;
    private State state = State.SECURE;

    public boolean isOpen() {
        return open;
    }

    public boolean isUnderMaintenance() {
        return underMaintenance;
    }

    public int getFloorNumber() {
        return floorNumber;
    }

    public State getState() {
        return state;
    }

    public void move(int floor) {
        if(floor < -2 || floor > 10)
            throw new IllegalArgumentException("Floor number should be between -2 and 10");
        if(state != State.SECURE)
            throw new RuntimeException("Elevator is insecure");
        if(floorNumber == floor)
            return;
        close();
        floorNumber = floor;
    }

    public void open() {
        open = true;
    }

    public void startMaintenance() {
        state = State.INSECURE;
        underMaintenance = true;
    }

    public void finishMaintenance() {
        state = State.SECURE;
        underMaintenance = false;
    }

    public void close() {
        open = false;
    }
}
