import java.util.*;
import java.io.*;
import java.util.ArrayList;

public class UserOperations {
    ArrayList<User> userList = new ArrayList<User>();
    void add(User u) {
        userList.add(u);
    }
    void delete(String user_Name)
    {
        for(User u: userList)
        {
            if(u.userName==user_Name)
            {
                userList.remove(u);
            }
        }
    }
    void showUserList()
    {
        for(User u: userList)
        {
            System.out.println(u.FirstName + "   "+u.LastName+"   "+u.userName+"   "+u.Password);
        }
    }

}
