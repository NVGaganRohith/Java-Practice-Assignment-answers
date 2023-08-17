import java.io.*;
class MyException extends Exception{
    String msg;
    MyException(String p){
        this.msg=p;
    }
    public String toString(){
        return "Exception occured: "+msg;
    }
}
class Mainexception{
    public static void main(String[] args)throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String Number;
        try{
            Number=br.readLine();
            if(Number.length()>10){
                throw new MyException("length greater than 10");
            }
            if(Number.length()<10){
                throw new MyException("length greater less than 10");
            }
            char[] c=Number.toCharArray();
            for(int i=0;i<10;i++){
                if(!Character.isDigit(c[i])){
                    throw new MyException("Has Characters other than numbers");
                }
            }
        }
        catch(MyException e){
            System.out.println(e);
        }
    }
}