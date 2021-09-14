package sk.kosickaakademia.strausz.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "Food")
public class Food {

    @Id
    @Column(name ="fdc_id")
    private int fdcID;

    @Column(name ="data_type")
    private String dataType;

    @Column(name ="description")
    private String description;

    @Column(name ="food_category_id")
    private String foodCategoryId;

    @Column(name ="publication_date")
    private String publicationDate;



    public Food(int fdcID, String dataType, String description, String foodCategoryId, String publicationDate) {
        this.fdcID = fdcID;
        this.dataType = dataType;
        this.description = description;
        this.foodCategoryId = foodCategoryId;
        this.publicationDate = publicationDate;
    }

    public Food() {

    }

    public int getFdcID() {
        return fdcID;
    }

    public void setFdcID(int fdcID) {
        this.fdcID = fdcID;
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
}
