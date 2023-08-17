abstract class Shapes {
    float area;
    abstract void area();
    void display(){
        System.out.println("Area of the figure is: "+area+"\n");
    }
}

class Square extends Shapes{
    float side;
    Square(float pside){
        side=pside;
    }
    void area(){
        area=side*side;
    }
    void display(){
        System.out.println("Side of square is: "+side);
        super.display();
    }
}

class Rectangle extends Shapes{
    float length;
    float breadth;
    Rectangle(float l, float b){
        length=l;
        breadth=b;
    }
    void area(){
        area=length*breadth;
    }
    void display(){
        System.out.println("Length of Rectangle is: "+length+"\n"+"Breadth of rectangle is: "+breadth);
        super.display();
    }
}

class Triangle extends Shapes{
    float base;
    float height;
    Triangle(float b, float h){
        base=b;
        height=h;
    }
    void area(){
        area=(0.5f)*base*height;
    }
    void display(){
        System.out.println("Base of Triangle is: "+base+"\n"+"height of Triangle is: "+height);
        super.display();
    }
}

class Circle extends Shapes{
    float radius;
    Circle (float r){
        radius=r;
    }
    void area(){
        area=(3.14f)*radius*radius;
    }
    void display(){
        System.out.println("Radius of Circle is: "+radius);
        super.display();
    }
}

class da1q8{
    public static void main(String args[]){
        Square s=new Square(5);
        Rectangle r=new Rectangle(5,10);
        Triangle t=new Triangle(5,10);
        Circle c=new Circle(5);

        Shapes a=s;
        a.area();
        a.display();
        a=r;
        a.area();
        a.display();
        a=t;
        a.area();
        a.display();
        a=c;
        a.area();
        a.display();

    }
}