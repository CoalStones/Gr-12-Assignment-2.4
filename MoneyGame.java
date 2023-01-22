package assignment24;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

public class MoneyGame {
    Scanner input=new Scanner(System.in);
    private static ArrayList<Integer> scores=new ArrayList<Integer>();
    private static int[][] finals;
    
    
    public void run(){
        input();
        output();
        subtract();
    }
    
    private void input(){
        System.out.println("Enter a number that is a multiple of 10 and between 10-90");
        System.out.println("Enter -1 to finsih");
        for(int count=0; count<6; count++){
            System.out.println("Enter a number");
            int iHolder=input.nextInt();
            if(iHolder==-1)break;
            else scores.add(iHolder);
        }
        sort();
        
        finals=new int[scores.size()-1][scores.size()];
    }
    
    private void sort(){
        //taken from the note on the insertion sort
        int iHolder;
        for(int count=0; count<scores.size(); count++){
            iHolder=count;
            //while the counter is greater than 0 and the marks at the counter are greater than 0 swap
            //the positions of marks and names
            while(iHolder>0&&scores.get(iHolder).compareTo(scores.get(iHolder-1))<0){
                Collections.swap(scores,iHolder,iHolder-1);
                iHolder--;
            }
        }
    }
    
    private void output(){
        for(int count:scores){
            System.out.format("%4s",count);
        }
        System.out.println();
        
    }
    
    private void subtract(){
        int holder;
        for(int i=0; i<scores.size()-1; i++){
            for(int count=0; count<scores.size(); count++){
                if(count==i&&i==0){
                    finals[i][count]=scores.get(count)-scores.get(i+1);
                }
                else if(i<count){
                    finals[i][count]=scores.get(count)-scores.get(i);
                }
                else{
                    finals[i][count]=scores.get(count)-scores.get(i+1);
                }
            }
        }
        for(int i=0; i<scores.size()-1; i++){
            for(int count=0; count<scores.size(); count++){
                if(i==0&&count==0){
                    for (Integer score : scores) {
                        System.out.print("----");
                    }
                    System.out.println();
                }
                System.out.format("%4s",finals[i][count]);
            }
            System.out.println();
        }
        for (Integer score : scores) {
            System.out.print("----");
        }
            System.out.println();
        for(int i=0; i<scores.size(); i++){
            int total=0;
            for(int count=0; count<scores.size()-1; count++){
                total+=finals[count][i];
            }
            System.out.format("%4s",total);
        }
        System.out.println();
    }
    
}
