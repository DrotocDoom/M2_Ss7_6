import java.util.Scanner;

public class Book {
    private Integer bookId;
    private String bookName;
    private String bookAuthor;

    public Book(Integer bookId, String bookName, String bookAuthor) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.bookAuthor = bookAuthor;
    }
    public Book() {
    }

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getBookAuthor() {
        return bookAuthor;
    }

    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
    }

    public void inputData(Scanner scanner) {
        System.out.println("Enter book ID: ");
        this.bookId = scanner.nextInt();
        System.out.println("Enter book name: ");
        scanner.nextLine(); // Consume the newline character
        this.bookName = scanner.nextLine();
        System.out.println("Enter book author: ");
        this.bookAuthor = scanner.nextLine();
    }
    public void displayData() {
        System.out.println("Book ID: " + this.bookId);
        System.out.println("Book name: " + this.bookName);
        System.out.println("Book author: " + this.bookAuthor);
    }
}
