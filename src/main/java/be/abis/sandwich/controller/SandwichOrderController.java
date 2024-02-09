package be.abis.sandwich.controller;

import be.abis.sandwich.model.SandwichOrder;
import be.abis.sandwich.service.SandwichOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

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
    public void createSandwichOrder (@RequestBody SandwichOrder sandwichOrder)  {
        sandwichService.createSandwichOrder(sandwichOrder);
    }

    @GetMapping(path="{id}/calculatePrice")
    public ResponseEntity<? extends Object> calculatePrice(@PathVariable("id")int id) {
        SandwichOrder sandwichOrder = sandwichService.findSandwichOrder(id);
        double calculatedPrice = sandwichService.calculateSandwichOrderPrice(sandwichOrder);
        return new ResponseEntity<>(calculatedPrice, HttpStatus.OK);
    }

    @GetMapping(path="{id}/print")
    public ResponseEntity<? extends Object> printOrder(@PathVariable("id")int id)  {
        SandwichOrder sandwichOrder = sandwichService.findSandwichOrder(id);
        sandwichService.printSandwichOrder(sandwichOrder);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
