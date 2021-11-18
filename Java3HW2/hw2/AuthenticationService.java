package ru.gb.java3.hw2;

import com.sun.org.apache.bcel.internal.generic.Select;

import java.rmi.ConnectException;
import java.sql.*;
import java.util.Optional;

public class AuthenticationService {

    public Optional<String> findUsername(String login, String password) {
        Connection connection = DatabaseConnector.getConnection();
        try {
            PreparedStatement st = connection.prepareStatement("SELECT * FROM users WHERE login = ? AND password = ?");
            st.setString(1, login);
            st.setString(2, password);
            ResultSet rs = st.executeQuery();

            if(rs.next()) {
                return Optional.of(rs.getString("username"));
            }



        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DatabaseConnector.close(connection);
        }

        return Optional.empty();
    }


    private static class User {
        private String login;
        private String password;
        private String username;

        public User(String login, String password, String username) {
            this.login = login;
            this.password = password;
            this.username = username;
        }

        public String getLogin() {
            return login;
        }

        public String getPassword() {
            return password;
        }

        public String getUsername() {
            return username;
        }
    }
}
