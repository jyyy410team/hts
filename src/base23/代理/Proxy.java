package base23.代理;

import base23.装饰.Source;
import base23.装饰.Sourceable;

public class Proxy implements Sourceable {
	private Source source;

	public Proxy() {
		super();
		source = new Source();
	}

	public void method() {
		System.out.println("111111111111111111111111111");
		source.method();
		System.out.println("2222222222222222222222222222");

	}

}
