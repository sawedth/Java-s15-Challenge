import java.util.Date;
import java.util.Objects;

public class Book {
    private int book_ID;
    private Author author;
    private String title;
    private double price;
    private Status status;
    private int edition;
    private String date_of_purchase;
    private Person owner;

    public Book(int book_ID, Author author, String title, double price, int edition, String date_of_purchase) {
        this.book_ID = book_ID;
        this.author = author;
        this.title = title;
        this.price = price;
        this.status = Status.WAITING;
        this.edition = edition;
        this.date_of_purchase = date_of_purchase;
    }

    public String getName() {
        return title;
    }

    public int getBook_ID() {
        return book_ID;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Person getAuthor() {
        return author;
    }

    public void changeOwner(Person owner){
        if(this.status == Status.WAITING){
            this.owner = owner;
            this.status = Status.RENTED;
        }
    }

    public void returned(){
        status = Status.WAITING;
        owner = null;
    }

    public Status getStatus() {
        return status;
    }

    public double getPrice() {
        return price;
    }

    public String display() {
        return "Book{" +
                "book_ID=" + book_ID +
                ", author=" + author +
                ", title='" + title + '\'' +
                ", price=" + price +
                ", status=" + status +
                ", edition=" + edition +
                ", date_of_purchase='" + date_of_purchase + '\'' +
                ", owner=" + owner +
                '}';
    }

    public void updateStatus(Status status){
        this.status = status;
    }

    @Override
    public String toString() {
        return "Book{" +
                "book_ID=" + book_ID +
                ", author=" + author +
                ", title='" + title + '\'' +
                ", price=" + price +
                ", status=" + status +
                ", edition=" + edition +
                ", date_of_purchase='" + date_of_purchase + '\'' +
                ", owner=" + owner +
                '}';
    }


    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Book book)) return false;
        return book_ID == book.book_ID;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(book_ID);
    }
}
