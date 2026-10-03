import java.util.Scanner;
class Employee{
    String name;
    String employeeId;
    double salary;
    Employee(String name, String employeeId, double salary){
        this.name = name;
        this.employeeId = employeeId;
        this.salary = salary;
    }
    double calculateBonus(){
        return 0;
    }
    void displayDetails(){
        System.out.println("Name: " + name);
        System.out.println("ID: " + employeeId);
        System.out.println("Salary: " + salary);
        System.out.println("Bonus: " + calculateBonus());
        System.out.println();
    }
}
class Developer extends Employee{
    Developer(String name, String employeeId, double salary){
        super(name, employeeId, salary);
    }
    @Override
    double calculateBonus(){
        return salary * 10 / 100;
    }
}
class Manager extends Employee{
    Manager(String name, String employeeId, double salary){
        super(name, employeeId, salary);
    }
    @Override
    double calculateBonus(){
        return salary * 15 / 100;
    }
}
public class Bonus{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Employee[] employees = new Employee[n];
        for(int i = 0; i < n; i++) {
            String type = sc.next();
            String id = sc.next();
            String name = sc.next();
            double salary = sc.nextDouble();
            if(type.equals("DEVELOPER")){
                employees[i] = new Developer(name, id, salary);
            }
            else{
                employees[i] = new Manager(name, id, salary);
            }
        }
        for(int i = 0; i < n; i++){
            employees[i].displayDetails();
        }
        sc.close();
    }
}
