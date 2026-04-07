import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TrainConsistManagementApp {

    static class Bogie {
        private String name;
        private int capacity;

        public Bogie(String name, int capacity) {
            this.name = name;
            this.capacity = capacity;
        }

        public String getName() {
            return name;
        }

        public int getCapacity() {
            return capacity;
        }

        public String toString() {
            return "Bogie[name=" + name + ", capacity=" + capacity + "]";
        }
    }

    public static void main(String[] args) {

        System.out.println("=== UC8: Filter Bogies by Capacity ===");

        List<Bogie> bogies = new ArrayList<>();

        bogies.add(new Bogie("Sleeper", 72));
        bogies.add(new Bogie("AC Chair", 56));
        bogies.add(new Bogie("Second Class", 90));
        bogies.add(new Bogie("First Class", 24));

        System.out.println("Original bogie list:");
        bogies.forEach(System.out::println);

        int threshold = 60;

        List<Bogie> highCapacityBogies = bogies.stream()
                .filter(b -> b.getCapacity() > threshold)
                .collect(Collectors.toList());

        System.out.println("Bogies with capacity > " + threshold + ":");
        highCapacityBogies.forEach(System.out::println);

        System.out.println("Original list size: " + bogies.size());
    }
}