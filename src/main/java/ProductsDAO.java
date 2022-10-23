import java.io.*;
import java.util.*;
import java.sql.*;

public class ProductsDAO {
    public static void displayAll()
    {
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/bestbuy", "root", "JavaSucks");
            Statement statement = connection.createStatement();
            ResultSet resultSet;
            resultSet = statement.executeQuery(Queries.QUERY_TO_READ_PRODUCTS);
            while (resultSet.next()) {
                System.out.println(resultSet.getString("productID")+"     "+
                        resultSet.getString("productName")+"                       "+
                        resultSet.getString("productCategory")+"                "+
                        resultSet.getString("subCategory")+"                   "+
                        resultSet.getString("productPrice"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
