package Drive;

public abstract class Vehicle {
    private String type;

    public Vehicle(String type) {
        this.type = type;
    }
    public abstract void drivedByFemaleDriver();
    public abstract void drivedByMaleDriver();
    public Vehicle(){}
}
