import java.util.Arrays;
import java.util.List;

/**
 * Represents a single cargo item in the Caribbean freight system.
 * Each package is auto-assigned a unique tracking ID in the format PKG-XXXX.
 */
public class Package {

    // TODO M1: Initialise this static counter to 1.
    private static int nextTrackingNumber;

    private static final List<String> VALID_DESTINATIONS = Arrays.asList(
            "Trinidad", "Barbados", "Jamaica", "Antigua", "Grenada"
    );

    // TODO M1: These fields are declared but not yet assigned.
    // Your constructors (M2, M3) must assign them.
    private String trackingId;
    private String senderName;
    private String receiverName;
    private double weightKg;
    private int lengthCm;
    private int widthCm;
    private int heightCm;
    private String destination;
    private boolean isFragile;
    private double declaredValue;

    /**
     * Full constructor with all 9 parameters.
     * TODO M2: Implement this constructor.
     *   - Validate: senderName and receiverName non-null and non-empty
     *   - Validate: weightKg > 0
     *   - Validate: all dimensions > 0
     *   - Validate: destination is in VALID_DESTINATIONS
     *   - Throw IllegalArgumentException on any failure
     *   - Auto-assign trackingId using String.format("PKG-%04d", nextTrackingNumber)
     *   - Increment nextTrackingNumber
     *   - Assign all fields
     */
    public Package(String senderName, String receiverName, double weightKg,
                   int lengthCm, int widthCm, int heightCm,
                   String destination, boolean isFragile, double declaredValue) {
        // TODO M2: Write validation and field assignments here
    }

    /**
     * Convenience constructor: not fragile, no declared value.
     * TODO M3: Chain to the full constructor using this(...) with
     *   isFragile=false and declaredValue=0.0
     */
    public Package(String senderName, String receiverName, double weightKg,
                   int lengthCm, int widthCm, int heightCm, String destination) {
        // TODO M3: Write the this(...) call here
    }

    // --- Getters ---
    // TODO M4: Write getters for ALL fields:
    //   getTrackingId(), getSenderName(), getReceiverName(), getWeightKg(),
    //   getLengthCm(), getWidthCm(), getHeightCm(), getDestination(),
    //   isFragile(), getDeclaredValue()

    // --- Computed methods ---

    /**
     * TODO M5: Return lengthCm * widthCm * heightCm
     */
    public int getVolumeCm3() {
        return 0; // TODO M5
    }

    /**
     * TODO M5: Return getVolumeCm3() / 5000.0
     */
    public double getVolumetricWeightKg() {
        return 0.0; // TODO M5
    }

    /**
     * TODO M5: Return Math.max(weightKg, getVolumetricWeightKg())
     */
    public double getBillableWeightKg() {
        return 0.0; // TODO M5
    }

    /**
     * TODO M6: Implement the shipping cost formula.
     *   1. Look up rate per kg by destination
     *   2. cost = getBillableWeightKg() * ratePerKg
     *   3. If fragile: cost *= 1.25
     *   4. If declaredValue > 0: cost += declaredValue * 0.015
     *   5. Round: Math.round(cost * 100) / 100.0
     */
    public double getShippingCost() {
        return 0.0; // TODO M6
    }

    /**
     * TODO M7: Return a string in this format:
     *   "PKG-0001  Alice -> Bob  Trinidad  5.00 kg  $40.00"
     * If fragile, append "  [FRAGILE]" at the end.
     * Use String.format for formatting.
     */
    @Override
    public String toString() {
        return ""; // TODO M7
    }
}
