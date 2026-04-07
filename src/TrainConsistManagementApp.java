public class TrainConsistManagementApp {

    public static void main(String[] args) {

        System.out.println("=== UC18: Search Bogie ID using Linear Search ===");

        String[] bogieIds = {"BG101", "BG205", "BG309", "BG412", "BG550"};

        String searchId = "BG309";

        System.out.println("Available bogie IDs:");
        for (String id : bogieIds) {
            System.out.print(id + " ");
        }

        boolean found = false;

        for (String id : bogieIds) {
            if (id.equals(searchId)) {
                found = true;
                break;
            }
        }

        if (found) {
            System.out.println("\nBogie ID found: " + searchId);
        } else {
            System.out.println("\nBogie ID not found: " + searchId);
        }
    }
}