package factoryImpl;

import factoryInter.FactoryInter;
import factoryInter.SendInterface;

public class SmsFactoryImpl implements FactoryInter {

	public SendInterface produce() {
		return new SmsSender();
	}

}


/*
Hello out_hello = new Hello();
Hello.Image image = out_hello.new Image();
87白旗
*/