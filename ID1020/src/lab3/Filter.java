package lab3;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by Linus Bein Fahlander on 2018-09-26.
 */
public class Filter {
    BufferedReader br;
    public Filter() throws FileNotFoundException {
        this.br = new BufferedReader(new FileReader("C:\\Projects\\kth-projects\\ID1020\\src\\lab3\\the_text.txt"));
    }

    public String getText() throws IOException {
        StringBuilder sb = new StringBuilder();
        String currentLine;
        while((currentLine = this.br.readLine()) != null){
            for(char c : currentLine.toCharArray()){
                if((c > 64 && c < 91) || (c > 96 && c < 123)) {
                    sb.append(c);
                } else {
                    sb.append(' ');
                }
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        try{
            Filter f = new Filter();
            System.out.println(f.getText());
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
