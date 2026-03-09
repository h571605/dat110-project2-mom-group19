package no.hvl.dat110.iotsystem;

import no.hvl.dat110.client.Client;
import no.hvl.dat110.common.TODO;

public class TemperatureDevice {

	private static final int COUNT = 10;

	public static void main(String[] args) {

		// simulated / virtual temperature sensor
		TemperatureSensor sn = new TemperatureSensor();

		// TODO - start

		String user = "sensor";
		String topic = Common.TEMPTOPIC;

		Client client = new Client(user, Common.BROKERHOST, Common.BROKERPORT);

		client.connect();

		for (int i = 0; i < COUNT; i++) {
			int temp = sn.read();
			client.publish(topic, String.valueOf(temp));
		}

		// Disconnect from broker
		client.disconnect();

		// create a client object and use it to

		// - connect to the broker - user "sensor" as the user name
		// - publish the temperature(s)
		// - disconnect from the broker

		// TODO - end

		System.out.println("Temperature device stopping ... ");

	}
}
