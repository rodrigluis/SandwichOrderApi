package be.abis.sandwich.service;

import be.abis.sandwich.model.Sandwich;

import java.util.List;

public interface SandwichService {
    List<Sandwich> getAllSandwiches();
    Sandwich findSandwichById(int id);
}
