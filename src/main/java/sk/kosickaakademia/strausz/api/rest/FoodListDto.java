package sk.kosickaakademia.strausz.api.rest;

import javax.validation.constraints.NotNull;

public class FoodListDto {

    @NotNull(message = "id.cannot.be.null")
    private Long id;

    @NotNull(message = "description.cannot.be.null")
    private String description;

    @NotNull(message = "foodCategoryId.cannot.be.null")
    private String foodCategoryId;

    @NotNull(message = "publicationDate.cannot.be.null")
    private String publicationDate;


    public FoodListDto(Long id, String description, String foodCategoryId, String publicationDate) {
        this.id = id;
        this.description = description;
        this.foodCategoryId = foodCategoryId;
        this.publicationDate = publicationDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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
