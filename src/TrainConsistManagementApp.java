import java.util.Arrays;

public class TrainConsistManagementApp {

    public static void main(String[] args) {

        System.out.println("=== UC19: Binary Search for Bogie ID ===");

        String[] bogieIds = {"BG101", "BG205", "BG309", "BG412", "BG550"};

        String searchId = "BG309";

        System.out.println("Sorted bogie IDs:");
        System.out.println(Arrays.toString(bogieIds));

        int low = 0;
        int high = bogieIds.length - 1;
        boolean found = false;

        while (low <= high) {

            int mid = (low + high) / 2;

            int comparison = searchId.compareTo(bogieIds[mid]);

            if (comparison == 0) {
                found = true;
                System.out.println("Bogie ID found at index: " + mid);
                break;
            } else if (comparison > 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        if (!found) {
            System.out.println("Bogie ID not found: " + searchId);
        }
    }
}