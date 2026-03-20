import java.util.LinkedList;
import java.util.List;

public class TrainConsistManagementApp {

    public static void main(String[] args) {

        System.out.println("=== UC4: Maintain Ordered Bogie Consist ===");

        List<String> trainConsist = new LinkedList<>();

        trainConsist.add("Engine");
        trainConsist.add("Sleeper");
        trainConsist.add("AC");
        trainConsist.add("Cargo");
        trainConsist.add("Guard");

        System.out.println("Initial train consist:");
        System.out.println(trainConsist);

        trainConsist.add(2, "Pantry");

        System.out.println("After inserting Pantry at position 2:");
        System.out.println(trainConsist);

        trainConsist.remove(0);
        trainConsist.remove(trainConsist.size() - 1);

        System.out.println("After removing first and last bogie:");
        System.out.println(trainConsist);
    }
}