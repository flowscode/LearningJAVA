import java.util.*;

public class Main {

        static LinkedList<Employee>  employeeList = new LinkedList<>();
        static List<String> employeeNames = new ArrayList<>();

    public static void main(String[] args) {

        Employee josh = new Employee("Joshua Dawkins",26,"Cashier");
        Employee bobby = new Employee("Bobby Brown", 28, "Cleaner");
        Employee rob = new Employee("Robert Downer", 55, "Manager");
        Employee mike = new Employee("Mike Wilson", 34, "CEO");

        employeeList.add(josh);
        employeeList.add(bobby);
        employeeList.add(rob);
        employeeList.add(mike);


        allEmployeeInfo(employeeList);
        printAllNames();

    }

    public static void allEmployeeInfo(LinkedList<Employee> list){
        ListIterator<Employee> it = list.listIterator();
        System.out.println("----[ EMPLOYEE LIST ]----");
        while(it.hasNext()){
            System.out.println("ID: " + it.next().getiD() + "\nName: " + it.previous().getName() + "\nAge: " + it.next().getAge() + "\nJob Role: " + it.previous().getJobTitle() +
                    "\n============================");
            it.next();

        }
     }
    public static void printAllNames(){
        int i = 1;
         for (Employee o: employeeList) {
             employeeNames.add(o.getName());
         }
         for (String employeeName : employeeNames) {
             System.out.println("Employee number " + i + ": " + employeeName);
             i++;
         }

     }
}

