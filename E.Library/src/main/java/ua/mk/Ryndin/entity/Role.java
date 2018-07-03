package ua.mk.Ryndin.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "role")
public class Role implements Serializable { //
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //SEQUENCE), generator = "SEQ_STORE"
    @Column(name = "ROLE_ID", nullable = false, columnDefinition = "serial")
    private Long roleID;
    @Column(name = "role_name", columnDefinition = "varchar (255)")
    private String roleName;
    @Column(name = "NAME", columnDefinition = "varchar (255)")
    private String name;
    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "role") //MERGE  cascade = CascadeType.ALL,

    private List<User> users;

    public Role(){

    }

    public Role(String roleName, String name, List<User> users) {
        this.roleName = roleName;
        this.name = name;
        this.users = users;
    }

    public Long getRoleID() {
        return roleID;
    }

    public void setRoleID(Long roleID) {
        this.roleID = roleID;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Role)) return false;

        Role role = (Role) o;

        if (!getRoleID().equals(role.getRoleID())) return false;
        if (!getRoleName().equals(role.getRoleName())) return false;
        if (!getName().equals(role.getName())) return false;
        return getUsers().equals(role.getUsers());
    }

    @Override
    public int hashCode() {
        int result = getRoleID().hashCode();
        result = 31 * result + getRoleName().hashCode();
        result = 31 * result + getName().hashCode();
        result = 31 * result + getUsers().hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Role{" +
                "roleID=" + roleID +
                ", roleName='" + roleName + '\'' +
                ", name='" + name + '\'' +
                ", users=" + users +
                '}';
    }
}
