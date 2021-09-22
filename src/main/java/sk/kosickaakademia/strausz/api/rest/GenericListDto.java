package sk.kosickaakademia.strausz.api.rest;

import javax.validation.constraints.NotNull;
import java.util.List;

public class GenericListDto<T> {

    @NotNull(message = "data.cannot.be.null")
    private List<T> data;

    public GenericListDto() {
    }

    public GenericListDto(List<T> data) {
        this.data = data;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }
}
