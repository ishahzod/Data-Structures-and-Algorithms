
public class TestGenerate {

	public static void main(String[] args) {
		
		int array[] = new int[6]; 
		for(int i = 0; i<array.length; i++){
			array[i] = (int) (Math.random()*100); 
			System.out.println("a[" + i + "] = " + array[i]);
		}
		

	}

}
