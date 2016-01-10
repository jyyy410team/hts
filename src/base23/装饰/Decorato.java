package base23.装饰;

public class Decorato implements Sourceable {
	public Decorato(Sourceable sourceable) {
		super();
		this.source = sourceable;
	}

	private Sourceable source;

	public void method() {
		System.out.println("111111111111111111111111111");
		source.method();
		System.out.println("2222222222222222222222222222");
	}

}
