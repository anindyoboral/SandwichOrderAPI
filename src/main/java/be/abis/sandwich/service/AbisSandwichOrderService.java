package be.abis.sandwich.service;

import be.abis.sandwich.enumeration.BreadType;
import be.abis.sandwich.model.Sandwich;
import be.abis.sandwich.model.SandwichOrder;
import be.abis.sandwich.model.SandwichOrderDetail;
import be.abis.sandwich.repository.SandwichOrderDetailRepository;
import be.abis.sandwich.repository.SandwichOrderRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

@Service
public class AbisSandwichOrderService implements SandwichOrderService {



    @Autowired
    private RestTemplate rt;
    @Value("${filepath.jsonOrder}")
    private String fileName;
    //@Value("${sandwichapi.hostnamelist}")
    //private String[] sandwichApiHostname = {"ws94wo93.abis.be","ws94wo94.abis.be"}; //HAHAHA issue with DNS names
    private String[] sandwichApiHostname = {"10.24.234.253","10.24.234.233","localhost"};
    private String baseUri = "http://" + sandwichApiHostname[2] + ":8080/sandwiches/api";
    private static String apiKey = null;

    @Autowired
    SandwichOrderRepository sor;

    @Autowired
    SandwichOrderDetailRepository sodr;

    @Autowired
    PersonService personService;

    @Autowired
    CourseService courseService;

    @Override
    public List<Sandwich> findAllSandwiches() {
        ResponseEntity<? extends Object> re = null;
        List<Sandwich> sandwich = null;
        re = rt.exchange(baseUri + "/all", HttpMethod.GET, null, new ParameterizedTypeReference<List<Sandwich>>() {
        });
        sandwich = (List<Sandwich>) re.getBody();

        return sandwich;
    }

    @Override
    public Sandwich findSandwichByName(String name) {
        //ResponseEntity<? extends Object> re = null;
        //Sandwich sandwich=null;
        Sandwich p = rt.getForObject(baseUri + "/sandwichname/" + name, Sandwich.class);
        //Sandwich p = (Sandwich) re.getBody();
        return p;
    }


    @Override
    public void addSandwichOrderDetail(SandwichOrderDetail sod) {
        sodr.addSandwichOrderDetail(sod);

    }

    @Override
    public void printSandwichOrder(SandwichOrder so) {
        List<SandwichOrderDetail> sodl = sodr.findSandwichorderDetailsBySandwichOrderId(so.getId());
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        String json = null;
        try {
            json = ow.writeValueAsString(sodl);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        try {
            FileOutputStream outputStream = null;
            outputStream = new FileOutputStream(fileName);
            byte[] strToBytes = json.getBytes();
            outputStream.write(strToBytes);
            outputStream.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public float calculateSandwichOrderPrice(SandwichOrder so) {
        float totalPrice = 0;
        Sandwich sandwich = new Sandwich();

        List<SandwichOrderDetail> sodl = sodr.findSandwichorderDetailsBySandwichOrderId(so.getId());
        for (SandwichOrderDetail sod : sodl) {
            float unitPrice = 0;
            unitPrice += findSandwichByName(sod.getSandwich().getName()).getBasePrice();
            if (sod.getBreadType().equals(BreadType.BROWN)) {
                unitPrice += 0.1;
            }
            if (sod.isVegetables()) {
                unitPrice += 0.1;
            }
            unitPrice *= sod.getAmount();
            totalPrice += unitPrice;
        }
        sor.setTotalForOrder(so,totalPrice);
        return totalPrice;
    }
}
