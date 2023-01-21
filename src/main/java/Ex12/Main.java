package Ex12;

import java.time.Year;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Manufacturer manufacturer1 = new Manufacturer("Ford", 1920, "USA");
        Manufacturer manufacturer2 = new Manufacturer("Ford", 1920, "USA");
        Manufacturer manufacturer3 = new Manufacturer("Audi", 1950, "Niemcy");

        System.out.println(manufacturer1.equals(manufacturer2));
        System.out.println(manufacturer1);
        System.out.println(manufacturer2);

//        manufacturer2.setName("Audi");

        System.out.println(manufacturer1.equals(manufacturer2));
        System.out.println(manufacturer1);
        System.out.println(manufacturer2);

        List<Manufacturer> manufacturers1 = List.of(manufacturer2, manufacturer1);
        List<Manufacturer> manufacturers2 = List.of(manufacturer2, manufacturer3);

        Car car1 = new Car("Audi", "A4", "35000", 2008, manufacturers1, EngineType.V6);
        Car car2 = new Car("Audi", "A4", "35000", 2008, manufacturers2, EngineType.V6);

        System.out.println(car1.equals(car2));
    }
}
