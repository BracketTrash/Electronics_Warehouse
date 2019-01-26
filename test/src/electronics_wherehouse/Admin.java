
package electronics_wherehouse;

/**
 * This program implements an application that
 * does the following ................
 * Allows users to make accounts
 * Allows users to login
 * Allows admins to log in
 * Allows products to be added
 * Allows products to be displayed
 *
 * @author  Conor Casey
 * @version 1.0
 * @since   2018-10-23
 */

public class Admin {

    private int adminId;
    private String adminName;
    private String adminPassword;

    public Admin(int adminId,String adminName, String adminPassword) {
        this.adminId = adminId;
        this.adminName = adminName;
        this.adminPassword = adminPassword;
    }

    public int getAdminId() {
        return adminId;
    }

    public void setAdminId(int adminId) {
        this.adminId = adminId;
    }

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    public String getAdminPassword() {
        return adminPassword;
    }

    public void setAdminPassword(String adminPassword) {
        this.adminPassword = adminPassword;
    }
}
