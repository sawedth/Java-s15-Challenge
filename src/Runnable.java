import java.util.Set;

public interface Runnable {
    void addBook(Book book);
    void addReader(Reader reader);
    Book getBook(int id);
    Book getBook(String name);
    void removeBook(Book book);
    void updateBook(Book book);
    void getCategory(String category);
    void borrowBook(int reader_ID, int book_ID);
    void returnBook(int reader_ID, int book_ID);
    Set<Book> readerBooks(int reader_ID);
}
