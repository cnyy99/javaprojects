package BALL;

public class Point {
    private int xCoordinate;
    private int yCoordinate;
    public Point(){

    }


    public Point(int xCoordinate, int yCoordinate) {
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
    }

    @Override
    public String toString(){
        return "(xCoordinate="+Double.toString(xCoordinate)+", yCoordinate="+Double.toString(yCoordinate)+")";
    }
}
