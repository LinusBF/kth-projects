package lab4;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.net.URL;
import java.util.Scanner;

/**
 * Created by Linus Bein Fahlander on 2018-10-09.
 */
public class Task3 {
    public static void main(String[] args) throws FileNotFoundException {
        String source = (args.length > 1 ? args[0] : "CA");
        String target = (args.length > 1 ? args[1] : "NY");
        URL url = Task3.class.getResource("statesWeighted.txt");
        Scanner scan =  new Scanner(new FileReader(url.getPath()));
        WeightedGraph g = new WeightedGraph(scan);
        BFSWeight bfs = new BFSWeight(g, source);

        for(String s : bfs.pathTo(target)){
            System.out.print(s + (!s.equals(source) ? " -> " : ""));
        }
    }
}
