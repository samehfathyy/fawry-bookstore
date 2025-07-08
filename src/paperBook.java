import java.time.LocalDate;

public class paperBook extends Book{
    private int availableQuantity;

    public paperBook(String title, String ISPN, double price, LocalDate publishDate, int availableQuantity) {
        super(title, ISPN, price, publishDate);
        this.availableQuantity = availableQuantity;
    }

    public int getAvailableQuantity() {
        return availableQuantity;
    }

    public void minusQuantity(int quantity){
        this.availableQuantity -= quantity;
    }
}
