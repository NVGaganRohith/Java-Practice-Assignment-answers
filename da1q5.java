import java.io.*;
import java.util.HashMap;

public class da1q5 {
    public static void main(String[] args)throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Enter the no.of Strings: ");

        int max=Integer.parseInt(br.readLine());

        String s = "";

        for(int i=0;i<max;i++){
            s=s+" "+br.readLine();
        }

        s = s.toLowerCase();

        String[] words = s.split("\\s+");

        HashMap<String, Integer> counter = new HashMap<>();

        for (String word : words){

            counter.put(word, counter.getOrDefault(word, 0) + 1);
        }

        System.out.println(String.format("%20s   %-5s", "word", "count"));

        counter.forEach((key, count) -> {
            System.out.println(String.format("%20s : %-5d", key, count));
        });
    }
}