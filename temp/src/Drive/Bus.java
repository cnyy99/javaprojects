package Drive;

public class Bus extends Vehicle{
    @Override
    public void drivedByFemaleDriver() {
        System.out.println("A female driver drives a bus.");
    }

    @Override
    public void drivedByMaleDriver() {
        System.out.println("A male driver drives a bus.");

    }

    public Bus(){}
}
