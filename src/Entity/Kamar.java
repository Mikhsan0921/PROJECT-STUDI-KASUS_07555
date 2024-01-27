package Entity;

public class Kamar {
    public String kodeKamar;
    public String jenisKamar;

    public boolean isStatus() {
        return status;
    }

    public int hargaPerMalam;
    public boolean status;

    public Kamar() {
    }

    public Kamar(String kodeKamar, String jenisKamar, int hargaPerMalam, boolean status) {
        this.kodeKamar = kodeKamar;
        this.jenisKamar = jenisKamar;
        this.hargaPerMalam = hargaPerMalam;
        this.status = status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getKodeKamar() {
        return kodeKamar;
    }

    public String getJenisKamar() {
        return jenisKamar;
    }

    public int getHargaPerMalam() {
        return hargaPerMalam;
    }

    public void dataKamar() {
        System.out.println("Kode Kamar      : " + kodeKamar);
        System.out.println("Jenis Kamar     : " + jenisKamar);
        System.out.println("Harga Per Malam : " + hargaPerMalam);
        System.out.println("Status          : " + status);
    }

}