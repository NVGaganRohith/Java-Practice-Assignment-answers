import java.io.*;
interface Shapes{
public void area();
public void display();
}

abstract class Mshapes implements Shapes{
float area;
float l1;
float l2;

public void area(){}

public void display(){
System.out.println("Area of figure is: "+area);
}

}

class Rect extends Mshapes{

Rect(float length,float breadth){
l1=length;
l2=breadth;
}

public void area(){
	area=l1*l2;
}

public void display(){
System.out.println("Length of rectangle is: "+l1+"\nBreadth of rectangle is: "+l2);
super.display();
}

}

class Square extends Mshapes{

Square (float side){
l1=side;
l2=side;
}

public void area(){
	area=l1*l2;
}

public void display(){
System.out.println("Side of Square is: "+l1);
super.display();
}

}
class Triangle extends Mshapes{

Triangle(float height,float base){
l1=height;
l2=base;
}

public void area(){
	area=(0.5f)*l1*l2;
}

public void display(){
System.out.println("Height of Triangle is: "+l1+"\nBase of Triangle is: "+l2);
super.display();
}

}
class Circle extends Mshapes{

Circle(float radius){
l1=radius;
l2=radius;
}

public void area(){
	area=(3.14f)*l1*l2;
}

public void display(){
System.out.println("Radius of circle is: "+l1);
super.display();
}

}

class Shapesnew{
public static void main(String args[])throws IOException{
	BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
	System.out.println("Enter first measurement of shape: ");
	float l1=Float.parseFloat(br.readLine());
	System.out.println("Enter second measurement of shape: ");
	float l2=Float.parseFloat(br.readLine());
	Rect r = new Rect(l1,l2);
	Square s=new Square(l1);
	Triangle t=new Triangle(l1,l2);
	Circle c=new Circle(l1);
	Shapes m=r;
	m.area();
	m.display();
	m=s;
	m.area();
	m.display();
	m=t;
	m.area();
	m.display();
	m=c;
	m.area();
	m.display();
	
}
}
