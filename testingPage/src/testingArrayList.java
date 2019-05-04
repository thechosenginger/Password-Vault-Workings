// This program illustrates ArrayList and dynamically add/remove and manipulate

import java. util.ArrayList;

public class testingArrayList {
    public static void main(String[] args){
        int simple_array[] = new int[5]; //or {1,2,3,4,5}

        ArrayList<Integer> myList = new ArrayList<Integer>(5);
        myList.add(1);
        myList.add(5);
        myList.add(3);
        myList.add(23);
        myList.add(27);
        myList.add(5);
        myList.add(99);

        for(Integer x : myList)
            System.out.println(x);
        System.out.println("size = " + myList.size());

        myList.remove(4);

        for(Integer x : myList)
            System.out.println(x);
        System.out.println("size = " + myList.size());

        myList.set(0,100);
        for(Integer x : myList)
            System.out.println(x);
        System.out.println("size = " + myList.size());

        myList.clear();
        myList.trimToSize();
        for(Integer x : myList)
            System.out.println(x);
        System.out.println("size = " + myList.size());

    }
}

// use ArrayList<String>