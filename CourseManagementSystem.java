import java.util.HashMap;

public class CourseManagementSystem {
    private HashMap<String, Course> courseDatabase;
    private HashMap<String, Student> studentDatabase;

    public CourseManagementSystem() {
        courseDatabase = new HashMap<>();
        studentDatabase = new HashMap<>();
    }

    // Add a course to the course database
    public void addCourse(Course course) {
        courseDatabase.put(course.getCode(), course);
    }

    // Add a student to the student database
    public void addStudent(Student student) {
        studentDatabase.put(student.getStudentId(), student);
    }

    // Display available courses
    public void listCourses() {
        System.out.println("Available Courses:");
        for (Course course : courseDatabase.values()) {
            System.out.println(course);
        }
    }

    // Register a student for a course
    public void registerStudent(String studentId, String courseCode) {
        Student student = studentDatabase.get(studentId);
        Course course = courseDatabase.get(courseCode);
        
        if (student != null && course != null) {
            if (student.registerForCourse(course)) {
                System.out.println(student.getName() + " has successfully registered for " + course.getTitle());
            } else {
                System.out.println("Registration failed: No available slots or already enrolled.");
            }
        } else {
            System.out.println("Invalid student ID or course code.");
        }
    }

    // Drop a course for a student
    public void dropCourse(String studentId, String courseCode) {
        Student student = studentDatabase.get(studentId);
        Course course = courseDatabase.get(courseCode);
        
        if (student != null && course != null) {
            if (student.dropCourse(course)) {
                System.out.println(student.getName() + " has successfully dropped " + course.getTitle());
            } else {
                System.out.println("Course drop failed: Not registered in the course.");
            }
        } else {
            System.out.println("Invalid student ID or course code.");
        }
    }
    
    public static void main(String[] args) {
        // Create an instance of CourseManagementSystem
        CourseManagementSystem cms = new CourseManagementSystem();
        
        // Create and add some courses
        Course course1 = new Course("CS101", "Intro to Programming", "Basic programming concepts", 30, "Mon-Wed-Fri 10:00AM-11:00AM");
        Course course2 = new Course("CS102", "Data Structures", "Introduction to Data Structures", 25, "Tue-Thu 2:00PM-3:30PM");
        
        cms.addCourse(course1);
        cms.addCourse(course2);
        
        // Create and add some students
        Student student1 = new Student("S001", "Alice");
        Student student2 = new Student("S002", "Bob");
        
        cms.addStudent(student1);
        cms.addStudent(student2);
        
        // List available courses
        cms.listCourses();
        
        // Register students for courses
        cms.registerStudent("S001", "CS101");
        cms.registerStudent("S002", "CS102");
        
        // Drop a course
        cms.dropCourse("S001", "CS101");
        
        // List available courses again
        cms.listCourses();
    }
}
