import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;

// name: Aldiyar Orak
// this code can be reproduced

public class ContinuingSubsequences {
    public static void main(String[] argv) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int number = Integer.parseInt(br.readLine());

        for(int i = 0; i < number; i++) {
            br.readLine();
            int counter = 0;
            int quint = Integer.parseInt(br.readLine());
            int[] sequence = new int[quint + 1];
            sequence[0] = 0;
            String[] line = br.readLine().split(" ");
            for (int j = 1; j < quint; j++){
                sequence[j] = Integer.parseInt(line[j]);
                if(sequence[j] < 47)
                    sequence[j] += sequence[j - 1];
            }
            for (int j = 1; j < quint; j++){
                if(sequence[j] == 47)
                    counter++;

            }
            System.out.println(counter);
        }

    }
}
