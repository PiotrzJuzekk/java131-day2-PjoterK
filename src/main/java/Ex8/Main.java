package Ex8;

public class Main {
    public static void main(String[] args) {
        Parcel parcel1 = new Parcel(10, 20, 150, 100, true);
        Parcel parcel2 = new Parcel(10, 200, 150, 10, true);
        Parcel parcel3 = new Parcel(10, 20, 150, 10, false);
        Parcel parcel4 = new Parcel(100, 200, 150, 10, false);

        Validator validator = new Validator();
        validator.validate(parcel1);
        System.out.println();
        validator.validate(parcel2);
        System.out.println();
        validator.validate(parcel3);
        System.out.println();
        validator.validate(parcel4);
        System.out.println();

    }
}
