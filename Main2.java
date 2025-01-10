import java.util.*;
class Event {
    private String eventName;
    private String eventDate;
    private String location;

    public Event(String eventName, String eventDate, String location) {
        this.eventName = eventName;
        this.eventDate = eventDate;
        this.location = location;
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

    @Override
    public String toString() {
        return "Event{eventName='" + eventName + '\'' + ", eventDate='" + eventDate + '\'' + ", location='" + location + '\'' + '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Event event = (Event) obj;
        return Objects.equals(eventName, event.eventName) &&
                Objects.equals(eventDate, event.eventDate) &&
                Objects.equals(location, event.location);
    }

    @Override
    public int hashCode() {
        return Objects.hash(eventName, eventDate, location);
    }
}

class AdvancedEvent extends Event {
    private List<Person> participants;

    public AdvancedEvent(String eventName, String eventDate, String location) {
        super(eventName, eventDate, location);
        this.participants = new ArrayList<>();
    }

    public List<Person> getParticipants() {
        return participants;
    }

    public void addParticipant(Person participant) {
        participants.add(participant);
    }

    public void sortParticipantsByAge() {
        participants.sort(Comparator.comparing(Person::getAge));
    }

    public Person searchParticipantByAge(int age) {
        return participants.stream()
                .filter(participant -> participant.getAge() == age)
                .findFirst()
                .orElse(null);
    }

    @Override
    public String toString() {
        return "AdvancedEvent{" + super.toString() + ", participants=" + participants + '}';
    }
}

// Encapsulation for data pool management
class EventManager {
    private String managerName;
    private List<AdvancedEvent> events;

    public EventManager(String managerName) {
        this.managerName = managerName;
        this.events = new ArrayList<>();
    }

    public String getManagerName() {
        return managerName;
    }

    public void setManagerName(String managerName) {
        this.managerName = managerName;
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
        return "EventManager{managerName='" + managerName + '\'' + ", events=" + events + '}';
    }
}

class Person {
    private String name;
    private String email;
    private int age;

    public Person(String name, int age, String email) {
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
        return "Person{name='" + name + '\'' + ", age=" + age + ", email='" + email + '\'' + '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Person person = (Person) obj;
        return age == person.age &&
                Objects.equals(name, person.name) &&
                Objects.equals(email, person.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, email);
    }
}

public class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Person p1 = new Person("Bekzhan", 25, "beksh_14@gmail.com");
        Person p2 = new Person("Dauren", 30, "Daur05@gmail.com");
        Person p3 = new Person("Musa", 28, "musa_240@gmail.com");
        Person p4 = new Person("Nurbek", 29, "nura_24@gmail.com");
        Person p5 = new Person("Galym", 31, "gala_20@gmail.com");

        AdvancedEvent event1 = new AdvancedEvent("Cryptocurrency conference", "2024-05-15", "Astana");
        AdvancedEvent event2 = new AdvancedEvent("Chess Training", "2024-12-20", "Almaty");

        event1.addParticipant(p1);
        event1.addParticipant(p2);
        event2.addParticipant(p3);
        event1.addParticipant(p4);
        event2.addParticipant(p5);

        EventManager manager = new EventManager("Rakhman Khamzanov");
        manager.addEvent(event1);
        manager.addEvent(event2);

        event1.sortParticipantsByAge();
        manager.sortEventsByName();

        System.out.print("Enter age to search for a participant: ");
        int ageToSearch = scanner.nextInt();
        Person foundParticipant = event1.searchParticipantByAge(ageToSearch);

        if (foundParticipant != null) {
            System.out.println("Found Participant: " + foundParticipant);
        } else {
            System.out.println("Participant with age " + ageToSearch + " not found.");
        }

        System.out.println(manager);
    }
}
