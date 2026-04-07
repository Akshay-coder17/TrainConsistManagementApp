public class TrainConsistManagementApp {

    static class InvalidCapacityException extends Exception {
        public InvalidCapacityException(String message) {
            super(message);
        }
    }

    static class Bogie {
        private String name;
        private int capacity;

        public Bogie(String name, int capacity) throws InvalidCapacityException {
            if (capacity <= 0) {
                throw new InvalidCapacityException("Capacity must be greater than zero");
            }
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

        System.out.println("=== UC14: Handling Invalid Bogie Capacity ===");

        try {
            Bogie validBogie = new Bogie("Sleeper", 72);
            System.out.println("Created: " + validBogie);
        } catch (InvalidCapacityException e) {
            System.out.println(e.getMessage());
        }

        try {
            new Bogie("AC Chair", -10);
        } catch (InvalidCapacityException e) {
            System.out.println("Error: " + e.getMessage());
        }

        try {
            new Bogie("First Class", 0);
        } catch (InvalidCapacityException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}