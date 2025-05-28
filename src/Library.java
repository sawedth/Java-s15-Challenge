import java.util.HashSet;
import java.util.Set;

public class Library {
    public Set<Book> books = new HashSet<>();
    public Set<Reader> readers = new HashSet<>();

    public void addBook(Book book){
        if(!books.contains(book)){
            System.out.println("Book added.");
            books.add(book);
        }else{
            System.out.println("Book is already in the Library");
        }
    }

    public void addReader(Reader reader){
        if(!readers.contains(reader)){
            System.out.println("Reader added.");
            readers.add(reader);
        }else{
            System.out.println("Reader is already added to Library");
        }
    }

    public Book getBook(int id){
        for(Book book:books){
            if(book.getBook_ID() == id){
                System.out.println("The book is " + book);
                return (book);
            }
        }
        System.out.println("The book can not been found");
        return null;
    }

    public Book getBook(String name){
        for(Book book:books){
            if(book.getName().equals(name)){
                System.out.println("The book is " + book);
                return (book);
            }
        }
        System.out.println("The book can not been found");
        return null;
    }

    public void removeBook(Book book){
        if(books.contains(book)){
            books.remove(book);
            System.out.println("The book has been removed");
        }else{
            System.out.println("The book can not been found");
        }
    }

    public void updateBook(Book book){
        if(books.contains(book)){
            for(Book libBook:books){
                if(libBook.equals(book)){
                    books.remove(libBook);
                    books.add(book);
                    System.out.println("The book has been updated");
                    break;
                }
            }
        }else {
            System.out.println("The book id can not been matched");
        }
    }

    public void getCategory(String category){
        if(category.equals("journals")){
            for(Book book:books){
                if(book instanceof Journals){
                    System.out.println(book);
                }
            }
            System.out.println("All books from journals category");
        }else if (category.equals("studybooks")) {
            for(Book book:books){
                if(book instanceof StudyBooks){
                    System.out.println(book);
                }
            }
            System.out.println("All books from study books category");
        } else if (category.equals("magazines")) {
            for(Book book:books){
                if(book instanceof Magazines){
                    System.out.println(book);
                }
            }
            System.out.println("All books from magazines category");
        }else{
            System.out.println("The category can not been found");
        }
    }

    public void getBooksByAuthor(Author author){
        for(Book book:books){
            if(book.getAuthor().equals(author)){
                System.out.println(book);
            }
        }
    }

    public void borrowBook(int reader_ID, int book_ID){
        Reader reader1 = new Reader(null,null,null,reader_ID);
        Book book1 = new Book(book_ID, null,null,0,0,null);
        if(reader1.getBooks().contains(book1)){
            System.out.println("Reader already has the book");
        } else if (book1.getStatus() == Status.RENTED) {
                System.out.println("The book already borrowed");
        } else if(books.contains(book1)){
            if(readers.contains(reader1)){
                for(Reader reader:readers){
                    if(reader.equals(reader1) && reader.getNo_books_issued() < 5){
                        for (Book book:books){
                            if(book.equals(book1) && book.getStatus() == Status.WAITING){
                                book.changeOwner(reader);
                                reader.setNo_books_issued(reader.getNo_books_issued() + 1);
                                reader.addBook(book);
                                reader.setBill(book.getPrice() + reader.getBill());
                                System.out.println("Book borrowed");
                                System.out.println("New bill of " + reader.getName() + " " + reader.getSurname() + ": " + reader.getBill());

                            }
                        }
                    }else if(reader.getNo_books_issued() == 5){
                        System.out.println("This reader reached borrowed book limit");

                    }
                }
            }else{
                System.out.println("There is no such reader");
            }
        }else{
            System.out.println("There is no such book");
        }
    }
    public void returnBook(int reader_ID, int book_ID){
        Reader reader1 = new Reader(null,null,null,reader_ID);
        Book book1 = new Book(book_ID, null,null,0,0,null);

        if(books.contains(book1)){
            if(readers.contains(reader1)){
                for(Reader reader:readers){
                    if(reader.equals(reader1) ){

                        if(!reader.getBooks().contains(book1)){
                            System.out.println("Reader does not have the book");
                        }else{
                            for (Book book:books){
                                if(book.equals(book1) && reader.getBooks().contains(book)){
                                    book.returned();
                                    reader.setNo_books_issued(reader.getNo_books_issued() - 1);
                                    reader.removeBook(book);
                                    reader.setBill( (10*reader.getBill() - 10*book.getPrice())/10);
                                    System.out.println("Book has been returned");
                                    System.out.println("Returned to customer: " + book.getPrice());
                                    System.out.println("New bill of " + reader.getName() + " " + reader.getSurname() + ": " + reader.getBill());
                                }
                            }
                        }

                    }
                }
            }else{
                System.out.println("There is no such reader");
            }
        }else{
            System.out.println("There is no such book");
        }
    }
}
