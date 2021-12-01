package sk.kosickaakademia.strausz.api.rest;

public class MineralDto {


    private Integer id;

    private String name;

    private String benefits;

    private String recommendedAmount;

    private String upperLimit;

    private String foodSources;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBenefits() {
        return benefits;
    }

    public void setBenefits(String benefits) {
        this.benefits = benefits;
    }

    public String getRecommendedAmount() {
        return recommendedAmount;
    }

    public void setRecommendedAmount(String recommendedAmount) {
        this.recommendedAmount = recommendedAmount;
    }

    public String getUpperLimit() {
        return upperLimit;
    }

    public void setUpperLimit(String upperLimit) {
        this.upperLimit = upperLimit;
    }

    public String getFoodSources() {
        return foodSources;
    }

    public void setFoodSources(String foodSources) {
        this.foodSources = foodSources;
    }
}
