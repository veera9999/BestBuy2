import java.util.*;
import java.io.*;

public class Application {
    public static void main(String [] args)
    {
       UserOperations userOperations=new UserOperations();
       userOperations.showAll();
       ProductsDAO.displayAll();
       OrderOperations.displayOrders();


    }
}
