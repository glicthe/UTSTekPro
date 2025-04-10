import java.time.LocalDate;
import java.time.LocalTime;

public class Main {
    public static void main(String[] args) {
        Department itDepartment = new Department("Information Technology", "IT001");

        // Asep (fulltime)
        Fulltime asep = new Fulltime(
            "Asep",
            "K001",
            LocalDate.of(2021, 1, 1),
            "Staff",
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
            "K002",
            LocalDate.of(2024, 1, 1),
            "Staff",
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

        System.out.println("===========================================");
        System.out.println("                 SLIP GAJI                ");
        System.out.println("===========================================");
        
        printSalarySlip(asep, "Maret", 2024);
        System.out.println("\n");
        printSalarySlip(ujang, "Maret", 2024);
    }
    
    private static void printSalarySlip(Employee employee, String bulan, int tahun) {
        System.out.println("Nama Karyawan    : " + employee.getName());
        System.out.println("ID Karyawan      : " + employee.getId());
        System.out.println("Jabatan          : " + employee.getPosition());
        System.out.println("Departemen       : " + employee.getDepartmentName());
        System.out.println("Periode          : " + bulan + " " + tahun);
        System.out.println("-------------------------------------------");
        System.out.println("RINCIAN GAJI:");
        System.out.println("Gaji Pokok       : Rp " + formatRupiah(employee.getBasicSalary()));
        
        if (employee instanceof Fulltime) {
            Fulltime ft = (Fulltime) employee;
            System.out.println("Tunjangan Jabatan: Rp " + formatRupiah(1000000));
            System.out.println("Tunjangan Anak   : Rp " + formatRupiah(ft.getNumberOfChildren() * 500000));
            System.out.println("Tunjangan Kom    : Rp 500.000");
        }
        
        double totalOvertime = employee.getOvertimeList().stream()
                .mapToDouble(Lembur::hitungTotalLembur)
                .sum();
        System.out.println("Tunjangan Lembur : Rp " + formatRupiah(totalOvertime));
        
        if (employee instanceof Parttime) {
            Parttime pt = (Parttime) employee;
            System.out.println("Bonus Proyek     : Rp " + formatRupiah(pt.getCompletedProjects() * 200000));
        }
        
        if (employee instanceof Fulltime) {
            Fulltime ft = (Fulltime) employee;
            System.out.println("Pinjaman Koperasi: Rp " + formatRupiah(ft.getLoanMonthly()));
        }
        
        System.out.println("-------------------------------------------");
        System.out.println("TOTAL GAJI       : Rp " + formatRupiah(employee.calculateSalary()));
        System.out.println("===========================================");
    }
    
    private static String formatRupiah(double amount) {
        return String.format("%,.0f", amount);
    }
}
