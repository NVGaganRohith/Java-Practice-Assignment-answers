class da1q7  
{  
private static int count; 
String name = "Sam";  
public da1q7(String n)   
{  
count++;
name=n;
}
void display(){
    System.out.println(name);
}
public static void main(String args[])   
{ 
da1q7 a = new da1q7("gagan");
da1q7 b = new da1q7("code");
da1q7 c = new da1q7("java");
da1q7 d = new da1q7("new");
da1q7 e = new da1q7("one");
a.display();
b.display();
c.display();
d.display();
e.display();

System.out.print("Number of objects created: " + da1q7.count);  
}  
}  