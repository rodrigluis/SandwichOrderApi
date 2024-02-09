package be.abis.sandwich.dao.repository;


import be.abis.sandwich.dao.entities.SandwichOrderEntity;
import be.abis.sandwich.model.SandwichOrder;
import org.springframework.data.repository.CrudRepository;

public interface JpaSandwichOrderRepository extends CrudRepository<SandwichOrderEntity, Integer> {
    SandwichOrderEntity findById(int sandwichOrderId);
}
