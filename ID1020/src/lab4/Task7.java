/*
* This class sorts in topological order of a Directed Graph
*
* */

package lab4;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.net.URL;
import java.util.Scanner;

/**
 * Created by Linus on 2018-10-11.
 */
public class Task7 {
    public static void main(String[] args) throws FileNotFoundException {
        URL url = Task4.class.getResource("smallDB.txt");
        Scanner scan =  new Scanner(new FileReader(url.getPath()));
        DirectedGraph g = new DirectedGraph(scan);
        Topological top = new Topological(g);

        for(String e : top.order()){
            System.out.print(e + "\n");
        }
    }
}
