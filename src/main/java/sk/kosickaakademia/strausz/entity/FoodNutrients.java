package sk.kosickaakademia.strausz.entity;

import javax.persistence.*;

@Entity(name = "food_nutrient")
public class FoodNutrients {

    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "fdc_id")
    private int fdcId;

    @Column(name = "nutrient_id")
    private int nutrientId;

    @Column(name = "amount")
    private double amount;

    @Column(name = "data_points")
    private String dataPoints;

    @Column(name = "derivation_id")
    private String derivationId;

    @Column(name = "min")
    private String min;

    @Column(name = "max")
    private String max;

    @Column(name = "median")
    private String median;

    @Column(name = "footnote")
    private String footnote;

    @Column(name = "min_year_acqured")
    private String minYearAcqured;

    public FoodNutrients() {
    }

    public FoodNutrients(int fdcId, int nutrientId, double amount, String dataPoints, String derivationId, String min, String max, String median, String footnote, String minYearAcqured) {
        this.fdcId = fdcId;
        this.nutrientId = nutrientId;
        this.amount = amount;
        this.dataPoints = dataPoints;
        this.derivationId = derivationId;
        this.min = min;
        this.max = max;
        this.median = median;
        this.footnote = footnote;
        this.minYearAcqured = minYearAcqured;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getFdcId() {
        return fdcId;
    }

    public void setFdcId(int fdcId) {
        this.fdcId = fdcId;
    }

    public int getNutrientId() {
        return nutrientId;
    }

    public void setNutrientId(int nutrientId) {
        this.nutrientId = nutrientId;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getDataPoints() {
        return dataPoints;
    }

    public void setDataPoints(String dataPoints) {
        this.dataPoints = dataPoints;
    }

    public String getDerivationId() {
        return derivationId;
    }

    public void setDerivationId(String derivationId) {
        this.derivationId = derivationId;
    }

    public String getMin() {
        return min;
    }

    public void setMin(String min) {
        this.min = min;
    }

    public String getMax() {
        return max;
    }

    public void setMax(String max) {
        this.max = max;
    }

    public String getMedian() {
        return median;
    }

    public void setMedian(String median) {
        this.median = median;
    }

    public String getFootnote() {
        return footnote;
    }

    public void setFootnote(String footnote) {
        this.footnote = footnote;
    }

    public String getMinYearAcqured() {
        return minYearAcqured;
    }

    public void setMinYearAcqured(String minYearAcqured) {
        this.minYearAcqured = minYearAcqured;
    }
}
