import java.io.*;

class Employee{
    private String name;
    private String id;
    private float salary;
    void setall(String pname, String pid,float psalary){
        name=pname;
        id=pid;
        salary=psalary;
    }
    String getname(){
        return name;
    }
    String getid(){
        return id;
    }
    float salary(){
        return salary;
    }
    float getnetpay(float allowance,float deductions){
        float netpay= salary+allowance-deductions;
        return netpay;
    }
}

class Driver{
    public static void main(String[] args)throws IOException{
        Employee[] e=new Employee[10];
        int length=e.length;
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        for(int i=0;i<length;i++){
            System.out.println("Enter the details of Employee "+i+" in order Name, Id, Salary");
            e[i]=new Employee();
            String name=br.readLine();
            String id=br.readLine();
            float salary=Float.parseFloat(br.readLine());
            e[i].setall(name,id,salary);
    }
    for(int i=0;i<e.length;i++){
        System.out.println(e[i].getnetpay(5000f,3200f));
    }
}
}