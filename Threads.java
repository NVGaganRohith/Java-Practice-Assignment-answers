import java.io.*;

class A extends Thread{
    int[] arr=new int[20];
    Thread t;
    int sum;
    A(int[] a,String n){
        arr=a;
        t=new Thread(this);
        t.setName(n);
    }
    public void run(){
        if(t.getName().toLowerCase().equals("sum")){
            for(int i=0;i<arr.length;i++){
                sum+=arr[i];
            }
            System.out.println("Sum of elements: "+sum);
        }
        else if(t.getName().toLowerCase().equals("even")){
            int count=0;
            for(int i=0;i<arr.length;i++){
                if(arr[i]%2==0){
                    count++;
                }
            }
            System.out.println("No.of even numbers is: "+count);
        }
        else if(t.getName().toLowerCase().equals("max")){
            int max=arr[0];
            for(int i=0;i<arr.length;i++){
                if(max<arr[i]){
                    max=arr[i+1];
                }
            }
            System.out.println("Max element is: "+ max);
        }
        else{
            System.out.println("Invalid logic");
        }
    }
}

public class Threads {
    public static void main(String[] args)throws IOException{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Enter lengtth of array: ");
        int num=Integer.parseInt(br.readLine());

        int[] arr=new int[num];
        for(int i=0;i<num;i++){
            System.out.println("Enter "+i+" element of array: ");
            arr[i]=Integer.parseInt(br.readLine());
        }

        System.out.println("Enter name of thread 1: ");
        String name=br.readLine().trim();
        A a=new A(arr,name);
        System.out.println("Enter name of thread 2: ");
        String name2=br.readLine().trim();
        A b=new A(arr,name2);
        System.out.println("Enter name of thread 3: ");
        String name3=br.readLine().trim();
        A c=new A(arr,name3);
        a.start();
        try{  
            a.join();  
           }
        catch(Exception e){
            System.out.println(e);
            }
        b.start();
        try{  
            b.join();  
           }
        catch(Exception e){
            System.out.println(e);
            }
        c.start();
        try{  
            c.join();  
           }
        catch(Exception e){
            System.out.println(e);
            }
    }
}
