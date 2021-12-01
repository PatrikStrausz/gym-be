package sk.kosickaakademia.strausz.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import sk.kosickaakademia.strausz.api.rest.GenericListDto;
import sk.kosickaakademia.strausz.api.rest.MineralDto;
import sk.kosickaakademia.strausz.service.MineralService;

@RestController
@RequestMapping("/api")
public class MineralController {

    private final MineralService mineralService;

    public MineralController(MineralService mineralService) {
        this.mineralService = mineralService;
    }

    @GetMapping(path = "/mineral")
    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_USER')")
    public GenericListDto<MineralDto> getMinerals(@RequestParam(defaultValue = "0", required = false) int page) {

        return mineralService.getMinerals(page);
    }

    @GetMapping("/mineral/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_USER')")
    public MineralDto getMineralById(@PathVariable int id) {

        return mineralService.getMineralById(id);


    }
}
