import java.sql.*;
import java.util.*;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;  
import javafx.stage.Stage;

public class App extends Application{

    DetailsDAO d=new DetailsDAO();
    @Override
    public void start(Stage s){
        Label l1=new Label("ID");
        TextField t1=new TextField();
        Label l2=new Label("Last Name");
        TextField t2=new TextField();
        Label l3=new Label("First Name");
        TextField t3=new TextField();
        Label l4=new Label("mi");
        TextField t4=new TextField();
        Label l5=new Label("Address");
        TextField t5=new TextField();
        Label l6=new Label("City");
        TextField t6=new TextField();
        Label l7=new Label("State");
        TextField t7=new TextField();
        Label l8=new Label("Telephone");
        TextField t8=new TextField();
        
        Button b1=new Button("View");
        Button b2=new Button("Insert");
        Button b3=new Button("Update");
        Button b4=new Button("Delete");

        GridPane g=new GridPane();
        g.setAlignment(Pos.CENTER);

        g.add(l1,1,1);
        g.add(t1,2,1);

        g.add(l2,1,2);
        g.add(t2,2,2);

        g.add(l3,3,2);
        g.add(t3,4,2);

        g.add(l4,5,2);
        g.add(t4,6,2);

        g.add(l5,1,3);
        g.add(t5,2,3);

        g.add(l6,1,4);
        g.add(t6,2,4);

        g.add(l7,3,4);
        g.add(t7,4,4);

        g.add(l8,1,5);
        g.add(t8,2,5);

        g.add(b1,2,6);
        g.add(b2,3,6);
        g.add(b3,4,6);
        g.add(b4,5,6);

        b1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String id=t1.getText();
                List<Details> details = d.getDetails("select * from details where id =" + "\""+ id +"\"");
                details.forEach(e -> System.out.println(e));
            }
        });

        b2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event){
                int id=Integer.parseInt(t1.getText().trim());
                String lastName=t2.getText();
                String firstName=t3.getText();
                String mi=t4.getText();
                String address=t5.getText();
                String city=t6.getText();
                String state=t7.getText();
                int telephone=Integer.parseInt(t8.getText().trim());
                d.setDetails(id,lastName,firstName,mi,address,city,state,telephone);;
                List<Details> details=d.getDetails("select * from details");
                details.forEach(e -> System.out.println(e));
            }
        });

        b3.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event){
                int id=Integer.parseInt(t1.getText().trim());
                String lastName=t2.getText();
                String firstName=t3.getText();
                String mi=t4.getText();
                String address=t5.getText();
                String city=t6.getText();
                String state=t7.getText();
                int telephone=Integer.parseInt(t8.getText().trim());
                d.updateDetails(id,lastName,firstName,mi,address,city,state,telephone);
                List<Details> details=d.getDetails("select * from details");
                details.forEach(e -> System.out.println(e));
            }
        });

        b4.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String id=t1.getText();
                d.delDetails("DELETE FROM details where id = " + id);
                List<Details> details=d.getDetails("select * from details");
                details.forEach(e -> System.out.println(e));
            }
        });

        Scene s2=new Scene(g);
        s.setScene(s2);
        s.show();
        }
    public static void main(String[] args) throws Exception {
        launch(args);
    }
}

class Details{
    int id;
    String lastName;
    String firstName;
    String mi;
    String Address;
    String city;
    String state;
    int telephone;

    public Details(int id, String lastName, String firstName, String mi, String Address, String city, String state, int telephone){
        this.id=id;
        this.lastName=lastName;
        this.firstName=firstName;
        this.mi=mi;
        this.Address=Address;
        this.city=city;
        this.state=state;
        this.telephone= telephone;
    }

    public String toString(){
        return String.format("ID : %s | Last Name : %s | First Name : %s | MI : %s | Address : %s | City : %s | State : %s | Telephone : %s\n", id,lastName,firstName,mi,Address,city,state,telephone);
    }

    public int getID() {
        return this.id;
    }

    public void setID(int id) {
        this.id = id;
    }

    public int getTelephone() {
        return this.telephone;
    }

    public void setTelephone(int Telephone) {
        this.telephone = Telephone;
    }

    public String getLN() {
        return this.lastName;
    }

    public void setLN(String lastName) {
        this.lastName = lastName;
    }

    public String getFN() {
        return this.firstName;
    }

    public void setFN(String firstName) {
        this.firstName = firstName;
    }

    public String getMI() {
        return this.mi;
    }

    public void setMI(String mi) {
        this.mi = mi;
    }

    public String getAddress() {
        return this.Address;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

    public String getCity() {
        return this.city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return this.state;
    }

    public void setState(String state) {
        this.state = state;
    }
}

class DetailsDAO{
    public List<Details> getDetails(String query){
        List<Details> details = new ArrayList<Details>();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            // System.out.println("select * from details where " +  id + "=" +  value);
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Details", "root", "Gagan@2002");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            
            while (rs.next()){
                details.add(
                    new Details(rs.getInt("id"), rs.getString("lastName"), rs.getString("firstName"), rs.getString("mi"), rs.getString("Address"), rs.getString("city"), rs.getString("state"), rs.getInt("telephone"))
                );
            }
        }catch(Exception e){
            System.out.print(e);
        }
        return details;
    }
    public void setDetails(int id,String lastname,String firstname,String mi,String address,String city,String state,int telephone){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Details", "root", "Gagan@2002");
            Statement st = con.createStatement();
            st.executeUpdate("insert into details value("+id+",\""+lastname+"\",\""+firstname+"\",\""+mi+"\",\""+address+"\",\""+city+"\",\""+state+"\","+telephone+")");
        }catch(Exception e){
            System.out.print(e);
        }

    }

    public void delDetails(String query){

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Details", "root", "Gagan@2002");
            Statement st = con.createStatement();
            st.executeUpdate(query);
        }catch(Exception e){
            System.out.print(e);
        }

    }

    public List<Details> updateDetails(int id,String lastname,String firstname,String mi,String address,String city,String state,int telephone){
        List<Details> details = new ArrayList<Details>();
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Details","root","Gagan@2002");
            Statement st=con.createStatement();
            ResultSet rs=st.executeQuery("Select * from details where id ="+id);
            if(rs.next()==true){
            st.executeUpdate("update details set lastName=\""+lastname+"\", firstName=\""+firstname+"\",mi=\""+mi+"\",address=\""+address+"\",city=\""+city+"\",state=\""+state+"\",telephone="+telephone+" where id="+id);
            }
            else{
                do{
                st.executeUpdate("insert into details value("+id+",\""+lastname+"\",\""+firstname+"\",\""+mi+"\",\""+address+"\",\""+city+"\",\""+state+"\","+telephone+")");
                }while(rs.next());
            }

        }catch(Exception e){
            System.out.print(e);
        }
        
        return details;
    }
}
