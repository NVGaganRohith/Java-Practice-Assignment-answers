import java.io.*;
class Complex{
    int r,im;
    Complex(int rp, int imp){
        r=rp;
        im=imp;
    }

    void add(Complex a, Complex b){
        int r1=a.r;
        int im1=a.im;
        int r2=b.r;
        int im2=b.im;
        r=r1+r2;
        im=im1+im2;
        Complex n= new Complex(r,im);
        display(n);
    }

    void subract(Complex a, Complex b){
        int r1=a.r;
        int im1=a.im;
        int r2=b.r;
        int im2=b.im;
        r=(r1-r2);
        im=(im1-im2);
        Complex n= new Complex(r,im);
        display(n);
    }

    void multiply(Complex a, Complex b){
        int r1=a.r;
        int im1=a.im;
        int r2=b.r;
        int im2=b.im;
        r=(r1*r2)-(im1*im2);
        im=(r2*im1)+(r1*im2);
        Complex n= new Complex(r,im);
        display(n);
    }

    void display(){
        if (im>0){
            System.out.print(r+"+"+im+"i\n");
        }
        else{
            System.out.print(r+""+im+"i\n");
        }
    }
    void display(Complex c){
        if (im>0){
            System.out.print(r+"+"+im+"i\n");
        }
        else{
            System.out.print(r+""+im+"i\n");
        }
    }
}

    class da1q4{
    public static void main(String[] args)throws IOException{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter coeffcients of first complex number: ");
        int r=Integer.parseInt(br.readLine());
        int im=Integer.parseInt(br.readLine());
        Complex c1=new Complex(r,im);
        System.out.println("Enter coeffcients of second complex number: ");
        int r1=Integer.parseInt(br.readLine());
        int im1=Integer.parseInt(br.readLine());
        Complex c2=new Complex(r1,im1);
        System.out.println("Complex Number 1 is: ");
        c1.display();
        System.out.println("Complex Number 2 is: ");
        c2.display();
        c1.add(c1,c2);
    }
}