import java.io.BufferedReader;
import java.io.InputStreamReader;

class Operations extends Thread{
    double x,result;
    String sname;
    Thread t;
    Operations(double x,String s){
        this.x=Math.toRadians(x);
        System.out.println("this.x="+x);
        sname=s;
        t=new Thread(this);
        t.setName(s);
        t.start();
    }
    public double computesin(){
        double ans=Math.sin(x);
        return ans;
    }
    public double computecos(){
        double ans=Math.cos(x);
        return ans;
    }
    public double computetan(){
        double ans=Math.sin(x);
        return ans;
    }
    public void run(){
        if(t.getName().equals("sin")) result=computesin();
        if(t.getName().equals("cos")) result=computecos();
        if(t.getName().equals("tan")) result=computetan();
    }

}

public class Da3q4 {
    public static void main(String[] args)throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        System.out.print("Enter radian input for sin: ");
        double x=Double.parseDouble(br.readLine());

        System.out.print("Enter radian input for cos: ");
        double y=Double.parseDouble(br.readLine());

        System.out.print("Enter radian input for tan: ");
        double z=Double.parseDouble(br.readLine());
        System.out.println();

        Operations o1=new Operations(x,"sin");
        Operations o2=new Operations(y,"cos");
        Operations o3=new Operations(z,"tan");

        o1.t.join();
        o2.t.join();
        o3.t.join();

        System.out.print("Result of sin(x)+cos(y)+tan(z): "+(o1.result+o2.result+o3.result));

    }
}