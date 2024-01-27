package Entity;

public abstract class User {
    public String nama;
    public String nip;

    public User(String nama,String nip) {
        this.nama = nama;
        this.nip = nip;
    }
    public abstract String getNama();

    public abstract String getNip();

    public void dataUser() {
        System.out.println("NAMA    : "+nama);
        System.out.println("NIP     : "+nip);
    }
}