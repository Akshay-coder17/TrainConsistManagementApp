import java.util.Arrays;

public class TrainConsistManagementApp {

    public static void main(String[] args) {

        System.out.println("=== UC17: Sort Bogie Names using Arrays.sort ===");

        String[] bogieNames = {"Sleeper", "AC Chair", "First Class", "General", "Luxury"};

        System.out.println("Before sorting:");
        System.out.println(Arrays.toString(bogieNames));

        Arrays.sort(bogieNames);

        System.out.println("After sorting:");
        System.out.println(Arrays.toString(bogieNames));
    }
}