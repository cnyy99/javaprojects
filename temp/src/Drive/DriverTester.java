package Drive;

public class DriverTester {
    public static void main(String args[])
    {
        Driver female = new FemaleDriver();
        Driver male = new MaleDriver();
        Vehicle car = new Car();
        Vehicle bus = new Bus();
        female.drives(car);
        male.drives(bus);
    }
}
