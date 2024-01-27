package View;

import Model.hotelModel;
import Entity.Kamar;
import Entity.Reservasi;
import Entity.Tamu;
import java.util.Scanner;

public class DashbordPage {
    private static Scanner input = new Scanner(System.in);

    public DashbordPage() {
        run();
    }

    private void run() {
        String str = """
                ============== HOTEL MANAGEMENT ==============
                1. Check In
                2. Check Out
                3. Reservasi
                0. Keluar
                """;

//        int menu = -1;
        int menu;

        do {
            System.out.print(str);
            System.out.print("Pilih: ");
            menu = input.nextInt();
            input.nextLine();

            switch (menu) {
                case 1:
                    checkIn();
                    break;
                case 2:
                    checkOut();
                    break;
                case 3:
                    daftarReservasi();
                    break;
                case 0:
                    LoginPage.menuPage();
                    break;
                default:
                    System.out.println("Menu Tidak Tersedia");
                    break;
            }

        } while (menu != 0);
    }

    private void checkIn() {
        System.out.println("------------------ RESERVASI -----------------");
        System.out.println("------------------ CHECK  IN -----------------");

        String nik, nama, alamat, noTelp;

        System.out.print("Masukan NIK Tamu    : ");
        nik = input.nextLine();

        System.out.print("Masukan Nama Tamu   : ");
        nama = input.nextLine();

        System.out.print("Masukan Alamat Tamu : ");
        alamat = input.nextLine();

        System.out.print("Masukan No Telp Tamu: ");
        noTelp = input.nextLine();

        Kamar kamar = pilihKamar();

        System.out.print("Berapa Malam        : ");
        int malam = input.nextInt();
        input.nextLine();

        Tamu tamu = new Tamu(nik, nama, alamat, noTelp);

        hotelModel.checkIn(tamu, kamar, malam);
    }

    private Kamar pilihKamar() {
        boolean pilihKamarStatus = false;
        String kodeKamar;
        Kamar kamar;

        do {
            System.out.print("  Masukkan Kode Kamar    : ");
            kodeKamar = input.nextLine();
            kamar = hotelModel.cariKamar(kodeKamar);

            if (kamar != null) {
                if (kamar.status) {
                    char pilihKamarIni = 'n';

                    System.out.println("    Kode Kamar      : " + kamar.kodeKamar);
                    System.out.println("    Jenis Kamar     : " + kamar.jenisKamar);
                    System.out.println("    Harga Permalam  : " + kamar.hargaPerMalam);

                    System.out.print("  Pilih Kamar ini (y/n) : ");
                    pilihKamarIni = input.nextLine().charAt(0);

                    if (pilihKamarIni == 'y') {
                        pilihKamarStatus = true;
                        break;
                    }

                } else {
                    System.out.println("KAMAR TELAH DIPESAN!!!");
                }
            } else {
                System.out.println("KAMAR YANG ANDA MASUKKAN TIDAK DITEMUKAN");
            }
        } while (pilihKamarStatus == false);

        return kamar;
    }

    private void checkOut() {
        System.out.println("------------------ RESERVASI -----------------");
        System.out.println("------------------ CHECK OUT -----------------");

        String kodeKamar;

        System.out.print("Masukan Kode Kamar  : ");
        kodeKamar = input.nextLine();

        int indexReservasi = hotelModel.cariReservasibyKodeKamar(kodeKamar);
        if (indexReservasi > -1) {
            hotelModel.checkOut(indexReservasi);

            System.out.println("----------------------------------------------");
            System.out.println("|             Berhasil CHECK OUT.            |");
            System.out.println("----------------------------------------------");
            System.out.println();
        } else {
            System.out.println("Data Tidak Ditemukan !");
        }
    }

    private void daftarReservasi() {
        for (Reservasi reservasi : hotelModel.daftarReservasi) {
            System.out.println("==============================================");
            System.out.println("----------------- KAMAR -----------------");
            System.out.println("Kode Kamar      : " + reservasi.kamar.kodeKamar);
            System.out.println("Jenis Kamar     : " + reservasi.kamar.jenisKamar);
            System.out.println("--------------- IDENTITAS ---------------");
            System.out.println("NIK Tamu        : " + reservasi.tamu.nip);
            System.out.println("Nama Tamu       : " + reservasi.tamu.nama);
            System.out.println("No Telp Tamu    : " + reservasi.tamu.noTelp);
            System.out.println("------------------ DATE -----------------");
            System.out.println("Tanggal CheckIn : " + reservasi.tanggalCheckIn);
            System.out.println("Malam           : " + reservasi.malam);
            System.out.println("Tanggal CheckOut: " + reservasi.tanggalCheckOut);
            System.out.println("==============================================");
        }
    }

}