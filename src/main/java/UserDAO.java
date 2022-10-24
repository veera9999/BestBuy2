import java.io.*;
import java.util.*;
import java.sql.*;

public class UserDAO {
    public static boolean validate(String userID, String password) {
        Connection connection = null;
        ResultSet resultSet = null;
        try {
            connection = ConnectionHandler.getConnection();
            Statement statement = connection.createStatement();
            resultSet = statement.executeQuery(String.format(Queries.QUERY_TO_VALIDATE_USER, userID));
            if (!resultSet.next()) {
                System.out.println("Invalid userID");
                return false;
            } else if (!resultSet.getString("password").equals(password)) {
                System.out.println("Invalid password");
                return false;
            } else {
                System.out.println("Logged in successfully");
                return true;
            }
        } catch (Exception e) {

            e.printStackTrace();
        } finally {
            try {
                resultSet.close();
                connection.close();

            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return true;
    }

    public static void add(String userID, String password) {
        Connection connection = null;
        try {
            connection = ConnectionHandler.getConnection();
            Statement statement = connection.createStatement();
            statement.executeUpdate(String.format(Queries.QUERY_TO_ADD_USER, userID, password));
            System.out.println("New User added");
        } catch (Exception e) {

            e.printStackTrace();
        } finally {
            try {
                connection.close();

            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

    }

    public static void delete(String userID) {
        Connection connection = null;
        try {
            connection = ConnectionHandler.getConnection();
            Statement statement = connection.createStatement();
            statement.executeUpdate(String.format(Queries.QUERY_TO_DELETE_USER, userID));
            System.out.println("User Deleted Successfully");
        } catch (Exception e) {

            e.printStackTrace();
        } finally {
            try {
                connection.close();

            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }


    public static void update(String userID, String password) {
        Connection connection = null;
        try {
            connection = ConnectionHandler.getConnection();
            Statement statement = connection.createStatement();
            statement.executeUpdate(String.format(Queries.QUERY_TO_UPDATE_USER, password, userID));
            System.out.println("User Credentials Updated Successfully");
        } catch (Exception e) {

            e.printStackTrace();
        } finally {
            try {
                connection.close();

            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

    }

}
