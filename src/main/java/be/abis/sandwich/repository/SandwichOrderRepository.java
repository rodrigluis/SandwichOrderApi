package be.abis.sandwich.repository;

import be.abis.sandwich.model.SandwichOrder;

public interface SandwichOrderRepository {
    SandwichOrder createSandwichOrder(SandwichOrder sandwichOrder);
    SandwichOrder updateSandwichOrder(SandwichOrder sandwichOrder);
    void deleteSandwichOrder(int sandwichOrderId);
    SandwichOrder findSandwichOrderById(int sandwichOrderId);
}
