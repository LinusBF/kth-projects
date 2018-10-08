package lab3;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;

/**
 * Created by Linus Bein Fahlander on 2018-09-26.
 */
public class Task1 {
    BufferedReader br;
    public Task1() throws FileNotFoundException {
        URL url = Task1.class.getResource("filtered_text.txt");
        this.br = new BufferedReader(new FileReader(url.getPath()));
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
            Task1 f = new Task1();
            System.out.println(f.getText());
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
