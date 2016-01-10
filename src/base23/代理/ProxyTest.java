package base23.代理;

import base23.装饰.Sourceable;

public class ProxyTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Sourceable sourceable = new Proxy();
		sourceable.method();
	}

}
