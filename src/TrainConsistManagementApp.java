import java.util.ArrayList;
import java.util.List;

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

        System.out.println("=== UC10: Calculate Total Seating Capacity ===");

        List<Bogie> bogies = new ArrayList<>();

        bogies.add(new Bogie("Sleeper", 72));
        bogies.add(new Bogie("AC Chair", 56));
        bogies.add(new Bogie("First Class", 24));
        bogies.add(new Bogie("Second Class", 90));

        System.out.println("Original bogie list:");
        bogies.forEach(System.out::println);

        int totalSeats = bogies.stream()
                .map(Bogie::getCapacity)
                .reduce(0, Integer::sum);

        System.out.println("Total seating capacity: " + totalSeats);

        List<Bogie> emptyBogies = new ArrayList<>();

        int emptyTotal = emptyBogies.stream()
                .map(Bogie::getCapacity)
                .reduce(0, Integer::sum);

        System.out.println("Empty list capacity: " + emptyTotal);

        System.out.println("Original list size: " + bogies.size());
    }
}