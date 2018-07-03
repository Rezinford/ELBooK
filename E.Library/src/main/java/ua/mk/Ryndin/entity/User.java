package ua.mk.Ryndin.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "user_client")
public class User implements Serializable {
    // private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //SEQUENCE), generator = "SEQ_STORE"
    @Column(name = "USER_ID", nullable = false, columnDefinition = "serial")
    private Long userID;
    @Column(name = "FIRST_NAME", columnDefinition = "varchar (255)")
    private String first_name;
    @Column(name = "LAST_NAME", columnDefinition = "varchar (255)")
    private String last_namee;
    @Column(name = "E_MAIL", nullable = false, columnDefinition = "varchar (255)")
    private String e_mail;
    @Column(name = "PASSWORD", columnDefinition = "varchar (255)")
    private String password;
    @Column(name = "AGE")
    private Integer age;

    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(name = "user_role", joinColumns = {@JoinColumn(name = "USER_ID")},
            inverseJoinColumns = {@JoinColumn(name = "ROLE_ID")})
    private List<Role> role;

    public User(String first_name, String last_namee, String e_mail, String password, Integer age, List<Role> role) {
        this.first_name = first_name;
        this.last_namee = last_namee;
        this.e_mail = e_mail;
        this.password = password;
        this.age = age;
        this.role = role;
    }

    public User() {

    }

    public Long getUserID() {
        return userID;
    }

    public void setUserID(Long userID) {
        this.userID = userID;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_namee() {
        return last_namee;
    }

    public void setLast_namee(String last_namee) {
        this.last_namee = last_namee;
    }

    public String getE_mail() {
        return e_mail;
    }

    public void setE_mail(String e_mail) {
        this.e_mail = e_mail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public List<Role> getRole() {
        return role;
    }

    public void setRole(List<Role> role) {
        this.role = role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;

        User user = (User) o;

        if (!getUserID().equals(user.getUserID())) return false;
        if (!getFirst_name().equals(user.getFirst_name())) return false;
        if (!getLast_namee().equals(user.getLast_namee())) return false;
        if (!getE_mail().equals(user.getE_mail())) return false;
        if (!getPassword().equals(user.getPassword())) return false;
        if (!getAge().equals(user.getAge())) return false;
        return getRole().equals(user.getRole());
    }

    @Override
    public int hashCode() {
        int result = getUserID().hashCode();
        result = 31 * result + getFirst_name().hashCode();
        result = 31 * result + getLast_namee().hashCode();
        result = 31 * result + getE_mail().hashCode();
        result = 31 * result + getPassword().hashCode();
        result = 31 * result + getAge().hashCode();
        result = 31 * result + getRole().hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "User{" +
                "userID=" + userID +
                ", first_name='" + first_name + '\'' +
                ", last_namee='" + last_namee + '\'' +
                ", e_mail='" + e_mail + '\'' +
                ", password='" + password + '\'' +
                ", age=" + age +
                ", role=" + role +
                '}';
    }
}
