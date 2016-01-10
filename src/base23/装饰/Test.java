package base23.装饰;

public class Test {
 public static void main(String[] args) {
	Sourceable sourceable = new Source();
	Decorato decorato = new Decorato(sourceable);
	decorato.method();//传入这个需要装饰的对象，然后用装饰对象调用同样的方法，得到装饰后的方法。
}
}
