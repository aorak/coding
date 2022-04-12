import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

// name: Aldiyar Orak
// this code can be reproduced

public class RunningMom {
    static HashMap<String , ArrayList<String>> grid = new HashMap<>();
    public static void main(String[] argv) throws Exception{
        Scanner br = new Scanner(System.in);
        int number = Integer.parseInt(br.nextLine());
        for (int i = 0; i < number; i++) {
            String[] buf = br.nextLine().split(" ");
            String first = buf[0];
            String second = buf[1];
            //populating our grid
            if (!grid.containsKey(first)) grid.put(first , new ArrayList<String>());
            if (!grid.containsKey(second)) grid.put(second , new ArrayList<String>());
            grid.get(first).add(second);
        }
        String goal;
        while (br.hasNextLine()) {
            goal = br.nextLine();
            //figuring out whether trapped or safe city is in goal
            if(DFS(goal, new ArrayList<String>())) System.out.println(goal + " safe");
            else System.out.println(goal + " trapped");
        }
    }
    //was inspired by code from https://www.geeksforgeeks.org/depth-first-search-or-dfs-for-a-graph/
    public static boolean DFS(String goal, ArrayList<String> search) {
        search.add(goal);
        for (String connect : grid.get(goal)) {
            if (search.contains(connect)) return true;
            else search.add(connect);
            if (DFS(connect, search)) return true;
            else search.remove(connect);
        }
        return false;
    }
}
