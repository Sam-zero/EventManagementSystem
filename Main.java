import java.util.*;
class Participant {
    private String name;
    private int age;
    private String email;

    public Participant(String name, int age, String email) {
        this.name = name;
        this.age = age;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Participant{name='" + name + '\'' + ", age=" + age + ", email='" + email + '\'' + '}';
    }
}

class Event {
    private String eventName;
    private String eventDate;
    private String location;
    private List<Participant> participants;

    public Event(String eventName, String eventDate, String location) {
        this.eventName = eventName;
        this.eventDate = eventDate;
        this.location = location;
        this.participants = new ArrayList<>();
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getEventDate() {
        return eventDate;
    }

    public void setEventDate(String eventDate) {
        this.eventDate = eventDate;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public List<Participant> getParticipants() {
        return participants;
    }

    public void addParticipant(Participant participant) {
        participants.add(participant);
    }

    @Override
    public String toString() {
        return "Event{eventName='" + eventName + '\'' + ", eventDate='" + eventDate + '\'' + ", location='" + location + '\'' + ", participants=" + participants + '}';
    }
}

class EventManager {
    private String name;
    private List<Event> events;

    public EventManager(String name) {
        this.name = name;
        this.events = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Event> getEvents() {
        return events;
    }

    public void addEvent(Event event) {
        events.add(event);
    }

    @Override
    public String toString() {
        return "EventManager{name='" + name + '\'' + ", events=" + events + '}';
    }
}

public class Main {
    public static void main(String[] args) {
        Participant p1 = new Participant("Bekzhan", 25, "beksh_14@gmail.com");
        Participant p2 = new Participant("Dauren", 30, "Daur05@gmail.com");

        Event event = new Event("Cryptocurrency conference", "2024-05-15", "Astana");
        event.addParticipant(p1);
        event.addParticipant(p2);

        EventManager manager = new EventManager("Rakhman Khamzanov");
        manager.addEvent(event);

        System.out.println(manager);
    }
}