package Controller;
import Model.hotelModel;
import Entity.Staff;
public class hotelController {
    static Staff staffLogged = null;

    public static Staff getStaffLogged() {
        return staffLogged;
    }

    public static boolean login(String nip, String password) {
        for (Staff staff : hotelModel.daftarStaff) {
            if ((staff.nip.equals(nip)) && (staff.password.equals(password))) {
                staffLogged = staff;
                return true;
            }
        }
        return false;
    }

    public static boolean loginAdmin(String nip, String password) {

        for (Staff staff : hotelModel.daftarAdmin) {
            if ((staff.nip.equals(nip)) && (staff.password.equals(password))) {
                return true;
            }
        }
        return false;
    }

    public static void logout() {
        staffLogged = null;
    }
}
