import java.util.*;
import java.io.*;

public class Application {
    public static void main(String [] args)
    {
      OrderOperations orderOperations=new OrderOperations();
      ProductsDAO.displayAll();
      System.out.println();
      orderOperations.orderProduct();
      System.out.println();
      orderOperations.displayOrders();
      System.out.println();
      orderOperations.updateOrder();
      System.out.println();
      orderOperations.displayOrders();
    }
}
