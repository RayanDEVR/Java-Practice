/*
Library Management Console   [Mini Project | Project]
Model Book, Member, Loan and LoanStatus. Use Map for book/member lookup, Set for unique ISBN/member ID 
and List for loan history. Encapsulate borrow/return rules in LibraryService.
Done when: Cannot borrow unavailable book, cannot return unborrowed book, duplicate IDs are rejected, and 
reports show available/borrowed books and member loans.
*/

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

class Book {

    private final String isbn;
    private final String title;
    private boolean available = true;

    public Book(String isbn, String title) {
        this.isbn = isbn;
        this.title = title;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getTitle() {
        return title;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    @Override
    public String toString() {
        return isbn + " | " + title + " | " + (available ? "AVAILABLE" : "BORROWED");
    }
}

class Member {

    private final String memberId;
    private final String name;

    public Member(String memberId, String name) {
        this.memberId = memberId;
        this.name = name;
    }

    public String getMemberId() {
        return memberId;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return memberId + " | " + name;
    }
}

enum LoanStatus {
    BORROWED,
    RETURNED
}

class Loan {

    private final String loanId;
    private final String isbn;
    private final String memberId;
    private LoanStatus status;

    public Loan(String loanId, String isbn, String memberId) {

        this.loanId = loanId;
        this.isbn = isbn;
        this.memberId = memberId;
        this.status = LoanStatus.BORROWED;
    }

    public String getLoanId() {
        return loanId;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getMemberId() {
        return memberId;
    }

    public LoanStatus getStatus() {
        return status;
    }

    public void setStatus(LoanStatus status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return loanId + " | ISBN=" + isbn + " | member=" + memberId + " | " + status;
    }
}

class LibraryService {
    private final Map<String, Book> books = new HashMap<>();
    private final Map<String, Member> members = new HashMap<>();
    private final Set<String> isbnSet = new HashSet<>();
    private final Set<String> memberIdSet = new HashSet<>();
    private final List<Loan> loanHistory = new ArrayList<>();

    private int nextLoanNumber = 1;

    public void addBook(Book book) {

        if (!isbnSet.add(book.getIsbn())) {
            throw new IllegalArgumentException("Duplicate ISBN: " + book.getIsbn());
        }

        books.put(book.getIsbn(), book);
    }

    public void addMember(Member member) {
        if (!memberIdSet.add(member.getMemberId())) {
            throw new IllegalArgumentException("Duplicate member ID: " + member.getMemberId());
        }

        members.put(member.getMemberId(), member);
    }

    public void borrowBook(String isbn, String memberId) {
        Book book = books.get(isbn);

        if (book == null) {
            throw new IllegalArgumentException("Book not found");
        }

        if (!members.containsKey(memberId)) {
            throw new IllegalArgumentException("Member not found");
        }

        if (!book.isAvailable()) {
            throw new IllegalStateException("Book is already borrowed");
        }

        Loan loan = new Loan("L-" + nextLoanNumber++, isbn, memberId);

        loanHistory.add(loan);

        book.setAvailable(false);
    }

    public void returnBook(String isbn, String memberId) {
        Book book = books.get(isbn);

        if (book == null) {
            throw new IllegalArgumentException("Book not found");
        }

        Loan activeLoan = null;

        for (Loan loan : loanHistory) {
            if (loan.getIsbn().equals(isbn) && loan.getMemberId().equals(memberId) && loan.getStatus() == LoanStatus.BORROWED) {
                activeLoan = loan;
                break;
            }
        }

        if (activeLoan == null) {
            throw new IllegalStateException("No active loan found for this member and book");
        }

        activeLoan.setStatus(LoanStatus.RETURNED);

        book.setAvailable(true);
    }

    public void reportBooks() {
        System.out.println("\nAvailable books:");

        for (Book book : books.values()) {
            if (book.isAvailable()) {
                System.out.println(book);
            }
        }

        System.out.println("Borrowed books:");

        boolean foundBorrowed = false;
        for (Book book : books.values()) {
            if (!book.isAvailable()) {
                System.out.println(book);
            }
        }
        
        if (!foundBorrowed) {
            System.out.println("No borrowed books.");
        }
    }

    public void reportMemberLoans(String memberId) {
        if (!members.containsKey(memberId)) {
            throw new IllegalArgumentException("Member not found");
        }

        System.out.println("\nLoans for " + members.get(memberId).getName() + ":"
        );

        boolean found = false;

        for (Loan loan : loanHistory) {
            if (loan.getMemberId().equals(memberId)) {
                System.out.println(loan);
                found = true;
            }
        }

        if (!found) {
            System.out.println("No loan history");
        }
    }
}

public class Ex185LibraryManagementConsole {

    public static void main(String[] args) {

        LibraryService library =new LibraryService();

        library.addBook(new Book("978-001", "Java Basics"));
        library.addBook(new Book("978-002", "Spring Boot Intro"));
        
        library.addMember(new Member("M-101","Rayan"));
        library.addMember(new Member("M-102", "Sami"));
        try {
            library.addMember(new Member( "M-101", "Duplicate"));
        } 
        catch (IllegalArgumentException e) {
            System.out.println("Duplicate member rejected: " + e.getMessage());
        }

        library.borrowBook("978-001", "M-101");

        try {
            library.borrowBook("978-001", "M-102");
        }
        catch (IllegalStateException e) {
            System.out.println("Second borrow rejected: " + e.getMessage());
        }

        library.reportBooks();

        library.reportMemberLoans("M-101");

        library.returnBook("978-001", "M-101");

        try {
            library.returnBook("978-001", "M-101");
        } 
        catch (IllegalStateException e) {
            System.out.println("Second return rejected: " + e.getMessage());
        }

        library.reportBooks();
    }
}