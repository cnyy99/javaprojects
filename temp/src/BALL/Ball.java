package BALL;

public class Ball extends Point{
    private int radius;

    public Ball(int radius) {
        this.radius = radius;
    }

    public Ball(int xCoordinate, int yCoordinate, int radius) {
        super(xCoordinate, yCoordinate);
        this.radius = radius;
    }

    @Override
    public String toString() {
        return super.toString()+"(" +
                "radius=" + radius +
                ')';
    }
}
