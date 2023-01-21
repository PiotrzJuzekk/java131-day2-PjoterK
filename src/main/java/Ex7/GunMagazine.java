package Ex7;

import java.util.ArrayList;
import java.util.List;

public class GunMagazine {
    private int maxMagazineSize;
    private List<String> magazine = new ArrayList<>();

    public GunMagazine(int magazineSize) {
        this.maxMagazineSize = magazineSize;
    }

    public void loadBullet(String bulletName) {

        if (maxMagazineSize <= magazine.size()){
            System.out.println("przekroczono limit");
            return;
        }
        magazine.add(bulletName);
        System.out.println(magazine);
    }

    public boolean isLoaded(){
        if (magazine.size() > 0){
            return true;
        } else {
            return false;
        }
    }
}
