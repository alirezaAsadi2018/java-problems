package ir.javacup.repeatingString;

public class RepeatInString {

	public static int StringInString(String one, String two) {
		if(one == null || two == null || one.length() == 0 || two.length() == 0)
			return 0;
		int index = one.indexOf(two);
		int ans = 0;
		int secondLen = two.length();
		while(index != -1){
			ans++;
			index ++;
			index = one.indexOf(two, index);
		}
		return ans;
	}
}