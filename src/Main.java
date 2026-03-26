public class Main {

    public static void main(String[] args) {

        // parameters
        int doctors = 3;
        double arrivalRate = 15.0;      // patients per hour
        double serviceRate = 6.0;       // patients served per hour per doctor
        double simulationTime = 12.0;   // total simulation time in hours

        EmergencyDepartment ed = new EmergencyDepartment(doctors, arrivalRate, serviceRate);
        SimulationEngine engine = new SimulationEngine(simulationTime, ed);

        engine.run();

        System.out.println("==================================");
        System.out.println("Emergency Department Simulation");
        System.out.println("==================================");
        System.out.println("Doctors: " + doctors);
        System.out.printf("Arrival rate: %.1f patients/hour%n", arrivalRate);
        System.out.printf("Service rate: %.1f patients/hour%n", serviceRate);
        System.out.printf("Simulation time: %.1f hours%n", simulationTime);
        System.out.println("----------------------------------");

        System.out.println("Patients served: " + ed.stats.patientsServed);

        if (ed.stats.patientsServed > 0) {

            // wait time is stored in hours, so convert to minutes
            double avgWaitHours = ed.stats.totalWaitTime / ed.stats.patientsServed;
            double avgWaitMinutes = avgWaitHours * 60.0;

            double utilization = ed.stats.totalBusyTime / (simulationTime * doctors);
            utilization = Math.min(1.0, utilization); // cap at 100%

            double avgQueueLength = ed.stats.queueArea / simulationTime;

            System.out.printf("Average wait time: %.2f minutes%n", avgWaitMinutes);
            System.out.printf("Doctor utilization: %.2f%%%n", utilization * 100.0);
            System.out.printf("Maximum queue length: %d%n", ed.stats.maxQueueLength);
            System.out.printf("Average queue length: %.2f%n", avgQueueLength);
            System.out.printf("Patients left in queue at end: %d%n", ed.getCurrentQueueLength());
        }

        System.out.println("==================================");
    }
}
