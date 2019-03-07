import java.io.*;
import java.util.*;

class WhiteWalker {

    public int index;
    public int power;

    public WhiteWalker(int index, int power) {
        this.index = index;
        this.power = power;
    }
}

public class Problem4 {

    public static void main(String args []) {
    	//Grader: Please specify the txt file path on your PC
        File txtFile = new File("C:\\Users\\ishah\\workspace\\CSE214 Hw2\\src\\in4.txt");
        //declare and initialize a scanner variable to null
        Scanner in = null;
        //Try-catch block for file verification
        try {
            in = new Scanner(new FileInputStream(txtFile));
        } catch (FileNotFoundException e) {
            System.out.println("Cannot find " + txtFile);
            System.exit(1);
        }
        int max, m, n;
        int TestNums = in.nextInt();
        for(int i = 0; i < TestNums; ++i) {
            n = in.nextInt();
            m = in.nextInt();
            
            //Creates a queue of whitewalkers 
            //add the index and the power of each WW to the queue
            Queue<WhiteWalker> queue = new ArrayDeque<>();
            for(int j = 0; j < n; ++j) {
                queue.add(new WhiteWalker(j, in.nextInt()));
            }
            // calculates output
            for(int k = 0; k < m; ++k) {
            	//create an arraylist of WhiteWalkers
                List<WhiteWalker> list = new ArrayList<>();
                if(!queue.isEmpty()) {
                    max = 0;
                    //iterates through the queue and adds the index of the most powerful WW to the arraylist
                    for (int j = 0; j < m; ++j) {
                        if (!queue.isEmpty()) {
                            list.add(queue.peek());
                            if (list.get(j).power > list.get(max).power) {
                                max = j;
                            }
                            queue.remove();
                        }
                    }
                    
                    //prints the index of the powerful WW in the order they were presented
                    System.out.print(list.get(max).index + " ");
                    for(int j = 0; j < list.size(); ++j) {
                        if(j != max) {
                            if(list.get(j).power > 0)
                                list.get(j).power--;
                            queue.add(list.get(j));
                        }
                    }
                }
            }
        }
        in.close();
    }

}