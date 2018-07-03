package ua.mk.Ryndin.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;


@Entity
@Table(name = "book")
public class Book implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //SEQUENCE), generator = "SEQ_STORE"
    @Column(name = "BOOK_ID", nullable = false, columnDefinition = "serial")
    private Long bookID;
    @Column(name = "BOOK_NAME", columnDefinition = "varchar (255)")
    private String bookName;
    @Column(name = "DESCRIPTION")
    private String description;
    @Column(name = "RANG")
    private Double rang;
    @Column(name = "PAGE")
    private Integer page;
    //    @Column(name = "PUBLISHER")
//    private String publisher;
    @Column(name = "DATAPUBLICDATA")
    private Long dataPublicData;
    @Column(name = "LANGUAGE")
    private String language;

    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(name = "book_category", joinColumns = {@JoinColumn(name = "BOOK_ID")},
            inverseJoinColumns = {@JoinColumn(name = "AUTOR_ID")})
    private List<Author> author;

    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(name = "book_autor", joinColumns = {@JoinColumn(name = "BOOK_ID")},
            inverseJoinColumns = {@JoinColumn(name = "CAT_ID")})
    private List<Category> category;

    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(name = "publisher_autor", joinColumns = {@JoinColumn(name = "BOOK_ID")},
            inverseJoinColumns = {@JoinColumn(name = "PUBLISHER_ID")})
    private List<Publisher> publisher;

    @Column(name = "IBSN")
    private String ibsn; //ISBN
    // Constructor
    public Book() {
    }

    public Book(String bookName, String description, Double rang, Integer page, Long dataPublicData, String language, List<Author> autor, List<Category> category, List<Publisher> publisher, String ibsn) {
        this.bookName = bookName;
        this.description = description;
        this.rang = rang;
        this.page = page;
        this.dataPublicData = dataPublicData;
        this.language = language;
        this.author = autor;
        this.category = category;
        this.publisher = publisher;
        this.ibsn = ibsn;
    }

    public Long getBookID() {
        return bookID;
    }

    public void setBookID(Long bookID) {
        this.bookID = bookID;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getRang() {
        return rang;
    }

    public void setRang(Double rang) {
        this.rang = rang;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Long getDataPublicData() {
        return dataPublicData;
    }

    public void setDataPublicData(Long dataPublicData) {
        this.dataPublicData = dataPublicData;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public List<Author> getAuthor() {
        return author;
    }

    public void setAutor(List<Author> author) {
        this.author = author;
    }

    public List<Category> getCategory() {
        return category;
    }

    public void setCategory(List<Category> category) {
        this.category = category;
    }

    public List<Publisher> getPublisher() {
        return publisher;
    }

    public void setPublisher(List<Publisher> publisher) {
        this.publisher = publisher;
    }

    public String getIbsn() {
        return ibsn;
    }

    public void setIbsn(String ibsn) {
        this.ibsn = ibsn;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Book)) return false;

        Book book = (Book) o;

        if (!getBookID().equals(book.getBookID())) return false;
        if (!getBookName().equals(book.getBookName())) return false;
        if (!getDescription().equals(book.getDescription())) return false;
        if (!getRang().equals(book.getRang())) return false;
        if (!getPage().equals(book.getPage())) return false;
        if (!getDataPublicData().equals(book.getDataPublicData())) return false;
        if (!getLanguage().equals(book.getLanguage())) return false;
        if (!getAuthor().equals(book.getAuthor())) return false;
        if (!getCategory().equals(book.getCategory())) return false;
        if (!getPublisher().equals(book.getPublisher())) return false;
        return getIbsn().equals(book.getIbsn());
    }

    @Override
    public int hashCode() {
        int result = getBookID().hashCode();
        result = 31 * result + getBookName().hashCode();
        result = 31 * result + getDescription().hashCode();
        result = 31 * result + getRang().hashCode();
        result = 31 * result + getPage().hashCode();
        result = 31 * result + getDataPublicData().hashCode();
        result = 31 * result + getLanguage().hashCode();
        result = 31 * result + getAuthor().hashCode();
        result = 31 * result + getCategory().hashCode();
        result = 31 * result + getPublisher().hashCode();
        result = 31 * result + getIbsn().hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookID=" + bookID +
                ", bookName='" + bookName + '\'' +
                ", description='" + description + '\'' +
                ", rang=" + rang +
                ", page=" + page +
                ", dataPublicData=" + dataPublicData +
                ", language='" + language + '\'' +
                ", autor=" + author +
                ", category=" + category +
                ", publisher=" + publisher +
                ", ibsn='" + ibsn + '\'' +
                '}';
    }
}
