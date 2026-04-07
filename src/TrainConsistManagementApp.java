import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class TrainConsistManagementApp {

    static class GoodsBogie {
        private String type;
        private String cargo;

        public GoodsBogie(String type, String cargo) {
            this.type = type;
            this.cargo = cargo;
        }

        public String getType() {
            return type;
        }

        public String getCargo() {
            return cargo;
        }

        public String toString() {
            return "GoodsBogie[type=" + type + ", cargo=" + cargo + "]";
        }
    }

    public static boolean checkSafetyCompliance(List<GoodsBogie> bogies) {
        return bogies.stream()
                .allMatch(b -> !b.getType().equalsIgnoreCase("Cylindrical")
                        || b.getCargo().equalsIgnoreCase("Petroleum"));
    }

    public static void main(String[] args) {

        System.out.println("=== UC12: Safety Compliance Check ===");

        List<GoodsBogie> safeTrain = Arrays.asList(
                new GoodsBogie("Cylindrical", "Petroleum"),
                new GoodsBogie("Box", "Coal"),
                new GoodsBogie("Open", "Grain")
        );

        System.out.println("Safe train:");
        safeTrain.forEach(System.out::println);
        System.out.println("Compliant: " + checkSafetyCompliance(safeTrain));

        List<GoodsBogie> unsafeTrain = Arrays.asList(
                new GoodsBogie("Cylindrical", "Coal"),
                new GoodsBogie("Box", "Grain")
        );

        System.out.println("Unsafe train:");
        unsafeTrain.forEach(System.out::println);
        System.out.println("Compliant: " + checkSafetyCompliance(unsafeTrain));

        List<GoodsBogie> flexibleTrain = Arrays.asList(
                new GoodsBogie("Box", "Petroleum"),
                new GoodsBogie("Open", "Coal")
        );

        System.out.println("Flexible train:");
        flexibleTrain.forEach(System.out::println);
        System.out.println("Compliant: " + checkSafetyCompliance(flexibleTrain));

        List<GoodsBogie> emptyTrain = Collections.emptyList();

        System.out.println("Empty train compliant: " + checkSafetyCompliance(emptyTrain));
    }
}