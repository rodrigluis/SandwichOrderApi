package be.abis.sandwich.repository;


import be.abis.sandwich.model.SandwichOrder;
import org.springframework.data.repository.CrudRepository;

public interface JpaSandwichOrderRepository extends CrudRepository<SandwichOrder, Integer> {
    SandwichOrder findById(int sandwichOrderId);
}
