import java.io.*;

class Queue{
    int[] arr=new int[100];
    boolean test=false;
    int count=0;
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public synchronized void put(int length)throws IOException{
        while(test){
            try{
                wait();
            }
            catch(InterruptedException e){}
        }
            for(int i=0;i<length;i++){
                System.out.print("Enter element to insert into queue: ");
                arr[i]=Integer.parseInt(br.readLine());
                System.out.println("Put = " + arr[i]+"\n");
                count++;
            }
            if(count==length) test=true;
            notify();
    }
    
    public synchronized void get(int length){
        while(!test){
            try{
                wait();
            }
            catch(InterruptedException e){}
        }
            for(int i=0;i<length;i++){
                System.out.println("Got = " + arr[i]);
                count--;
            }
            if(count==0) test=false;
            notify();
    }
}

public class Synchronization2 {
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter size of queue less than 100: ");
        int num=Integer.parseInt(br.readLine());
        Queue q=new Queue();
        q.put(num);
        q.get(num);
    }
}
