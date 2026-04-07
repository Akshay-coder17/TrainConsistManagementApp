import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TrainConsistManagementApp {

    private static final Pattern TRAIN_ID_PATTERN = Pattern.compile("^TRN-\\d{4}$");
    private static final Pattern CARGO_CODE_PATTERN = Pattern.compile("^PET-[A-Z]{2}$");

    public static boolean validateTrainId(String trainId) {
        if (trainId == null) return false;
        Matcher matcher = TRAIN_ID_PATTERN.matcher(trainId);
        return matcher.matches();
    }

    public static boolean validateCargoCode(String cargoCode) {
        if (cargoCode == null) return false;
        Matcher matcher = CARGO_CODE_PATTERN.matcher(cargoCode);
        return matcher.matches();
    }

    public static void main(String[] args) {

        System.out.println("=== UC11: Validate Train and Cargo Codes ===");

        List<String> trainIds = Arrays.asList(
                "TRN-1234",
                "TRAIN12",
                "TRN12A",
                "1234-TRN",
                "TRN-123",
                "TRN-12345",
                ""
        );

        System.out.println("Train ID validation:");

        for (String id : trainIds) {
            System.out.println(id + " -> " + validateTrainId(id));
        }

        List<String> cargoCodes = Arrays.asList(
                "PET-AB",
                "PET-ab",
                "PET123",
                "AB-PET",
                "PET-A",
                "PET-ABC",
                ""
        );

        System.out.println("Cargo code validation:");

        for (String code : cargoCodes) {
            System.out.println(code + " -> " + validateCargoCode(code));
        }
    }
}