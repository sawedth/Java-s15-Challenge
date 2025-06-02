import java.util.IllegalFormatPrecisionException;
import java.util.Scanner;

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

        wakeTheLibrary(library);
    }

    public static void wakeTheLibrary(Library library){
        Scanner scanner = new Scanner(System.in);
        boolean isOpen = true;
        System.out.println("Welcome to the Library");
        while(isOpen){
            System.out.println("Please insert next operation you want to do");
            System.out.println("add => Adding Book");
            System.out.println("getid => Get Book by Id");
            System.out.println("getname => Get Book by Name");
            System.out.println("update => Updating a Book");
            System.out.println("listcategory => List All Books from a Category");
            System.out.println("listauthor => List All Books Written by a Author");
            System.out.println("lend => Lend a Book to a Reader");
            System.out.println("return => Return a Book from the Reader");
            System.out.println("close => Close the Library");
            String operation = scanner.next();
            operation = operation.replaceAll("\\p{Punct}","");
            operation = operation.replace(" ", "");
            operation = operation.replaceAll("[0-9]", "");

            switch (operation){
                case "add":
                    Scanner bookAdd = new Scanner(System.in);
                    System.out.println("Please insert book id");
                    int bookId = Integer.parseInt(bookAdd.nextLine());
                    System.out.println("Please insert Author's first name");
                    String authorName = bookAdd.nextLine();
                    System.out.println("Please insert Author's last name");
                    String authorLast = bookAdd.nextLine();
                    System.out.println("Please insert title of the book");
                    String title = bookAdd.nextLine();
                    System.out.println("Please insert price of the book");
                    double price = Double.parseDouble(bookAdd.nextLine());
                    System.out.println("Please insert edition of the book");
                    int edition = Integer.parseInt(bookAdd.nextLine());
                    System.out.println("Please insert date of purchase (DD-MM-YYYY)");
                    String date = bookAdd.nextLine();
                    Book newBook = new Book(bookId, new Author(authorName, authorLast), title, price, edition, date);
                    library.addBook(newBook);
                    break;
                case "getid":
                    System.out.println("Please insert Book Id");
                    int findId = scanner.nextInt();
                    library.getBook(findId);
                    break;
                case "getname":
                    Scanner getNameSc = new Scanner(System.in);
                    System.out.println("Please insert book name");
                    String findName = getNameSc.nextLine();
                    library.getBook(findName);
                    break;
                case "update":
                    Scanner bookUpdate = new Scanner(System.in);
                    System.out.println("Please insert book id");
                    int bookId2 = Integer.parseInt(bookUpdate.nextLine());
                    System.out.println("Please insert Author's first name");
                    String authorName2 = bookUpdate.nextLine();
                    System.out.println("Please insert Author's last name");
                    String authorLast2 = bookUpdate.nextLine();
                    System.out.println("Please insert title of the book");
                    String title2 = bookUpdate.nextLine();
                    System.out.println("Please insert price of the book");
                    double price2 = Double.parseDouble(bookUpdate.nextLine());
                    System.out.println("Please insert edition of the book");
                    int edition2 = Integer.parseInt(bookUpdate.nextLine());
                    System.out.println("Please insert date of purchase (DD-MM-YYYY)");
                    String date2 = bookUpdate.nextLine();
                    Book newBook2 = new Book(bookId2, new Author(authorName2, authorLast2), title2, price2, edition2, date2);
                    library.updateBook(newBook2);
                    break;
                case"listcategory":
                    Scanner listCato = new Scanner(System.in);
                    System.out.println("Please insert name of the category");
                    String catego = listCato.nextLine();
                    library.getCategory(catego);
                    break;
                case "listauthor":
                    Scanner listAu = new Scanner(System.in);
                    System.out.println("Please insert Author's first name");
                    String authorNameList = listAu.nextLine();
                    System.out.println("Please insert Author's last name");
                    String authorLastList = listAu.nextLine();
                    Author auth = new Author(authorNameList, authorLastList);
                    library.getBooksByAuthor(auth);
                    break;
                case "lend":
                    System.out.println("Please insert book id");
                    int lendBook = scanner.nextInt();
                    System.out.println("Please insert reader id");
                    int lendReader = scanner.nextInt();
                    library.borrowBook(lendReader,lendBook);
                    break;
                case "return":
                    System.out.println("Please insert book id");
                    int returnBook = scanner.nextInt();
                    System.out.println("Please insert reader id");
                    int returnReader = scanner.nextInt();
                    library.returnBook(returnReader,returnBook);
                    break;
                case "close":
                    System.out.println("Have a Nice Day!");
                    isOpen = false;
                    break;
                default:
                    System.out.println("Wrong Command");
                    break;
            }

        }
    }
}