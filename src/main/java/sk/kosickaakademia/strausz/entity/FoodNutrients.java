package sk.kosickaakademia.strausz.entity;

import javax.persistence.*;

@Entity(name = "food_nutrient")
public class FoodNutrients {

    @Id
    private int id;

    private int fdc_id;

    private int nutrient_id;

    private double amount;

    private String data_points;

    private String derivation_id;

    private String min;

    private String max;

    private String median;

    private String footnote;

    private String min_year_acqured;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getFdc_id() {
        return fdc_id;
    }

    public void setFdc_id(int fdc_id) {
        this.fdc_id = fdc_id;
    }

    public int getNutrient_id() {
        return nutrient_id;
    }

    public void setNutrient_id(int nutrient_id) {
        this.nutrient_id = nutrient_id;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getData_points() {
        return data_points;
    }

    public void setData_points(String data_points) {
        this.data_points = data_points;
    }

    public String getDerivation_id() {
        return derivation_id;
    }

    public void setDerivation_id(String derivation_id) {
        this.derivation_id = derivation_id;
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

    public String getMin_year_acqured() {
        return min_year_acqured;
    }

    public void setMin_year_acqured(String min_year_acqured) {
        this.min_year_acqured = min_year_acqured;
    }

    @Override
    public String toString() {
        return "FoodNutrients{" +
                "id=" + id +
                ", fdc_id=" + fdc_id +
                ", nutrient_id=" + nutrient_id +
                ", amount=" + amount +
                ", data_points='" + data_points + '\'' +
                ", derivation_id='" + derivation_id + '\'' +
                ", min='" + min + '\'' +
                ", max='" + max + '\'' +
                ", median='" + median + '\'' +
                ", footnote='" + footnote + '\'' +
                ", min_year_acqured='" + min_year_acqured + '\'' +
                '}';
    }
}
