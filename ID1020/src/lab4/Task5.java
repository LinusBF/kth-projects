package lab4;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.net.URL;
import java.util.Scanner;

/**
 * Created by Linus Bein Fahlander on 2018-10-11.
 */
public class Task5 {
    public static void main(String[] args) throws FileNotFoundException {
        String source = (args.length > 1 ? args[0] : "AZ");
        String target = (args.length > 1 ? args[1] : "WA");
        URL url = Task5.class.getResource("states.txt");
        Scanner scan =  new Scanner(new FileReader(url.getPath()));
        DirectedGraph g = new DirectedGraph(scan);
        BFS bfs = new BFS(g, source);
        Boolean pathFound = false;
        try {
            for (String s : bfs.pathTo(target)) {
                if (!pathFound) pathFound = true;
                System.out.print(s + (!s.equals(source) ? " -> " : "\n"));
            }
            System.out.println("Found a path between " + source + " and " + target);
        } catch (NullPointerException e){
            System.out.println("No path between " + source + " and " + target);
        }
    }
}
