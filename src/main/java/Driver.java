/**
 * Scripted demo of the Caribbean Cargo & Logistics System.
 * Creates 12 packages, packs and dispatches them, and prints reports.
 */
public class Driver {

    public static void main(String[] args) {

        FreightTerminal terminal1 = new FreightTerminal("Port of Spain Hub");

        Package package1 = new Package("Alice", "Bob", 5.0, 40, 30, 20, "Trinidad");

        Package package2 = new Package("Carol", "Dan", 2.0, 60, 40, 40, "Barbados", true, 500.0);

        Package package3 = new Package("Eve", "Frank", 10.0, 30, 30, 30, "Jamaica");

        Package package4 = new Package("Grace", "Hank", 3.5, 50, 50, 50, "Barbados", false, 200.0);

        Package package5 = new Package("Ivy", "Jack", 8.0, 20, 20, 20, "Trinidad", true, 1000.0);

        Package package6 = new Package("Kim", "Leo", 1.5, 100, 60, 40, "Antigua");

        Package package7 = new Package("Mia", "Noah", 15.0, 40, 40, 30, "Jamaica", true, 750.0);

        Package package8 = new Package("Olivia", "Pat", 6.0, 35, 25, 15, "Grenada");

        Package package9 = new Package("Quinn", "Ray", 4.0, 45, 35, 25, "Trinidad", false, 100.0);

        Package package10 = new Package("Sara", "Tim", 20.0, 80, 60, 50, "Barbados", true, 2000.0);

        Package package11 = new Package("Uma", "Vic", 0.5, 15, 10, 10, "Grenada");

        Package package12 = new Package("Will", "Xia", 12.0, 50, 40, 30, "Antigua", true, 300.0);

        terminal1.receivePackage(package1);
        terminal1.receivePackage(package2);
        terminal1.receivePackage(package3);
        terminal1.receivePackage(package4);
        terminal1.receivePackage(package5);
        terminal1.receivePackage(package6);
        terminal1.receivePackage(package7);
        terminal1.receivePackage(package8);
        terminal1.receivePackage(package9);
        terminal1.receivePackage(package10);
        terminal1.receivePackage(package11);
        terminal1.receivePackage(package12);

        System.out.println("=== Pending: " + terminal1.getPendingCount() + " packages ===");

        System.out.println(package1);

        System.out.println("Shipping cost: $" + package1.getShippingCost());

        System.out.println();

        int containersCreated = terminal1.packContainers();

        System.out.println("Packed into " + containersCreated + " containers");

        System.out.println();

        for(Container c : terminal1.getActiveContainers()){
            System.out.println(c.getManifest());
        }

        System.out.println();

        int dispatched = terminal1.dispatchAll();

        System.out.println("Dispatched " + dispatched + " containers");

        System.out.println();

        terminal1.printDailyReport();

        System.out.println();

        if(terminal1.findPackage("PKG-0005") != null){
            System.out.println("Found: " + terminal1.findPackage("PKG-0005"));
        }
        else{
            System.out.println("PKG-0005: Not found");
        }

        if(terminal1.findPackage("PKG-9999") != null){
            System.out.println("Found: " + terminal1.findPackage("PKG-9999"));
        }
        else{
            System.out.println("PKG-9999: Not found");
        }

        /*
        System.out.println("-----------------------------------------");

        System.out.println(containersCreated);

        System.out.println(terminal1.getPendingCount());

        System.out.println(terminal1.getActiveContainers().size());

        System.out.println(terminal1.getTotalRevenue());

        System.out.println(terminal1.getTotalPackagesShipped());

        System.out.println(terminal1.findPackage("PKG-0001"));
        System.out.println(terminal1.findPackage("PKG-0002"));
        System.out.println(terminal1.findPackage("PKG-0003"));
        System.out.println(terminal1.findPackage("PKG-0004"));
        System.out.println(terminal1.findPackage("PKG-0005"));
        System.out.println(terminal1.findPackage("PKG-0006"));
        System.out.println(terminal1.findPackage("PKG-0007"));
        System.out.println(terminal1.findPackage("PKG-0008"));
        System.out.println(terminal1.findPackage("PKG-0009"));
        System.out.println(terminal1.findPackage("PKG-0010"));
        System.out.println(terminal1.findPackage("PKG-0011"));
        System.out.println(terminal1.findPackage("PKG-0012"));

        System.out.println(package1);

        System.out.println(package3);

        System.out.println(package4.getVolumeCm3());

        System.out.println(package4.getVolumetricWeightKg());

        System.out.println(package4.getBillableWeightKg());

        System.out.println(package5.getVolumeCm3());

        System.out.println(package5.getVolumetricWeightKg());

        System.out.println(package5.getBillableWeightKg());

        System.out.println(package1.getShippingCost());

        System.out.println(package2.getShippingCost());

        System.out.println(package3.getShippingCost());
         */

    }
}
