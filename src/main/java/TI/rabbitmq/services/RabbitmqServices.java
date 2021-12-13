package TI.rabbitmq.services;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.DeliverCallback;

import TI.rabbitmq.model.Pedido;

public class RabbitmqServices {
	private final static String QUEUE_NAME = "Fila_do_inss";
	private final static String HOST = "localhost";
	private final static String USERNAME = "rabbitmq";
	private final static String PASSWORD = "rabbitmq";
	private final static int PORT = 5672;

	public void rabbitmqPublish(Pedido pedido) throws IOException, TimeoutException {
		ConnectionFactory factory = new ConnectionFactory();
		factory.setHost(HOST);
		factory.setPort(PORT);
		factory.setUsername(USERNAME);
		factory.setPassword(PASSWORD);
		Connection connection = factory.newConnection();
		Channel channel = connection.createChannel();
		System.out.println(connection.isOpen());
		// Define a fila

		channel.queueDeclare(QUEUE_NAME, false, false, false, null);
		// Define msg

		String message = pedido.toString();
		;

		channel.basicPublish("", QUEUE_NAME, null, message.getBytes());
		System.out.println(" [x] Sent '" + message + "'");

		channel.close();
		connection.close();

	}

	public void rabbitmqConsumer() throws IOException, TimeoutException {
		ConnectionFactory factory = new ConnectionFactory();
		factory.setHost(HOST);
		factory.setPort(PORT);
		factory.setUsername(USERNAME);
		factory.setPassword(PASSWORD);
		Connection connection = factory.newConnection();
		Channel channel = connection.createChannel();

		channel.queueDeclare(QUEUE_NAME, false, false, false, null);
		System.out.println(" [*] Waiting for messages. To exit press CTRL+C");

		DeliverCallback deliverCallback = (consumerTag, delivery) -> {
			String message = new String(delivery.getBody(), StandardCharsets.UTF_8);
			System.out.println(" [x] Received '" + message + "'");
		};
		channel.basicConsume(QUEUE_NAME, true, deliverCallback, consumerTag -> {
		});

	}
}
