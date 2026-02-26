public class Main {

    public static void main(String[] args) {

        int doctors = 3;
        double arrivalRate = 2.0;
        double serviceRate = 3.0;
        double simulationTime = 1000;

        EmergencyDepartment ed = new EmergencyDepartment(doctors, arrivalRate, serviceRate);
        SimulationEngine engine = new SimulationEngine(simulationTime, ed);

        engine.run();

        System.out.println("Patients served: " + ed.stats.patientsServed);

        if (ed.stats.patientsServed > 0) {
            System.out.println("Average wait time: " +
                    ed.stats.totalWaitTime / ed.stats.patientsServed);
        }

        System.out.println("Doctor utilization: " +
                ed.stats.totalBusyTime / (simulationTime * doctors));
    }
}
