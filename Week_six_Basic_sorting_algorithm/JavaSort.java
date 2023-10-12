import java.util.Comparator;

public class JavaSort {
    class Student{
        private int id;
        private String fname;
        private double cgpa;
        public Student(int id, String fname, double cgpa) {
            super();
            this.id = id;
            this.fname = fname;
            this.cgpa = cgpa;
        }
        public int getId() {
            return id;
        }
        public String getFname() {
            return fname;
        }
        public double getCgpa() {
            return cgpa;
        }
    }

    //Complete the code
    class StudentComparator implements Comparator<Student>
    {
        @Override
        public int compare(Student x, Student y)
        {
            if (x.getCgpa() > y.getCgpa()) {
                return -1;
            } else if (x.getCgpa() < y.getCgpa()) {
                return 1;
            } else {
                if (x.getFname().compareTo(y.getFname()) != 0) {
                    return x.getFname().compareTo(y.getFname());
                } else {
                    if (x.getId() > y.getId()) {
                        return -1;
                    } else if (x.getId() < y.getId()) {
                        return 1;
                    } else {
                        return 0;
                    }
                }
            }
        }
    }
}
