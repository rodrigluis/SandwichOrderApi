package be.abis.sandwich.service;

import be.abis.sandwich.enumeration.BreadType;
import be.abis.sandwich.model.Sandwich;
import be.abis.sandwich.model.SandwichOrder;
import be.abis.sandwich.model.SandwichOrderDetail;
import be.abis.sandwich.repository.SandwichOrderRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.BufferedWriter;
import java.io.File;
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

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());

        try {
            objectMapper.writeValue(new File("C:\\temp\\SandwichOrder_" + so.getId()), so);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        /*
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
*/
    }

    @Override
    public double calculateSandwichOrderPrice(SandwichOrder so) {
        Sandwich sandwich = null;
        double orderPrice = 0;

        for (SandwichOrderDetail detail:so.getSandwichOrderDetails()) {
            sandwich = sandwichService.findSandwichById(detail.getSandwich().getId());
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

        return orderPrice;

    }

    @Override
    public SandwichOrder findSandwichOrder(int id) {
       SandwichOrder sandwichOrder = sandwichOrderRepository.findSandwichOrderById(id);
       Sandwich sandwich = null;
       for (SandwichOrderDetail sandwichOrderDetail : sandwichOrder.getSandwichOrderDetails()) {
           sandwich = sandwichService.findSandwichById(sandwichOrderDetail.getSandwich().getId());
           sandwichOrderDetail.setSandwich(sandwich);
       }
       return sandwichOrder;
    }
}
