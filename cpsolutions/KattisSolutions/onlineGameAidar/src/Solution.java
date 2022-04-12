import java.util.Scanner;

public class Solution {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String A = sc.nextLine();
        String B = sc.nextLine();
        System.out.println(solution(A,B));
    }

    public static int solution(String A, String B){
        String[] hoursMinutes1 = A.split(":");
        String[] hoursMinutes2 = B.split(":");
        int hours1 = Integer.parseInt(hoursMinutes1[0]);
        int hours2 = Integer.parseInt(hoursMinutes2[0]);
        int minutes1 = Integer.parseInt(hoursMinutes1[1]);
        int minutes2 = Integer.parseInt(hoursMinutes2[1]);
        int time1 = minutes1 + 60 * hours1;
        int time2 = minutes2 + 60 * hours2;
        if(time2 < time1)
            time2 += 24 * 60;
        if(time1 % 15 != 0)
            time1 += 15 - (time1 % 15);
        return (time2 - time1)/15;
    }

}
