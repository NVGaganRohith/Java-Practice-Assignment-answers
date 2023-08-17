import java.io.*;

class Queue{
    int n;
    boolean test=false;
    public synchronized void put(int p){
        while(test){
            try{
                wait();
            }
            catch(InterruptedException e){}
        }
        while(!test){
            n=p;
            System.out.println("Put = " + p);
            test=true;
            notify();
            p++;
        }
    }
    
    public synchronized int get(){
        while(!test){
            try{
                wait();
            }
            catch(InterruptedException e){}
        }
        
        System.out.println("Got: "+n);
        test =false;
        notify();
        return n;
    }
}
class Synchronization{
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num=Integer.parseInt(br.readLine());
        Queue q=new Queue();
        q.put(num);
        q.get();
    }
}