import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Reader extends Person{
    private int member_ID;
    private String date_of_membership;
    private int no_books_issued = 0;
    private int max_book_limit = 5;
    private Set<Book> books = new HashSet<>();
    private double bill;
    public Reader(String name, String surname, String date_of_membership, int member_ID) {
        super(name, surname);
        this.date_of_membership = date_of_membership;
        this.member_ID = member_ID;


    }

    public int getNo_books_issued() {
        return no_books_issued;
    }

    public void setNo_books_issued(int no_books_issued) {
        this.no_books_issued = no_books_issued;
    }

    public void addBook(Book book){
        if(!books.contains(book)){
            books.add(book);
        }else{
            System.out.println("Contains");
        }
    }

    public void removeBook(Book book){
        if(books.contains(book)){
            books.remove(book);
        }else{
            System.out.println("Don't Contains");
        }
    }

    public Set<Book> getBooks() {
        return books;
    }


    public double getBill() {
        return bill;
    }

    public void setBill(double bill) {
        this.bill = bill;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Reader reader)) return false;
        return member_ID == reader.member_ID;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(member_ID);
    }
}
