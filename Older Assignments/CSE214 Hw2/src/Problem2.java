import java.io.*;
import java.util.*;

//a class for Basketball player with h height and jersey number
class BBplayer{
    public int height;
    public int jerseyNum;
}

public class Problem2{

     public static void main(String args []){
    	
       try {
    	   //making a linked list of BasketBall players
          LinkedList<BBplayer> list = new LinkedList<BBplayer>();
          
          //Grader: please insert the path of the .txt File for the correct output
          File txtFile = new File("C:\\Users\\ishah\\workspace\\CSE214 Hw2\\src\\in2.txt");
          Scanner in = new Scanner(txtFile);
          String endLine ="";
          
          //parse the contents of the txt file to an int
          int n = Integer.parseInt(in.nextLine());
          
          //iterate through and divide each of the 3 endLines based on the endendLine whitespace
          for (int i = 0; i<n; i++){
             endLine = in.nextLine();
             String[] nums = endLine.split(" ");
             for(int j = 0; j<nums.length; j++){
                
          //assigns the corresponding jersey # to each player and adds it to the list
                 BBplayer p = new BBplayer();
                 p.jerseyNum = Integer.parseInt(nums[j]);
                 list.add(p);
             }
            
          //assigns the corresponding height value to the players  
             endLine = in.nextLine();
             nums = endLine.split(" ");
             for(int j = 0; j<nums.length; j++){
                 list.get(j).height = Integer.parseInt(nums[j]);
             }
            
          }
         
          //iterates left to right and compares height(i) to height(i+1)
          //orders it from greatest to least heights and prints out the jerseyNum corresponding to the player
          for (int i = 0; i<list.size(); i++){
             if (list.size() > i+1){
                if (list.get(i).height > list.get(i+1).height)
                   System.out.print(list.get(i).jerseyNum + " ");
             }
             else {
                  System.out.println(list.get(i).jerseyNum);
             }
          }
          System.out.println();
         
          //catches an exception and prints the error message
        } catch (Exception e){
        	System.out.println("Cannot find the txt file.");
        }

     }
}
