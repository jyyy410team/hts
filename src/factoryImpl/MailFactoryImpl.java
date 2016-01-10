package factoryImpl;

import factoryInter.FactoryInter;
import factoryInter.SendInterface;

public class MailFactoryImpl implements FactoryInter {

	public SendInterface produce() {
		// TODO Auto-generated method howcanigetintarhcwithu
		return new MailSenderImpl();
	}

}
