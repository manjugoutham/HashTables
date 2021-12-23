package hashtable;
import java.util.ArrayList;

public class Hashtable<K, V> {
	Mynode head;
	Mynode tail;
	private final int numofbuckets;
	ArrayList<Mynode<K, V>> myBucketArray;

	public Hashtable() {
		this.numofbuckets = 10;
		this.myBucketArray = new ArrayList<>();
		for (int i = 0; i < numofbuckets; i++)
			this.myBucketArray.add(null);
	}

	public void add(K key, V value) {
		int index = this.BucketIndex(key);
		Mynode<K, V> myNode = this.myBucketArray.get(index);
		if (myNode == null) {
			myNode = new Mynode<>(key, value);
			this.myBucketArray.set(index, myNode);
		}
		myNode = (Mynode<K, V>) searchNode(key);
		if (myNode == null) {
			myNode = new Mynode<>(key, value);
			this.append(myNode);
		} else {
			myNode.setValue(value);
		}
	}

	public void append(Mynode myNode) {
		if (this.head == null)
			this.head = myNode;
		if (this.tail == null)
			this.tail = myNode;
		else {
			this.tail.setNext(myNode);
			this.tail = myNode;
		}
	}

	public Mynode<K, V> searchNode(K data) {
		Mynode currentNode = head;
		int position = 0;
		while (currentNode != null) {
			position++;
			if (currentNode.getKey().equals(data)) {
				return currentNode.next;
			}
			currentNode = currentNode.getNext();
		}
		return currentNode;
	}

	// Searching for the word and get the value from the linked list
	public V get(K word) {
		int index = this.BucketIndex(word);
		if (this.myBucketArray.get(index) == null)
			return null;
		Mynode<K, V> myMapNode = searchNode(word);
		return (myMapNode == null) ? null : myMapNode.getValue();
	}

	private int BucketIndex(K word) {
		int hashCode = Math.abs(word.hashCode());
		int index = hashCode % numofbuckets;
		return index;
	}

	public void remove(K word) {
		Mynode currentNode = head;
		Mynode previousNode = null;
		while (currentNode != null && currentNode.getKey().equals(word)) {
			head = currentNode.getNext();
			return;
		}
		while (currentNode != null && !(currentNode.getKey().equals(word))) {
			previousNode = currentNode;
			currentNode = currentNode.getNext();
		}
		if (currentNode != null) {
			previousNode.next = currentNode.next;
		}
		if (currentNode == null)
			System.out.println("Not found");
	}

	@Override
	public String toString() {
		return " \n{" + head + "}";
	}
}