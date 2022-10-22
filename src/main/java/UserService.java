public class UserService {
    UserDAO userDAO  = new UserDAO();


    boolean validateUser(String userID) {
        User userFromDB = userDAO.getUserFromDB(userID);
       return userFromDB.userName.equals("veera") && userFromDB.Password.equals("passtemp$$");
    }

}
