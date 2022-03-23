import java.util.ArrayList;
import java.util.List;

public class Employee {
    private static List<Integer> employeeAmount = new ArrayList<>();
    public static int employeeCounter;

    private int iD;
    private String name;
    private int age;
    private String jobTitle;


    public Employee(String name, int age, String jobTitle) {
        employeeAmount.add(employeeCounter);
        this.name = name;
        this.age = age;
        this.jobTitle = jobTitle;
        this.iD = (12 * 100000) + employeeAmount.size();
        employeeCounter++;

    }

    public int getiD() {
        return iD;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getJobTitle() {
        return jobTitle;
    }
}
