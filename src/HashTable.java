import java.awt.List;

public class HashTable {
	int[] primes = new int[100];
	Node[] table;
	int tableSize=0;
	
	public HashTable(int size){
		table=new Node[size];
		for(int i=0;i<table.length;++i)
			table[i]=new Node();
		tableSize=size;
		Primes p=new Primes();
		p.genPrimes(primes);
		
	}
	
	public void add(String in){
		int hash = hash(in);
		Node head=table[hash];
		while(head.next!=null){
			head=head.next;
		}
		head.next=new Node(in,1,null);
	}
	
	public boolean contains(String in){
		int hash = hash(in);
		Node head=table[hash];
		while(head.next!=null){
			if(in.equals(head.key))
				return true;
			head=head.next;
		}
		if(in.equals(head.key))
			return true;
		return false;
		
		
	}
	public int getValue(String in){
		int hash = hash(in);
		Node head=table[hash];
		while(head.next!=null){
			if(in.equals(head.key))
				return head.value;
			head=head.next;
		}
		if(in.equals(head.key))
			return head.value;
		return 0;
	}
	public void setValue(String key, int val){
		int hash = hash(key);
		Node head=table[hash];
		while(head.next!=null){
			if(key.equals(head.key))
				head.value=val;
			head=head.next;
		}
		if(key.equals(head.key))
			head.value=val;
		
	}
	public void incValue(String key  ){
		int hash = hash(key);
		Node head=table[hash];
		while(head.next!=null){
			if(key.equals(head.key))
				++head.value;
			head=head.next;
		}
		if(key.equals(head.key))
			++head.value;
		
	}
	public void printall(){
		for(int i=0;i<table.length;++i){
			Node head=table[i];
			while(head.next!=null){
				if(head.key!=null)
					printVal(head);
				head=head.next;
			}	
			if(head.key!=null)
				printVal(head);
		}
	}
	
	
	private void printVal(Node n){
		System.out.println(n.key + " was found a total of "+ n.value + " times" );
	}
	private int hash(String in){
		int out=0;
		for(int i=0;i<in.length();++i)
			out+=in.charAt(i)*primes[i]*primes[i+1];
		return out%tableSize;
	}
	
	
}






class Node{
	String key;
	int value;
	Node next;
	public Node(){
		this(null,0,null);
	}
	public Node(String k, int v, Node n){
		next=n;
		value=v;
		key=k;
	}
}

class Primes{
	public static int[] genPrimes(int[] primes){
		int lastPrime=2;
		primes[0]=lastPrime;
		for(int i=1;i<primes.length;++i){
			boolean done=true;
			
			for(int j=lastPrime+1;done;++j){
				if(checkPrime(j,primes)){
					primes[i]=j;
					lastPrime=j;
					done=false;
				}
			}
		}
		return primes;
	}
	
	public static boolean checkPrime(int n, int[] primes){
		for(int i=0;i<primes.length;++i){
			if(primes[i]==0)return true;
			else{
				if(primes[i]>Math.sqrt(n)){
					return true;
				}else
					if(n%primes[i]==0) return false;
				
			}
		}
		return false;
	}
}
