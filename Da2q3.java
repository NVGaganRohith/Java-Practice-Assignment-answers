import java.io.*;

class Stock{
    String symbol;
    String name;
    double previousClosingPrice;
    double currentPrice;
    Stock(String s,String n){
        symbol=s;
        name=n;
    }
    double getChangePercent(){
        return ((previousClosingPrice - currentPrice)/previousClosingPrice)*100;
    }

}

public class Da2q3 {
    public static void main(String[] args)throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter Symbol for Stock: ");
        String ss=br.readLine();
        System.out.print("Enter name for Stock: ");
        String n =br.readLine();
        Stock t = new Stock(ss,n);
        t.previousClosingPrice=4.5;
        t.currentPrice=4.35;
        System.out.println("Change percentage for "+ t.name +" is: "+ t.getChangePercent());
    }
}