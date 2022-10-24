

import java.util.HashMap;

public class Orders {


    public int orderID;
    public String productID;
    public String productName;
    public int quantity;
    public double price;
    public String orderStatus;

    public static final String ORDER_DELIVERED = "ORDER_DELIVERED";

    public static final String ORDER_DISPATCHED  = "ORDER_DISPATCHED";

    public static final String ORDER_IN_STORE_HOUSE = "ORDER_IN_STORE_HOUSE";
    public static final String ORDER_PLACED = "ORDER_PLACED";

    public static final HashMap<Integer,String> orderStatusMap = new HashMap<>();
    static {
        orderStatusMap.put(1,ORDER_PLACED);
        orderStatusMap.put(2,ORDER_IN_STORE_HOUSE);
        orderStatusMap.put(3,ORDER_DISPATCHED);
        orderStatusMap.put(4,ORDER_DELIVERED);
    }

    public static String [] headers = {"ORDER_ID","PRODUCT_ID","PRODUCT_NAME","QUANTITY","PRICE","ORDER_STATUS"};
}