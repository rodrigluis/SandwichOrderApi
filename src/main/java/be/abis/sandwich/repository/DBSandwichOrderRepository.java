package be.abis.sandwich.repository;

import be.abis.sandwich.dao.entities.CourseEntity;
import be.abis.sandwich.dao.entities.PersonEntity;
import be.abis.sandwich.dao.entities.SandwichOrderDetailEntity;
import be.abis.sandwich.dao.entities.SandwichOrderEntity;
import be.abis.sandwich.dao.repository.JpaSandwichOrderRepository;
import be.abis.sandwich.model.*;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Repository;

@Repository
public class DBSandwichOrderRepository implements SandwichOrderRepository {
    @Resource
    JpaSandwichOrderRepository jpaSandwichOrderRepository;

    @Override
    public SandwichOrder createSandwichOrder(SandwichOrder sandwichOrder) {
        return toSandwichOrder(jpaSandwichOrderRepository.save(toSandwichOrderEntity(sandwichOrder)));
    }

    @Override
    public SandwichOrder updateSandwichOrder(SandwichOrder sandwichOrder) {
        return toSandwichOrder(jpaSandwichOrderRepository.save(toSandwichOrderEntity(sandwichOrder)));
    }

    @Override
    public void deleteSandwichOrder(int sandwichOrderId) {
        jpaSandwichOrderRepository.deleteById(sandwichOrderId);
    }

    @Override
    public SandwichOrder findSandwichOrderById(int sandwichOrderId) {
        return toSandwichOrder(jpaSandwichOrderRepository.findById(sandwichOrderId));
    }

    private SandwichOrder toSandwichOrder(SandwichOrderEntity sandwichOrderEntity) {
            SandwichOrder sandwichOrder = new SandwichOrder();
            sandwichOrder.setId(sandwichOrderEntity.getId());
            sandwichOrder.setOrderDate(sandwichOrderEntity.getOrderDate());
            sandwichOrder.setTotalCost(sandwichOrderEntity.getTotalCost());
            sandwichOrder.setCourse(toCourse(sandwichOrderEntity.getCourse()));
            for (SandwichOrderDetailEntity sandwichOrderDetailEntity : sandwichOrderEntity.getSandwichOrderDetails()) {
                SandwichOrderDetail sandwichOrderDetail = new SandwichOrderDetail();
                sandwichOrderDetail.setId(sandwichOrder.getId());
                Sandwich sandwich = new Sandwich();
                sandwich.setId(sandwichOrderDetailEntity.getSandwichId());
                sandwichOrderDetail.setSandwich(sandwich);
                sandwichOrderDetail.setAmount(sandwichOrderDetailEntity.getAmount());
                sandwichOrderDetail.setComments(sandwichOrderDetailEntity.getComments());
                sandwichOrderDetail.setBreadType(sandwichOrderDetailEntity.getBreadType());
                sandwichOrderDetail.setVegetables(sandwichOrderDetailEntity.isVegetables());
                sandwichOrderDetail.setPerson(toPerson(sandwichOrderDetailEntity.getPerson()));

                sandwichOrder.getSandwichOrderDetails().add(sandwichOrderDetail);
            }
            return sandwichOrder;
        }

    private SandwichOrderEntity toSandwichOrderEntity(SandwichOrder sandwichOrder) {
        SandwichOrderEntity sandwichOrderEntity = new SandwichOrderEntity();
        sandwichOrderEntity.setId(sandwichOrder.getId());
        sandwichOrderEntity.setOrderDate(sandwichOrder.getOrderDate());
        sandwichOrderEntity.setTotalCost(sandwichOrder.getTotalCost());
        sandwichOrderEntity.setCourse(toCourseEntity(sandwichOrder.getCourse()));

        for (SandwichOrderDetail sandwichOrderDetail : sandwichOrder.getSandwichOrderDetails()) {
            SandwichOrderDetailEntity sandwichOrderDetailEntity = new SandwichOrderDetailEntity();
            sandwichOrderDetailEntity.setId(sandwichOrderEntity.getId());
            sandwichOrderDetailEntity.setSandwichOrder(sandwichOrderEntity);
            sandwichOrderDetailEntity.setSandwichId(sandwichOrderDetail.getSandwich().getId());
            sandwichOrderDetailEntity.setAmount(sandwichOrderDetail.getAmount());
            sandwichOrderDetailEntity.setComments(sandwichOrderDetail.getComments());
            sandwichOrderDetailEntity.setBreadType(sandwichOrderDetail.getBreadType());
            sandwichOrderDetailEntity.setVegetables(sandwichOrderDetail.isVegetables());
            sandwichOrderDetailEntity.setPerson(toPersonEntity(sandwichOrderDetail.getPerson()));

            sandwichOrderEntity.getSandwichOrderDetails().add(sandwichOrderDetailEntity);
        }
        return sandwichOrderEntity;
    }

    private PersonEntity toPersonEntity(Person person) {
        PersonEntity personEntity = new PersonEntity();
        personEntity.setId(person.getId());
        personEntity.setFirstName(person.getFirstName());
        personEntity.setLastName(person.getLastName());
        return personEntity;
    }

    private Person toPerson(PersonEntity personEntity) {
        Person person = new Person();
        person.setId(personEntity.getId());
        person.setFirstName(personEntity.getFirstName());
        person.setLastName(personEntity.getLastName());
        return person;
    }

    private CourseEntity toCourseEntity(Course course) {
        CourseEntity courseEntity = new CourseEntity();
        courseEntity.setId(course.getId());
        courseEntity.setTitle(course.getTitle());
        return courseEntity;
    }

    private Course toCourse(CourseEntity courseEntity) {
        Course course = new Course();
        course.setId(courseEntity.getId());
        course.setTitle(courseEntity.getTitle());
        return course;
    }

}