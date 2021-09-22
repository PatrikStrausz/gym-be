package sk.kosickaakademia.strausz.entity;

import javax.persistence.*;
import java.util.Set;

@Entity(name = "food")
public class Food {

    @Id
    @Column(name ="fdc_id")
    private Long id;

    @Column(name ="data_type")
    private String dataType;

    @Column(name ="description")
    private String description;

    @Column(name ="food_category_id")
    private String foodCategoryId;

    @Column(name ="publication_date")
    private String publicationDate;


    @ManyToMany(mappedBy = "foodSet")
    private Set<Diet> dietSet;


    @ManyToMany
    @JoinTable(
            name = "food_nutrient",
            joinColumns = @JoinColumn(name = "fdc_id"),
            inverseJoinColumns = @JoinColumn(name = "nutrient_id"))
    private Set<Nutrient> nutrientSet;


    public Food(String dataType, String description, String foodCategoryId, String publicationDate) {
        this.dataType = dataType;
        this.description = description;
        this.foodCategoryId = foodCategoryId;
        this.publicationDate = publicationDate;
    }

    public Food() {

    }

    public Long getId() {
        return id;
    }

    public String getDataType() {
        return dataType;
    }

    public void setDataType(String dataType) {
        this.dataType = dataType;
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

    public Set<Diet> getDietSet() {
        return dietSet;
    }

    public void setDietSet(Set<Diet> dietSet) {
        this.dietSet = dietSet;
    }

    public Set<Nutrient> getNutrientSet() {
        return nutrientSet;
    }

    public void setNutrientSet(Set<Nutrient> nutrientSet) {
        this.nutrientSet = nutrientSet;
    }
}
