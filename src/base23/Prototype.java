package base23;

public class Prototype implements Cloneable{

	
	private Prototype() {
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		Prototype prototype = (Prototype) super.clone();
		return prototype;
	}
	
	
}
