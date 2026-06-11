import java.util.ArrayList;

/**
 * Represents a shipping container bound for a single destination.
 * Holds packages and enforces a maximum weight capacity.
 */
public class Container {

    private static int nextContainerId = 1;

    private String containerId;
    private String destination;
    private double maxWeightKg;
    private ArrayList<Package> packages;

    public Container(String destination, double maxWeightKg) {

        if(destination == null || destination.isEmpty())
            throw new IllegalArgumentException("Invalid destination");
        else
            this.destination = destination;

        if(maxWeightKg <= 0)
            throw new IllegalArgumentException("Invalid maximum weight");
        else
            this.maxWeightKg = maxWeightKg;

        containerId = String.format("CNT-%03d", nextContainerId);

        nextContainerId++;

        this.packages = new ArrayList<Package>();

    }


    public Container(String destination) {
        this(destination, 500.0);
    }

    public String getContainerId(){
        return this.containerId;
    }

    public String getDestination(){
        return this.destination;
    }

    public double getMaxWeightKg(){
        return this.maxWeightKg;
    }

    public boolean addPackage(Package p) {

        if(p == null || !p.getDestination().equals(destination) || getCurrentWeightKg() + p.getWeightKg() > maxWeightKg)
            return false;

        packages.add(p);
        return true;

    }


    public double getCurrentWeightKg() {

        double currentWeight = 0.0;

        for(Package pkg : packages){
            currentWeight += pkg.getWeightKg();
        }
        return currentWeight;
    }

    public double getRemainingCapacityKg() {
        return maxWeightKg - getCurrentWeightKg(); // TODO M8
    }

    public int getPackageCount() {
        return packages.size(); // TODO M8
    }

    public double getTotalRevenue() {

        double shippingCost = 0.0;

        for(Package pkg : packages){
            shippingCost += pkg.getShippingCost();
        }
        return shippingCost;

    }

    public String getManifest() {

        StringBuilder sb = new StringBuilder();

        sb.append(String.format("=== %s -> %s (%d packages, %.2f / %.2f kg) ===\n",
                containerId, destination, packages.size(),
                getCurrentWeightKg(), maxWeightKg));

        double revenue = 0.0;

        for(Package pkg : packages){
            sb.append("  " + pkg + "\n");

            revenue += pkg.getShippingCost();
        }

        sb.append(String.format("  Container revenue: $%.2f\n", revenue));

        return sb.toString();
    }

    public ArrayList<Package> getPackages() {
        return packages;
    }

    @Override
    public String toString() {
        return  String.format("%s -> %s [%d packages, %.2f / %.2f kg]",
                containerId, destination, packages.size(),
                getCurrentWeightKg(), maxWeightKg); // TODO M9
    }
}
