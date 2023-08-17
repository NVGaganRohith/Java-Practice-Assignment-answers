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

public class Da3q51 extends Thread {
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter size of queue less than 100: ");
        int num=Integer.parseInt(br.readLine());
        Queue q=new Queue();

        System.out.print("Enter start to begin the producer consumer interaction: ");

        while(br.readLine().equalsIgnoreCase("start")){
            Thread t1= new Thread() { 
                public void run() {
                    try{
                    q.put(num);
                    }
                    catch(Exception e){
                        System.out.println(e.getMessage());
                    }
                }
            };
            t1.start();
            t1.join();

            Thread t2= new Thread() { 
                public void run() {
                    q.get(num);
                    System.out.print("Enter start again to continue the producer consumer interaction: ");
                }
            };
            t2.start();
            t2.join();
        }
    }
}
