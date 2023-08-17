import java.util.*;

public class Collectionsdemo {
    public static void main(String[] args){
        List<Integer> lint=new ArrayList<Integer>();
        lint.add(5);
        Iterator<Integer> it=lint.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }
    }
}
