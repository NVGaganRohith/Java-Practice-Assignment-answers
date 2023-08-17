import java.io.*;
class Find{
    int length,indexreq=0;
        int index(int[] a,int num){
            length=a.length;
            for(int i=0;i<length;i++){
                if(a[i]==num) indexreq=i;
            }
            return indexreq;
        }
        int index(String[] a,String num){
            length=a.length;
            for(int i=0;i<length;i++){
                if(a[i].equals(num)) indexreq=i;
            }
            return indexreq;
        }
        int index(char[] a,char num){
            length=a.length;
            for(int i=0;i<length;i++){
                if(a[i]==num) indexreq=i;
            }
            return indexreq;
        }
}
class da1q3{
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter length of array and give length no.of inputs of integer, String, charecter in order: ");
        int length=Integer.parseInt(br.readLine());
        int[] a=new int[length];
        String[] b=new String[length];
        char[] c=new char[length];
        for(int i=0; i<length; i++){
            a[i]=Integer.parseInt(br.readLine());
        }
        for(int i=0; i<length; i++){
            b[i]=br.readLine();
        }
        c=br.readLine().toCharArray();
        System.out.println("Enter integer,String,char to find in order");
        int fint=Integer.parseInt(br.readLine());
        String fString=br.readLine();
        char fchar=(char)br.read();
        Find f=new Find();
        int index1=f.index(a,fint);
        int index2=f.index(b,fString);
        int index3=f.index(c,fchar);
        System.out.println("Index of integer is: " + index1);
        System.out.println("Index of String is: " + index2);
        System.out.println("Index of charecter is: " + index3);
    }
}
