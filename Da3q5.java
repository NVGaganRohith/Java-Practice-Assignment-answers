import java.io.BufferedReader;
import java.io.InputStreamReader;

class BoundedBuffer extends Thread{
    int lengtharr=0;
    int[] arr=new int[lengtharr];
    boolean test=false;
    // Thread t1,t2;
    int length=arr.length,count=0;
    BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

    BoundedBuffer(int l, int[] a){
        lengtharr=l;
        arr=a;
        // t1=new Thread(this);
        // t1.setName("put");
        // t2=new Thread(this);
        // t2.setName("get");
    }
    
    public synchronized void put(BoundedBuffer b){
        // while(test){
        //     try{
        //         wait();
        //     }
        //     catch(Exception e){}
        // }
        for(int i=0;i<length;i++){
            System.out.println("Put: "+b.arr[i]);
            count++;
        }
        if(count==length){
            test=true;
            notifyAll();
            b.get(b);
        }
    }

    public synchronized void get(BoundedBuffer b){
        while(!test){
            try{
                wait();
            }
            catch(Exception e){}
        }
        for(int i=0;i<length;i++){
            System.out.println("Got: "+b.arr[i]);
            b.arr[i]=0;
            count--;
        }
        if(count==0){
            test=false;
            notifyAll();
            b.put(b);
        }
        
    }
    // public void run(){
    //         // while(true){
    //             if(Thread.currentThread().getName()=="put"){
    //                 this.put(this);
    //             }
    //             if(Thread.currentThread().getName()=="get"){
    //                 this.get(this);
    //             }
    //         // }
    // }

}

public class Da3q5 extends Thread {
    public static void main(String [] args) throws Exception{

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        

        System.out.print("Enter length: ");
        int length=Integer.parseInt(br.readLine());
        int[] arr=new int[length];
        
        System.out.println("Enter "+length+" numbers to put into the buffer \nGive \"STOP\" as input to stop the program");
        for(int i=0;i<length;i++){
            String inp=br.readLine();
            if(inp.toUpperCase().equals("STOP")) System.exit(9);
            arr[i]=Integer.parseInt(inp);
        }

        BoundedBuffer obj=new BoundedBuffer(length,arr);
        // obj.t1.start();

        // obj.t2.start();
        Thread t1= new Thread() { 
            public void run() {
                obj.put(obj);
            }
        };
        t1.start();
        t1.join();
        Thread t2=new Thread() { 
            public void run() {
                obj.get(obj);
            }
        };
        t2.start();
        t2.join();


    }
}
