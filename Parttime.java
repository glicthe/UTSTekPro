import java.time.LocalDate;

public class Parttime extends Employee {
    private static final double PROJECT_BONUS = 200000;
    private int completedProjects;

    public Parttime(String name, LocalDate joinDate, double basicSalary, Department department) {
        super(name, joinDate, basicSalary, department);
        this.completedProjects = 0;
    }

    public void setCompletedProjects(int count) {
        this.completedProjects = count;
    }

    @Override
    public double calculateSalary() {
        double totalSalary = basicSalary;
        
        // Calculate overtime allowance
        double totalOvertimeAllowance = 0;
        for (Lembur overtime : overtimeList) {
            totalOvertimeAllowance += overtime.hitungTotalLembur();
        }
        totalSalary += totalOvertimeAllowance;
        
        // Add project bonus
        totalSalary += (completedProjects * PROJECT_BONUS);
        
        return totalSalary;
    }

    public int getCompletedProjects() {
        return completedProjects;
    }
} 