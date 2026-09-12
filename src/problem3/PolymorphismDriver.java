package problem3;

public class PolymorphismDriver {
    private static final Ship[] ships = new Ship[3];

    public static void main(String[] args) {
        ships[0] = new Ship("Harbor Explorer", "2001");
        ships[1] = new CruiseShip("Ocean Breeze", "2015", 3000);
        ships[2] = new CargoShip("Pacific Carrier", "2018", 50000);

        for (Ship ship : ships) {
            ship.print();
        }
    }
}
