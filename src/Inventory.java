import java.awt.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Inventory {
    //singleton inventory class
    static Inventory inventory = new Inventory();
    private List<Book> books;


    private Inventory(){
        books= new ArrayList<>();
    }
    public static Inventory getInstance(){
        return inventory;
    }
    public List<Book> getBooks() {
        return books;
    }
    public void addBook(Book book){
        for (Book b:books){
            if(b.getISPN().equals(book.getISPN())){
                System.out.println("this ispn is used for another book");
                return;
            }
        }
        books.add(book);
        return;
    }
    public List<Book> removeOutdatedBooks(int years){
            List<Book> booksToBeRemoved = new ArrayList<>();
            LocalDate date = LocalDate.now();
        if(years>=1) {
            date=date.minusYears(years);
            for (Book book : books) {
                if (book.getPublishDate().isBefore(date)) {
                    booksToBeRemoved.add(book);
                }
            }
            books.removeAll(booksToBeRemoved);
            System.out.printf("%d books removed from inventory\n", booksToBeRemoved.size());
        }else {
            System.out.println("Number of years must be a positive number");
        }
        return booksToBeRemoved;
    }
    public void printBooksInfo(){
        for (Book book : books){
            System.out.printf("title: %s\n",book.getTitle());
            System.out.printf("publish date: %s\n",book.getPublishDate());
            if(book instanceof paperBook){
                System.out.println("type: paper book");
                System.out.printf("quantity: %d\n",((paperBook) book).getAvailableQuantity());
            }
            else if(book instanceof Ebook){
                System.out.println("type: Ebook");
                System.out.printf("file type: %s\n",((Ebook) book).getFileType());
            }
            else if (book instanceof demoBook){
                System.out.println("type: demo book");
            }
            System.out.println("-----------------");
        }
    }
    public double buyBook(String isbn,int quantity,String email,String address){
        Services services = new Services();
        if(quantity<1)
            return 0;
        for (Book book:books){
            if(book.getISPN().equals(isbn)){
                if(book instanceof paperBook){
                    int availableQuantity = ((paperBook) book).getAvailableQuantity();
                    if (availableQuantity>=quantity){
                        //success
                        ((paperBook) book).minusQuantity(quantity);
                        //send paper book to shipping service
                        services.ShippingService(book,address);
                        double totalAmount= book.getPrice()*quantity;
                        System.out.printf("%dx ",quantity);
                        System.out.printf("%s\n",book.getTitle());

                        System.out.printf("Total Amount: %.2f\n",totalAmount);
                        return totalAmount;
                    }
                    else {
                        System.out.printf("We are sorry ,only %d books is available.\n",availableQuantity);
                        return 0;
                    }
                }
                else if (book instanceof Ebook){
                    //send ebook to mail service
                    services.MailService(book,email);
                    System.out.printf("%s\n",book.getTitle());
                    System.out.printf("Total Amount: %.2f\n",book.getPrice());
                    return book.getPrice();
                }
                else if(book instanceof demoBook){
                    System.out.println("This book is not for sale.");
                    return 0;
                }
            }
        }
        System.out.println("No books are available with this isbn");
        return 0;
    }
}
