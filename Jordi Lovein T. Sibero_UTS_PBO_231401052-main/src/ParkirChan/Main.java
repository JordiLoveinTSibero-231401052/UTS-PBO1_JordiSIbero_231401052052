package ParkirChan;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<Kendaraan> daftarKendaraan = new ArrayList<>();
        Scanner input = new Scanner(System.in);

        boolean lanjut = true;
        while (lanjut) {
            System.out.println("===== Selamat Datang di ParkirChan =====");

            // Validasi jenis kendaraan
            Kendaraan kendaraan = null;
            while (kendaraan == null) {
                System.out.print("Jenis Kendaraan (Motor/Mobil/Truk): ");
                String jenisKendaraan = input.next();
                try {
                    kendaraan = new Kendaraan(jenisKendaraan);
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage() + " Silakan coba lagi.");
                }
            }

            // Validasi cara masukkan durasi
            String jenisDurasi;
            while (true) {
                System.out.print("Cara Masukkan Durasi (Manual/Time): ");
                jenisDurasi = input.next();
                if (jenisDurasi.equalsIgnoreCase("manual") || jenisDurasi.equalsIgnoreCase("time")) {
                    break;
                }
                System.out.println("Pilihan tidak valid. Masukkan 'Manual' atau 'Time'.");
            }

            // Proses hitung biaya
            if (jenisDurasi.equalsIgnoreCase("manual")) {
                System.out.print("Jumlah Durasi (Dalam Jam): ");
                int durasiParkir = input.nextInt();
                kendaraan.hitungBiaya(durasiParkir);
            } else {
                System.out.print("Jam Masuk (1–24): ");
                int jamMasuk = input.nextInt();
                System.out.print("Jam Keluar (1–24): ");
                int jamKeluar = input.nextInt();
                kendaraan.hitungBiaya(jamMasuk, jamKeluar);
            }
            daftarKendaraan.add(kendaraan);

            // Validasi tambah kendaraan
            String pilihan;
            while (true) {
                System.out.print("Tambah Kendaraan? (y/n): ");
                pilihan = input.next();
                if (pilihan.equalsIgnoreCase("y")) {
                    break;
                } else if (pilihan.equalsIgnoreCase("n")) {
                    lanjut = false;
                    break;
                }
                System.out.println("Pilihan tidak valid. Masukkan 'y' atau 'n'.");
            }
            System.out.println();
        }

        int totalKendaraan = 0;
        double totalBiayaParkir = 0;
        for (Kendaraan kendaraan : daftarKendaraan) {
            totalKendaraan++;
            totalBiayaParkir += kendaraan.subTotal;

        }

        System.out.println("\nRincian Biaya Parkir");
        System.out.printf("Total Kendaraan       : %d%n", totalKendaraan);
        System.out.printf("Total Biaya Parkir    : %.2f%n", totalBiayaParkir);
        System.out.println("Hati-Hati di Jalan :D !!!");
    }
}
