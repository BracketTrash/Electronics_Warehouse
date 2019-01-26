package electronics_wherehouse;

import java.util.ArrayList;

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

    public class Users {


        private String userName,userPassword;
        private  int userId;

        private ArrayList<Users> userList;


        public Users( int userId,String userName, String userPassword) {
            this.userId = userId;
            this.userName = userName;
            this.userPassword = userPassword;
        }

        public Users(String userName, String userPassword) {
            this.userName = userName;
            this.userPassword = userPassword;
        }


        public void setUserName(String userName) {
            this.userName = userName;
        }

        public String getUserName() {
            return userName;
        }

        public String getUserPassword() {
            return userPassword;
        }

        public void setUserPassword(String userPassword) {
            this.userPassword = userPassword;
        }

        public ArrayList<Users> getUsers() {
            return userList;
        }

        public void setUsers(ArrayList<Users> users) {
            this.userList = users;
        }


    }


