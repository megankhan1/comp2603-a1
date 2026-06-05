import java.util.ArrayList;

/**
 * Represents a shipping container bound for a single destination.
 * Holds packages and enforces a maximum weight capacity.
 */
public class Container {

    // TODO M1: Initialise this static counter to 1.
    private static int nextContainerId;

    // TODO M1: These fields are declared but not yet assigned.
    // Your constructors (M2, M3) must assign them.
    private String containerId;
    private String destination;
    private double maxWeightKg;
    private ArrayList<Package> packages;

    /**
     * Full constructor with destination and max weight.
     * TODO M2: Implement this constructor.
     *   - Validate: destination non-null, maxWeightKg > 0
     *   - Auto-assign containerId using String.format("CNT-%03d", nextContainerId)
     *   - Increment nextContainerId
     *   - Initialise the packages ArrayList
     */
    public Container(String destination, double maxWeightKg) {
        // TODO M2
    }

    /**
     * Convenience constructor: default capacity of 500 kg.
     * TODO M3: Chain to the 2-param constructor using this(...)
     */
    public Container(String destination) {
        // TODO M3: Write the this(...) call here
    }

    // --- Getters ---
    // TODO M4: Write getters for containerId, destination, maxWeightKg

    /**
     * TODO M8: Add a package to this container.
     *   Return false if: p is null, p's destination does not match, or
     *   adding p would exceed maxWeightKg.
     *   Return true on success.
     */
    public boolean addPackage(Package p) {
        return false; // TODO M8
    }

    /**
     * TODO M8: Return the sum of all packages' weightKg.
     */
    public double getCurrentWeightKg() {
        return 0.0; // TODO M8
    }

    /**
     * TODO M8: Return maxWeightKg - getCurrentWeightKg()
     */
    public double getRemainingCapacityKg() {
        return 0.0; // TODO M8
    }

    /**
     * TODO M8: Return the number of packages in this container.
     */
    public int getPackageCount() {
        return 0; // TODO M8
    }

    /**
     * TODO M8: Return the sum of all packages' getShippingCost().
     */
    public double getTotalRevenue() {
        return 0.0; // TODO M8
    }

    /**
     * TODO M9: Build and return the multi-line manifest string.
     * Format:
     *   === CNT-001 -> Trinidad (3 packages, 17.00 / 500.00 kg) ===
     *     PKG-0001  Alice -> Bob  Trinidad  5.00 kg  $40.00
     *     PKG-0005  Ivy -> Jack  Trinidad  8.00 kg  $95.00  [FRAGILE]
     *     ...
     *     Container revenue: $199.50
     * Each package line is indented with 2 spaces.
     * Use StringBuilder and String.format.
     */
    public String getManifest() {
        return ""; // TODO M9
    }

    /**
     * Returns the list of packages (needed by FreightTerminal.findPackage).
     */
    public ArrayList<Package> getPackages() {
        return packages;
    }

    /**
     * TODO M9: Return a one-line summary:
     *   "CNT-001 -> Trinidad [3 packages, 17.00 / 500.00 kg]"
     */
    @Override
    public String toString() {
        return ""; // TODO M9
    }
}
