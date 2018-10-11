package lab4;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.net.URL;
import java.util.Scanner;

/**
 * Created by Linus on 2018-10-11.
 */
public class Task4 {
    public static void main(String[] args) throws FileNotFoundException {
        URL url = Task4.class.getResource("statesWeighted.txt");
        Scanner scan =  new Scanner(new FileReader(url.getPath()));
        WeightedGraph g = new WeightedGraph(scan);
        MST mst = new MST(g);

        for(Edge e : mst.edges()){
            System.out.println(e);
        }

        System.out.println("Total weight for MST: " + mst.totalWeight());
    }
}
