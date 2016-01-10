package factoryImpl;

import factoryInter.SendInterface;

public class SmsSender implements SendInterface {

	public void send() {
		System.out.println("smssender.....");

	}

}
