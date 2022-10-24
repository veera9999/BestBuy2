import java.io.*;
import java.util.*;
import java.sql.*;

public class ProductsDAO {
    public static void displayAll()
    {
        Connection connection = null;
        ResultSet resultSet = null;
        try {
            connection = ConnectionHandler.getConnection();
            Statement statement = connection.createStatement();
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
        finally{
            try {
                resultSet.close();
                connection.close();

            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

}
