import java.util.*;
import java.io.*;
import java.sql.*;

public class OrdersDAO {

    public static void addToOrders(String productID,int quantity) {
        Connection connection = null;
        ResultSet resultSet = null;
        try {
            connection = ConnectionHandler.getConnection();
            Statement statement = connection.createStatement();
            resultSet = statement.executeQuery(String.format(Queries.QUERY_TO_READ_PRODUCT_BY_ID,productID));
            resultSet.next();
                    statement.executeUpdate(String.format(Queries.QUERY_TO_ADD_ORDER,
                    resultSet.getString("productID"),
                    resultSet.getString("productName"),
                    quantity,
                    resultSet .getString("productPrice"),
                    Orders.orderStatusMap.get(1)));
            System.out.println("Order Placed Successfully");
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

    public static void updateOrder(int orderID,int choice)
    {
        Connection connection = null;
        try {
            connection = ConnectionHandler.getConnection();
            Statement statement = connection.createStatement();
            statement.executeUpdate(String.format(Queries.QUERY_TO_UPDATE_ORDER, Orders.orderStatusMap.get(choice),orderID));
            System.out.println("OrderStatus Updated Successfully");

        } catch (Exception e) {

            e.printStackTrace();
        }
        finally{
            try {
                connection.close();

            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static void displayOrders()
    {
        Connection connection = null;
        ResultSet resultSet = null;
        try {
            connection = ConnectionHandler.getConnection();
            Statement statement = connection.createStatement();
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



