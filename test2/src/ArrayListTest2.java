import java.util.Scanner;
import java.util.ArrayList;

public class ArrayListTest2 {

    static Scanner reader = new Scanner(System.in);
    static ArrayList<Integer> array = new ArrayList<>();

    public static void main(String[] args){

        System.out.println("Please enter an array of numbers, type in 0 when finished!");
        int in = reader.nextInt();
        while(in != 0){
            array.add(in);
            in = reader.nextInt();
        }

        // The user types 0
        System.out.println("-------------------------------");

        for(int i: array)
        {
            System.out.println(i);
        }

        System.out.println("What number would you like to delete? ");
        int del = reader.nextInt();

    }
    public void PrintArray(){

    }
}
