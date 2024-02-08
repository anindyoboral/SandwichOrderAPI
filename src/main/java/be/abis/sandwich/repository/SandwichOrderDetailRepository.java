package be.abis.sandwich.repository;

import be.abis.sandwich.model.SandwichOrderDetail;

import java.util.List;

public interface SandwichOrderDetailRepository {
    void addSandwichOrderDetail(SandwichOrderDetail sod);
    List<SandwichOrderDetail> findSandwichorderDetailsById(int id);


}
