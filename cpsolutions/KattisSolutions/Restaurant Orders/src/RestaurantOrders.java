import java.io.*;

public class RestaurantOrders {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int pricesNum = Integer.parseInt(in.readLine());
        String[] buf = in.readLine().split(" ");
        int[] prices = new int[pricesNum];
        for(int i = 0; i < buf.length; i++){
            prices[i] = Integer.parseInt(buf[i]);
        }
        int ordersNum = Integer.parseInt(in.readLine());
        buf = in.readLine().split(" ");
        int[] orders = new int[ordersNum];
        for(int i = 0; i < buf.length; i++){
            orders[i] = Integer.parseInt(buf[i]);
        }

    }
}
