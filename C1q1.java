import java.io.*;


class IntimationThread extends Thread
{
    Thread t;
    Products[] listProducts;
    IntimationThread(Products[] product){
        listProducts=product;
        t=new Thread(this);
        t.start();
    }
    public void run(){
        System.out.println("Thread Running");
        while(true){
            for(int i=0;i<listProducts.length;i++){
                //System.out.println("Intimation Check....");
                if(listProducts[i].quantity<=listProducts[i].min){
                    listProducts[i].intimationCount++;
                    System.out.println("Increment count");
                }
                try{
                    Thread.sleep(10000);
                }
                catch(Exception e){}
            }
        }
    }
}

class Products{
    int id;
    String name;
    double price;
    int quantity;
    int min;
    int intimationCount;

    Products(int i,String n,double p,int q,int m){
        id=i;
        name=n;
        price=p;
        quantity=q;
        min=m;
        intimationCount=0;
    }

    boolean isavailable(){
        if(this.quantity>0) return true;
        else return false;
    }

    double sale(int sq){
        if(this.isavailable() && this.quantity>=sq){
            this.quantity--;
        }
        else System.out.print("Sorry out of stock");
    
        return this.price*sq;
    }
}

class C1q1{
    public static void main(String[] args)throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        System.out.print("Enter no.of products: ");
        int num=Integer.parseInt(br.readLine());

        Products[] l=new Products[num];

        for(int i=0;i<num;i++){
            System.out.println("Enter name of product, price, inital stock, min stock in the same order, each in a new line: ");
            
            String n=br.readLine();
            double p=Double.parseDouble(br.readLine());
            int q=Integer.parseInt(br.readLine());
            int m=Integer.parseInt(br.readLine());
            
            l[i]=new Products(i,n, p, q, m);
        }

        IntimationThread iThread = new IntimationThread(l);
        
        boolean flag=true;

        int[][] order=new int[num][num];

        int j=0;

        while(flag==true && j<num){

            System.out.println("Enter products id of product you need to buy: ");
            int sid=Integer.parseInt(br.readLine());

            System.out.println("Enter quantity: ");
            int sq=Integer.parseInt(br.readLine());

            System.out.println("Do you need more products (Y/N): ");
            String inp=br.readLine().toLowerCase();
            
            order[j][0]=sid;
            order[j][1]=sq;
            j++;

            if(inp.equals("y")|| inp.equals("yes")){
                continue;
            }
            else if(inp.equals("n")|| inp.equals("No")){
                flag=false;
            }
            else{
                System.out.println("Invalid input");
                continue;
            }
            }

            int len=order.length;
            double sum=0;
            int c=0;

            for(int i=0;i<len;i++){
                // if(order[i][0]==null || order[i][1]==null ){
                //     break;
                // }
                sum+=l[order[i][0]].sale(order[i][1]);
                c++;
                if (len==c) break;
            }
            System.out.println("your bill is: "+(sum));

            iThread.stop();

            for(Products pro:l){            
                System.out.println("Intimation Count for Product["+pro.id+"]:--> "+pro.intimationCount);               
            }
    }
}