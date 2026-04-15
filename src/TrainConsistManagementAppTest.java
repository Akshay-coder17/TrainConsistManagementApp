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
        bogies.add(new TrainConsistManagementApp.Bogie("Sleeper", 70));
        bogies.add(new TrainConsistManagementApp.Bogie("AC Chair", 60));
        return bogies;
    }

    @Test
    public void testGrouping_BogiesGroupedByType() {
        Map<String, List<TrainConsistManagementApp.Bogie>> grouped =
                getBogies().stream()
                        .collect(Collectors.groupingBy(TrainConsistManagementApp.Bogie::getType));

        assertTrue(grouped.containsKey("Sleeper"));
        assertTrue(grouped.containsKey("AC Chair"));
    }

    @Test
    public void testGrouping_MultipleBogiesInSameGroup() {
        Map<String, List<TrainConsistManagementApp.Bogie>> grouped =
                getBogies().stream()
                        .collect(Collectors.groupingBy(TrainConsistManagementApp.Bogie::getType));

        assertEquals(2, grouped.get("Sleeper").size());
    }

    @Test
    public void testGrouping_DifferentBogieTypes() {
        Map<String, List<TrainConsistManagementApp.Bogie>> grouped =
                getBogies().stream()
                        .collect(Collectors.groupingBy(TrainConsistManagementApp.Bogie::getType));

        assertEquals(3, grouped.size());
    }

    @Test
    public void testGrouping_EmptyBogieList() {
        List<TrainConsistManagementApp.Bogie> bogies = new ArrayList<>();

        Map<String, List<TrainConsistManagementApp.Bogie>> grouped =
                bogies.stream()
                        .collect(Collectors.groupingBy(TrainConsistManagementApp.Bogie::getType));

        assertTrue(grouped.isEmpty());
    }

    @Test
    public void testGrouping_SingleBogieCategory() {
        List<TrainConsistManagementApp.Bogie> bogies = new ArrayList<>();
        bogies.add(new TrainConsistManagementApp.Bogie("Sleeper", 72));

        Map<String, List<TrainConsistManagementApp.Bogie>> grouped =
                bogies.stream()
                        .collect(Collectors.groupingBy(TrainConsistManagementApp.Bogie::getType));

        assertEquals(1, grouped.size());
    }

    @Test
    public void testGrouping_MapContainsCorrectKeys() {
        Map<String, List<TrainConsistManagementApp.Bogie>> grouped =
                getBogies().stream()
                        .collect(Collectors.groupingBy(TrainConsistManagementApp.Bogie::getType));

        assertTrue(grouped.keySet().contains("Sleeper"));
        assertTrue(grouped.keySet().contains("AC Chair"));
        assertTrue(grouped.keySet().contains("First Class"));
    }

    @Test
    public void testGrouping_GroupSizeValidation() {
        Map<String, List<TrainConsistManagementApp.Bogie>> grouped =
                getBogies().stream()
                        .collect(Collectors.groupingBy(TrainConsistManagementApp.Bogie::getType));

        assertEquals(2, grouped.get("AC Chair").size());
    }

    @Test
    public void testGrouping_OriginalListUnchanged() {
        List<TrainConsistManagementApp.Bogie> original = getBogies();

        original.stream()
                .collect(Collectors.groupingBy(TrainConsistManagementApp.Bogie::getType));

        assertEquals(5, original.size());
    }
}