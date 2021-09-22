package sk.kosickaakademia.strausz.exception;

public class FoodNotFoundException extends Exception{

    private int id;



    public static FoodNotFoundException createWith(int id){
        return  new FoodNotFoundException(id);
    }

    public FoodNotFoundException(int id) {
        this.id = id;

    }


    @Override
    public String getMessage() {
        return "Food : [" +id +"] not found" ;
    }
}
