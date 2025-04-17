import java.time.LocalDate;
import java.time.LocalTime;

public class Main {
    public static void main(String[] args) {
        Department itDepartment = new Department("Staff Programmer");

        // Asep (fulltime)
        Fulltime asep = new Fulltime(
            "Asep",
            LocalDate.of(2021, 1, 1),
            5000000,
            itDepartment
        );
        
        asep.setNumberOfChildren(2);
        asep.setLoanMonthly(500000);
        
        asep.addOvertime(new Lembur(
            LocalDate.of(2024, 3, 15),
            LocalTime.of(9, 0),
            LocalTime.of(12, 0)
        ));
        asep.addOvertime(new Lembur(
            LocalDate.of(2024, 3, 16),
            LocalTime.of(20, 0),
            LocalTime.of(23, 0)
        ));

        // Ujang (parttime)
        Parttime ujang = new Parttime(
            "Ujang",
            LocalDate.of(2024, 1, 1),
            3000000,
            itDepartment
        );
        
        ujang.setCompletedProjects(1);
        
        ujang.addOvertime(new Lembur(
            LocalDate.of(2024, 3, 15),
            LocalTime.of(13, 0),
            LocalTime.of(18, 0)
        ));
        ujang.addOvertime(new Lembur(
            LocalDate.of(2024, 3, 16),
            LocalTime.of(10, 0),
            LocalTime.of(14, 0)
        ));

        
        printSalarySlip(asep, "Maret", 2024);
        System.out.println("\n");
        printSalarySlip(ujang, "Maret", 2024);
    }
    
    private static void printSalarySlip(Employee employee, String bulan, int tahun) {
        System.out.println("===========================================");
        System.out.println("           SLIP GAJI BULAN MARET           ");
        System.out.println("===========================================");
        System.out.println("Tanggal Terbit: 1 April 2025");
        System.out.println("Tanggal Pembayaran: 1 April 2025");
        System.out.println();
        System.out.println();
        System.out.println("Nama                       : " + employee.getName());
        System.out.println("Jabatan                    : " + employee.getDepartmentName());

        int totalJamLembur = employee.getOvertimeList().stream()
                .mapToInt(overtime -> (int) java.time.Duration.between(overtime.getJamMulai(), overtime.getJamSelesai()).toHours())
                .sum();
        int totalJamKerja = 176 + totalJamLembur; // 176 jam kerja normal dalam sebulan
        System.out.println("Total Jam Kerja            : " + totalJamKerja + " jam");
        System.out.println("Total Lembur               : " + totalJamLembur + " jam");

        
        if (employee instanceof Fulltime) {
            Fulltime ft = (Fulltime) employee;
            System.out.println("Tunjangan Jabatan          : Rp " + formatRupiah(1000000));
            System.out.println("Tunjangan Anak             : Rp " + formatRupiah(ft.getNumberOfChildren() * 500000));
            System.out.println("Tunjangan Komunikasi       : Rp 500.000");
        }
        
        double totalOvertime = employee.getOvertimeList().stream()
                .mapToDouble(Lembur::hitungTotalLembur)
                .sum();
        System.out.println("Tunjangan Lembur           : Rp " + formatRupiah(totalOvertime));
        
        if (employee instanceof Parttime) {
            Parttime pt = (Parttime) employee;
            System.out.println("Bonus Proyek               : Rp " + formatRupiah(pt.getCompletedProjects() * 200000));
        }
        
        if (employee instanceof Fulltime) {
            Fulltime ft = (Fulltime) employee;
            System.out.println("Total Pinjaman Koperasi    : Rp " + formatRupiah(ft.getLoanMonthly()));
        }
        
        System.out.println("-------------------------------------------");
        System.out.println("TOTAL GAJI                 : Rp " + formatRupiah(employee.calculateSalary()));
        System.out.println("===========================================");
    }
    
    private static String formatRupiah(double amount) {
        return String.format("%,.0f", amount);
    }
}
