import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Arrays;

public class ExactChange {
    static int[][] dp;
    static boolean[][] grid;
    public static void main(String[] argv) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int number = Integer.parseInt(br.readLine());

        for(int i = 0; i < number; i++){
            int price = Integer.parseInt(br.readLine());
            int billNum = Integer.parseInt(br.readLine());
            int[] bills = new int[billNum];
            dp = new int[billNum + 1][10001];
            grid = new boolean[billNum + 1][10001];
            for(int[] j : dp) {
                Arrays.fill(j, 12345678);
            }
            for(int j = 0; j < billNum; j++){
                bills[j] = Integer.parseInt(br.readLine());
            }
            PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));
            for (int num = price; num < dp[billNum].length; num++) {
                if (helper(bills, num, 0) != 12345678) {
                    System.out.println(num + " " + helper(bills, num, 0));
                    break;
                }
            }

        }
    }
    public static int helper(int[] bills, int amount, int n){
        if (grid[n][amount]) {
            if (amount == 0) dp[n][amount] = 0;
            else if (n == bills.length) dp[n][amount] = 12345678;
            else if (amount >= bills[n]) dp[n][amount]=Math.min(helper(bills, amount, n + 1),
                    1 + helper(bills, amount - bills[n],n + 1));
            else if (amount < bills[n]) dp[n][amount] = helper(bills, amount, n + 1);
            grid[n][amount]=true;
        }
        return dp[n][amount];
    }

}
