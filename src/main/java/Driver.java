/**
 * Scripted demo of the Caribbean Cargo & Logistics System.
 * Creates 12 packages, packs and dispatches them, and prints reports.
 *
 * TODO M10: Complete this class so that running "java Driver" produces
 * the exact expected output shown in the README.
 */
public class Driver {

    public static void main(String[] args) {

        FreightTerminal terminal1 = new FreightTerminal("Port of Spain Hub");

        Package package1 = new Package("Alice", "Bob", 5.0, 40, 30, 20, "Trinidad", false, 0.0);

        Package package2 = new Package("Carol", "Dan", 2.0, 60, 40, 40, "Barbados", true, 500.0);

        Package package3 = new Package("Eve", "Frank", 10.0, 30, 30, 30, "Jamaica", false, 0.0);

        Package package4 = new Package("Grace", "Hank", 3.5, 50, 50, 50, "Barbados", false, 200.0);

        Package package5 = new Package("Ivy", "Jack", 8.0, 20, 20, 20, "Trinidad", true, 1000.0);

        Package package6 = new Package("Kim", "Leo", 1.5, 100, 60, 40, "Antigua", false, 0.0);

        Package package7 = new Package("Mia", "Noah", 15.0, 40, 40, 30, "Jamaica", true, 750.0);

        Package package8 = new Package("Olivia", "Pat", 6.0, 35, 25, 15, "Grenada", false, 0.0);

        Package package9 = new Package("Quinn", "Ray", 4.0, 45, 35, 25, "Trinidad", false, 100.0);

        Package package10 = new Package("Sara", "Tim", 20.0, 80, 60, 50, "Barbados", true, 2000.0);

        Package package11 = new Package("Uma", "Vic", 0.5, 15, 10, 10, "Grenada", false, 0.0);

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

        int containersCreated = terminal1.packContainers();

        System.out.println(containersCreated);

        System.out.println(terminal1.getPendingCount());

        System.out.println(terminal1.getActiveContainers().size());

        int dispatched = terminal1.dispatchAll();

        System.out.println(dispatched);

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



        // Step 1: Create the terminal
        // TODO M10: Create a FreightTerminal named "Port of Spain Hub"

        // Step 2: Create and receive all 12 packages
        // TODO M10: Create these 12 packages in order (PKG-0001 through PKG-0012):
        //
        //  #  | Sender  | Receiver | Weight | L   | W  | H  | Destination | Fragile | Value
        //  1  | Alice   | Bob      | 5.0    | 40  | 30 | 20 | Trinidad    | no      | 0
        //  2  | Carol   | Dan      | 2.0    | 60  | 40 | 40 | Barbados    | yes     | 500
        //  3  | Eve     | Frank    | 10.0   | 30  | 30 | 30 | Jamaica     | no      | 0
        //  4  | Grace   | Hank     | 3.5    | 50  | 50 | 50 | Barbados    | no      | 200
        //  5  | Ivy     | Jack     | 8.0    | 20  | 20 | 20 | Trinidad    | yes     | 1000
        //  6  | Kim     | Leo      | 1.5    | 100 | 60 | 40 | Antigua     | no      | 0
        //  7  | Mia     | Noah     | 15.0   | 40  | 40 | 30 | Jamaica     | yes     | 750
        //  8  | Olivia  | Pat      | 6.0    | 35  | 25 | 15 | Grenada     | no      | 0
        //  9  | Quinn   | Ray      | 4.0    | 45  | 35 | 25 | Trinidad    | no      | 100
        //  10 | Sara    | Tim      | 20.0   | 80  | 60 | 50 | Barbados    | yes     | 2000
        //  11 | Uma     | Vic      | 0.5    | 15  | 10 | 10 | Grenada     | no      | 0
        //  12 | Will    | Xia      | 12.0   | 50  | 40 | 30 | Antigua     | yes     | 300
        //
        // Use the 7-param constructor for non-fragile packages with value 0.
        // Use the 9-param constructor for packages that are fragile or have a declared value.
        // Receive each package into the terminal.

        // Step 3: Print pending count
        // TODO M10: Print "=== Pending: 12 packages ==="

        // Step 4: Print first package details for verification
        // TODO M10: Print p1.toString() and its shipping cost

        // Step 5: Pack containers
        // TODO M10: Call packContainers() and print "Packed into N containers"

        // Step 6: Print manifests for all active containers
        // TODO M10: Loop through getActiveContainers() and print each manifest

        // Step 7: Dispatch all containers
        // TODO M10: Call dispatchAll() and print "Dispatched N containers"

        // Step 8: Print daily report
        // TODO M10: Call printDailyReport()

        // Step 9: Find a package
        // TODO M10: Find "PKG-0005" and print "Found: " + result

        // Step 10: Try to find a non-existent package
        // TODO M10: Find "PKG-9999" and print "PKG-9999: Not found" if null
    }
}
