import java.time.LocalDate;

public class Ebook extends Book{
    private String fileType;

    public Ebook(String title, String ISPN, double price, LocalDate publishDate, String fileType) {
        super(title, ISPN, price, publishDate);
        this.fileType = fileType;
    }

    public String getFileType() {
        return fileType;
    }
}
