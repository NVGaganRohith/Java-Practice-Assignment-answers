import java.io.*;

class Files {
    public static void main(String[] args)throws IOException{

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String w=br.readLine();

        File f=new File("First.txt");

        try{
            if(f.exists()){
                System.out.println("File already exsists");
            }
            else{
                f.createNewFile();
                FileOutputStream fos=new FileOutputStream("First.txt");
                fos.write(w.getBytes());
                fos.close();
                FileInputStream fin=new FileInputStream("First.txt");
                byte[] a=new byte[1024];
                fin.read(a);
                fin.close();
                String r= new String(a);
                System.out.println(r);
            }
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        
        int count=0;

        try{
            int c;
            FileInputStream fin=new FileInputStream("First.txt");
            while((c=fin.read())!=-1){
                char c1 = (char) c;
                if (c1 == 'a'||c1 == 'e'||c1 == 'i'||c1 == 'o'||c1 == 'u'){
                    count++;
                }
                else{
                    continue;
                }
            }
            fin.close();
            System.out.println(count);
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}
