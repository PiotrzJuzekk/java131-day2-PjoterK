package Ex12;

import java.time.Year;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CarServiceMain {
    public static void main(String[] args) {

        Manufacturer audiManufacturer = new Manufacturer("Audi", 1950, "Germany");
        Manufacturer mercedesManufacturer = new Manufacturer("Mercedes", 1940, "Germany");
        Manufacturer bmwManufacturer = new Manufacturer("BMW", 1960, "Germany");

        List<Manufacturer> manufacturers = new ArrayList<>();

        manufacturers.add(audiManufacturer);
//        manufacturers.add(mercedesManufacturer);

        List<Manufacturer> manufacturers2 = new ArrayList<>();

//        manufacturers2.add(audiManufacturer);
        manufacturers2.add(mercedesManufacturer);
        manufacturers.add(bmwManufacturer);

        CarService carService = new CarService();

        Car car1 = new Car("Audi", "A4", "35000", 2008, manufacturers, EngineType.V6);
        Car car2 = new Car("Audi", "A6", "55000", 2009, manufacturers, EngineType.V6);
        Car car3 = new Car("Audi", "A8", "95000", 1990, manufacturers, EngineType.V6);
        Car car4 = new Car("Mercedes", "S600", "150000", 2011, manufacturers2, EngineType.V12);
        Car car5 = new Car("Mercedes", "CL600", "195000", 2005, manufacturers2, EngineType.V12);
        Car car6 = new Car("BMW", "760Li", "295000", 2006, manufacturers2, EngineType.V12);
        Car car7 = new Car("BMW", "760Li", "295000", 2009, manufacturers2, EngineType.V12);

        carService.addCar(car1);
        carService.addCar(car2);
        carService.addCar(car3);
        carService.addCar(car4);
        carService.addCar(car5);
        carService.addCar(car6);

//        List<Car> allCars = carService.getAllCars();
//        allCars.forEach(car -> System.out.println(car));
//        allCars.add(car3);
//
//        carService.removeCar(car1);
//        carService.removeCar(car2);

//        System.out.println(carService.getAllV12Cars());
//        System.out.println(carService.getAllBefore1999());
//        System.out.println(carService.getCarsWithThreeManufacturers());
//        System.out.println(carService.isOnTheList(car7));
//        carService.getAllProducedBy(audiManufacturer).forEach(car -> System.out.println(car));

        var carNames = carService.getAllProducedBy(audiManufacturer).stream()
                .map(car -> car.getName())
                .map(carName -> "nazwa samochodu: " + carName)
                .map(carName -> carName.length())
                .collect(Collectors.toList());
//        System.out.println(carNames);

//        carService.producedByManufacturersYear(Year.of(1949), ComparisonType.HIGHER).forEach(System.out::println);
        carService.producedByManufacturersYear(Year.of(1951), null).forEach(System.out::println);
    }
}
