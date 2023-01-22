package Ex12;

import java.time.Year;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

//Stwórz klasę CarService, która będzie zawierać w sobie listę aut, oraz będzie realizować poniższe metody:
//
//        dodawanie aut do listy,
//        usuwanie auta z listy,
//        zwracanie listy wszystkich aut,
//        zwracanie aut z silnikiem V12,
//        zwracanie aut wyprodukowanych przed rokiem 1999,
//        zwracanie najdroższego auta,
//        zwracanie najtańszego auta,
//        zwracanie auta z co najmniej 3 producentami,
//        zwracanie listy wszystkich aut posortowanych zgodnie z przekazanym parametrem: rosnąco/malejąco,
//        sprawdzanie czy konkretne auto znajduje się na liście,
//        zwracanie listy aut wyprodukowanych przez konkretnego producenta,
//        zwracanie listy aut wyprodukowanych przez producenta z rokiem założenia
//        <,>,<=,>=,=,!= od podanego
public class CarService {
    private List<Car> cars = new ArrayList<>();
    public void addCar(Car car){
        cars.add(car);
//        System.out.println(cars);
    }

    public void removeCar(Car car){
        cars.remove(car);
//        System.out.println(cars);
    }

    public List<Car> getAllCars(){
        List<Car> result = new ArrayList<>();
        result.addAll(cars);
        return result;
    }

    public List<Car> getAllV12Cars(){
        return cars.stream()
                .filter(car -> EngineType.V12 == car.getEngineType())
                .collect(Collectors.toList());
    }

    public List<Car> getAllBefore1999(){
        return cars.stream()
                .filter(car -> Year.of(1999).isAfter(car.getYearOfProduction()))
                .collect(Collectors.toList());
    }

    public Car getMostExpensive(){
        Car mostExpensiveCar = null;
        for (Car car : cars) {
            if (mostExpensiveCar == null) {
//                (mostExpensiveCar == null || mostExpensiveCar.getPrice().compareTo(car.getPrice())
                mostExpensiveCar = car;
            }
            if (mostExpensiveCar.getPrice().compareTo(car.getPrice()) < 0){
                mostExpensiveCar = car;
            }
        }
        return mostExpensiveCar;
    }

    public Car getMostExpensive2() {
        return cars.stream()
                .sorted(Comparator.comparing(Car::getPrice).reversed())
                .collect(Collectors.toList())
                .iterator().next();


    }


    public Car getMostExpensive3(){
        //posortowanie po cenie malejąco
        final var sortedCars =  cars.stream()
                .sorted(Comparator.comparing(Car::getPrice).reversed())
                .collect(Collectors.toList());

        //pobranie iteratora ("skoczka") dla posortowanej listy
        final var carsIterator = sortedCars.iterator();

        //jesli iterator widzi pierwszy element to go zwraca, jesli nie to null
        if(carsIterator.hasNext()) {
            return carsIterator.next();
        } else {
            return null;
        }
    }

    public Car getMostExpensive4() {
        return cars.stream()
                .reduce((car1, car2) -> {
                    if (car1.getPrice().compareTo(car2.getPrice()) < 0){
                        return car2;
                    } else {
                        return car1;
                    }
                })
                .orElse(null);
    }

    public Car getCheapest(){
        return cars.stream()
                .sorted(Comparator.comparing(Car::getPrice))
                .collect(Collectors.toList())
                .iterator().next();
    }

    public List<Car> getCarsWithThreeManufacturers(){
        List<Car> result = cars.stream()
                .filter(car -> car.getManufacturers().size() > 2) // size = policz
                .collect(Collectors.toList());
        return result;
    }

    public List<Car> sortCarsByYear(SortOrder sortOrder){
        if (sortOrder.DESCENDING == sortOrder) {
            return cars.stream()
                    .sorted(Comparator.comparing((Car car) -> car.getYearOfProduction()).reversed())
                    .collect(Collectors.toList());
        } else {
            return cars.stream()
                    .sorted(Comparator.comparing(car -> car.getYearOfProduction()))
                    .collect(Collectors.toList());
        }
    }

    public List<Car> sortCarsByYear2(SortOrder sortOrder){
        Comparator<Car> comparator = null;
        if (SortOrder.DESCENDING == sortOrder){
            comparator = Comparator.comparing(Car::getYearOfProduction).reversed();
        } else {
            comparator = Comparator.comparing(Car::getYearOfProduction);
        }
        return cars.stream()
                .sorted(comparator)
                .collect(Collectors.toList());
    }

    public boolean isOnTheList(Car car){
        return cars.contains(car);
    }

    public List<Car> getAllProducedBy (Manufacturer manufacturer){
        return cars.stream()
                .filter(car -> car.getManufacturers().contains(manufacturer))
                .collect(Collectors.toList());
    }

    private List<Year> yearsOfCreation(Car car){
        return car.getManufacturers().stream()
                .map(manufacturer -> manufacturer.getYearOfFundation())
                .collect(Collectors.toList());
    }
    public List<Car> producedByManufacturersYear(Year ageOfEstablishment, ComparisonType comparisonType) {
        if (ComparisonType.EQUAL == comparisonType) {
            return cars.stream()
                    .filter(car -> yearsOfCreation(car).contains(ageOfEstablishment))
                    .collect(Collectors.toList());
        } else if (ComparisonType.IS_NOT_EQUAL == comparisonType) {
            return cars.stream()
                    .filter(car -> !yearsOfCreation(car).contains(ageOfEstablishment))
                    .collect(Collectors.toList());
        } else if (ComparisonType.HIGHER == comparisonType) {
            return cars.stream()
                    .filter(car -> yearsOfCreation(car).stream().anyMatch(year -> year.isAfter(ageOfEstablishment)))
                    .collect(Collectors.toList());
        } else if (ComparisonType.HIGHER_AND_EQUAL == comparisonType) {
            return cars.stream()
                    .filter(car -> yearsOfCreation(car).stream().anyMatch(year -> year.isAfter(ageOfEstablishment) || year.equals(ageOfEstablishment)))
                    .collect(Collectors.toList());
        } else if (ComparisonType.LOWER == comparisonType) {
            return cars.stream()
                    .filter(car -> yearsOfCreation(car).stream().anyMatch(year -> year.isBefore(ageOfEstablishment)))
                    .collect(Collectors.toList());
        } else if (ComparisonType.LOWER_AND_EQUAL == comparisonType) {
            return cars.stream()
                    .filter(car -> yearsOfCreation(car).stream().anyMatch(year -> year.isBefore(ageOfEstablishment) || year.equals(ageOfEstablishment)))
                    .collect(Collectors.toList());
        }
        throw new RuntimeException("stary, przekazales comparisonType jako null");
    }


}
