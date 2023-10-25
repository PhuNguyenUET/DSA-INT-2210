
import java.util.*;
/*
 * Create the Student and Priorities classes here.
 */
class Student {
    private int id;
    private String name;
    private double cgpa;

    Student(int id, String name, double cgpa) {
        this.id = id;
        this.name = name;
        this.cgpa = cgpa;
    }

    Student(String name, double cgpa, int id) {
        this(id, name, cgpa);
    }

    public int getID() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getCGPA() {
        return cgpa;
    }
}

class Priorities {
    public List<Student> getStudents (List<String> events) {
        PriorityQueue<Student>pq = new PriorityQueue<>(
                Comparator.comparing(Student::getCGPA).reversed()
                        .thenComparing(Student::getName)
                        .thenComparing(Student::getID)
        );

        for (String event : events) {
            StringTokenizer st = new StringTokenizer(event);

            switch(st.nextToken()) {
                case "ENTER":
                    pq.add(new Student(st.nextToken(), Double.parseDouble(st.nextToken()), Integer.parseInt(st.nextToken())));
                    break;
                case "SERVED":
                    pq.poll();

            }
        }
        List<Student> res = new ArrayList<>();
        while(!pq.isEmpty()) {
            res.add(pq.poll());
        }
        return res;
    }
}
