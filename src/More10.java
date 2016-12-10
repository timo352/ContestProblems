
import java.util.*;

public class More10 {

    public static class Statement {

	String w1, w2;
	boolean is;

	Statement(String o, boolean i, String t) {
	    w1 = o;
	    w2 = t;
	    is = i;
	}
    }

    public static class LemngthComparator implements Comparator {

	@Override
	public int compare(Object o1, Object o2) {
	    int cmp = Integer.compare(((String) o1).length(), ((String) o2).length());
	    if (cmp == 0) {
		return ((String) o1).compareTo((String) o2);
	    } else {
		return cmp;
	    }

	}
    }

    public static String getRhyme(Map<String, LinkedHashSet<String>> dictionary, String word) {
	String rhyme = (word.length() < 3) ? word : word.substring(word.length() - 3);

	for (int j = rhyme.length() - 1; j >= 0; j--) {
	    if (dictionary.containsKey(rhyme.substring(j))) {
		return rhyme.substring(j);
	    }
	}
	return rhyme;
    }

    public static void main(String[] args) {
	Scanner in = new Scanner(System.in);

	int numStates = in.nextInt();
	
	HashMap<String, LinkedHashSet<String>> dictionary = new HashMap();
	TreeSet<String> wordTree = new TreeSet(new LemngthComparator());

	Statement[] s = new Statement[numStates];
	Statement[] n = new Statement[numStates];

	int countS = 0;
	int countN = 0;

	in.nextLine();
	for (int i = 0; i < numStates; i++) {

	    String n1 = in.next();
	    boolean b = in.next().equals("is");
	    String n2 = in.next();

	    if (b) {
		s[countS++] = new Statement(n1, b, n2);
	    } else {
		n[countN++] = new Statement(n1, b, n2);
	    }

	    if(!wordTree.contains(n1)) wordTree.add(n1);
	    if(!wordTree.contains(n2)) wordTree.add(n2);
	    in.nextLine();
	}
	
	for (String word : wordTree) {
	    String rhyme = (word.length() <= 3) ? word : word.substring(word.length() - 3, word.length());

	    for (int j = rhyme.length() - 1; j >= 0; j--) {
		if (dictionary.containsKey(rhyme.substring(j))) {
		    dictionary.get(rhyme.substring(j)).add(word);
		    break;
		} else if (j == 0) {
		    LinkedHashSet<String> hash = new LinkedHashSet();
		    hash.add(word);
		    dictionary.put(rhyme, hash);
		    break;
		}
	    }
	}
	
	for (int i = 0; i < countS; i++) {
	    Statement state = s[i];
	    
	    if(state.w1.equals(state.w2)){
		continue;
	    }
	    
	    String rhyme1 = getRhyme(dictionary, state.w1);
	    String rhyme2 = getRhyme(dictionary, state.w2);
	    
	    if(rhyme1.equals(rhyme2)){
		continue;
	    }
	    
	    dictionary.get(rhyme2).addAll(dictionary.get(rhyme1));
	    dictionary.put(rhyme1, dictionary.get(rhyme2));
	}

	for (int i = 0; i < countN; i++) {
	    Statement state = n[i];
	    String rhyme = getRhyme(dictionary, state.w1);
	    LinkedHashSet<String> rhymeList = dictionary.get(rhyme);

	    if (rhymeList.contains(state.w2)) {
		System.out.println("wait what?");
		System.exit(0);
	    }
	}

	System.out.println("yes");
    }
}
