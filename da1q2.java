import java.io.*;
class da1q2{
	public static void main(String[] args) throws IOException{
	
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("Enter the number strings: ");
		
		int length=Integer.parseInt(br.readLine());
		
		String[] s=new String[length];
		
		int[] num=new int[length];
		
		for(int i=0;i<length;i++){
			System.out.println("Enter String "+i+": ");
			s[i]=br.readLine();
			String temp =s[i];
			num[i]=temp.length();
		}
        int index=0;
        for ( int i = 1; i < num.length; i++ ){
            if ( num[i] > num[index] ) index = i;
        }
		System.out.println("Maximum length string is: " + s[index] +" With length of "+num[index] );
	}
}
