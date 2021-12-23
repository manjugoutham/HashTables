package hashtable;

public class Hashtabletest {

	public static void main(String[] args) {

		Hashtable<String, Integer> hashtable = new Hashtable<>();

		String message = "To be or not to be";

		String[] value = message.toLowerCase().split(" ");

		for (String word : value) {
			//System.out.print(word);
			Integer val = hashtable.get(word);

			if (val == null)
				val = 1;
			else
				val = val + 1;
			hashtable.add(word, val);
		}
		//System.out.println(value);
		System.out.println(hashtable);
	}
}