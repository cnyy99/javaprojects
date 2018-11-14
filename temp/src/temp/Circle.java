package temp;

public class Circle implements Shape2D ,Color{
    double radius;
    String color;

    public void setColor(String color) {
        this.color = color;
    }

    public Circle(double r) {
        radius = r;
    }

    public double area() {
        return (pi * radius * radius);

    }
}
