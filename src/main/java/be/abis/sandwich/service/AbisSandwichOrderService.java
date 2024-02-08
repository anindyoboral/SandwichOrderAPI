package be.abis.sandwich.service;

import be.abis.sandwich.enumeration.BreadType;
import be.abis.sandwich.model.Person;
import be.abis.sandwich.model.Sandwich;
import be.abis.sandwich.model.SandwichOrder;
import be.abis.sandwich.model.SandwichOrderDetail;
import be.abis.sandwich.repository.SandwichOrderDetailRepository;
import be.abis.sandwich.repository.SandwichOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.List;

@Service
public class AbisSandwichOrderService implements SandwichOrderService{


    @Autowired
    private RestTemplate rt;
    private String baseUri= "http://localhost:8080/sandwiches/api";
    private static String apiKey=null;

    @Autowired
    SandwichOrderRepository sor;

    @Autowired
    SandwichOrderDetailRepository sodr;

    @Autowired
    PersonService personService;

    @Autowired
    CourseService courseService;

    @Override
    public List<Sandwich> findAllSandwiches()  {
        ResponseEntity<? extends Object> re = null;
        List<Sandwich> sandwich=null;
        re =  rt.exchange(baseUri+"/all", HttpMethod.GET,null,new ParameterizedTypeReference<List<Sandwich>>(){});
        sandwich = (List<Sandwich>) re.getBody();

        return sandwich;
    }

    @Override
    public Sandwich findSandwichByName(String name) {
        ResponseEntity<? extends Object> re = null;
        Sandwich sandwich=null;
        re =rt.getForEntity(baseUri+"/api/sandwichname/"+ name,Sandwich.class);
        Sandwich p = (Sandwich) re.getBody();
        return sandwich;
    }



    @Override
    public void addSandwichOrderDetail(SandwichOrderDetail sod) {
        sodr.addSandwichOrderDetail(sod);

    }

    @Override
    public void printSandwichOrder(SandwichOrder so) {

        List<SandwichOrderDetail> sodl = sodr.findSandwichorderDetailsBySandwichOrderId(so.getId());
        for (SandwichOrderDetail sod : sodl) {
            System.out.println(sod.toString());
        }
    }

    @Override
    public float calculateSandwichOrderPrice(SandwichOrder so) {
            float totalPrice= 0;
            Sandwich sandwich = new Sandwich();

        List <SandwichOrderDetail> sodl = sodr.findSandwichorderDetailsBySandwichOrderId(so.getId());
        for (SandwichOrderDetail sod : sodl) {
            float unitPrice = 0;
             unitPrice+= findSandwichByName(sod.getSandwich().getName()).getBasePrice();
            if( sod.getBreadType().equals(BreadType.BROWN)){
                unitPrice+= 0.1;
            }
            if(sod.isVegetables()){
                unitPrice+= 0.1;
            }
            unitPrice*= sod.getAmount();
            totalPrice+=unitPrice;
        }
        return totalPrice;
    }
}
