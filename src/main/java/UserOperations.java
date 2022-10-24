import java.util.*;
import java.io.*;
import java.util.ArrayList;
import java.sql.*;

public class UserOperations
{

    static Scanner sc = new Scanner(System.in);

    public static boolean validateUser()
    {
        System.out.println("Enter the User ID");
        String userID = sc.nextLine();
        System.out.println("Enter the password");
        String password = sc.nextLine();
        boolean v = UserDAO.validate(userID, password);
        if (v==false)
            validateUser();
        return v;

    }
    public static void addUser()
    {
        System.out.println("Enter the User ID");
        String userID = sc.nextLine();
        System.out.println("Enter the password");
        String password = sc.nextLine();
        UserDAO.add(userID,password);
    }
    public static void deleteUser()
    {
        System.out.println("Enter the User ID");
        String userID = sc.nextLine();
        UserDAO.delete(userID);
    }
    public static void updateUser()
    {
        System.out.println("Enter the User ID");
        String userID = sc.nextLine();
        System.out.println("Enter the password");
        String password = sc.nextLine();
        UserDAO.update(userID,password);
    }
}
