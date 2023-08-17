import java.io.BufferedReader;
import java.io.InputStreamReader;
class IllegalTriangelException extends Exception{
    public String toString(){
        return "Sides do not satisfy the rules of a Triangle\n";
    }
}

class Triangle{
    double side1;
    double side2;
    double side3;
    Triangle(double s1,double s2,double s3) throws IllegalTriangelException{
        try{
            if(s1+s2<=s3||s2+s3<=s1||s1+s3<=s2){
            throw new IllegalTriangelException();
            }
            side1=s1;
            side2=s2;
            side3=s3;
        }
        catch(IllegalTriangelException e){
            System.out.print(e);
            System.exit(9);
        }

    }
    public String toString(){
        return "\n"+"Triangle Sucessfully Created\n\n"+"Side 1 is: "+ side1+"\n"+ "Side 2 is: "+side2+"\n"+"Side 3 is: "+side3;
    }
}

public class Da3q3 {
    public static void main(String[] args)throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter Side 1 of Triangle: ");
        double s1=Double.parseDouble(br.readLine());
        System.out.print("Enter Side 2 of Triangle: ");
        double s2=Double.parseDouble(br.readLine());
        System.out.print("Enter Side 3 of Triangle: ");
        double s3=Double.parseDouble(br.readLine());
        Triangle t=new Triangle(s1,s2,s3);
        System.out.println(t);
    }
}
