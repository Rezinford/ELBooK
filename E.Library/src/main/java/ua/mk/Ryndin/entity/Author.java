package ua.mk.Ryndin.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "author")
public class Author implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //SEQUENCE), generator = "SEQ_STORE"
    @Column(name = "AUTHOR_ID", nullable = false, columnDefinition = "serial")
    private Long authorID;
    @Column(name = "AUTHOR_FIRST_NAME", columnDefinition = "varchar (255)")
    private String authorfirstName;
    @Column(name = "AUTHOR_LAST_NAME", columnDefinition = "varchar (255)")
    private String authorlastName;
    @Column(name = "AUTHOR_START_YEAR")
    private Integer authorstartYear;
    @Column(name = "AUTHOR_ENDT_YEAR")
    private Integer authorendYear;
    @Column(name = "AUTHOR_DESCRIPTION")
    private String authordescription;

    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "author")
    private List<Book> book;

    public Author() {

    }

    public Author(String authorfirstName, String authorlastName, Integer authorstartYear, Integer authorendYear, String authordescription, List<Book> book) {
        this.authorfirstName = authorfirstName;
        this.authorlastName = authorlastName;
        this.authorstartYear = authorstartYear;
        this.authorendYear = authorendYear;
        this.authordescription = authordescription;
        this.book = book;
    }

    public Long getAuthorID() {
        return authorID;
    }

    public void setAuthorID(Long authorID) {
        this.authorID = authorID;
    }

    public String getAuthorfirstName() {
        return authorfirstName;
    }

    public void setAuthorfirstName(String authorfirstName) {
        this.authorfirstName = authorfirstName;
    }

    public String getAuthorlastName() {
        return authorlastName;
    }

    public void setAuthorlastName(String authorlastName) {
        this.authorlastName = authorlastName;
    }

    public Integer getAuthorstartYear() {
        return authorstartYear;
    }

    public void setAuthorstartYear(Integer authorstartYear) {
        this.authorstartYear = authorstartYear;
    }

    public Integer getAuthorendYear() {
        return authorendYear;
    }

    public void setAuthorendYear(Integer authorendYear) {
        this.authorendYear = authorendYear;
    }

    public String getAuthordescription() {
        return authordescription;
    }

    public void setAuthordescription(String authordescription) {
        this.authordescription = authordescription;
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
        if (!(o instanceof Author)) return false;

        Author author = (Author) o;

        if (!getAuthorID().equals(author.getAuthorID())) return false;
        if (!getAuthorfirstName().equals(author.getAuthorfirstName())) return false;
        if (!getAuthorlastName().equals(author.getAuthorlastName())) return false;
        if (!getAuthorstartYear().equals(author.getAuthorstartYear())) return false;
        if (!getAuthorendYear().equals(author.getAuthorendYear())) return false;
        if (!getAuthordescription().equals(author.getAuthordescription())) return false;
        return getBook().equals(author.getBook());
    }

    @Override
    public int hashCode() {
        int result = getAuthorID().hashCode();
        result = 31 * result + getAuthorfirstName().hashCode();
        result = 31 * result + getAuthorlastName().hashCode();
        result = 31 * result + getAuthorstartYear().hashCode();
        result = 31 * result + getAuthorendYear().hashCode();
        result = 31 * result + getAuthordescription().hashCode();
        result = 31 * result + getBook().hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Author{" +
                "authorID=" + authorID +
                ", authorfirstName='" + authorfirstName + '\'' +
                ", authorlastName='" + authorlastName + '\'' +
                ", authorstartYear=" + authorstartYear +
                ", authorendYear=" + authorendYear +
                ", authordescription='" + authordescription + '\'' +
                ", book=" + book +
                '}';
    }
}
