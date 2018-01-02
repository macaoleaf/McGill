package Users.zisheng.GitHub.McGill_COMP250.a4.out.production.a4;

/*
Zisheng Ye 260714548
Discussion about rehash and HashIterator with Ian Tsai;
got some hints in Facebook group and at wiki.jikexueyuan.com/project/java-collection/hashtable.html
 */

import java.util.ArrayList;
import java.util.Iterator;

class MyHashTable<K,V> {
	/*
	 *   Number of entries in the HashTable.
	 */
	private int entryCount = 0;

	/*
	 * Number of buckets. The constructor sets this variable to its initial value,
	 * which eventually can get changed by invoking the rehash() method.
	 */
	private int numBuckets;

	/**
	 * Threshold load factor for rehashing.
	 */
	private final double MAX_LOAD_FACTOR=0.75;

	/**
	 *  Buckets to store lists of key-value pairs.
	 *  Traditionally an array is used for the buckets and
	 *  a linked list is used for the entries within each bucket.
	 *  We use an Arraylist rather than an array, since the former is simpler to use in Java.
	 */

	ArrayList< HashLinkedList<K,V> >  buckets;

	/*
	 * Constructor.
	 *
	 * numBuckets is the initial number of buckets used by this hash table
	 */

	MyHashTable(int numBuckets) {

		//  ADD YOUR CODE BELOW HERE
		this.buckets = new ArrayList<HashLinkedList<K,V> >();
		this.numBuckets = numBuckets;
		for (int n = 0; n < this.numBuckets; n++){
			HashLinkedList<K,V> blank = new HashLinkedList<K,V>();
			buckets.add(blank);
		} //create an empty hashtable with certain spaces
		//  ADD YOUR CODE ABOVE HERE

	}

	/**
	 * Given a key, return the bucket position for the key.
	 */
	private int hashFunction(K key) {

		return  Math.abs( key.hashCode() ) % numBuckets ;
	}

	/**
	 * Checking if the hash table is empty.
	 */

	public boolean isEmpty()
	{
		if (entryCount == 0)
			return true;
		else
			return(false);
	}

	/**
	 *   return the number of entries in the hash table.
	 */

	public int size()
	{
		return(entryCount);
	}

	/**
	 * Adds a key-value pair to the hash table. If the load factor goes above the
	 * MAX_LOAD_FACTOR, then call the rehash() method after inserting.
	 *
	 *  If there was a previous value for the given key in this hashtable,
	 *  then overwrite it with new value and return the old value.
	 *  Otherwise return null.
	 */

	public  V  put(K key, V value) {

		//  ADD YOUR CODE BELOW HERE
		int index = hashFunction(key);
		this.entryCount++;
		V oldValue = null;
		//determine if there is value need to be replaced
		if (this.get(key) != null){
			HashNode<K,V> oldNode = new HashNode<K,V> (key, this.get(key));
			oldValue = oldNode.getValue();
			this.remove(key);
		} //find the oldValue
		this.buckets.get(index).add(key, value); //add new node to the proper HashLinkedList
		double loadFactor = this.size() / this.numBuckets; //must be double or it won't work
		if (loadFactor > MAX_LOAD_FACTOR) {
			this.rehash();
		}
		//determine if there is an oldValue to return
		if (oldValue != null){
			return oldValue;
		}
		//  ADD YOUR CODE ABOVE HERE
		return null;
	}

	/**
	 * Retrieves a value associated with some given key in the hash table.
	 Returns null if the key could not be found in the hash table)
	 */
	public V get(K key) {

		//  ADD YOUR CODE BELOW HERE
		int index = hashFunction(key);
		HashNode<K,V> present = this.buckets.get(index).getListNode(key);
		if (present != null){
			return present.getValue();
		}
		//  ADD YOUR CODE ABOVE HERE

		return null;
	}

	/**
	 * Removes a key-value pair from the hash table.
	 * Return value associated with the provided key.   If the key is not found, return null.
	 */
	public V remove(K key) {

		//  ADD YOUR CODE BELOW HERE
		int index = hashFunction(key);
		HashLinkedList<K,V> present = buckets.get(index);
		if (containsKey(key)){
			HashNode<K,V> pairRemoved = present.remove(key);
			V valueRemoved = pairRemoved.getValue(); //find the node and its value to be removed
			entryCount--;
			return valueRemoved;
		}
		//  ADD  YOUR CODE ABOVE HERE

		return(null);
	}

	/*
	 *  This method is used for testing rehash().  Normally one would not provide such a method.
	 */

	public int getNumBuckets(){
		return numBuckets;
	}

	/*
	 * Returns an iterator for the hash table.
	 */

	public MyHashTable<K, V>.HashIterator  iterator(){
		return new HashIterator();
	}

	/*
	 * Removes all the entries from the hash table,
	 * but keeps the number of buckets intact.
	 */
	public void clear()
	{
		for (int ct = 0; ct < buckets.size(); ct++){
			buckets.get(ct).clear();
		}
		entryCount=0;
	}

	/**
	 *   Create a new hash table that has twice the number of buckets.
	 */


	public void rehash()
	{
		//   ADD YOUR CODE BELOW HERE
		this.numBuckets *= 2;
		ArrayList<HashLinkedList<K,V>> newBuckets = new ArrayList<HashLinkedList<K, V>>(numBuckets);
		for (int m = 0; m < numBuckets; m++){
			HashLinkedList<K,V> newPairs = new HashLinkedList<K,V>();
			newBuckets.add(newPairs);
		} //set the empty new structure
		for (int n = 0; n < numBuckets / 2; n++){ //since the numbers won't increase
			HashLinkedList<K,V> list = this.buckets.get(n);
			HashNode<K,V> node = list.getHead(); //get the original lists and nodes
			if (!list.isEmpty() && (node != null)){ //if a node exists
				for (int p = 0; p < list.size(); p++){
					int newHashValue = hashFunction(node.getKey()); //create new HashValues
					newBuckets.get(newHashValue).add(node.getKey(), node.getValue()); //put them into new buckets
					node = node.next; //go to next node until all of them are visited
				}
			}
		}
		this.buckets = newBuckets;
		//   ADD YOUR CODE ABOVE HERE

	}


	/*
	 * Checks if the hash table contains the given key.
	 * Return true if the hash table has the specified key, and false otherwise.
	 */

	public boolean containsKey(K key)
	{
		int hashValue = hashFunction(key);
		if(buckets.get(hashValue).getListNode(key) == null){
			return false;
		}
		return true;
	}

	/*
	 * return an ArrayList of the keys in the hashtable
	 */

	public ArrayList<K>  keys()
	{

		ArrayList<K>  listKeys = new ArrayList<K>();

		//   ADD YOUR CODE BELOW HERE
		int range;
		HashLinkedList<K,V> hashLinkedList = new HashLinkedList<K,V>();
		HashNode<K,V> node;
		for (int n = 0; n < numBuckets; n++){
			hashLinkedList = buckets.get(n);
			if (!hashLinkedList.isEmpty()){ //if the list is not empty
				range = hashLinkedList.size();
				node = hashLinkedList.getHead();
				for (int m = 0; m < range; m++){
					listKeys.add(node.getKey()); //put all nodes into the list
					node = node.next;
				}
			}
		}
		return listKeys;
		//   ADD YOUR CODE ABOVE HERE
	}

	/*
	 * return an ArrayList of the values in the hashtable
	 */
	public ArrayList <V> values()
	{
		ArrayList<V>  listValues = new ArrayList<V>();

		//   ADD YOUR CODE BELOW HERE
		int range;
		HashLinkedList<K,V> hashLinkedList = new HashLinkedList<K,V>();
		HashNode<K,V> node;
		for (int n = 0; n < numBuckets; n++){
			hashLinkedList = buckets.get(n);
			if (!hashLinkedList.isEmpty()){ //if the list is not empty
				range = hashLinkedList.size();
				node = hashLinkedList.getHead();
				for (int m = 0; m < range; m++){
					listValues.add(node.getValue()); //put all nodes into the list
					node = node.next;
				}
			}
		}
		return listValues;
		//   ADD YOUR CODE ABOVE HERE
	}

	@Override
	public String toString() {
		/*
		 * Implemented method. You do not need to modify.
		 */
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < buckets.size(); i++) {
			sb.append("Bucket ");
			sb.append(i);
			sb.append(" has ");
			sb.append(buckets.get(i).size());
			sb.append(" entries.\n");
		}
		sb.append("There are ");
		sb.append(entryCount);
		sb.append(" entries in the hash table altogether.");
		return sb.toString();
	}

	/*
	 *    Inner class:   Iterator for the Hash Table.
	 */
	public class HashIterator implements  Iterator<HashNode<K,V> > {
		HashLinkedList<K,V>  allEntries;

		/**
		 * Constructor:   make a linkedlist (HashLinkedList) 'allEntries' of all the entries in the hash table
		 */
		public  HashIterator()
		{

			//  ADD YOUR CODE BELOW HERE
			for (int i = 0; i < buckets.size(); i++){
				if (buckets.get(i) != null){
					for (int j = 0; j < buckets.get(i).size(); j++){
						HashNode<K,V> node = buckets.get(i).getNode(j);
						allEntries.add(node.getKey(), node.getValue());
					}
				}
			}
			//  ADD YOUR CODE ABOVE HERE

		}

		//  Override
		@Override
		public boolean hasNext()
		{
			return !allEntries.isEmpty();
		}

		//  Override
		@Override
		public HashNode<K,V> next()
		{
			return allEntries.removeFirst();
		}

		@Override
		public void remove() {
			// not implemented,  but must be declared because it is in the Iterator interface

		}
	}

}
