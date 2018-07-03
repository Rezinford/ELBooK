package ua.mk.Ryndin.controller.Auther.Create;

import org.springframework.format.annotation.DateTimeFormat;

public class AuthorCreateRequest {
    private Long authorID;
    private String authorfirstName;
    private String authorlastName;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Integer authorstartYear;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Integer authorendYear;
    private String authordescription;

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

    @Override
    public String toString() {
        return "AutherCreateRequest{" +
                "authorID=" + authorID +
                ", authorfirstName='" + authorfirstName + '\'' +
                ", authorlastName='" + authorlastName + '\'' +
                ", authorstartYear=" + authorstartYear +
                ", authorendYear=" + authorendYear +
                ", authordescription='" + authordescription + '\'' +
                '}';
    }
}
