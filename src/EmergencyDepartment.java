import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class EmergencyDepartment {

    private int numDoctors;
    private int busyDoctors = 0;
    private Queue<Patient> queue = new LinkedList<>();
    private Random random = new Random();

    private double arrivalRate;
    private double serviceRate;

    public Statistics stats = new Statistics();

    public EmergencyDepartment(int numDoctors, double arrivalRate, double serviceRate) {
        this.numDoctors = numDoctors;
        this.arrivalRate = arrivalRate;
        this.serviceRate = serviceRate;
    }

    private double exponential(double rate) {
        return -Math.log(1 - random.nextDouble()) / rate;
    }

    // updates queue statistics whenever queue size changes
    private void updateQueueStats(double currentTime) {
        double timePassed = currentTime - stats.lastQueueUpdateTime;
        stats.queueArea += queue.size() * timePassed;
        stats.lastQueueUpdateTime = currentTime;
    }

    public void handleArrival(double currentTime, SimulationEngine engine) {

        updateQueueStats(currentTime);

        Patient patient = new Patient(currentTime);

        if (busyDoctors < numDoctors) {
            startService(patient, currentTime, engine);
        } else {
            queue.add(patient);

            if (queue.size() > stats.maxQueueLength) {
                stats.maxQueueLength = queue.size();
            }
        }

        double nextArrival = currentTime + exponential(arrivalRate);

        if (nextArrival <= engine.getEndTime()) {
            engine.schedule(new Event(nextArrival, EventType.ARRIVAL, null));
        }
    }

    private void startService(Patient patient, double currentTime, SimulationEngine engine) {

        busyDoctors++;
        patient.serviceStartTime = currentTime;

        double serviceTime = exponential(serviceRate);

        stats.totalWaitTime += (patient.serviceStartTime - patient.arrivalTime);
        stats.totalBusyTime += serviceTime;

        engine.schedule(new Event(currentTime + serviceTime, EventType.SERVICE_COMPLETE, patient));
    }

    public void handleDeparture(double currentTime, SimulationEngine engine) {

        updateQueueStats(currentTime);

        stats.patientsServed++;
        busyDoctors--;

        if (!queue.isEmpty()) {
            Patient next = queue.poll();

            updateQueueStats(currentTime);

            startService(next, currentTime, engine);
        }
    }

    public int getCurrentQueueLength() {
        return queue.size();
    }
}
