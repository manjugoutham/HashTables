package hashtable;

public class Hashtabletest {

	public static void main(String[] args) {

		Hashtable<String, Integer> hashtable = new Hashtable<>();

		String message = "Paranoids are not paranoid because they are paranoid but because they keep putting themselves deliberately into paranoid avoidable situations";

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