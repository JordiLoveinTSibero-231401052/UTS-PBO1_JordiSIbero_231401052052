package SistemManajemenDataKaryawan;

public class Karyawan {
    public int id;
    public String nama, posisi;
    public int gaji;

    Karyawan(int id, String nama, String posisi, int gaji){
        this.id = id;
        this.nama = nama;
        this.posisi = posisi;
        this.gaji = gaji;
    }
}
