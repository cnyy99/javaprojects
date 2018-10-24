package BALL;

public class MovingBall extends Ball{
    private int direction;

    public MovingBall(int radius, int direction) {
        super(radius);
        this.direction = direction;
    }

    public MovingBall(int xCoordinate, int yCoordinate, int radius, int direction) {
        super(xCoordinate, yCoordinate, radius);
        this.direction = direction;
    }

    @Override
    public String toString() {
        return super.toString()+"(" +
                "direction=" + direction +
                ')';
    }
}
