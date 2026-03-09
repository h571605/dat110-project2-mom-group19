package no.hvl.dat110.iotsystem;

import no.hvl.dat110.client.Client;
import no.hvl.dat110.messages.Message;
import no.hvl.dat110.messages.PublishMsg;
import no.hvl.dat110.common.TODO;

public class DisplayDevice {
	
	private static final int COUNT = 10;
		
	public static void main (String[] args) {

		String user = "display";
		String topic = Common.TEMPTOPIC;
		
		// TODO - START
		Client client = new Client(user, Common.BROKERHOST, Common.BROKERPORT);

		client.connect();

		client.createTopic(topic);

		client.subscribe(topic);

		int received = 0;
		while(received < COUNT) {
			Message msg = client.receive();
			if(msg instanceof PublishMsg) {
				System.out.println("DISPLAY: " + ((PublishMsg) msg).getMessage());
				received++;
			}
		}

		client.unsubscribe(topic);
		client.disconnect();
		// create a client object and use it to
		
		// - connect to the broker - use "display" as the username
		// - create the temperature topic on the broker
		// - subscribe to the topic
		// - receive messages on the topic
		// - unsubscribe from the topic
		// - disconnect from the broker

		// TODO - END
		
		System.out.println("Display stopping ... ");
		
	}
}
