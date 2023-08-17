import java.io.*;

abstract class Employee {
    float week_salary;
    float hours;
    float salespercent;
    float extra;
    abstract float netpay(float bonus);
    void display(){
        System.out.println(week_salary);
    }
}

class S_employee extends Employee{
    S_employee(float psalary){
        week_salary=psalary;
        extra=0;
    }
    float netpay(float bonus){
        extra=bonus;
        return week_salary+extra;
    }
}

class H_employee extends Employee{
    H_employee(float hours, float wage_hour){
        week_salary=0;
        extra=(hours*wage_hour);
    }
    float netpay(float overtime){  
        return week_salary+extra+overtime;
    }
}

class C_employee extends Employee{
    C_employee(float sales, float commision){
        week_salary=0;
        extra=sales*commision;
    }
    float netpay(float bonus){
        return week_salary+extra+bonus;
    }
}

class SC_employee extends Employee{
    SC_employee(float sales, float commision,float psalary){
        week_salary=psalary;
        extra=sales*commision;
    }
    float netpay(float bonus){
        return week_salary+extra+bonus;
    }
}

class da1q6{
    public static void main(String[] args)throws IOException{

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        
        System.out.println("Enter Bonus for Salaried-Commisioned Employees: ");
        float bonus=Float.parseFloat(br.readLine());

        System.out.println("Enter Base salary for Employees: ");
        float salary=Float.parseFloat(br.readLine());

        System.out.println("Enter sales done by Employees: ");
        float sales=Float.parseFloat(br.readLine());

        System.out.println("Enter commision for Employees: ");
        float commision=Float.parseFloat(br.readLine());

        System.out.println("Enter Hours worked by Employees: ");
        float hours=Float.parseFloat(br.readLine());

        System.out.println("Enter Wage per hour of Employees: ");
        float wagephr=Float.parseFloat(br.readLine());

        S_employee s=new S_employee(salary);
        H_employee h=new H_employee(hours,wagephr);
        C_employee c=new C_employee(sales,commision);
        SC_employee sc=new SC_employee(sales,commision,salary);

        float net_bonus=(bonus/100.0f)*salary;
        bonus=0f;
        
        Employee e=s;
        System.out.println("Salary of Salaried Employee is: " + e.netpay(bonus));
        
        e=h;
        System.out.println("Salary of Hourly wage Employee is: " + e.netpay(bonus));
        
        e=c;
        System.out.println("Salary of Commisioned Employee is: " + e.netpay(bonus));
        
        e=sc;
        System.out.println("Salary of Salaried-Commisioned Employee is: " + e.netpay(net_bonus));
    }
}