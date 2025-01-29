import java.sql.*;

public class Main {
    private static final String URL = "jdbc:postgresql://localhost:5432/event_management_system";
    private static final String USER = "postgres";
    private static final String PASSWORD = "SamoKaz2007)";

    public static Connection connect() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    public void addEvent(String event_name, String event_date, String eventLocation) {
        String sql = "INSERT INTO event (eventName, eventDate, location) VALUES (?, ?, ?)";
        try (Connection conn = connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, event_name);
            pstmt.setDate(2, Date.valueOf(event_date));
            pstmt.setString(3, eventLocation);
            pstmt.executeUpdate();
            System.out.println("Event added successfully.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void addParticipant(String participant_name, int age, String email) {
        String sql = "INSERT INTO participant (name, age, email) VALUES (?, ?, ?)";
        try (Connection conn = connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, participant_name);
            pstmt.setInt(2, age);
            pstmt.setString(3, email);
            pstmt.executeUpdate();
            System.out.println("Participant added successfully.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void updateEvent(int eventId, String event_name, String event_date, String eventLocation) {
        String sql = "UPDATE event SET eventName = ?, eventDate = ?, location = ? WHERE event_id = ?";
        try (Connection conn = connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, event_name);
            pstmt.setDate(2, Date.valueOf(event_date));
            pstmt.setString(3, eventLocation);
            pstmt.setInt(4, eventId);
            pstmt.executeUpdate();
            System.out.println("Event updated successfully.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void deleteEvent(int eventId) {
        String sql = "DELETE FROM event WHERE event_id = ?";
        try (Connection conn = connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, eventId);
            pstmt.executeUpdate();
            System.out.println("Event deleted successfully.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void getEvents() {
        String sql = "SELECT * FROM event";
        try (Connection conn = connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                System.out.println("Event ID: " + rs.getInt("event_id"));
                System.out.println("Event Name: " + rs.getString("eventName"));
                System.out.println("Event Date: " + rs.getDate("eventDate"));
                System.out.println("Event Location: " + rs.getString("location"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void getParticipants() {
        String sql = "SELECT * FROM participant";
        try (Connection conn = connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                System.out.println("Participant ID: " + rs.getInt("participant_id"));
                System.out.println("Participant Name: " + rs.getString("name"));
                System.out.println("Participant Age: " + rs.getDate("age"));
                System.out.println("Participant email: " + rs.getString("email"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
        Main dbManager = new Main();
        dbManager.addEvent("Cryptocurrency conference", "2024-05-15", "Astana");
        dbManager.addEvent("Chess Training", "2024-12-20", "Almaty");
        dbManager.getEvents();
        dbManager.updateEvent(1, "Blockchain conference", "2024-05-16", "Shymkent");
        dbManager.getEvents();
        dbManager.deleteEvent(1);
        dbManager.getEvents();
        dbManager.addParticipant("Bekzhan", 25, "beksh_14@gmail.com");
        dbManager.addParticipant("Dauren", 30, "Daur05@gmail.com");
        dbManager.addParticipant("Musa", 28, "musa_240@gmail.com");
        dbManager.addParticipant("Nurbek", 29, "nura_24@gmail.com");
        dbManager.addParticipant("Galym", 31, "gala_20@gmail.com");
        dbManager.getParticipants();
    }
}
