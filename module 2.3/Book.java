import java.util.ArrayList;

public class Book {
    private String title;
    private String author;
    private int publicationYear;
    private double rating;
    private ArrayList<String> reviews = new ArrayList<>();

    public Book(String title, String author, int publicationYear) {
        if (title == null || title.trim().isEmpty() || author == null || author.trim().isEmpty()) {
            throw new IllegalArgumentException("Title and author must not be empty.");
        }
        this.title = title.trim();
        this.author = author.trim();
        this.publicationYear = publicationYear;
    }

    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public int getPublicationYear() { return publicationYear; }
    public double getRating() { return rating; }

    public void setRating(double rating) {
        if (!Double.isFinite(rating) || rating < 0 || rating > 5) {
            throw new IllegalArgumentException("Rating must be between 0 and 5.");
        }
        this.rating = rating;
    }

    public void addReview(String review) {
        if (review == null || review.trim().isEmpty()) {
            throw new IllegalArgumentException("Review must not be empty.");
        }
        reviews.add(review.trim());
    }

    public ArrayList<String> getReviews() {
        return new ArrayList<>(reviews);
    }

    public int getReviewCount() { return reviews.size(); }

    public String toString() {
        return "Title: \"" + title + "\", Author: \"" + author + "\", Year: " + publicationYear;
    }
}
