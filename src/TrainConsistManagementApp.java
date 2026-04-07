import java.util.ArrayList;
import java.util.Comparator;
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

        System.out.println("=== UC7: Sort Bogies by Capacity ===");

        List<Bogie> bogies = new ArrayList<>();

        bogies.add(new Bogie("Sleeper", 72));
        bogies.add(new Bogie("AC Chair", 56));
        bogies.add(new Bogie("First Class", 24));

        System.out.println("Before sorting:");
        for (Bogie b : bogies) {
            System.out.println(b);
        }

        bogies.sort(Comparator.comparingInt(Bogie::getCapacity));

        System.out.println("After sorting by capacity:");
        for (Bogie b : bogies) {
            System.out.println(b);
        }
    }
}