import java.time.LocalDate;

public abstract class Book {
    private String title;
    private String ISPN;
    private double price;
    private LocalDate publishDate;

    public Book(String title, String ISPN, double price, LocalDate publishDate) {
        this.title = title;
        this.ISPN = ISPN;
        this.price = price;
        this.publishDate = publishDate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getISPN() {
        return ISPN;
    }

    public void setISPN(String ISPN) {
        this.ISPN = ISPN;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public LocalDate getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(LocalDate publishDate) {
        this.publishDate = publishDate;
    }
}
