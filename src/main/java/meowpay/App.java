package meowpay;

import meowpay.restcontroller.meow.Meow;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;

import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
public class App {
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
        RestService restService = new RestService(new RestTemplateBuilder());
        // create a map for post parameters
        Map<String, Object> map = new HashMap<>();
        map.put("meow", new Meow(1));
        map.put("description", "Introduction to Spring Boot");
        map.put("total_amount", 123);
        map.put("status",0);

        //System.out.println(restService.postRequest("http://127.0.0.1:8080/claim", Meow.class, map));

    }
}
