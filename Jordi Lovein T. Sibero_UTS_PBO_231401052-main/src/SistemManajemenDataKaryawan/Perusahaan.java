package SistemManajemenDataKaryawan;

import java.util.ArrayList;
import java.util.Scanner;

public class Perusahaan {
    ArrayList<Karyawan> daftarKaryawan = new ArrayList<Karyawan>();
    Scanner input = new Scanner(System.in);

    public void tambahKaryawan() {
        int id;

        System.out.print("ID: ");
        id = input.nextInt();
        input.nextLine();

        for (Karyawan karyawan : daftarKaryawan) {
            if (karyawan.id == id) {
                System.out.printf("Karyawan dengan ID %d sudah terdaftar!\n", id);
                return;
            }
        }

        System.out.print("Nama: ");
        String nama = input.nextLine();

        System.out.print("Posisi: ");
        String posisi = input.nextLine();

        System.out.print("Gaji: ");
        int gaji = input.nextInt();

        if (gaji < 0){
            System.out.println("Nilai Gaji Tidak Valid\n");
            return;
        }

        daftarKaryawan.add(new Karyawan(id, nama, posisi, gaji));
        System.out.println("Karyawan berhasil ditambahkan!\n");
    }


    public void hapusKaryawan(){
        int id;

        System.out.print("ID: ");
        id = input.nextInt();

        int i = 0;
        for (Karyawan karyawan : daftarKaryawan){
            if (karyawan.id == id){
                daftarKaryawan.remove(i);
                System.out.printf("Data Karyawan Dengan Id %d Berhasil Dihapus\n", id);
                return;
            }
            i++;
        }

        System.out.printf("Tidak Dapat Menemukan ID Karyawan, %d\n", id);
    }

    public void ubahPosisiKaryawan(){
        int id;
        String posisiBaru;
        boolean ketemu = false;

        System.out.print("ID: ");
        id = input.nextInt();
        input.nextLine();

        for (Karyawan karyawan : daftarKaryawan) {
            if (karyawan.id == id) {
                ketemu = true;
            }
        }

        if (ketemu){
            System.out.print("Posisi Baru: ");
            posisiBaru = input.nextLine();

            for (Karyawan karyawan : daftarKaryawan){
                if (karyawan.id == id){
                    karyawan.posisi = posisiBaru;
                    System.out.printf("Posisi Data Karyawan Dengan Id %d Berhasil Diubah Menjadi %s\n", id, posisiBaru);
                    return;
                }
            }
        }

        System.out.printf("Tidak Dapat Menemukan ID Karyawan, %d\n", id);
    }

    public void ubahGajiKaryawan(){
        int id, gajiBaru;
        boolean ketemu = false;

        System.out.print("ID: ");
        id = input.nextInt();
        input.nextLine();

        for (Karyawan karyawan : daftarKaryawan) {
            if (karyawan.id == id) {
                ketemu = true;
            }
        }

        if (ketemu){
            System.out.print("Gaji Baru: ");
            gajiBaru = input.nextInt();

            if (gajiBaru < 0){
                System.out.println("Nilai Gaji Tidak Valid\n");
                return;
            }

            for (Karyawan karyawan : daftarKaryawan){
                if (karyawan.id == id){
                    karyawan.gaji = gajiBaru;
                    System.out.printf("Gaji Data Karyawan Dengan Id %d Berhasil Diubah Menjadi %d\n", id, gajiBaru);
                    return;
                }
            }
        }

        System.out.printf("Tidak Dapat Menemukan ID Karyawan, %d\n", id);
    }

    public void tampilkanKaryawan(){
        System.out.println("==== Data Karyawan ====");
        for (Karyawan karyawan : daftarKaryawan){
            System.out.printf("ID: %d\n", karyawan.id);
            System.out.printf("Nama: %s\n", karyawan.nama);
            System.out.printf("Posisi: %s\n", karyawan.posisi);
            System.out.printf("Gaji: %d\n\n", karyawan.gaji);
        }
    }
}
