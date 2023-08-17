import java.io.File;
import java.io.FileOutputStream;
import java.io.FileInputStream;

public class Da3q1{
    public static void main(String[] args)throws Exception{
        File f=new File("Copied File.txt");
        String s="";
        int c;
            if(f.exists()){
                System.out.println("File already exists");
            }
            else{
                f.createNewFile();
                System.out.println("File created");
                FileInputStream fis =new FileInputStream("Da3q1 text.txt");
                while((c=fis.read())!=-1){
                    s=s+((char) c);
                }
                FileOutputStream fos = new FileOutputStream("Copied File.txt");
                fos.write(s.getBytes());
                fos.close();
                fis.close();
            }
    }
}