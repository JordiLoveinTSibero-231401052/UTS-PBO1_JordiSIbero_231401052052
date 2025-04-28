package SistemManajemenDataKaryawan;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Perusahaan perusahaan = new Perusahaan();

        Scanner input = new Scanner(System.in);
        int pilihan;
        boolean lanjut = true;

        while (lanjut){
            System.out.println("===== Sistem Manajemen Karyawan =====");
            System.out.println("1. Tambah Karyawan");
            System.out.println("2. Hapus Karyawan");
            System.out.println("3. Ubah Posisi");
            System.out.println("4. Ubah Gaji");
            System.out.println("5. Tampilkan Data Karyawan");
            System.out.println("6. Keluar");

            System.out.print("\nPilihan: ");
            pilihan = input.nextInt();

            switch (pilihan){
                case 1:
                    perusahaan.tambahKaryawan();
                    break;
                case 2:
                    perusahaan.hapusKaryawan();
                    break;
                case 3:
                    perusahaan.ubahPosisiKaryawan();
                    break;
                case 4:
                    perusahaan.ubahGajiKaryawan();
                    break;
                case 5:
                    perusahaan.tampilkanKaryawan();
                    break;
                case 6:
                    lanjut = false;
                    break;
            }
        }

    }
}
