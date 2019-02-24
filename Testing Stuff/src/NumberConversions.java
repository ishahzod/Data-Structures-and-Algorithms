
public class NumberConversions {

	public static void main(String[] args) {
		System.out.println( decimalToBinary(10) );   
		System.out.println( binaryToDecimal("10") );   
		System.out.println( decimalToHex(16) );   
		System.out.println( binaryToHex("101010") );
		System.out.println( hexadecimalToDecimal("AA") );       
		System.out.println( hexadecimalToBinary("AA") );   
		System.out.println( hexadecimalToDecimal("AA") );
	}

	public static String decimalToBinary(int n){
		String b = "";
		while(n>0){
			b = n%2 + b;
			n /= 2;
		}
		return b;
	}

	public static String decimalToHex(int n){
		String b = "";
		while(n>0){
			b = hexDigit(n%16) + b;
			n /= 16;
		}
		return b;
	}

	public static char hexDigit(int n){
		if(n<10)
			return (char)('0'+n);
		else
			return (char)(n-10+'A');
	}

	public static int binaryToDecimal(String b){
		int n = 0;
		for(int i=0; i<b.length(); i++){
			n = n*2 + (b.charAt(i) - '0');
		}
		return n;
	}

	public static String binaryToHex(String b){
		return decimalToHex(binaryToDecimal(b));
	}

	public static int hexadecimalToDecimal(String h){
		int n = 0;
		for(int i=0; i<h.length(); i++){
			n = n*16 + digitHex(h.charAt(i));
		}
		return n;
	}

	public static int digitHex(char h){
		if('0'<=h && h<='9')
			return h - '0';
		else
			return h -'A' + 10;
	}

	public static String hexadecimalToBinary(String h){
		return decimalToBinary(hexadecimalToDecimal(h));
	}
}
