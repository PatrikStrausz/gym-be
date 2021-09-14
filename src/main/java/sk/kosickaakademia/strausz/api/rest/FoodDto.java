package sk.kosickaakademia.strausz.api.rest;

public class FoodDto {

    private int id;

    private String description;

    private String foodCategoryId;

    private String publicationDate;


    public FoodDto(int id, String description, String foodCategoryId, String publicationDate) {
        this.id = id;
        this.description = description;
        this.foodCategoryId = foodCategoryId;
        this.publicationDate = publicationDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getFoodCategoryId() {
        return foodCategoryId;
    }

    public void setFoodCategoryId(String foodCategoryId) {
        this.foodCategoryId = foodCategoryId;
    }

    public String getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(String publicationDate) {
        this.publicationDate = publicationDate;
    }
}
