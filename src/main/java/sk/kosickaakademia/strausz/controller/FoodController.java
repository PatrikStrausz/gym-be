package sk.kosickaakademia.strausz.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import sk.kosickaakademia.strausz.api.rest.*;
import sk.kosickaakademia.strausz.service.FoodService;

@RestController
@RequestMapping("/api")
public class FoodController {


    private final FoodService foodService;


    public FoodController(FoodService foodService) {
        this.foodService = foodService;
    }


    @GetMapping(path = "/food")
    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_USER')")
    public GenericListDto<FoodListDto> getFoods(@RequestParam(defaultValue = "0", required = false) int page) {
        return foodService.getFoods(page);
    }

    @GetMapping("/food/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_USER')")
    public FoodDto getFood(@PathVariable long id) {

        return foodService.getFoodById(id);


    }

    @GetMapping(path = "/food/by/user/details/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_USER')")
    public GenericListDto<FoodDto> getFoodsByUserDetails(@PathVariable int id) {
        return foodService.getFoodsByUserDetails(id);
    }


    @GetMapping(path = "/food/by/date/{userDetailsId}/{date}")
    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_USER')")
    public GenericListDto<FoodNutrientsDto> getAllFoodsByDate(@PathVariable int userDetailsId, @PathVariable String date) {
        return foodService.findAllFoodsByDate(userDetailsId, date);
    }

    @GetMapping(path = "/food/by/user/details/id/{userDetailsId}")
    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_USER')")
    public GenericListDto<UserFoodDetailsDto> getAllFoodsByUserDetailsId(@PathVariable int userDetailsId) {
        return foodService.findAllFoodsByUserDetailsId(userDetailsId);
    }


    @GetMapping(path = "/food/by/page")
    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_USER')")
    public GenericListDto<FoodDto> getExercisesByPage(int pageIndex, int pageSize) {
        return foodService.getAllFoodsByPage(pageIndex, pageSize);
    }


}
