package sk.kosickaakademia.strausz.entity;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name="muscle")
public class Muscle {

    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "image_small")
    private String imageSmall;

    @Column(name = "image_big")
    private String imageBig;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getImageSmall() {
        return imageSmall;
    }

    public void setImageSmall(String imageSmall) {
        this.imageSmall = imageSmall;
    }

    public String getImageBig() {
        return imageBig;
    }

    public void setImageBig(String imageBig) {
        this.imageBig = imageBig;
    }
}
