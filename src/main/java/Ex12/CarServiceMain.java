package Ex12;

import java.util.ArrayList;
import java.util.List;

public class CarServiceMain {
    public static void main(String[] args) {

        Manufacturer audiManufacturer = new Manufacturer("Audi", 1950, "Germany");
        Manufacturer mercedesManufacturer = new Manufacturer("Mercedes", 1950, "Germany");
        List<Manufacturer> manufacturers = new ArrayList<>();
        manufacturers.add(audiManufacturer);
        manufacturers.add(mercedesManufacturer);
        CarService carService = new CarService();
        Car car1 = new Car("Audi", "A4", "35000", 2008, manufacturers, EngineType.V6);
        Car car2 = new Car("Audi", "A6", "55000", 2009, manufacturers, EngineType.V6);
        Car car3 = new Car("Audi", "A8", "95000", 1990, manufacturers, EngineType.V6);
        Car car4 = new Car("Mercedes", "S600", "150000", 2009, manufacturers, EngineType.V12);
        Car car5 = new Car("Mercedes", "CL600", "195000", 2009, manufacturers, EngineType.V12);

        carService.addCar(car1);
        carService.addCar(car2);
        carService.addCar(car3);
        carService.addCar(car4);
        carService.addCar(car5);

//        List<Car> allCars = carService.getAllCars();
//        allCars.forEach(car -> System.out.println(car));
//        allCars.add(car3);
//
//        carService.removeCar(car1);
//        carService.removeCar(car2);

        System.out.println(carService.getAllV12Cars());
        System.out.println(carService.getAllBefore1999());
    }
}
