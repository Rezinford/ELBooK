package ua.mk.Ryndin.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "category")
public class Category implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //SEQUENCE), generator = "SEQ_STORE"
    @Column(name = "CAT_ID", nullable = false, columnDefinition = "serial")
    private Long catID;
    @Column(name = "NAME", columnDefinition = "varchar (255)")
    private String name;
    @Column(name = "DESCRIPTION")
    private String description;

//    @ManyToMany(cascade = CascadeType.ALL,mappedBy = "category") // cascade = CascadeType.ALL,
//    private List<Book> book;

    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(name = "cat_perm", joinColumns = {@JoinColumn(name = "CAT_ID")},
            inverseJoinColumns = {@JoinColumn(name = "PERMISSION_ID")})
    private List<Permission> permission;

    public Category(){

    }

    public Category(String name, String description, List<Permission> permission) {
        this.name = name;
        this.description = description;
        this.permission = permission;
    }

    public Long getCatID() {
        return catID;
    }

    public void setCatID(Long catID) {
        this.catID = catID;
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

    public List<Permission> getPermission() {
        return permission;
    }

    public void setPermission(List<Permission> permission) {
        this.permission = permission;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Category)) return false;

        Category category = (Category) o;

        if (!getCatID().equals(category.getCatID())) return false;
        if (!getName().equals(category.getName())) return false;
        if (!getDescription().equals(category.getDescription())) return false;
        return getPermission().equals(category.getPermission());
    }

    @Override
    public int hashCode() {
        int result = getCatID().hashCode();
        result = 31 * result + getName().hashCode();
        result = 31 * result + getDescription().hashCode();
        result = 31 * result + getPermission().hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Category{" +
                "catID=" + catID +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", permission=" + permission +
                '}';
    }
}
