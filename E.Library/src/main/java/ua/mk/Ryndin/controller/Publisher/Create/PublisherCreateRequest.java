package ua.mk.Ryndin.controller.Publisher.Create;

public class PublisherCreateRequest {
    private String publisherName;
    private String country;
    private String publisherdescription;

    public String getPublisherName() {
        return publisherName;
    }

    public void setPublisherName(String publisherName) {
        this.publisherName = publisherName;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPublisherdescription() {
        return publisherdescription;
    }

    public void setPublisherdescription(String publisherdescription) {
        this.publisherdescription = publisherdescription;
    }

    @Override
    public String toString() {
        return "PublisherCreateRequest{" +
                "publisherName='" + publisherName + '\'' +
                ", Country='" + country + '\'' +
                ", publisherdescription='" + publisherdescription + '\'' +
                '}';
    }
}
