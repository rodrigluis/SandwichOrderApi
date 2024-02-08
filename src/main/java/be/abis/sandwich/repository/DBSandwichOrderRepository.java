package be.abis.sandwich.repository;

import be.abis.sandwich.model.SandwichOrder;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Repository;

@Repository
public class DBSandwichOrderRepository implements SandwichOrderRepository {
    @Resource
    JpaSandwichOrderRepository jpaSandwichOrderRepository;

    @Override
    public SandwichOrder createSandwichOrder(SandwichOrder sandwichOrder) {
        return jpaSandwichOrderRepository.save(sandwichOrder);
    }

    @Override
    public SandwichOrder updateSandwichOrder(SandwichOrder sandwichOrder) {
        return jpaSandwichOrderRepository.save(sandwichOrder);
    }

    @Override
    public void deleteSandwichOrder(int sandwichOrderId) {
        jpaSandwichOrderRepository.deleteById(sandwichOrderId);
    }

    @Override
    public SandwichOrder findSandwichOrderById(int sandwichOrderId) {
        return jpaSandwichOrderRepository.findById(sandwichOrderId);
    }
}