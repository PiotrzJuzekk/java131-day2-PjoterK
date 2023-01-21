package Ex8;

public class Validator {
    private void isSizeViable(Parcel parcel){
        if (parcel.getxLength() + parcel.getyLength() + parcel.getzLength() <= 300){
            System.out.println("wymiary " + parcel + " sa poprawne");
        } else {
            System.out.println("wymiary " + parcel + " sa zle");
        }
    }

    private void isWeightGood(Parcel parcel){
        if (parcel.getWeight() <= 30 && !parcel.isExpress()){
            System.out.println("waga " + parcel + " jest dobra i nie jest ekspresowa");
        } else if (parcel.getWeight() <= 15 && parcel.isExpress()){
            System.out.println("waga " + parcel + " jest dobra i jest ekspresowa");
        } else {
            System.out.println("paczka " + parcel + " jest zlej wagi");
        }
    }
    public void validate(Parcel parcel){
        isSizeViable(parcel);
        isWeightGood(parcel);
    }
}
