import java.util.IllegalFormatPrecisionException;

public class Main {
    public static void main(String[] args) {
        Library library = new Library();

        Person author1 = new Author("Yazar", "Bir");
        Person author2 = new Author("Yazar", "İki");

        Person reader1 = new Reader("Okur", "Bir", "Dün", 1);
        Person reader2 = new Reader("Okur", "İki", "Dün", 2);
        Person reader3 = new Reader("Okur", "Üç", "Dün", 3);

        Book book1 = new Journals(1, (Author) author1, "Kırık Kalp" , 5.2, 5,"Baya Önce");
        Book book2 = new Journals(2, (Author) author1, "Kırık Kol" , 6.2, 5,"Baya Önce");
        Book book3 = new Journals(3, (Author) author1, "Kırık Bacak" , 5.4, 5,"Baya Önce");
        Book book4 = new StudyBooks(4, (Author) author1, "Kırık Göğüs Kafesi" , 5.8, 5,"Baya Önce");
        Book book5 = new StudyBooks(5, (Author) author1, "Kırık Ense" , 10, 5,"Baya Önce");
        Book book6 = new Journals(6, (Author) author2, "Sevginin Gücü" , 21, 5,"Baya Önce");
        Book book7 = new Magazines(7, (Author) author2, "İlginin Gücü" , 8.75, 5,"Baya Önce");
        Book book8 = new Magazines(8, (Author) author2, "Saygının Gücü" , 13.20, 5,"Baya Önce");
        Book book9 = new Magazines(9, (Author) author2, "Alakanın Gücü" , 99, 5,"Baya Önce");
        Book book10 = new Journals(10, (Author) author2, "Gücün Gücü" , 2, 5,"Baya Önce");
        Book book11 = new StudyBooks(11, (Author) author2, "Güç" , 0.1, 5,"Baya Önce");

        library.addBook(book1);
        library.addBook(book2);
        library.addBook(book3);
        library.addBook(book4);
        library.addBook(book5);
        library.addBook(book6);
        library.addBook(book7);
        library.addBook(book8);
        library.addBook(book9);
        library.addBook(book10);
        library.addBook(book11);
        library.addBook(book1);

        library.addReader((Reader) reader1);
        library.addReader((Reader) reader2);
        library.addReader((Reader) reader3);

        library.getBook(1);
        library.getBook(22);

        library.getBook("Kırık Kalp");
        library.getBook("Rafadan Tayfa");

        library.removeBook(book11);
        library.getBook(11);

        library.getBook(10);
        book10.setPrice(55);
        library.updateBook(book10);
        library.getBook(10);

        System.out.println("**************************");
        library.getBook(11);
        book11.setPrice(55);
        library.updateBook(book11);
        library.getBook(11);

        library.getCategory("journals");

        library.getBooksByAuthor((Author) author1);

        System.out.println("**************************");
        library.borrowBook(1,1);
        System.out.println(((Reader) reader1).getNo_books_issued());
        library.borrowBook(1,2);
        library.borrowBook(1,3);
        library.borrowBook(1,4);
        library.borrowBook(1,5);
        System.out.println(((Reader) reader1).getNo_books_issued());
        System.out.println("**************************");
        library.borrowBook(1,6);
        System.out.println(((Reader) reader1).getBooks());
        System.out.println(((Reader) reader1).getBooks().size());
        System.out.println("**************************");
        library.returnBook(1,1);
        System.out.println("**************************");
        library.returnBook(1,7);
        library.borrowBook(1,6);
        System.out.println("**************************");
        library.returnBook(2,1);
        System.out.println("**************************");
        library.returnBook(1,22);
        library.borrowBook(1,22);
        System.out.println("**************************");


    }
}