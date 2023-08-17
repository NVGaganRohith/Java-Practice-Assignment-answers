import java.io.*;

class MyString1{
    char[] c;
    String str;
    int val;

    MyString1(){
        str="";
    }

    public MyString1(char[] chars){
        c=chars;
    }

    public char charAt(int index){
        return c[index];
    }

    public int length(){
        int count=0;
        for (int i=0; i<this.c.length; i++){
            count+=1;
        }
        return count;
    }

    public MyString1 substring(int begin, int end){
        MyString1 s=new MyString1(this.c);
        String a="";
        for (int i=begin;i<=end;i++){
            a+=s.charAt(i);
        }
        s.str=a;
        return s;
    }

    public MyString1 toLowerCase(){
        MyString1 s = new MyString1();
        for(int i=0; i<this.c.length;i++){
            if(this.c[i]>='A'&&this.c[i]<='Z'){
                c[i]+=32;
            }
            s.str+=c[i];
        }
        return s;
    }

    public boolean equals(MyString1 s){
        int i=0;
        boolean flag=true;
        if(s.length()==this.length()){
            while(flag==true && i<this.length()){
                if(s.charAt(i)==this.charAt(i)) i++;
                else flag=false;
            }
        }
        else{
            return false;
        }
        if(i==this.length()) return true;
        else return false;
    }

    public static MyString1 valueOf(int i) throws NumberFormatException{
        MyString1 s=new MyString1();
        //Printing the charecter with ASCII value of i
        // char c='A';
        // while(c!=i){
        //     c++;
        // }
        // s.str+=c;

        //changing integer input to string
        s.str+=i;
        return s;
    }

}

public class Da2q6 {
    public static void main(String[] args)throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        System.out.print("Enter a String: ");
        char[] ch=br.readLine().toCharArray();
        MyString1 s=new MyString1(ch);


        System.out.print("Enter a Index where you want to find a charecter: ");
        int index =Integer.parseInt(br.readLine());
        System.out.println("Char at index "+ index +" is: "+s.charAt(index));
        
        System.out.println("Length of String is: "+s.length());

        System.out.print("Enter Start Index of Substring you require: ");
        int start =Integer.parseInt(br.readLine());
        System.out.print("Enter End Index of Substring you require: ");
        int end =Integer.parseInt(br.readLine());
        MyString1 h=s.substring(start,end);
        System.out.println("SubString starting from "+ start+" and ends at "+end+" is: "+ h.str);
        
        MyString1 s2=s.toLowerCase();
        System.out.println("Given String in lower case is: "+s2.str);

        System.out.print("Enter a String with which you want to compare initially provided string: ");
        String p=br.readLine();
        char[] ch1=p.toCharArray();
        MyString1 s1=new MyString1(ch1);
        System.out.println("If string equals " + p +" : "+s.equals(s1));
        
        System.out.print("Enter a integer which you want to convert as an String: ");
        int stringint =Integer.parseInt(br.readLine());
        MyString1 s3=MyString1.valueOf(stringint);
        System.out.println("The integer entred is converted to string: "+s3.str+" is a " +s3.str.getClass().getSimpleName()+" the name was retrieved by getClass method.");

        // System.out.print("Enter the ASCII value of alphabet for which you need charecter represenation: ");
        // int asci =Integer.parseInt(br.readLine());
        // MyString1 s3=MyString1.valueOf(asci);
        // System.out.println("Chare with value 68 is: "+s3.str);

    }
}
