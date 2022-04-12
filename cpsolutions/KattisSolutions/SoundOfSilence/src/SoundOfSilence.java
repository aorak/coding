import java.io.BufferedReader;
import java.io.InputStreamReader;

// name: Aldiyar Orak
// this code can be reproduced

public class SoundOfSilence {
    public static void main(String[] argv) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] numbers = br.readLine().split(" ");
        // number of samples
        int silence = Integer.parseInt(numbers[0]);
        // length of silence
        int length = Integer.parseInt(numbers[1]);
        // silence threshold
        int threshold = Integer.parseInt(numbers[2]);


    }
}
