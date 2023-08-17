import java.io.*;
import java.util.Calendar;

class Account{
    private int id=0;
    private double balance=0;
    private double annualInterestRate=0;
    Calendar dateCreated= Calendar.getInstance();
    
    Account(){
    }

    public void setid(int i){
        id=i;
    }

    public void setbalance(double i){
        balance=i;
    }

    public void setannualIntrestRate(double i){
        annualInterestRate=i;
    }

    public void setdate(int year,int month,int date){
        dateCreated.set(Calendar.YEAR,year);
        dateCreated.set(Calendar.MONTH,month);
        dateCreated.set(Calendar.DATE,date);
    }
    

    public int getid(){
        return id;
    }

    public double getbalance(){
        return balance;
    }

    public double getannualIntrestRate(){
        return annualInterestRate;
    }

    public double getMonthlyInterestRate(){
        return annualInterestRate/12;
    }

    public double withdraw(double amt){
        double temp=balance;
        if(balance-amt> 0) return balance-=amt;
        else {
            balance=temp;
            System.out.print("Insufficient balance");
            return balance;
        }

    }

    public double deposits(double amt){
        return balance+=amt;
        
    }

    public String getdateCreated(){
        String s= "Date in dd-mm-yy format "+ dateCreated.get(Calendar.YEAR) + "-" +dateCreated.get(Calendar.MONTH) + "-" +dateCreated.get(Calendar.DATE);
        return s;
    }

}

public class Da2q4{
    public static void main(String[] args)throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        System.out.print("Enter the Account id: ");
        int id=Integer.parseInt(br.readLine());

        System.out.print("Enter the Account balance: ");
        double balance=Double.parseDouble(br.readLine());

        System.out.print("Enter the Account Annual Interest Rate: ");
        double annualInterestRate=Double.parseDouble(br.readLine());

        System.out.print("Enter the Amount to withdraw: ");
        double withdraw=Double.parseDouble(br.readLine());

        System.out.print("Enter the Amount to deposit: ");
        double deposit=Double.parseDouble(br.readLine());

        Account a=new Account();

        a.setid(id);
        a.setbalance(balance);
        a.setannualIntrestRate(annualInterestRate);

        System.out.print("Enter Date of account creation in dd-mm-yy format: ");
        String[] date=br.readLine().split("-");
        a.setdate(Integer.parseInt(date[0]), Integer.parseInt(date[1]), Integer.parseInt(date[2]));

        System.out.println("Balance after withdrawal is: "+a.withdraw(withdraw));
        System.out.println("Balance after deposit is: "+a.deposits(deposit));
        System.out.println("Balance is: "+a.getbalance());
        System.out.println("Monthly interest rate is: "+a.getMonthlyInterestRate());
        System.out.println("Date of Creation of Account is: "+a.getdateCreated());
    }
    
}
