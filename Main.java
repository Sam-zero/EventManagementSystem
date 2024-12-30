import java.util.*;

class Person {
    private String name;
    private String email;

    public Person(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Person{name='" + name + '\'' + ", email='" + email + '\'' + '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Person person = (Person) obj;
        return Objects.equals(name, person.name) && Objects.equals(email, person.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, email);
    }
}

class AdvancedParticipant extends Person {
    private int age;

    public AdvancedParticipant(String name, int age, String email) {
        super(name, email);
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return super.toString() + ", age=" + age;
    }
}

class AdvancedEvent {
    private String eventName;
    private String eventDate;
    private String location;
    private List<AdvancedParticipant> participants;

    public AdvancedEvent(String eventName, String eventDate, String location) {
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

    public List<AdvancedParticipant> getParticipants() {
        return participants;
    }

    public void addParticipant(AdvancedParticipant participant) {
        participants.add(participant);
    }

    public void sortParticipantsByName() {
        participants.sort(Comparator.comparing(AdvancedParticipant::getName));
    }

    public AdvancedParticipant searchParticipantByEmail(String email) {
        return participants.stream()
                .filter(participant -> participant.getEmail().equals(email))
                .findFirst()
                .orElse(null);
    }

    @Override
    public String toString() {
        return "AdvancedEvent{eventName='" + eventName + '\'' + ", eventDate='" + eventDate + '\'' + ", location='" + location + '\'' + ", participants=" + participants + '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        AdvancedEvent event = (AdvancedEvent) obj;
        return Objects.equals(eventName, event.eventName) && Objects.equals(eventDate, event.eventDate) && Objects.equals(location, event.location);
    }

    @Override
    public int hashCode() {
        return Objects.hash(eventName, eventDate, location);
    }
}

class AdvancedEventManager {
    private String name;
    private List<AdvancedEvent> events;

    public AdvancedEventManager(String name) {
        this.name = name;
        this.events = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<AdvancedEvent> getEvents() {
        return events;
    }

    public void addEvent(AdvancedEvent event) {
        events.add(event);
    }

    public void sortEventsByName() {
        events.sort(Comparator.comparing(AdvancedEvent::getEventName));
    }

    @Override
    public String toString() {
        return "AdvancedEventManager{name='" + name + '\'' + ", events=" + events + '}';
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        AdvancedParticipant p1 = new AdvancedParticipant("Bekzhan", 25, "beksh_14@gmail.com");
        AdvancedParticipant p2 = new AdvancedParticipant("Dauren", 30, "Daur05@gmail.com");
        AdvancedParticipant p3 = new AdvancedParticipant("Musa", 28, "musa_240@gmail.com");

        AdvancedEvent event1 = new AdvancedEvent("Cryptocurrency conference", "2024-05-15", "Astana");
        AdvancedEvent event2 = new AdvancedEvent("Chess Training", "2024-12-20", "Almaty");

        event1.addParticipant(p1);
        event1.addParticipant(p2);
        event2.addParticipant(p3);

        AdvancedEventManager manager = new AdvancedEventManager("Rakhman Khamzanov");
        manager.addEvent(event1);
        manager.addEvent(event2);

        event1.sortParticipantsByName();
        manager.sortEventsByName();

        System.out.print("Enter email to search for a participant: ");
        String emailToSearch = scanner.nextLine();
        AdvancedParticipant foundParticipant = event1.searchParticipantByEmail(emailToSearch);

        if (foundParticipant != null) {
            System.out.println("Found Participant: " + foundParticipant);
        }
        else {
            System.out.println("Participant with email " + emailToSearch + " not found.");
        }

        System.out.println(manager);
    }
}
