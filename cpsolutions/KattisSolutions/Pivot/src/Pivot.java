import java.io.BufferedReader;
import java.io.InputStreamReader;

// name: Aldiyar Orak
// this code can be reproduced
// wanted to do this with the sliding window, however I found it easier to just get max and min points

public class Pivot {
    public static void main(String[] argv) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int number = Integer.parseInt(br.readLine());
        String[] numbers = br.readLine().split(" ");
        int[] arr = new int[number];
        for(int i = 0; i < numbers.length; i++){
            arr[i] = Integer.parseInt(numbers[i]);
        }
        int[] minPoints = new int[number];
        int min = arr[number - 1];
        minPoints[number - 1] = min;
        int[] maxPoints = new int[number];
        int max = arr[0];
        maxPoints[0] = max;
        int result = 0;
        for(int i = 1; i < number; i++){
            if(arr[i] > max){
                max = arr[i];
            }
            maxPoints[i] = max;
        }

        for(int i = number - 2; i >= 0; i--){
            if(arr[i] < min) {
                min = arr[i];
            }
            minPoints[i] = min;
        }

        for(int i = 0; i < number; i++){
            if(arr[i] <= minPoints[i] &&  maxPoints[i] <= arr[i]) result++;
        }
        System.out.println(result);
    }
}
