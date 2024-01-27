package View;

import Model.hotelModel;
import Controller.hotelController;
import java.util.Scanner;
public class LoginPage {
    static Scanner input = new Scanner(System.in);

    public LoginPage(){
        menuPage();
    }
    private static void run() {
        String str = """
                """;
        int menu = -1;

        do {
            System.out.print(str);
            System.out.print("Pilih: ");
            menu = input.nextInt();
            input.nextLine();

            switch (menu) {
                case 1:
                    loginMenu();
                    break;
                case 2 :
                    loginAdminMenu();
                case 0:
                    LoginPage.menuPage();
                    break;
                default:
                    System.out.println("Menu Yang Anda Pilih Tidak Valid");
                    break;
            }
            System.out.println();
        } while (menu != 0);
    }

    public static void menuPage(){
        System.out.print("""
                1.STAFF
                2.TAMU
                3.EXIT
                INPUT  : """);
        int menu = input.nextInt();
        input.nextLine();
        switch (menu){
            case 1->run();
            case 2->new DashbordPage();
            case 3-> System.out.println("PROGRAM SELESAI");
        }
    }

    private static void loginMenu() {
        String nip, password;
        boolean status = false;

        do {
            System.out.println("\n-------------------- LOGIN -------------------");

            System.out.print("NIP       : ");
            nip = input.nextLine();

            System.out.print("Password  : ");
            password = input.nextLine();

            status = hotelController.login(nip, password);

            if (status) {
                System.out.println("----------------------------------------------");
                System.out.println("|               Berhasil Login.              |");
                System.out.println("----------------------------------------------");
                System.out.println();
                new DashbordPage();
                break;
            } else {
                System.out.println("----------------------------------------------");
                System.out.println("|         NIP atau password salah.           |");
                System.out.println("----------------------------------------------");
            }

        } while (status == false);
    }
    private static void loginAdminMenu() {
        String nip, password;
        boolean status = false;

        do {
            System.out.println("\n---------------- LOGIN ADMIN ---------------");

            System.out.print("NIP       : ");
            nip = input.nextLine();

            System.out.print("Password  : ");
            password = input.nextLine();

            status = hotelController.loginAdmin(nip, password);

            if (status) {
                System.out.println("----------------------------------------------");
                System.out.println("|               Berhasil Login.              |");
                System.out.println("----------------------------------------------");
                System.out.println();
                registerAccount();
                break;
            } else {
                System.out.println("----------------------------------------------");
                System.out.println("|         NIP atau password salah.           |");
                System.out.println("----------------------------------------------");
            }

        } while (status == false);

    }
    private static void registerAccount(){
        System.out.print("Masukkan Nama  : ");
        String nama = input.nextLine();
        System.out.print("Masukkan NIP   : ");
        String nip = input.nextLine();
        System.out.print("Masukkan Pass  : ");
        String password = input.nextLine();
        hotelModel.createAccount(nama,nip,password);

    }
}