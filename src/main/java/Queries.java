public class Queries {
    public static final String QUERY_TO_READ_CUSTOMER_BY_ID = "SELECT * FROM CUSTOMER WHERE ID = ?";
    public static final String QUERY_TO_READ_ALL_USERS = "SELECT * FROM USERS";
    public static final  String QUERY_TO_READ_PRODUCTS = "SELECT * FROM PRODUCTS";

    public static final String QUERY_TO_READ_ORDERS = "SELECT * FROM ORDERS";

    public static String QUERY_TO_UPDATE_ORDER = "UPDATE `bestbuy`.`orders` SET `orderStatus` = '%s' WHERE (`orderID` = '%d')";

    public static String QUERY_TO_READ_PRODUCT_BY_ID = "SELECT * FROM bestbuy.products where productID= '%s'";

    public static String QUERY_TO_ADD_ORDER="INSERT INTO ORDERS(productID,productName,quantity,price,orderStatus) VALUES('%s','%s','%d','%s','%s')";

}
