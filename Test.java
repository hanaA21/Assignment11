package lesson11;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Test {
	@SuppressWarnings("serial")
    List<Student> list = new ArrayList<Student>() {
        {
            add(new Student("Joe", "Smith", 3.2, Student.Standing.FRESHMAN));
            add(new Student("Tom", "Rogers", 3.5, Student.Standing.SENIOR));
            add(new Student("HeLing", "Wu", 2.9, Student.Standing.JUNIOR));
            add(new Student("Pierre", "Fromage", 2.8, Student.Standing.FRESHMAN));
            add(new Student("Ihaku", "Tamataku", 3.9, Student.Standing.JUNIOR));
            add(new Student("Richard", "Wong", 2.8, Student.Standing.SOPHOMORE));
        }
    };

    HashMap<Key, Student> map = Admin.processStudents(list);
    boolean[] expectedOutput = {true, false};
    boolean[] results = new boolean[2];
    Student s = new Student("Pierre", "Fromage", 2.8, Student.Standing.FRESHMAN);
    Key pierre = new Key("Pierre", "Fromage");
    Key richard = new Key("Richard", "Fremling");
    results[0] = map.get(pierre).equals(s);
    results[1] = !map.containsKey(richard); // Use negation since you expect false for this case
    System.out.println(Arrays.equals(expectedOutput, results) ? "pass" : "fail");

    double ave = Admin.computeAverageGPA(map);
    // Expected output : Average GPA : 3.1833333333333336
    System.out.println("Average GPA : " + ave);
}
}
	