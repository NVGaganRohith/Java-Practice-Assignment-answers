import java.io.*;

class da2q2{
	public static double min(double[] array){
		int length=array.length;
		double min=array[0];
		for(int i=0;i<length;i++){
			if(min>array[i]){
				min=array[i];
			}
		}
		return min;
	}
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader( new InputStreamReader(System.in));
		
		double[] d=new double[10];
		
		System.out.println("Kindly Enter 10 numbers: ");
		for(int i=0;i<10;i++){
			System.out.print("Kindly Enter Number "+i+" :");
			d[i]=Double.parseDouble(br.readLine());
		}
		
		System.out.println("\n"+"minimum of numbers is: "+min(d));
	}
}
