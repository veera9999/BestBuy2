import java.util.*;
import java.io.*;

public class OrderOperations {
    static  Scanner sc=new Scanner(System.in);
    public static void orderProduct()
    {
        System.out.println("Enter the productID:");
        String productID=sc.nextLine();
        System.out.println("Enter the Quantity:");
        int quantity=sc.nextInt();
        OrdersDAO.addToOrders(productID,quantity);
    }

    public static void updateOrder()
    {
        System.out.println("Enter the orderID: ");
        int orderID=sc.nextInt();
        System.out.println("1:ORDER_PLACED");
        System.out.println("2:ORDER_IN_STORE_HOUSE");
        System.out.println("3:ORDER_DISPATCHED");
        System.out.println("4:ORDER_DELIVERED");
        System.out.println("Enter the choice: ");
        int choice=sc.nextInt();
        OrdersDAO.updateOrder( orderID, choice);

    }

    public static void displayOrders()
    {
        OrdersDAO.displayOrders();
    }
}
