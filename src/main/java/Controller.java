import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;
import util.Response;

import java.time.LocalDateTime;
import java.util.UUID;

/**
 * Created by KURZRO on 09.03.2017.
 */
@org.springframework.stereotype.Controller
@EnableAutoConfiguration
public class Controller {

        int callCounter = 0;
        boolean killHealth = false;
        boolean suspendHealth = false;
        UUID uuid = UUID.randomUUID();
        RestTemplate request = new RestTemplate();

        @RequestMapping("/")
        @ResponseBody
        Response home() {
            callCounter += 1;
            return createResponse("/", "Hello World!");
        }

        @RequestMapping("/killProcess")
        @ResponseBody
        String killProcess(){
            System.exit(0);
            return "killed process";
        }

        @RequestMapping("/killHealth")
        @ResponseBody
        Response killHealth(){
            killHealth = true;
            return createResponse("/killHealth", "health will be killed");
        }

        @RequestMapping("/suspendHealth")
        @ResponseBody
        Response suspendHealth(){
            suspendHealth = true;
            return createResponse("/suspendHealth", "health will be suspended");
        }

        @RequestMapping("/healthz")
        @ResponseBody
        ResponseEntity<Response> healthZ(){
            if( killHealth )
            {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(createResponse("/healthz", "dead"));
            }
            else if( suspendHealth ){
                while(true){
                    System.out.println("Waiting to be killed...");
                }
            }
            System.out.println("Healthcheck");
            return ResponseEntity.ok(createResponse("/healthz", "healthy"));
        }

        @RequestMapping("/alive")
        @ResponseBody
        Response alive(){
            return createResponse("/alive", "alive");
        }

        @RequestMapping("/loadBalancing")
        @ResponseBody
        Response loadBalancing(){
            return createResponse("/loadBalancing", "load balancing");
        }

        @RequestMapping("/generateWorkload")
        @ResponseBody
        Response generateWorkload(){
            Load load = new Load();
            load.generateHighWorkload();
            return createResponse("/generateWorkload", "generating load...");
        }

        public static void main(String[] args) throws Exception {
            SpringApplication.run(Controller.class, args);
        }

        private Response createResponse(String endpoint, String message){

            return new Response(
                    uuid.toString(),
                    endpoint,
                    request.getForObject("http://api.ipify.org", String.class),
                    message,
                    System.getenv().toString()
            );
        }
}
