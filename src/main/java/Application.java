import java.util.*;
import java.io.*;

public class Application {
    public static void main(String [] args)
    {
       UserOperations userOperations=new UserOperations();
       userOperations.add(new User("Veera", "Palla", "Aomine","Jiraya"));
       userOperations.showUserList();
       userOperations.delete("Aomine");
       userOperations.showUserList();
    }
}
