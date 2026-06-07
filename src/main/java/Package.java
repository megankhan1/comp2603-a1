import java.util.Arrays;
import java.util.List;

/**
 * Represents a single cargo item in the Caribbean freight system.
 * Each package is auto-assigned a unique tracking ID in the format PKG-XXXX.
 */
public class Package {

    // TODO M1: Initialise this static counter to 1.
    private static int nextTrackingNumber = 1;

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

        if(senderName == null || senderName.isEmpty())
            throw new IllegalArgumentException("Sender name must not be null or empty");
        else
            this.senderName = senderName;

        if(receiverName == null || receiverName.isEmpty())
            throw new IllegalArgumentException("Receiver name must not be null or empty");
        else
            this.receiverName = receiverName;

        if(weightKg <= 0)
            throw new IllegalArgumentException("Weight is invalid");
        else
            this.weightKg = weightKg;

        if(lengthCm <= 0)
            throw new IllegalArgumentException("Length invalid");
        else
            this.lengthCm = lengthCm;

        if(widthCm <= 0)
            throw new IllegalArgumentException("Width invalid");
        else
            this.widthCm = widthCm;

        if(heightCm <= 0)
            throw new IllegalArgumentException("Height invalid");
        else
            this.heightCm = heightCm;

        boolean validDestination = false;

        for(String destinationList : VALID_DESTINATIONS) {
            if (destination.equals(destinationList)) {
                validDestination = true;
                break;
            }
        }

        if(!validDestination)
            throw new IllegalArgumentException("Destination invalid");

        this.destination = destination;

        this.isFragile = isFragile;

        this.declaredValue = declaredValue;

        trackingId = String.format("PKG-%04d", nextTrackingNumber);

        nextTrackingNumber++;
    }

    /**
     * Convenience constructor: not fragile, no declared value.
     * TODO M3: Chain to the full constructor using this(...) with
     *   isFragile=false and declaredValue=0.0
     */
    public Package(String senderName, String receiverName, double weightKg,
                   int lengthCm, int widthCm, int heightCm, String destination) {
        // TODO M3: Write the this(...) call here

        this(senderName, receiverName, weightKg, lengthCm, widthCm, heightCm,
                destination, false, 0.0);
    }

    // --- Getters ---
    // TODO M4: Write getters for ALL fields:
    //   getTrackingId(), getSenderName(), getReceiverName(), getWeightKg(),
    //   getLengthCm(), getWidthCm(), getHeightCm(), getDestination(),
    //   isFragile(), getDeclaredValue()

    public String getTrackingId(){
        return this.trackingId;
    }

    public String getSenderName(){
        return this.senderName;
    }

    public String getReceiverName(){
        return this.receiverName;
    }

    public double getWeightKg(){
        return this.weightKg;
    }

    public int getLengthCm(){
        return this.lengthCm;
    }

    public int getWidthCm(){
        return this.widthCm;
    }

    public int getHeightCm(){
        return this.heightCm;
    }

    public String getDestination(){
        return this.destination;
    }

    public boolean isFragile(){
        return this.isFragile;
    }

    public double getDeclaredValue(){
        return this.declaredValue;
    }

    // --- Computed methods ---

    /**
     * TODO M5: Return lengthCm * widthCm * heightCm
     */
    public int getVolumeCm3() {
        return lengthCm * widthCm * heightCm; // TODO M5
    }

    /**
     * TODO M5: Return getVolumeCm3() / 5000.0
     */
    public double getVolumetricWeightKg() {
        return getVolumeCm3() / 5000.0; // TODO M5
    }

    /**
     * TODO M5: Return Math.max(weightKg, getVolumetricWeightKg())
     */
    public double getBillableWeightKg() {
        return Math.max(weightKg, getVolumetricWeightKg()); // TODO M5
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
        double ratePerKg;

        switch(destination){
            case "Trinidad": ratePerKg = 8.00; break;
            case "Barbados": ratePerKg = 12.50; break;
            case "Jamaica": ratePerKg = 15.00; break;
            case "Antigua": ratePerKg = 18.00; break;
            case "Grenada": ratePerKg = 10.00; break;
            default: ratePerKg = 0.0; break;
        }

        double cost = getBillableWeightKg() * ratePerKg;

        if(isFragile){
            cost *= 1.25;
        }

        if(declaredValue > 0){
            cost += declaredValue * 0.015;
        }

        return Math.round(cost * 100) / 100.0;
        // TODO M6
    }

    /**
     * TODO M7: Return a string in this format:
     *   "PKG-0001  Alice -> Bob  Trinidad  5.00 kg  $40.00"
     * If fragile, append "  [FRAGILE]" at the end.
     * Use String.format for formatting.
     */
    @Override
    public String toString() {

        String base = String.format("PKG-%04d  %s -> %s  %s  %.2f kg $%.2f",
                Integer.parseInt(trackingId.substring(4)),
                senderName, receiverName, destination,
                getBillableWeightKg(), getShippingCost());

        if(isFragile)
            base += " [FRAGILE";

        return base;

        // TODO M7
    }
}
