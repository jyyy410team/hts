package test;

import factoryImpl.MailFactoryImpl;
import factoryImpl.SmsFactoryImpl;
import factoryInter.FactoryInter;

public class Mytest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		FactoryInter factoryInter = new MailFactoryImpl();
		factoryInter.produce().send();

		FactoryInter factoryInter2 = new SmsFactoryImpl();
		factoryInter2.produce().send();
	}

}
