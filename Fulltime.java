import java.time.LocalDate;

public class Fulltime extends Employee implements Koperasi {
    private static final double COMMUNICATION_ALLOWANCE = 500000;
    private static final double CHILD_ALLOWANCE = 500000;
    private static final double PRODUCTIVITY_BONUS_PERCENTAGE = 0.10;
    private double loanMonthly;

    public Fulltime(String name, String id, LocalDate joinDate, String position, double basicSalary, Department department) {
        super(name, id, joinDate, position, basicSalary, department);
        this.loanMonthly = 0;
    }

    private double calculatePositionAllowance() {
        switch (position.toLowerCase()) {
            case "manager":
                return 3000000;
            case "supervisor":
                return 2000000;
            case "staff":
                return 1000000;
            default:
                return 0;
        }
    }

    @Override
    public double calculateSalary() {
        double totalSalary = basicSalary;
        
        // Position allowance
        totalSalary += calculatePositionAllowance();
        
        // Child allowance (maximum 3 children)
        totalSalary += (numberOfChildren * CHILD_ALLOWANCE);
        
        // Communication allowance
        totalSalary += COMMUNICATION_ALLOWANCE;
        
        // Calculate total overtime hours
        int totalOvertimeHours = 0;
        double totalOvertimeAllowance = 0;
        
        for (Lembur overtime : overtimeList) {
            totalOvertimeAllowance += overtime.hitungTotalLembur();
            totalOvertimeHours += java.time.Duration.between(overtime.getJamMulai(), overtime.getJamSelesai()).toHours();
        }
        
        totalSalary += totalOvertimeAllowance;
        
        // Productivity bonus if working more than 200 hours
        if (totalOvertimeHours > 200) {
            totalSalary += (basicSalary * PRODUCTIVITY_BONUS_PERCENTAGE);
        }
        
        // Subtract cooperative loan
        totalSalary -= loanMonthly;
        
        return totalSalary;
    }

    @Override
    public double getLoanMonthly() {
        return loanMonthly;
    }

    @Override
    public void setLoanMonthly(double amount) {
        this.loanMonthly = amount;
    }
} 