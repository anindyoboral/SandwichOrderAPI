package be.abis.sandwich.repository;

import be.abis.sandwich.exception.SandwichAlreadyExistsException;
import be.abis.sandwich.exception.SandwichNotFoundException;
import be.abis.sandwich.model.SandwichOrderDetail;

import java.util.List;

public interface SandwichOrderDetailRepository {
    void addSandwichOrderDetail(SandwichOrderDetail sod) throws SandwichAlreadyExistsException;
    List<SandwichOrderDetail> findSandwichorderDetailsBySandwichOrderId(int id) throws SandwichNotFoundException;


}
