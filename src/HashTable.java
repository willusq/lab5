import java.awt.List;

public class HashTable {
	int[] primes = new int[50];
	
	public HashTable(){
		for (int i=0;i<primes.length;++i)
			primes[i]=0;
		
		genPrimes();
	}
	public boolean checkPrime(int n){
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
	public void genPrimes(){
		int lastPrime=2;
		primes[0]=lastPrime;
		for(int i=1;i<primes.length;++i){
			boolean done=true;
			
			for(int j=lastPrime+1;done;++j){
				if(checkPrime(j)){
					System.out.println(j);
					primes[i]=j;
					lastPrime=j;
					done=false;
				}
			}
		}
	}

	public int hash(String in){
		int out=0;
		for(int i=0;i<in.length();++i)
			out+=in.charAt(i)*primes[i];
		return out;
	}
}






class Node{
	String key;
	int value;
	Node next;
}
