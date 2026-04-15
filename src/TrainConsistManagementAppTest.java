import org.junit.jupiter.api.Test;
import java.util.*;
import java.util.stream.*;
import static org.junit.jupiter.api.Assertions.*;

public class TrainConsistManagementAppTest {

    private List<TrainConsistManagementApp.Bogie> getBogies() {
        List<TrainConsistManagementApp.Bogie> bogies = new ArrayList<>();
        bogies.add(new TrainConsistManagementApp.Bogie("Sleeper", 72));
        bogies.add(new TrainConsistManagementApp.Bogie("AC Chair", 56));
        bogies.add(new TrainConsistManagementApp.Bogie("First Class", 24));
        bogies.add(new TrainConsistManagementApp.Bogie("Sleeper", 70));
        return bogies;
    }

    @Test
    public void testReduce_TotalSeatCalculation() {
        int total = getBogies().stream()
                .map(TrainConsistManagementApp.Bogie::getCapacity)
                .reduce(0, Integer::sum);

        assertEquals(222, total);
    }

    @Test
    public void testReduce_MultipleBogiesAggregation() {
        int total = getBogies().stream()
                .map(TrainConsistManagementApp.Bogie::getCapacity)
                .reduce(0, Integer::sum);

        assertTrue(total > 0);
    }

    @Test
    public void testReduce_SingleBogieCapacity() {
        List<TrainConsistManagementApp.Bogie> bogies = new ArrayList<>();
        bogies.add(new TrainConsistManagementApp.Bogie("Sleeper", 72));

        int total = bogies.stream()
                .map(TrainConsistManagementApp.Bogie::getCapacity)
                .reduce(0, Integer::sum);

        assertEquals(72, total);
    }

    @Test
    public void testReduce_EmptyBogieList() {
        List<TrainConsistManagementApp.Bogie> bogies = new ArrayList<>();

        int total = bogies.stream()
                .map(TrainConsistManagementApp.Bogie::getCapacity)
                .reduce(0, Integer::sum);

        assertEquals(0, total);
    }

    @Test
    public void testReduce_CorrectCapacityExtraction() {
        List<Integer> capacities = getBogies().stream()
                .map(TrainConsistManagementApp.Bogie::getCapacity)
                .collect(Collectors.toList());

        assertTrue(capacities.contains(72));
        assertTrue(capacities.contains(56));
    }

    @Test
    public void testReduce_AllBogiesIncluded() {
        int total = getBogies().stream()
                .map(TrainConsistManagementApp.Bogie::getCapacity)
                .reduce(0, Integer::sum);

        assertEquals(222, total);
    }

    @Test
    public void testReduce_OriginalListUnchanged() {
        List<TrainConsistManagementApp.Bogie> original = getBogies();

        original.stream()
                .map(TrainConsistManagementApp.Bogie::getCapacity)
                .reduce(0, Integer::sum);

        assertEquals(4, original.size());
    }
}