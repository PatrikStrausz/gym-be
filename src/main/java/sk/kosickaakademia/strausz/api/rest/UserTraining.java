package sk.kosickaakademia.strausz.api.rest;

import java.util.List;

public interface UserTraining {

    String getName();

    Integer getReps();

    Integer getSets();

    List<Integer> getWeight();

    String getDate();


}
