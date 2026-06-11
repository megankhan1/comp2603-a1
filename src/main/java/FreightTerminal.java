import java.util.ArrayList;

/**
 * The hub that receives packages, packs them into containers,
 * dispatches containers, and produces financial reports.
 */
public class FreightTerminal {

    private String terminalName;
    private ArrayList<Package> pendingPackages;
    private ArrayList<Container> activeContainers;
    private ArrayList<Container> dispatchedContainers;

    public FreightTerminal(String terminalName) {

        this.terminalName = terminalName;

        pendingPackages = new ArrayList<>();

        activeContainers = new ArrayList<>();

        dispatchedContainers = new ArrayList<>();
    }

    public void receivePackage(Package p) {

        if(p != null){
            pendingPackages.add(p);
        }
    }

    public int getPendingCount() {
        return pendingPackages.size();
    }

    public int packContainers() {

        ArrayList<String> destinations = new ArrayList<>();

        for(Package p : pendingPackages){
            if(!destinations.contains(p.getDestination())){
                destinations.add(p.getDestination());
            }
        }

        for(String destination : destinations){
            Container c = new Container(destination);
            for(Package p : pendingPackages){
                if(destinations.contains(p.getDestination())){
                    c.addPackage(p);
                }
            }
            activeContainers.add(c);
        }

        pendingPackages.clear();


        return destinations.size();
    }

    public int dispatchAll() {

        int dispatchedCount = activeContainers.size();

        dispatchedContainers.addAll(activeContainers);

        activeContainers.clear();

        return dispatchedCount;
    }

    public double getTotalRevenue() {

        double sumTotalRevenue = 0;

        for(Container c : dispatchedContainers){
            sumTotalRevenue += c.getTotalRevenue();
        }

        return sumTotalRevenue;
    }

    public int getTotalPackagesShipped() {

        int sumPackageCount = 0;

        for(Container c : dispatchedContainers){
            sumPackageCount += c.getPackageCount();
        }

        return sumPackageCount;
    }

    public Package findPackage(String trackingId) {

        for(Package pkg : pendingPackages){
            if(pkg.getTrackingId().equals(trackingId))
                return pkg;
        }

        for(Container c : activeContainers){
            for(Package p : c.getPackages()) {
                if (p.getTrackingId().equals(trackingId))
                    return p;
            }
        }

        for(Container c2 : dispatchedContainers){
            for(Package dp : c2.getPackages()){
                if(dp.getTrackingId().equals(trackingId))
                    return dp;
            }
        }

        return null;

    }

    public ArrayList<Container> getActiveContainers() {
        return activeContainers;
    }

    public void printDailyReport() {

        StringBuilder sb = new StringBuilder();

        sb.append(String.format("=== Daily Report: %s ===\n", terminalName));
        sb.append(String.format("Packages received: %d\nContainers packed: %d\nPackages shipped: %d\nTotal revenue: $%.2f\n",
                getTotalPackagesShipped(), dispatchedContainers.size(), getTotalPackagesShipped(), getTotalRevenue()));

        sb.append("\nRevenue by destination:");

        System.out.println(sb);

        for(Container c : dispatchedContainers){
            System.out.println(String.format(" %-12s $%.2f (%d packages)%n", c.getDestination() + ":", c.getTotalRevenue(), c.getPackageCount()));

        }
    }
}
