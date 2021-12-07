package sk.kosickaakademia.strausz.api.rest;

import java.util.List;

public class GenericListDto<T> {

    private List<T> data;

    private Long totalElements;

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

    public Long getTotalElements() {
        return totalElements;
    }

    public void setTotalElements(Long totalElements) {
        this.totalElements = totalElements;
    }
}
