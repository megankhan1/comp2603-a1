import java.util.Arrays;
import java.util.List;

/**
 * Represents a single cargo item in the Caribbean freight system.
 * Each package is auto-assigned a unique tracking ID in the format PKG-XXXX.
 */
public class Package {

    private static int nextTrackingNumber = 1;

    private static final List<String> VALID_DESTINATIONS = Arrays.asList(
            "Trinidad", "Barbados", "Jamaica", "Antigua", "Grenada"
    );

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
    private boolean isExpress;

    public Package(String senderName, String receiverName, double weightKg,
                   int lengthCm, int widthCm, int heightCm,
                   String destination, boolean isFragile, double declaredValue) {

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

    public Package(String senderName, String receiverName, double weightKg,
                   int lengthCm, int widthCm, int heightCm, String destination) {

        this(senderName, receiverName, weightKg, lengthCm, widthCm, heightCm,
                destination, false, 0.0);
    }

    public Package(String senderName, String receiverName, double weightKg,
                   int lengthCm, int widthCm, int heightCm,
                   String destination, boolean isFragile, double declaredValue, boolean isExpress) {

        this(senderName, receiverName, weightKg, lengthCm, widthCm, heightCm,
                destination, isFragile, declaredValue);

        this.isExpress = isExpress;

    }

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

    public boolean getIsExpress(){
        return this.isExpress;
    }

    public int getVolumeCm3() {
        return lengthCm * widthCm * heightCm; // TODO M5
    }

    public double getVolumetricWeightKg() {
        return getVolumeCm3() / 5000.0; // TODO M5
    }

    public double getBillableWeightKg() {
        return Math.max(weightKg, getVolumetricWeightKg()); // TODO M5
    }

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
    }

    @Override
    public String toString() {

        String base = String.format("PKG-%04d  %s -> %s  %s  %.2f kg $%.2f",
                Integer.parseInt(trackingId.substring(4)),
                senderName, receiverName, destination,
                getBillableWeightKg(), getShippingCost());

        if(isFragile)
            base += " [FRAGILE]";

        return base;
    }
}
