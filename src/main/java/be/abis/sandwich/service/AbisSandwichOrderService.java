package be.abis.sandwich.service;

import be.abis.sandwich.model.Sandwich;
import be.abis.sandwich.model.SandwichOrder;
import be.abis.sandwich.model.SandwichOrderDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class AbisSandwichOrderService implements SandwichOrderService{


    @Autowired
    private RestTemplate rt;
    private String baseUri= "http://localhost:8080/sandwiches/api";
    private static String apiKey=null;


    @Override
    public List<Sandwich> findAllSandwiches()  {
        ResponseEntity<? extends Object> re = null;
        List<Sandwich> sandwich=null;
        re =  rt.exchange(baseUri+"/all", HttpMethod.GET,null,new ParameterizedTypeReference<List<Sandwich>>(){});
        sandwich = (List<Sandwich>) re.getBody();

        return sandwich;
    }

    @Override
    public void addSandwichOrderDetail(SandwichOrderDetail sod) {

    }

    @Override
    public void printSandwichOrder(SandwichOrder so) {

    }

    @Override
    public double calculateSandwichOrderPrice(SandwichOrder so) {
        return 0;
    }
}
