package Ex16;

public class Main {
    public static void main(String[] args) {
        System.out.println(Runner.getFitnessLevel(130));
        System.out.println(Runner.getFitnessLevel(170));
        System.out.println(Runner.getFitnessLevel(150));

        System.out.println(Runner.getFitnessLevel2(130));
        System.out.println(Runner.getFitnessLevel2(170));
        System.out.println(Runner.getFitnessLevel2(150));

        System.out.println("XXXXXXXXXXXX");

        System.out.println(Runner.getFitnessLevel3(130));
        System.out.println(Runner.getFitnessLevel3(170));
        System.out.println(Runner.getFitnessLevel3(150));
        System.out.println(Runner.getFitnessLevel3(-1));

    }
}
