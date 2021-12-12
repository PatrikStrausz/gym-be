package sk.kosickaakademia.strausz.api.rest;

public interface UserFoodDetailsDto {

    Integer getEnergy_value();

    double getProtein();

    double getCarbohydrates();

    double getFiber();

    double getFats();

    double getAmount();

    String getDate();
}
