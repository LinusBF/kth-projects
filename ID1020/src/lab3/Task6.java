package lab3;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Linus on 2018-10-01.
 */
public class Task6 {
    static void insert(GenericStore<String, ArrayList<Integer>> st, String s, Integer index){
        if(st.contains(s)){
            st.get(s).add(index);
        }
        else {
            ArrayList<Integer> list = new ArrayList<>();
            list.add(index);
            st.put(s, list);
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        Scanner scan =  new Scanner(new FileReader("E:\\kth-projects\\ID1020\\src\\lab3\\filtered_text.txt"));
        String searchKey = (args.length > 0 ? args[0] : "spectators");
        BinarySearchST<String, ArrayList<Integer>> ST = new BinarySearchST<>();

        Integer charCount = 1;
        while (scan.hasNext()) {
            String line = scan.nextLine().toLowerCase();
            String word = "";
            Integer start = 0;
            Integer i = 0;
            while(i < line.length()) {
                if(line.charAt(i) != ' '){
                    if(word.isEmpty())
                        start = charCount;
                    word += line.charAt(i);
                }
                else {
                    if(!word.isEmpty()) {
                        insert(ST, word, start);
                        word = "";
                    }
                }
                charCount++;
                i++;
            }
            if(!word.isEmpty())
                insert(ST, word, start);
        }

        System.out.println(charCount);

        System.out.println("The word " + searchKey + " can be found at char indexes:\n" + ST.get(searchKey).toString());
    }
}
