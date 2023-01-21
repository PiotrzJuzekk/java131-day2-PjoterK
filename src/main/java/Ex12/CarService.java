package Ex12;

import java.time.Year;
import java.util.ArrayList;
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
//        zwracanie listy aut wyprodukowanych przez producenta z rokiem założenia <,>,<=,>=,=,!= od podanego
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
}
