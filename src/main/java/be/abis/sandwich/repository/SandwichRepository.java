package be.abis.sandwich.repository;

import be.abis.sandwich.model.Sandwich;

import java.io.IOException;
import java.util.List;

public interface SandwichRepository {

    List<Sandwich> findAllSandwiches();
    Sandwich findSandwichById(int id);
    Sandwich findSandwichByName(String name);
    List<Sandwich> findSandwichesByCategory(String category) ;
    void addSandwich(Sandwich sandwich);
    void updatePrice(Sandwich sandwich);
    void deleteSandwich(int id);

}
