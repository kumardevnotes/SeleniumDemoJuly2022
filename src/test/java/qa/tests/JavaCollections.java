package qa.tests;


import java.util.ArrayList;
import java.util.List;

public class JavaCollections {
    public static void main(String[] args) {

        String stdDetailss[] =  new String[10]; //10-7 = 3
        //stdFName, stdLName, ID, StdFee, Adrress, email, contact information

        // List is an interface and ArrayList is a Class
        // ArrayList implements List by default
        //List will allow duplicate values
        // You can store values at any given index
       List stdDetails = new ArrayList(); //ArraysList implements List // index starts from 0
        stdDetails.add("James");
        stdDetails.add(1122);
        stdDetails.add(100);
        stdDetails.add('M');
        stdDetails.add("USA, Texas, 50012");
        System.out.println(stdDetails);
        System.out.println("============");
        stdDetails.add("James");
        stdDetails.add(0, "Wisdom School");
        System.out.println(stdDetails);
        System.out.println("============");
        System.out.println(stdDetails.get(1));
        System.out.println("============");
        System.out.println(stdDetails.contains("Kumar"));
        System.out.println(stdDetails);
        System.out.println("============");
        stdDetails.clear();
        System.out.println(stdDetails);
        System.out.println("============");
    }
}
