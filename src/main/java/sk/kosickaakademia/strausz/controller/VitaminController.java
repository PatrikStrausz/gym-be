package sk.kosickaakademia.strausz.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import sk.kosickaakademia.strausz.api.rest.GenericListDto;
import sk.kosickaakademia.strausz.api.rest.VitaminDto;
import sk.kosickaakademia.strausz.service.VitaminService;

@RestController
@RequestMapping("/api")
public class VitaminController {

    private final VitaminService vitaminService;

    public VitaminController(VitaminService vitaminService) {
        this.vitaminService = vitaminService;
    }


    @GetMapping(path = "/vitamin")
    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_USER')")
    public GenericListDto<VitaminDto> getVitamins(@RequestParam(defaultValue = "0", required = false) int page) {

        return vitaminService.getVitamins(page);
    }

    @GetMapping("/vitamin/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_USER')")
    public VitaminDto getVitaminById(@PathVariable int id) {

        return vitaminService.getVitaminById(id);


    }

}
