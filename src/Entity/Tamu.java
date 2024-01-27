package Entity;

public class Tamu extends User {
    public String alamat;
    public String noTelp;



    public Tamu(String nik, String nama, String alamat, String noTelp) {
        super(nama,nik);
        this.alamat = alamat;
        this.noTelp = noTelp;
    }

    @Override
    public String getNama() {
        return nama;
    }

    public String getAlamat() {
        return alamat;
    }

    public String getNoTelp() {
        return noTelp;
    }

    @Override
    public String getNip() {
        return nip;
    }

    public void dataTamu() {
        System.out.println("Nama Tamu       : " + nama);
        System.out.println("NIK Tamu        : " + nip);
        System.out.println("Alamat          : " + alamat);
        System.out.println("No Telp         : " + noTelp);
    }
}