package sk.kosickaakademia.strausz.entity;

import javax.persistence.*;

@Entity(name = "Food")
public class Food {

    @Id
    @SequenceGenerator(
            name = "food_sequence",
            sequenceName = "food_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "food_sequence"
    )
    private int id;

    private String name;

    private String image;

    private String weight;

    private String ingredients;

    private String properties;

    private String category;

    private String subcategory;

    public Food() {
    }

    public Food(String name, String image, String weight, String ingredients, String properties, String category, String subcategory) {
        this.name = name;
        this.image = image;
        this.weight = weight;
        this.ingredients = ingredients;
        this.properties = properties;
        this.category = category;
        this.subcategory = subcategory;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getIngredients() {
        return ingredients;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

    public String getProperties() {
        return properties;
    }

    public void setProperties(String properties) {
        this.properties = properties;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getSubcategory() {
        return subcategory;
    }

    public void setSubcategory(String subcategory) {
        this.subcategory = subcategory;
    }
}
