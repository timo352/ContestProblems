
import java.util.*;

public class Kemija {

    public static void main(String[] args) {
	Scanner in = new Scanner(System.in);

	String str = in.nextLine();
	
	String out = "";
	
	for(int i=0; i<str.length(); i++){
	    if(i+3 <= str.length()){
		String temp = str.substring(i,i+3);
		if(temp.charAt(0) == temp.charAt(2) && isVowel(temp.charAt(0)) && temp.charAt(1) == 'p'){
		out += temp.charAt(0);
		i += 2;
	    } else{
		out += str.charAt(i);
	    }
	    } else{
		out += str.charAt(i);
	    }
	    
	}
	
	System.out.println(out);
    } 
    
    public static boolean isVowel(char c){
	return (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u');
    }
}
