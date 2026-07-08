import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int choice;
        int currentIndex = 0;
        Book[] listBooks = new Book[100]; // Array to store up to 100 books
        do {
            System.out.println("----------MENU-----------");
            System.out.println("1. Thêm mới sách vào mảng.");
            System.out.println("2. Sửa thông tin sách theo bookId.");
            System.out.println("3. Xóa sách theo bookI");
            System.out.println("4. Hiển thị danh sách tất cả sách hiện có.");
            System.out.println("5. Tìm kiếm sách theo bookName.");
            System.out.println("6. Thoát");
            System.out.printf("Vui lòng chọn chức năng (1-6): ");
            while (true){
                if (!input.hasNextInt()){
                    System.out.println("Vui lòng nhập số");
                    input.nextLine(); // Consume the invalid input
                    continue;
                }
                choice = input.nextInt();
                if (choice < 1 || choice > 6){
                    System.out.println("Vui lòng nhập số nguyên từ 1 đến 6.");
                    continue;
                }
                break;
            }
            switch (choice) {
                case 1 ->{
                    listBooks[currentIndex] = new Book();
                    listBooks[currentIndex].inputData(input);
                    currentIndex++;
                }
                case 2 ->{
                    System.out.println("Nhập bookId của sách cần sửa thông tin: ");
                    int bookIdToEdit = input.nextInt();
                    input.nextLine();
                    boolean found = false;
                    for (int i = 0; i < currentIndex; i++) {
                        if (listBooks[i].getBookId() == bookIdToEdit){
                            found = true;
                            System.out.println("Nhập thông tin mới cho sách:");
                            System.out.println("Nhập tên sách mới: ");
                            String bookName = input.nextLine();
                            listBooks[i].setBookName(bookName);
                            System.out.println("Nhập tên tác giả mới: ");
                            String bookAuthor = input.nextLine();
                            listBooks[i].setBookAuthor(bookAuthor);
                            System.out.println("Thông tin sách đã được cập nhật.");
                            break;
                        }
                    }
                    if (!found){
                        System.out.println("Không tìm thấy sách với bookId: " + bookIdToEdit);
                    }
                }
                case 3 ->{
                    System.out.println("Nhập bookId của sách cần xóa: ");
                    int bookIdToDelete = input.nextInt();
                    boolean found = false;
                    for (int i = 0; i < currentIndex; i++) {
                        if (listBooks[i].getBookId() == bookIdToDelete){
                            found = true;
                            for (int j = i; j < currentIndex - 1; j++) {
                                listBooks[j] = listBooks[j + 1];
                            }
                            listBooks[currentIndex - 1] = null;
                            currentIndex--;
                            System.out.println("Sách đã được xóa.");
                            break;
                        }
                    }
                    if (!found){
                        System.out.println("Không tìm thấy sách với bookId: " + bookIdToDelete);
                    }
                }
                case 4 ->{
                    System.out.println("Danh sách tất cả sách hiện có:");
                    for (int i = 0; i < currentIndex; i++) {
                        System.out.println("--------------------");
                        listBooks[i].displayData();
                    }
                }
                case 5 ->{
                    System.out.println("Nhập tên sách cần tìm kiếm: ");
                    input.nextLine(); // Consume the newline character
                    String bookNameToSearch = input.nextLine();
                    boolean found = false;
                    for (int i = 0; i < currentIndex; i++) {
                        if (listBooks[i].getBookName().toLowerCase().contains(bookNameToSearch.toLowerCase())){
                            found = true;
                            System.out.println("--------------------");
                            listBooks[i].displayData();
                        }
                    }
                    if (!found){
                        System.out.println("Không tìm thấy sách với tên: " + bookNameToSearch);
                    }
                }
                case 6 ->{
                    System.out.println("Thoát chương trình.");
                    return;
                }
                default -> {
                    System.out.println("Vui lòng nhập số nguyên từ 1 đến 6.");
                }
            }
        }while (true);
    }
}
