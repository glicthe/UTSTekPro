import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

// Employee.java
public abstract class Employee {
    protected String name;
    protected LocalDate joinDate;
    protected double basicSalary;
    protected List<Lembur> overtimeList;
    protected int numberOfChildren;
    protected Department department;

    public Employee(String name, LocalDate joinDate, double basicSalary, Department department) {
        this.name = name;
        this.joinDate = joinDate;
        this.basicSalary = basicSalary;
        this.department = department;
        this.overtimeList = new ArrayList<>(); // Jam lembur 
        this.numberOfChildren = 0;
    }

    public void addOvertime(Lembur overtime) {
        overtimeList.add(overtime);
    }

    public void setNumberOfChildren(int numberOfChildren) {
        this.numberOfChildren = Math.min(numberOfChildren, 3); // Maximum 3 children
    }

    public abstract double calculateSalary();

    // Getters
    public String getName() { return name; }
    public LocalDate getJoinDate() { return joinDate; }
    public double getBasicSalary() { return basicSalary; }
    public List<Lembur> getOvertimeList() { return overtimeList; }
    public int getNumberOfChildren() { return numberOfChildren; }
    public Department getDepartment() { return department; }
    public String getDepartmentName() { return department.getDepartmentName(); }
} 