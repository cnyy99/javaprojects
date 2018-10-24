package Drive;

public class Car extends Vehicle{
    @Override
    public void drivedByFemaleDriver() {
        System.out.println("A female driver drives a Car.");
    }

    @Override
    public void drivedByMaleDriver() {
        System.out.println("A male driver drives a Car.");

    }

    public Car(){}
}
