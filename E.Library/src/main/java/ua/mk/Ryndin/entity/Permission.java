package ua.mk.Ryndin.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "permission")
public class Permission implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //SEQUENCE), generator = "SEQ_STORE"
    @Column(name = "PERMISSION_ID", columnDefinition = "serial")
    private Long permissionID;
    @Column(name = "PERMISSION_NAME", columnDefinition = "varchar (255)")
    private String permitionName;


//    @ManyToMany(cascade = {CascadeType.ALL})
//    @JoinTable(name = "permission_autor", joinColumns = {@JoinColumn(name = "CAT_ID")},
//            inverseJoinColumns = {@JoinColumn(name = "PERMISSION_ID")})

    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "permission") // cascade = CascadeType.ALL,
    private List<Category> category;

    public Permission(){

    }

    public Permission(String permitionName, List<Category> category) {
        this.permitionName = permitionName;
        this.category = category;
    }

    public Long getPermissionID() {
        return permissionID;
    }

    public void setPermissionID(Long permissionID) {
        this.permissionID = permissionID;
    }

    public String getPermitionName() {
        return permitionName;
    }

    public void setPermitionName(String permitionName) {
        this.permitionName = permitionName;
    }

    public List<Category> getCategory() {
        return category;
    }

    public void setCategory(List<Category> category) {
        this.category = category;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Permission)) return false;

        Permission that = (Permission) o;

        if (!getPermissionID().equals(that.getPermissionID())) return false;
        if (!getPermitionName().equals(that.getPermitionName())) return false;
        return getCategory().equals(that.getCategory());
    }

    @Override
    public int hashCode() {
        int result = getPermissionID().hashCode();
        result = 31 * result + getPermitionName().hashCode();
        result = 31 * result + getCategory().hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Permission{" +
                "permissionID=" + permissionID +
                ", permitionName='" + permitionName + '\'' +
                ", category=" + category +
                '}';
    }
}
