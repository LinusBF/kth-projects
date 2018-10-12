/*
* This class finds the shortest path in a graph using Depth First Search
*
* */

package lab4;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.net.URL;
import java.util.Scanner;

/**
 * Created by Linus on 2018-10-09.
 */
public class Task1 {
    public static void main(String[] args) throws FileNotFoundException {
        String source = (args.length > 1 ? args[0] : "CA");
        String target = (args.length > 1 ? args[1] : "NY");
        URL url = Task1.class.getResource("states.txt");
        Scanner scan =  new Scanner(new FileReader(url.getPath()));
        Graph g = new Graph(scan);
        DFS dfs = new DFS(g, source);

        for(String s : dfs.pathTo(target)){
            System.out.print(s + (!s.equals(source) ? " -> " : ""));
        }
    }
}
