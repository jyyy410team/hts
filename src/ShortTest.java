import com.jeecms.until.MathUtils;




public class ShortTest {

	/**1-33
	 * @param args
	 */
	
	public static String shortIt() {

		String result="";
		
		for (int i = 1; i <=6; i++) {
			Integer temp=MathUtils.getRandom(33, 1);
			result+=temp.toString()+",";
		}
		
		Integer bulue=MathUtils.getRandom(1, 16);
		result=result+bulue.toString();
		System.out.println(result);
		return result;
	}
	public static void main(String[] args) {
		
		 int loop=0;
	for (int i = 0; i <=1; i++) {
		String result=shortIt();
		/*if (result.equals("03,10,22,8,23,27,29")) {
			loop=1;
			System.out.println("下一个是:"+result);
		}*/
		
		
	}
		
		

	}

}
