public class Main {

    public static void main(String[] args) {

        // parameters
        int doctors = 1;
        double arrivalRate = 6.0;     // patients per hour
        double serviceRate = 6.0;      // patients served per hour per doctor
        double simulationTime = 12.0;  // total simulation time in hours

        EmergencyDepartment ed = new EmergencyDepartment(doctors, arrivalRate, serviceRate);
        SimulationEngine engine = new SimulationEngine(simulationTime, ed);

        engine.run();

        System.out.println("Patients served: " + ed.stats.patientsServed);

        if (ed.stats.patientsServed > 0) {

            // avgWait is in hours
            double avgWaitHours = ed.stats.totalWaitTime / ed.stats.patientsServed;
            double avgWaitMinutes = avgWaitHours * 60.0;

            double utilization = ed.stats.totalBusyTime / (simulationTime * doctors);
            utilization = Math.min(1.0, utilization); // cap at 100%

            System.out.printf("Average wait time: %.2f minutes%n", avgWaitMinutes);
            System.out.printf("Doctor utilization: %.2f%%%n", utilization * 100.0);
        }
    }
}