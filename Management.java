import java.util.Scanner;
class Book {
    String id;
    String title;
    boolean available;
    Book(String id, String title) {
        this.id = id;
        this.title = title;
        available = true;
    }
}
class Member {
    String id;
    String name;
    int borrowed;
    Member(String id, String name) {
        this.id = id;
        this.name = name;
        borrowed = 0;
    }
    boolean canBorrow() {
        return false;
    }
}
class StudentMember extends Member {
    StudentMember(String id, String name) {
        super(id, name);
    }
    boolean canBorrow() {
        return borrowed < 2;
    }
}
class FacultyMember extends Member {
    FacultyMember(String id, String name) {
        super(id, name);
    }
    boolean canBorrow() {
        return borrowed < 5;
    }
}
class GuestMember extends Member {
    GuestMember(String id, String name) {
        super(id, name);
    }
    boolean canBorrow() {
        return borrowed < 1;
    }
}
class Librarian {
    String name;
    Librarian(String name) {
        this.name = name;
    }
}
class Library {
    Book[] books;
    int count;
    Library(int n) {
        books = new Book[n];
        count = 0;
    }
    void addBook(Book book) {
        books[count] = book;
        count++;
    }
    Book findBook(String id) {
        for (int i = 0; i < count; i++) {
            if (books[i].id.equals(id)) {
                return books[i];
            }
        }
        return null;
    }
    void borrowBook(Member member, String id) {
        Book book = findBook(id);
        if (!member.canBorrow()) {
            System.out.println("Borrow failed: Borrowing limit reached");
        }
        else if (!book.available) {
            System.out.println("Borrow failed: Book unavailable");
        }
        else {
            book.available = false;
            member.borrowed++;
            System.out.println("Borrowed: " + book.title);
        }
    }
    void returnBook(Member member, String id) {
        Book book = findBook(id);
        if (!book.available) {
            book.available = true;
            member.borrowed--;
            System.out.println("Returned: " + book.title);
        }
        else {
            System.out.println("Return failed");
        }
    }
}
public class Management{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Library library = new Library(n);
        for (int i = 0; i < n; i++) {
            String id = sc.next();
            String title = sc.next();

            Book book = new Book(id, title);
            library.addBook(book);
        }
        String type = sc.next();
        String memberId = sc.next();
        String name = sc.next();
        Member member;
        if (type.equals("STUDENT")) {
            member = new StudentMember(memberId, name);
        }
        else if (type.equals("FACULTY")) {
            member = new FacultyMember(memberId, name);
        }
        else {
            member = new GuestMember(memberId, name);
        }
        int m = sc.nextInt();
        for (int i = 0; i < m; i++) {
            String operation = sc.next();
            String bookId = sc.next();
            if (operation.equals("BORROW")) {
                library.borrowBook(member, bookId);
            }
            else {
                library.returnBook(member, bookId);
            }
        }
        System.out.println("Books Borrowed: " + member.borrowed);
        sc.close();
    }
}
