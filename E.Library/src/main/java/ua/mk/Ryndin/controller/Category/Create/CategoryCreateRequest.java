package ua.mk.Ryndin.controller.Category.Create;


public class CategoryCreateRequest {
    private String categoryName;
     private String categorydescription;

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getCategorydescription() {
        return categorydescription;
    }

    public void setCategorydescription(String categorydescription) {
        this.categorydescription = categorydescription;
    }

    @Override
    public String toString() {
        return "CategoryCreateRequest{" +
                "categoryName='" + categoryName + '\'' +
                ", categorydescription='" + categorydescription + '\'' +
                '}';
    }
}
