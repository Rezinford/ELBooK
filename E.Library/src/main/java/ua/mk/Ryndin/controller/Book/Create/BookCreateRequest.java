package ua.mk.Ryndin.controller.Book.Create;

import java.util.List;

public class BookCreateRequest {
    private String bookName;
    private String bookdescription;
    private List<Long> bookautherName;
    private List<Long> bookCategoryName;
    private List<Long> bookPublisherName;
    private Long bookdataPublicData;
    private String booklanguage;

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getBookdescription() {
        return bookdescription;
    }

    public void setBookdescription(String bookdescription) {
        this.bookdescription = bookdescription;
    }

    public List<Long> getBookautherName() {
        return bookautherName;
    }

    public void setBookautherName(List<Long> bookautherName) {
        this.bookautherName = bookautherName;
    }

    public List<Long> getBookCategoryName() {
        return bookCategoryName;
    }

    public void setBookCategoryName(List<Long> bookCategoryName) {
        this.bookCategoryName = bookCategoryName;
    }

    public List<Long> getBookPublisherName() {
        return bookPublisherName;
    }

    public void setBookPublisherName(List<Long> bookPublisherName) {
        this.bookPublisherName = bookPublisherName;
    }

    public Long getBookdataPublicData() {
        return bookdataPublicData;
    }

    public void setBookdataPublicData(Long bookdataPublicData) {
        this.bookdataPublicData = bookdataPublicData;
    }

    public String getBooklanguage() {
        return booklanguage;
    }

    public void setBooklanguage(String booklanguage) {
        this.booklanguage = booklanguage;
    }

    @Override
    public String toString() {
        return "BookCreateRequest{" +
                "bookName='" + bookName + '\'' +
                ", bookdescription='" + bookdescription + '\'' +
                ", bookautherName=" + bookautherName +
                ", bookCategoryName=" + bookCategoryName +
                ", bookPublisherName=" + bookPublisherName +
                ", bookdataPublicData=" + bookdataPublicData +
                ", booklanguage='" + booklanguage + '\'' +
                '}';
    }
}
