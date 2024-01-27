package Entity;

import utils.DateString;

public class Reservasi {
    public Tamu tamu;
    public Kamar kamar;
    public int malam;

    public String tanggalCheckIn;
    public String tanggalCheckOut="Belum CheckOut";

    public Reservasi() {
    }

    public Reservasi(Tamu tamu, Kamar kamar, int malam) {
        this.tamu = tamu;
        this.kamar = kamar;
        this.malam = malam;
        this.tanggalCheckIn = DateString.now();
    }

    public void dataKamar() {
        tamu.dataTamu();
        kamar.dataKamar();
        System.out.println("Malam           : " + malam);
        System.out.println("Tanggal CheckIn : " + tanggalCheckIn);
        System.out.println("Tanggal CheckOut: " + tanggalCheckOut);
    }

    public void setTanggalCheckIn(String tanggalCheckIn) {
        this.tanggalCheckIn = tanggalCheckIn;
    }

    public void setTanggalCheckOut(String tanggalCheckOut) {
        this.tanggalCheckOut = tanggalCheckOut;
    }
    public Tamu getTamu() {
        return tamu;
    }

    public Kamar getKamar() {
        return kamar;
    }

    public int getMalam() {
        return malam;
    }
}