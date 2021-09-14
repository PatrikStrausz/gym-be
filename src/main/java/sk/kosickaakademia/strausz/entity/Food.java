package sk.kosickaakademia.strausz.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "Food")
public class Food {

    @Id
    private int fdcID;

    @Column()
    private String dataType;

    private String description;

    private String foodCategoryId;

    private String publicationDate;



}
