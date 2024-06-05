// LibraryItem.java
abstract class LibraryItem {
    protected String title;
    protected String author;
    protected int publicationYear;

    public LibraryItem(String title, String author, int publicationYear) {
        this.title = title;
        this.author = author;
        this.publicationYear = publicationYear;
    }

    public abstract void displayDetails();
}

// Book.java
class Book extends LibraryItem {
    private String genre;

    public Book(String title, String author, int publicationYear, String genre) {
        super(title, author, publicationYear);
        this.genre = genre;
    }

    @Override
    public void displayDetails() {
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Publication Year: " + publicationYear);
        System.out.println("Genre: " + genre);
    }
}

// Magazine.java
class Magazine extends LibraryItem {
    private String issue;

    public Magazine(String title, String author, int publicationYear, String issue) {
        super(title, author, publicationYear);
        this.issue = issue;
    }

    @Override
    public void displayDetails() {
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Publication Year: " + publicationYear);
        System.out.println("Issue: " + issue);
    }
}

// DVD.java
class DVD extends LibraryItem {
    private int duration;

    public DVD(String title, String author, int publicationYear, int duration) {
        super(title, author, publicationYear);
        this.duration = duration;
    }

    @Override
    public void displayDetails() {
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Publication Year: " + publicationYear);
        System.out.println("Duration: " + duration + " minutes");
    }
}

// FineCalculator.java
interface FineCalculator {
    double calculateFine(int daysLate);
}

// StandardFineCalculator.java
class StandardFineCalculator implements FineCalculator {
    private double standardRate;

    public StandardFineCalculator(double standardRate) {
        this.standardRate = standardRate;
    }

    @Override
    public double calculateFine(int daysLate) {
        return standardRate * daysLate;
    }
}

// ReducedFineCalculator.java
class ReducedFineCalculator implements FineCalculator {
    private double reducedRate;

    public ReducedFineCalculator(double reducedRate) {
        this.reducedRate = reducedRate;
    }

    @Override
    public double calculateFine(int daysLate) {
        return reducedRate * daysLate;
    }
}

public class SRP {
    public static void main(String[] args) {
        // Example usage
        Book book = new Book("C++", "Ich Vin Nienna", 2014, "Programming");
        book.displayDetails();

        Magazine magazine = new Magazine("Fuschia", "Aam Awaam Party", 2023, "April");
        magazine.displayDetails();

        DVD dvd = new DVD("Dabbe", "Turkish", 2015, 210);
        dvd.displayDetails();

        // Fine calculation
        StandardFineCalculator standardFineCalculator = new StandardFineCalculator(0.50);
        ReducedFineCalculator reducedFineCalculator = new ReducedFineCalculator(0.25);

        int daysLate = 5;
        double standardFine = standardFineCalculator.calculateFine(daysLate);
        double reducedFine = reducedFineCalculator.calculateFine(daysLate);

        System.out.println("Standard Fine for 5 days late: $" + standardFine);
        System.out.println("Reduced Fine for 5 days late: $" + reducedFine);
    }
}
