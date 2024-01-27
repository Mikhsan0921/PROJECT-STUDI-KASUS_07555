package Entity;

public class Staff extends User {

    public String password;

    public Staff(String nama, String nip, String password) {
        super(nama,nip);
        this.password = password;
    }

    public void setPass(String pass){
        this.password=pass;
    }
    @Override
    public String getNama(){
        return nama;
    }

    @Override
    public String getNip() {
        return null;
    }
    public void dataStaff() {
        System.out.println("Nama Staff      : " + nama);
        System.out.println("NIP Staff       : " + nip);
        System.out.println("Password        : " + password);
    }
}