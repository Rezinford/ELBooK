package ua.mk.Ryndin.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "publisher")
public class Publisher implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //SEQUENCE), generator = "SEQ_STORE"
    @Column(name = "PUBLISHER_ID", columnDefinition = "serial")
    private Long publisherID;
    @Column(name = "NAME", columnDefinition = "varchar (255)")
    private String name;
    @Column(name = "DESCRIPTION")
    private String description;
    @Column(name = "CONTRY", columnDefinition = "varchar (255)")
    private String country;

    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "publisher") // cascade = CascadeType.ALL,
    private List<Book> book;

    public Publisher(){

    }

    public Publisher(String name, String description, String country, List<Book> book) {
        this.name = name;
        this.description = description;
        this.country = country;
        this.book = book;
    }

    public Long getPublisherID() {
        return publisherID;
    }

    public void setPublisherID(Long publisherID) {
        this.publisherID = publisherID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public List<Book> getBook() {
        return book;
    }

    public void setBook(List<Book> book) {
        this.book = book;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Publisher)) return false;

        Publisher publisher = (Publisher) o;

        if (!getPublisherID().equals(publisher.getPublisherID())) return false;
        if (!getName().equals(publisher.getName())) return false;
        if (!getDescription().equals(publisher.getDescription())) return false;
        if (!getCountry().equals(publisher.getCountry())) return false;
        return getBook().equals(publisher.getBook());
    }

    @Override
    public int hashCode() {
        int result = getPublisherID().hashCode();
        result = 31 * result + getName().hashCode();
        result = 31 * result + getDescription().hashCode();
        result = 31 * result + getCountry().hashCode();
        result = 31 * result + getBook().hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Publisher{" +
                "publisherID=" + publisherID +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", country='" + country + '\'' +
                ", book=" + book +
                '}';
    }
}
