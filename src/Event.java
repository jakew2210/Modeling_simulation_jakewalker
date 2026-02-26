public class Event implements Comparable<Event> {

    public double time;
    public EventType type;
    public Patient patient;

    public Event(double time, EventType type, Patient patient) {
        this.time = time;
        this.type = type;
        this.patient = patient;
    }

    @Override
    public int compareTo(Event other) {
        return Double.compare(this.time, other.time);
    }
}
