package ua.mk.Ryndin.controller.User.Forms;

public class UserForm {
    private String e_mail;
    private String password;

    public UserForm() {
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


    @Override
    public String toString() {
        return "UserForm{" +
                "e_mail='" + e_mail + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
