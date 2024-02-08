package be.abis.sandwich.controller;

import be.abis.sandwich.model.SandwichOrder;
import be.abis.sandwich.service.SandwichOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("sandwichOrder")
public class SandwichOrderController {
    @Autowired
    private SandwichOrderService sandwichService;

    @GetMapping(path="{id}")
    public ResponseEntity<? extends Object> findSandwichOrder(@PathVariable("id")int id) {
        SandwichOrder sandwichOrder = null;

        sandwichOrder = sandwichService.findSandwichOrder(id);
        return new ResponseEntity<>(sandwichOrder, HttpStatus.OK);

    }

    @PostMapping(path="")
    public void addPerson (@RequestBody SandwichOrder sandwichOrder)  {
            sandwichService.createSandwichOrder(sandwichOrder);
    }
}
