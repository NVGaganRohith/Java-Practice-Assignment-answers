import java.io.*;

class Number{
    int num,res;
    Number(int v1){
    num=v1;
    }
    int reverse(int pnum){
    int temp,rem;
    temp = pnum;
    while(temp>0){
    rem=temp%10;
    res=(10*res)+rem;
    temp=temp/10;
    }
    System.out.println("The Reverse of Given Number is: "+res);
    return res;
    }
    void checkp(int num1){
    int temp,m,i;
    int flag=0;
    m=num1/2;
    for(i=2;i<m;i++){
    temp= num1%i;
    if(temp==0){
    flag=1;
    break;
    }
    }
    if(flag==1){
    System.out.println("The reverse of given number "+num+" is not prime");
    }
    else if(flag==0){
    System.out.println("The reverse of Given number "+num+" is prime");
    }
    }
    }
    
class da1q1{
    public static void main(String args[]) throws IOException{
    BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
    int num=Integer.parseInt(br.readLine());
    Number n= new Number(num);
    int rnum=n.reverse(num);
    n.checkp(rnum);
    }
}