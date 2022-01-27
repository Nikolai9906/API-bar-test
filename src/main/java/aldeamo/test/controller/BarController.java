package aldeamo.test.controller;

import aldeamo.test.service.BarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping()
public class BarController {
    private final BarService barService;

    public BarController(@Autowired BarService barService) {
        this.barService = barService;
    }

    @GetMapping("/operation")
    @ResponseBody

    public List<Integer> create(@RequestParam (name = "iteration", value = "iteration") int iteration, @RequestParam (name = "idArray", value = "idArray") int idArray ) {
            return barService.primeOperation(iteration,idArray);

    }
}
