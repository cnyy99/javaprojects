package temp;

public class Apple {
    private String color;
    private boolean ripe;

    public Apple(String acolor, boolean isripe) {
        color = acolor;
        ripe = isripe;
    }

    public void setColor(String acolor) {
        color = acolor;
    }

    public void setRipe(boolean isripe) {
        ripe = isripe;
    }

    public String getColor() {
        return color;
    }

    public boolean getRipe() {
        return ripe;
    }

    public String toString() {
        if (ripe)
            return ("A ripe " + color + "apple");
        else
            return ("A not so ripe " + color + "apple");
    }

    public boolean equals(Object obj) {
        if (obj instanceof Apple) {
            Apple a = (Apple) obj;
            return (color.equals(a.getColor()) && ripe == a.getRipe());
        }
        return false;

    }
}
