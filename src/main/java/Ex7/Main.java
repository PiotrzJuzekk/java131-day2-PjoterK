package Ex7;

public class Main {
    public static void main(String[] args) {

        GunMagazine gun = new GunMagazine(6);

        checkIfGunLoaded(gun);

        gun.loadBullet("bullet 1");
        gun.loadBullet("bullet 2");
        gun.loadBullet("bullet 3");
        gun.loadBullet("bullet 4");
        gun.loadBullet("bullet 5");
        gun.loadBullet("bullet 6");
        gun.loadBullet("bullet 7");
        gun.loadBullet("bullet 8");

        checkIfGunLoaded(gun);
    }

    private static void checkIfGunLoaded(GunMagazine gun) {
        System.out.println("Bron naladowana: " + gun.isLoaded());
    }
}
