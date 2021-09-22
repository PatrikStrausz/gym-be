package sk.kosickaakademia.strausz.api.rest;

import javax.validation.constraints.NotNull;

public class GenericListDto<T> {

    @NotNull(message = "data.cannot.be.null")
    private T data;

    public GenericListDto() {
    }

    public GenericListDto(@NotNull(message = "data.cannot.be.null") T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
