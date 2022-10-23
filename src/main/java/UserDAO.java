import java.io.*;
import java.util.*;
import java.sql.*;

public class UserDAO {
        public static void displayAllUsers()
        {
            try {
                Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/bestbuy", "root", "JavaSucks");
                Statement statement = connection.createStatement();
                ResultSet resultSet;
                resultSet = statement.executeQuery(Queries.QUERY_TO_READ_ALL_USERS);
                while (resultSet.next()) {
                    System.out.println(resultSet.getString("username"));
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }
