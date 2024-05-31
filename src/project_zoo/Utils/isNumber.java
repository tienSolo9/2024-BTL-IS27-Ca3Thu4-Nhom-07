package project_zoo.Utils;

public class isNumber {
	public static boolean check(String s) {
		try {
			Integer.parseInt(s);
			return true;
		}catch(Exception ex){
			ex.printStackTrace();
			return false;		
		}
	}
}
