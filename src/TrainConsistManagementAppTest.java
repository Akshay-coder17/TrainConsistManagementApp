import org.junit.jupiter.api.Test;
import java.util.*;
import java.util.stream.Collectors;
import static org.junit.jupiter.api.Assertions.*;

public class TrainConsistManagementAppTest {

    private List<TrainConsistManagementApp.Bogie> getBogies() {
        List<TrainConsistManagementApp.Bogie> bogies = new ArrayList<>();
        bogies.add(new TrainConsistManagementApp.Bogie("Sleeper", 72));
        bogies.add(new TrainConsistManagementApp.Bogie("AC Chair", 56));
        bogies.add(new TrainConsistManagementApp.Bogie("First Class", 24));
        bogies.add(new TrainConsistManagementApp.Bogie("General", 90));
        return bogies;
    }

    @Test
    public void testFilter_CapacityGreaterThanThreshold() {
        List<TrainConsistManagementApp.Bogie> result =
                getBogies().stream()
                        .filter(b -> b.getCapacity() > 60)
                        .collect(Collectors.toList());

        assertEquals(2, result.size());
    }

    @Test
    public void testFilter_CapacityEqualToThreshold() {
        List<TrainConsistManagementApp.Bogie> bogies = new ArrayList<>();
        bogies.add(new TrainConsistManagementApp.Bogie("Test", 60));

        List<TrainConsistManagementApp.Bogie> result =
                bogies.stream()
                        .filter(b -> b.getCapacity() > 60)
                        .collect(Collectors.toList());

        assertTrue(result.isEmpty());
    }

    @Test
    public void testFilter_CapacityLessThanThreshold() {
        List<TrainConsistManagementApp.Bogie> result =
                getBogies().stream()
                        .filter(b -> b.getCapacity() > 80)
                        .collect(Collectors.toList());

        assertEquals(1, result.size());
    }

    @Test
    public void testFilter_MultipleBogiesMatching() {
        List<TrainConsistManagementApp.Bogie> result =
                getBogies().stream()
                        .filter(b -> b.getCapacity() > 50)
                        .collect(Collectors.toList());

        assertEquals(3, result.size());
    }

    @Test
    public void testFilter_NoBogiesMatching() {
        List<TrainConsistManagementApp.Bogie> result =
                getBogies().stream()
                        .filter(b -> b.getCapacity() > 100)
                        .collect(Collectors.toList());

        assertTrue(result.isEmpty());
    }

    @Test
    public void testFilter_AllBogiesMatching() {
        List<TrainConsistManagementApp.Bogie> result =
                getBogies().stream()
                        .filter(b -> b.getCapacity() > 10)
                        .collect(Collectors.toList());

        assertEquals(4, result.size());
    }

    @Test
    public void testFilter_EmptyBogieList() {
        List<TrainConsistManagementApp.Bogie> bogies = new ArrayList<>();

        List<TrainConsistManagementApp.Bogie> result =
                bogies.stream()
                        .filter(b -> b.getCapacity() > 60)
                        .collect(Collectors.toList());

        assertTrue(result.isEmpty());
    }

    @Test
    public void testFilter_OriginalListUnchanged() {
        List<TrainConsistManagementApp.Bogie> original = getBogies();

        original.stream()
                .filter(b -> b.getCapacity() > 60)
                .collect(Collectors.toList());

        assertEquals(4, original.size());
    }
}