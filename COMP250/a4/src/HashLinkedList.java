package Users.zisheng.GitHub.McGill_COMP250.a4.out.production.a4;

//Zisheng Ye 260714548

public class HashLinkedList<K,V>{
	/*
	 * Fields
	 */
	private HashNode<K,V> head;

	private Integer size;

	/*
	 * Constructor
	 */

	HashLinkedList(){
		head = null;
		size = 0;
	}


	/*
	 *Add (Hash)node at the front of the linked list
	 */

	public void add(K key, V value){
		// ADD CODE BELOW HERE
		size++;
		HashNode<K,V> newNode = new HashNode<K,V>(key, value);
		if (this.head == null){
			this.head = newNode;
		} else {
			newNode.next = head;
			head = newNode;
		}
		// ADD CODE ABOVE HERE
	}

	/*
	 * Get Hash(node) by key
	 * returns the node with key
	 */

	public HashNode<K,V> getListNode(K key){
		// ADD CODE BELOW HERE
		HashNode<K,V> current = null;
		if (this.head != null){
			current = this.head;
			while (current != null){
				if (current.getKey().equals(key)){
					break;
				} else {
					current = current.next;
				}
			}
		}
		return current;
		// ADD CODE ABOVE HERE
	}


	/*
	 * Remove the head node of the list
	 * Note: Used by remove method and next method of hash table Iterator
	 */

	public HashNode<K,V> removeFirst(){
		// ADD CODE BELOW HERE
		if (this.head != null) {
			HashNode<K, V> removed = this.head;
			this.head = this.head.next;
			size--;
			removed.next = null;
			return removed;
		}
		return null;
		// ADD CODE ABOVE HERE
	}

	/*
	 * Remove Node by key from linked list
	 */

	public HashNode<K,V> remove(K key){
		// ADD CODE BELOW HERE
		HashNode<K,V> aim = this.getListNode(key);
		HashNode<K,V> removed = aim;
		if (aim != null && this.head != null){
			if(key.equals(this.head.getKey())) {
				return removeFirst();
			} else { // if not the head,
				HashNode<K, V> tmp = this.head;
				while (!tmp.next.getKey().equals(key)){
					tmp = tmp.next;
				}
				if (tmp.next.next == null){ // if node to remove is the last one
					tmp.next = null;
				} else {
					tmp.next = tmp.next.next;
				}
				size--;
				return removed;
			}
		}
		// ADD CODE ABOVE HERE
		return null; // removing failed
	}



	/*
	 * Delete the whole linked list
	 */
	public void clear(){
		head = null;
		size = 0;
	}
	/*
	 * Check if the list is empty
	 */

	boolean isEmpty(){
		return size == 0? true:false;
	}

	int size(){
		return this.size;
	}

	//ADD YOUR HELPER  METHODS BELOW THIS

	public HashNode<K, V> getHead() {
		return head;
	}

	public HashNode<K, V> getNode(int i){
		if (i >= this.size()){
			return null;
		}
		int n = 1;
		HashNode<K, V> tmp = this.head;
		while (n != i && tmp.next != null) {
			n++;
			tmp = tmp.next;
		}
		return tmp;
	}
	//ADD YOUR HELPER METHODS ABOVE THIS


}
