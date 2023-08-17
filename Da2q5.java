import java.io.*;

public class Da2q5 {
    public static void checkpassword(String p){
        int LC=0;
        if(p.length()>=8){
            for(int i=0; i<p.length(); i++){
                char c=p.charAt(i);
                if (Character.isAlphabetic(c)) continue;
                else if (Character.isDigit(c)) LC++;
                else {
                    System.out.println("Invalid Password because it contains charecters other than alphabets and numbers");
                    break;
                }
            }
            if (LC>=2) System.out.println("Valid password");
            else System.out.println("Invalid Password because it contains less than 2 digits");
        }
        else System.out.println("Invalid Password because its length is less than 8");
        
    }
    public static void main(String[] args)throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter Password to check if it is valid: ");
        String pasword=br.readLine();
        Da2q5.checkpassword(pasword);
}
}