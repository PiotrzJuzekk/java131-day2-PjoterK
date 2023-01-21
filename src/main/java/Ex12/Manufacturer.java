package Ex12;

//    Stwórz klasę Manufacturer, która będzie zawierać pola: nazwa, rok założenia, kraj. Uwzględnij wszystkie niezbędne metody
//    oraz parametry konstruktora. Zaimplementuj metody hashCode() i equals() .
//
//Stwórz klasę Car, która będzie zawierać pola: nazwa, model, cena, rok produkcji, lista producentów (Manufacturer),
// oraz typ silnika (reprezentowany jako klasa enum, np. V12, V8, V6, S6, S4, S3).
// Uwzględnij wszystkie niezbędne metody oraz parametry konstruktora. Zaimplementuj metody hashcode() i equals().

import java.time.Year;
import java.util.Objects;

public class Manufacturer {

    private String name;
    private Year yearOfFundation;
    private String country;

    public Manufacturer(String name, int yearOfFundation, String country) {
        this.name = name;
        this.yearOfFundation = Year.of(yearOfFundation);
        this.country = country;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Manufacturer that = (Manufacturer) o;
        return Objects.equals(name, that.name) && Objects.equals(yearOfFundation, that.yearOfFundation) && Objects.equals(country, that.country);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, yearOfFundation, country);
    }
}
