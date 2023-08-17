import java.sql.*;
import java.util.*;

class Book {
    private String title;
    private String author;
    private String pubYear;
    private String descr;

    @Override
    public String toString(){
        return String.format("Title : %-20s | Author : %-20s | Publication Year : %-20s | descrription : %-40s", title, author, pubYear, descr);
    }

    
    public Book(String title, String author, String pubYear, String descr) {
        this.title = title;
        this.author = author;
        this.pubYear = pubYear;
        this.descr = descr;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return this.author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPubYear() {
        return this.pubYear;
    }

    public void setPubYear(String pubYear) {
        this.pubYear = pubYear;
    }

    public String getDescr() {
        return this.descr;
    }

    public void setDescr(String descr) {
        this.descr = descr;
    }
}


public class BookDAO {
    public List<Book> getBooks(String name, String value) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("select * from book where " +  name + "=" +  value);
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Book", "root", "Gagan@2002");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from book where " +  name + "=" + "\""+ value+"\"");
            

            List<Book> books = new ArrayList<>();
            while (rs.next()){
                books.add(
                    new Book(rs.getString("title"), rs.getString("author"), rs.getString("pubYear"), rs.getString("descr"))
                );
            }
            return books;
        } catch (Exception e) {
            System.out.println(e);
        }

        return null;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BookDAO dao = new BookDAO();
        List<Book> books;
        System.out.print("Enter the column you want to seach by: ");
        switch(sc.next()){
            case "author":
            System.out.print("Enter the term in the column you need to filter with using where clause: ");
            books = dao.getBooks("author", sc.next());
            books.forEach(e -> System.out.println(e));
            break;
            case "title":
            System.out.print("Enter the term in the column you need to filter with using where clause: ");
            books = dao.getBooks("title", sc.next());
            books.forEach(e -> System.out.println(e));
            break;
            case "pubYear":
            System.out.print("Enter the term in the column you need to filter with using where clause: ");
            books = dao.getBooks("pubYear", sc.next());
            books.forEach(e -> System.out.println(e));
            break;
            default:
            System.exit(0);

        }
        sc.close();
    }
}
