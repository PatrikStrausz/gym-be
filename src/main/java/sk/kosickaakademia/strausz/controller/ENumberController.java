package sk.kosickaakademia.strausz.controller;


import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import sk.kosickaakademia.strausz.api.rest.ENumberDto;
import sk.kosickaakademia.strausz.api.rest.GenericListDto;
import sk.kosickaakademia.strausz.service.ENumberService;

@RestController
@RequestMapping("/api")
public class ENumberController {

    private final ENumberService eNumberService;

    public ENumberController(ENumberService eNumberService) {
        this.eNumberService = eNumberService;
    }


    @GetMapping(path = "/enumber")
    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_USER')")
    public GenericListDto<ENumberDto> getENumber(@RequestParam(defaultValue = "0", required = false) int page) {

        return eNumberService.getENumbers(page);
    }

    @GetMapping("/enumber/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_USER')")
    public ENumberDto getENumberById(@PathVariable int id) {

        return eNumberService.getENumberById(id);


    }
}
