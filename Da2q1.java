import java.io.*;

class da2q1{
	public static int reverse(int number){
		int temp=0;
		int reversed=0;
		while(number>0){
			temp=number%10;
			reversed=10*reversed + temp;
			number=number/10;
		}
		return reversed;
	}
	public static boolean isPalindrome(int number){
		if(number==reverse(number)){
			return true;
		}
		else{
			return false;
		}
	}
	public static void main(String[] args)throws IOException{
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		System.out.print("Enter the number you want to check weather it's a palindrome or not: ");
		int num=Integer.parseInt(br.readLine());
		System.out.println("\n"+"The Number entered is: "+num+"\n");
		System.out.println("Reversed Number is: "+reverse(num)+"\n");
		System.out.println("The statement that given number "+num+" is a palindrome is: "+isPalindrome(num));
	}
}
