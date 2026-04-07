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

        public int getCapacity() {
            return capacity;
        }
    }

    public static void main(String[] args) {

        System.out.println("=== UC13: Performance Comparison (Loops vs Streams) ===");

        List<Bogie> dataset = new ArrayList<>();

        for (int i = 0; i < 1_000_000; i++) {
            dataset.add(new Bogie("Passenger Bogie", (i % 2 == 0) ? 72 : 50));
        }

        long loopStart = System.nanoTime();

        List<Bogie> loopFiltered = new ArrayList<>();
        for (Bogie b : dataset) {
            if (b.getCapacity() > 60) {
                loopFiltered.add(b);
            }
        }

        long loopEnd = System.nanoTime();
        long loopTime = loopEnd - loopStart;

        System.out.println("Loop filtered size: " + loopFiltered.size());
        System.out.println("Loop time (ns): " + loopTime);

        long streamStart = System.nanoTime();

        List<Bogie> streamFiltered = dataset.stream()
                .filter(b -> b.getCapacity() > 60)
                .collect(Collectors.toList());

        long streamEnd = System.nanoTime();
        long streamTime = streamEnd - streamStart;

        System.out.println("Stream filtered size: " + streamFiltered.size());
        System.out.println("Stream time (ns): " + streamTime);

        System.out.println("Sizes match: " + (loopFiltered.size() == streamFiltered.size()));
    }
}