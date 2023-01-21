package Ex7;

public class Main {
    public static void main(String[] args) {

        GunMagazine gun = new GunMagazine(6);

        checkIfGunLoaded(gun);

        gun.loadedWithBullets(8);

        checkIfGunLoaded(gun);

        gun.shotBullets(9);

        checkIfGunLoaded(gun);
    }

    private static void checkIfGunLoaded(GunMagazine gun) {
        System.out.println("Bron naladowana: " + gun.isLoaded());
    }

}
