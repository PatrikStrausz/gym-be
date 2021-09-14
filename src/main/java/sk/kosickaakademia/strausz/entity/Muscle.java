package sk.kosickaakademia.strausz.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name="muscle")
public class Muscle {

    @Id
    private int id;

    private String image_small;

    private String image_big;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getImage_small() {
        return image_small;
    }

    public void setImage_small(String image_small) {
        this.image_small = image_small;
    }

    public String getImage_big() {
        return image_big;
    }

    public void setImage_big(String image_big) {
        this.image_big = image_big;
    }
}
