import java.io.*;
class da1q9{
        String reverse(String str){
        String s="";
        int length=str.length();
        for(int i=length - 1;i>=0;i--){
            s=s+str.charAt(i);
        }
        return s;
    }
    String add(String str,String a){
        return a+str+a+" ";
    }
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str =br.readLine();
        da1q9 d=new da1q9();
        String str1= d.reverse(str);
        String[] str2=str1.split(" ");
        String str3="";
        int length=str2.length;
        for(int i=0;i<length;i++){
            str3= d.add(str2[i],"a") + str3;
        }
        System.out.println(str3);
    }
}