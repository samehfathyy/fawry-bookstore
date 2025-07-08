import java.awt.print.Book;
import java.time.LocalDate;
import java.util.Locale;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        //singleton inventory instance
        Inventory inventory= Inventory.getInstance();
        //date yyyy-mm-dd
        LocalDate date = LocalDate.now(); //2025
        LocalDate outdated = date.minusYears(10); //2015
        //adding some books
        Ebook ebook = new Ebook("oop","c-11",300, date,"pdf");
        paperBook paperBook = new paperBook("network","c-12",100, outdated,5);
        demoBook demoBook = new demoBook("data structure","c-13", date);
        inventory.addBook(ebook);
        inventory.addBook(paperBook);
        inventory.addBook(demoBook);
        inventory.printBooksInfo();





        //buy available ebook
        //inventory.buyBook("c-11",1,"","");

        //buy available paper book
        //inventory.buyBook("c-12",2,"","");

        //try to buy demo book
        //inventory.buyBook("c-13",1,"","");

        //try to buy a lot of paper books ( more than available quantity )
        //inventory.buyBook("c-12",15,"","");

        //remove outdated books
        //System.out.println(inventory.getBooks().size());
        //inventory.removeOutdatedBooks(1);
        //System.out.println(inventory.getBooks().size());

        //inventory.printBooksInfo();

    }
}