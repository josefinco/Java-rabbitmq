package TI.rabbitmq;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import TI.rabbitmq.services.RabbitmqServices;

public class App {
	public static void main(String[] args) throws IOException, TimeoutException, InterruptedException {

		RabbitmqServices service = new RabbitmqServices();


        service.rabbitmqConsumer();
        
        
//		try {
//			ObjectMapper om = new ObjectMapper();
//			Pedido root = om.readValue(new File("test-json.json"), Pedido.class);
//
//			System.out.println(root.toString());
//			
//			service.rabbitmqPublish(root);
//			
//			
//		} catch (Exception e) {
//			e.printStackTrace();
//		}

	}

}
