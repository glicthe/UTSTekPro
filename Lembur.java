import java.time.LocalDate;
import java.time.LocalTime;

public class Lembur {
    private LocalDate tanggal;
    private LocalTime jamMulai;
    private LocalTime jamSelesai;
    private double tarifLembur;

    public Lembur(LocalDate tanggal, LocalTime jamMulai, LocalTime jamSelesai) {
        this.tanggal = tanggal;
        this.jamMulai = jamMulai;
        this.jamSelesai = jamSelesai;
        this.tarifLembur = hitungTarifLembur();
    }

    private double hitungTarifLembur() {
        // Cek apakah hari Sabtu/Minggu
        if (tanggal.getDayOfWeek().getValue() >= 6) {
            return 50000; // Rp50.000 per jam untuk hari Sabtu/Minggu
        }
        return 30000; // Rp30.000 per jam untuk hari biasa
    }

    public double hitungTotalLembur() {
        long jam = java.time.Duration.between(jamMulai, jamSelesai).toHours();
        return jam * tarifLembur;
    }

    // Getters
    public LocalDate getTanggal() { return tanggal; }
    public LocalTime getJamMulai() { return jamMulai; }
    public LocalTime getJamSelesai() { return jamSelesai; }
    public double getTarifLembur() { return tarifLembur; }
} 