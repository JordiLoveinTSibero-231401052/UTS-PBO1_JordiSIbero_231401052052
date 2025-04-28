package ParkirChan;

public class Kendaraan {
    public String jenisKendaraan;
    public int durasiParkir;
    public double subTotal = 0;

    Kendaraan(String jenisKendaraan) {
        this.jenisKendaraan = jenisKendaraan;
        // Validasi jenis kendaraan
        if (cekBiayaBerdasarkanKendaraan(this.jenisKendaraan) == 0) {
            throw new IllegalArgumentException("Hanya Berlaku Untuk Motor, Mobil, atau Truk");
        }
    }

    void hitungBiaya(int durasiParkir) {
        // Validasi durasi parkir
        if (durasiParkir <= 0) {
            System.out.println("Durasi parkir harus lebih dari 0 jam.");
            return;
        }
        this.durasiParkir = durasiParkir;
        double biayaParkir = cekBiayaBerdasarkanKendaraan(jenisKendaraan) * this.durasiParkir;
        this.subTotal = biayaParkir - cekDiskon(this.durasiParkir, biayaParkir);
        tampilRingkasan(this.jenisKendaraan, this.durasiParkir, this.subTotal);
    }

    void hitungBiaya(int jamMasuk, int jamKeluar) {
        // Validasi jam
        if (jamMasuk < 1 || jamMasuk > 24 || jamKeluar < 1 || jamKeluar > 24) {
            System.out.println("Jam masuk dan keluar antara jam 1 sampai 24.");
            return;
        }
        if (jamMasuk == jamKeluar) {
            System.out.println("Jam masuk dan jam keluar tidak boleh sama.");
            return;
        }

        System.out.println("Jam Masuk: " + jamMasuk);
        System.out.println("Jam Keluar: " + jamKeluar);

        int selisih = (jamKeluar - jamMasuk + 24) % 24;

        this.durasiParkir = selisih;
        double biayaParkir = cekBiayaBerdasarkanKendaraan(jenisKendaraan) * this.durasiParkir;
        this.subTotal = biayaParkir - cekDiskon(this.durasiParkir, biayaParkir);
        tampilRingkasan(this.jenisKendaraan, this.durasiParkir, this.subTotal);
    }


    int cekBiayaBerdasarkanKendaraan(String jenisKendaraan) {
        if (this.jenisKendaraan.toLowerCase().equals("motor")) {
            return 2000;
        } else if (this.jenisKendaraan.toLowerCase().equals("mobil")) {
            return 5000;
        } else if (this.jenisKendaraan.toLowerCase().equals("truk")) {
            return 9000;
        } else {
            return 0;
        }
    }

    double cekDiskon(int durasiParkir, double biayaParkir) {
        // diskon 10% jika > 5 jam
        if (durasiParkir > 5) return biayaParkir * 10 / 100;
        return 0;
    }

    void tampilRingkasan(String jenisKendaraan, int durasiParkir, double subTotal) {
        System.out.println("\nRincian Biaya Parkir");
        System.out.printf("Jenis Kendaraan        : %s\n", jenisKendaraan);
        System.out.printf("Durasi Parkir          : %d\n", durasiParkir);
        System.out.printf("Total Biaya Parkir     : %.2f\n\n", subTotal);
    }
}
