package be.abis.sandwich.service;

import be.abis.sandwich.enumeration.BreadType;
import be.abis.sandwich.model.Sandwich;
import be.abis.sandwich.model.SandwichOrder;
import be.abis.sandwich.model.SandwichOrderDetail;
import be.abis.sandwich.repository.SandwichOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;

@Service
public class AbisSandwichOrderService implements SandwichOrderService {
    final static double PRICE_BROWN_SUPPLEMENT = 0.1;
    final static double VEGETABLE_SUPPLEMENT = 0.2;

    @Autowired
    SandwichOrderRepository sandwichOrderRepository;

    @Autowired
    SandwichService sandwichService;

    @Autowired
    CourseService courseService;

    @Autowired
    PersonService personService;


    @Override
    public SandwichOrder createSandwichOrder(SandwichOrder sandwichOrder) {

        SandwichOrder createdSandwichOrder = sandwichOrderRepository.createSandwichOrder(sandwichOrder);
        return createdSandwichOrder;
    }

    @Override
    public void printSandwichOrder(SandwichOrder so) {
        String fileName = "C:\\temp\\SandwichOrder_" + so.getId();
        BufferedWriter writer = null;
        try {
            writer = new BufferedWriter(new FileWriter(fileName, true));
            writer.append(so.toString());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //close resources
            try {
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    @Override
    public double calculateSandwichOrderPrice(SandwichOrder so) {
        double sandwichOrderPrice = 0;
        Sandwich sandwich = null;
        double orderPrice = 0;

        for (SandwichOrderDetail detail:so.getSandwichOrderDetails()) {
            sandwich = sandwichService.findSandwichById(detail.getSandwichId());
            orderPrice = orderPrice + sandwich.getBasePrice() * detail.getAmount();
            if (BreadType.BROWN.equals(detail.getBreadType())) {
                orderPrice = orderPrice + PRICE_BROWN_SUPPLEMENT * detail.getAmount();
            }
            if (detail.isVegetables()) {
                orderPrice = orderPrice + VEGETABLE_SUPPLEMENT * detail.getAmount();
            }
        }

        so.setTotalCost(BigDecimal.valueOf(orderPrice));
        sandwichOrderRepository.updateSandwichOrder(so);

        return sandwichOrderPrice;

    }

    @Override
    public SandwichOrder findSandwichOrder(int id) {
       return sandwichOrderRepository.findSandwichOrderById(id);
    }
}
