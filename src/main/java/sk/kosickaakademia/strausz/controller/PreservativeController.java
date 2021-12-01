package sk.kosickaakademia.strausz.controller;


import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import sk.kosickaakademia.strausz.api.rest.GenericListDto;
import sk.kosickaakademia.strausz.api.rest.PreservativeDto;
import sk.kosickaakademia.strausz.service.PreservativeService;

@RestController
@RequestMapping("/api")
public class PreservativeController {

    private final PreservativeService preservativeService;

    public PreservativeController(PreservativeService preservativeService) {
        this.preservativeService = preservativeService;
    }


    @GetMapping(path = "/preservative")
    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_USER')")
    public GenericListDto<PreservativeDto> getENumber(@RequestParam(defaultValue = "0", required = false) int page) {

        return preservativeService.getENumbers(page);
    }

    @GetMapping("/preservative/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_USER')")
    public PreservativeDto getENumberById(@PathVariable int id) {

        return preservativeService.getENumberById(id);


    }
}
