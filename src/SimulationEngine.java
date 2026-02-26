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

    public void run() {

        schedule(new Event(0, EventType.ARRIVAL, null));

        while (!eventQueue.isEmpty() && currentTime < endTime) {

            Event event = eventQueue.poll();
            currentTime = event.time;

            if (event.type == EventType.ARRIVAL) {
                ed.handleArrival(currentTime, this);
            } else {
                ed.handleDeparture(currentTime, this);
            }
        }
    }
}
