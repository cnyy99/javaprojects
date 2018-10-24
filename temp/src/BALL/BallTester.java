package BALL;

public class BallTester {
    public static void main(String args[])
    {
        Point ball = new Ball(2,4,3);
        System.out.println(ball+"\n");
        Point movingball = new MovingBall(2,4,3,1);
        System.out.println(movingball);

    }
}
