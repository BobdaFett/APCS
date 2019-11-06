package unitLoops;

public class forTesting {

	public static void main(String[] args) {
		int count = 1;
		
		while(count <= 10) {
			System.out.println(count);
			count++;
		}
		
		//or you could use this
		
		for(int i = 1; i < 10; i++) {
			System.out.println(i);
		}
		
		//you can also initialize multiple variables in one loop, like this
		
		for(int i = 0, j = 10; i < j; i++, j--) {
			System.out.println(i + " " + j);
		}
	}

}
