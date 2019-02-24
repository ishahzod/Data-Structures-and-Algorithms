import java.io.*;

import java.util.*;
public class Testing {

	public static void main(String[] args) throws IOException {
		String s = "hello";
		BufferedWriter bw = new BufferedWriter(new FileWriter("C:\\Users\\ishah\\Desktop\\new.csv"));
		bw.write(s);
		
		bw.close();
	}
}
