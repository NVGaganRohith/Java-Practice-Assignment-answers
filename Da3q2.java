import java.util.Random;
import java.io.BufferedReader;
import java.io.InputStreamReader;

class E extends Exception{
    public String toString(){
        return "Out of Bounds";
    }
}
public class Da3q2 {
    public static void main(String[] args)throws Exception{
        Random r= new Random();
        int[] arr=new int[100];
        for(int i=0;i<100;i++){
            arr[i]=r.nextInt();
        }
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter index of array element: ");
        int index=Integer.parseInt(br.readLine());
        try{
            if(index>100) throw new E();
            System.out.println(arr[index]);
        }
        catch(E e){
            System.out.println(e);
        }
    }
}
