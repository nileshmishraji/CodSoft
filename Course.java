import java.util.ArrayList;

class Course {
    private String code;
    private String title;
    private String description;
    private int capacity;
    private int availableSlots;
    private String schedule;
    
    private ArrayList<String> enrolledStudents;

    public Course(String code, String title, String description, int capacity, String schedule) {
        this.code = code;
        this.title = title;
        this.description = description;
        this.capacity = capacity;
        this.availableSlots = capacity;
        this.schedule = schedule;
        this.enrolledStudents = new ArrayList<>();
    }

    public String getCode() {
        return code;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public int getAvailableSlots() {
        return availableSlots;
    }

    public boolean enrollStudent(String studentId) {
        if (availableSlots > 0 && !enrolledStudents.contains(studentId)) {
            enrolledStudents.add(studentId);
            availableSlots--;
            return true;
        }
        return false;
    }

    public boolean removeStudent(String studentId) {
        if (enrolledStudents.contains(studentId)) {
            enrolledStudents.remove(studentId);
            availableSlots++;
            return true;
        }
        return false;
    }

    public String getSchedule() {
        return schedule;
    }

    @Override
    public String toString() {
        return "Course Code: " + code + ", Title: " + title + ", Description: " + description + 
               ", Capacity: " + capacity + ", Available Slots: " + availableSlots + ", Schedule: " + schedule;
    }
}
