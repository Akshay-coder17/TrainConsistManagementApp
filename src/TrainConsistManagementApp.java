import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TrainConsistManagementApp {

    static class Bogie {
        private String type;
        private int capacity;

        public Bogie(String type, int capacity) {
            this.type = type;
            this.capacity = capacity;
        }

        public String getType() {
            return type;
        }

        public int getCapacity() {
            return capacity;
        }

        public String toString() {
            return "Bogie[type=" + type + ", capacity=" + capacity + "]";
        }
    }

    public static void main(String[] args) {

        System.out.println("=== UC9: Group Bogies by Type ===");

        List<Bogie> bogies = new ArrayList<>();

        bogies.add(new Bogie("Sleeper", 72));
        bogies.add(new Bogie("Sleeper", 72));
        bogies.add(new Bogie("AC Chair", 56));
        bogies.add(new Bogie("First Class", 24));
        bogies.add(new Bogie("First Class", 24));

        System.out.println("Original bogie list size: " + bogies.size());

        Map<String, List<Bogie>> groupedBogies = bogies.stream()
                .collect(Collectors.groupingBy(Bogie::getType));

        System.out.println("Grouped bogies:");

        for (Map.Entry<String, List<Bogie>> entry : groupedBogies.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue().size() + " bogies");
            entry.getValue().forEach(System.out::println);
        }

        System.out.println("Collection size unchanged: " + bogies.size());
    }
}