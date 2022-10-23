import java.util.*;
import java.io.*;
import java.sql.*;

public class OrdersDAO {

    public static void addToOrders(String productID,int quantity) {
        try {
            Connection connection1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/bestbuy", "root", "JavaSucks");
            Statement statement1 = connection1.createStatement();
            ResultSet resultSet1;
            resultSet1 = statement1.executeQuery(String.format(Queries.QUERY_TO_READ_PRODUCT_BY_ID,productID));
            resultSet1.next();
                    statement1.executeUpdate(String.format(Queries.QUERY_TO_ADD_ORDER,
                    resultSet1.getString("productID"),
                    resultSet1.getString("productName"),
                    quantity,
                    resultSet1.getString("productPrice"),
                    Orders.orderStatusMap.get(1)));
            System.out.println("Order Placed Successfully");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void updateOrder(int orderID,int choice)
    {
        try {

            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/bestbuy", "root", "JavaSucks");
            Statement statement = connection.createStatement();
            statement.executeUpdate(String.format(Queries.QUERY_TO_UPDATE_ORDER,Orders.orderStatusMap.get(choice),orderID));


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void displayOrders()
    {
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/bestbuy", "root", "JavaSucks");
            Statement statement = connection.createStatement();
            ResultSet resultSet;
            resultSet = statement.executeQuery(Queries.QUERY_TO_READ_ORDERS);
            while (resultSet.next()) {
                System.out.println(resultSet.getInt("orderID")+"   "+
                        resultSet.getString("productID")+"     "+
                        resultSet.getString("productName")+"                       "+
                        resultSet.getString("price")+"                "+
                        resultSet.getString("quantity")+"                   "+
                        resultSet.getString("orderStatus"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
