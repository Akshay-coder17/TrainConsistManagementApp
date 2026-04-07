import java.util.ArrayList;
import java.util.List;

public class TrainConsistManagementApp {

    public static void searchBogie(List<String> bogies, String searchId) {

        if (bogies.isEmpty()) {
            throw new IllegalStateException("Cannot perform search: Train has no bogies");
        }

        boolean found = false;

        for (String id : bogies) {
            if (id.equals(searchId)) {
                found = true;
                break;
            }
        }

        if (found) {
            System.out.println("Bogie ID found: " + searchId);
        } else {
            System.out.println("Bogie ID not found: " + searchId);
        }
    }

    public static void main(String[] args) {

        System.out.println("=== UC20: Exception Handling During Search Operations ===");

        List<String> bogies = new ArrayList<>();

        try {
            searchBogie(bogies, "BG101");
        } catch (IllegalStateException e) {
            System.out.println("Error: " + e.getMessage());
        }

        bogies.add("BG101");
        bogies.add("BG205");
        bogies.add("BG309");

        searchBogie(bogies, "BG205");
    }
}