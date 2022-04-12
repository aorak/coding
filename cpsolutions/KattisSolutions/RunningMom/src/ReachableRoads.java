import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

// name: Aldiyar Orak
// this code can be reproduced

public class ReachableRoads {
    static int[] grid;
    public static void main(String[] argv) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int number = Integer.parseInt(br.readLine());
        for (int i = 0; i < number; i++) {
            HashSet<Integer> graph = new HashSet<>();
            int vertices = Integer.parseInt(br.readLine());
            int edges = Integer.parseInt(br.readLine());
            grid = new int[vertices];
            for(int j = 0; j < vertices; j++){
                grid[j] = j;
            }
            //creating a connected graph
            for(int j = 0; j < edges; j++){
                String[] temp = br.readLine().split(" ");
                grid[search(Integer.parseInt(temp[0]))] = search(Integer.parseInt(temp[1]));
            }
            //completing the graph by adding only the vertices that could not point on certain locations
            for(int j = 0; j < vertices; j++){
                graph.add(search(grid[j]));
            }
            System.out.println(graph.size() - 1);
        }
    }
    public static int search(int vertex) {
        if(grid[vertex] == vertex) return vertex;
        else {
            grid[vertex] = search(grid[vertex]);
            return grid[vertex];
        }
    }
}
