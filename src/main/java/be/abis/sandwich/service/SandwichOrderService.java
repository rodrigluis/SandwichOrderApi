package be.abis.sandwich.service;

import be.abis.sandwich.model.SandwichOrder;
import be.abis.sandwich.model.SandwichOrderDetail;

import java.io.IOException;

public interface SandwichOrderService {
    SandwichOrder createSandwichOrder(SandwichOrder sandwichOrder);
    void printSandwichOrder(SandwichOrder so) throws IOException;
    double calculateSandwichOrderPrice(SandwichOrder so);

    SandwichOrder findSandwichOrder(int id);
}
