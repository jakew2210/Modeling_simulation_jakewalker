import java.util.PriorityQueue;

public class SimulationEngine {

    private PriorityQueue<Event> eventQueue = new PriorityQueue<>();
    private double currentTime = 0;
    private double endTime;

    private EmergencyDepartment ed;

    public SimulationEngine(double endTime, EmergencyDepartment ed) {
        this.endTime = endTime;
        this.ed = ed;
    }

    public void schedule(Event event) {
        eventQueue.add(event);
    }

    public double getEndTime() {
        return endTime;
    }

    public void run() {

        schedule(new Event(0, EventType.ARRIVAL, null));

        while (!eventQueue.isEmpty()) {

            Event event = eventQueue.poll();

            if (event.time > endTime) {
                break;
            }

            currentTime = event.time;

            if (event.type == EventType.ARRIVAL) {
                ed.handleArrival(currentTime, this);
            } else {
                ed.handleDeparture(currentTime, this);
            }
        }

        // final queue stats update through end of simulation
        ed.stats.queueArea += ed.getCurrentQueueLength() * (endTime - ed.stats.lastQueueUpdateTime);
        ed.stats.lastQueueUpdateTime = endTime;
    }
}
