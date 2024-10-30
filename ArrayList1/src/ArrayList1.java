import java.util.ArrayList;
import java.util.Collections;

public class ArrayList1 {
    public static void main(String[] args) {
        //Task 1 create a new array list, add some colors (string) and print out the collection
        ArrayList<String> colors = new ArrayList<>();
        colors.add("Red");
        colors.add("Yellow");
        colors.add("Green");
        colors.add("Blue");
        System.out.println("ArrayList: " + colors);

        //Task 2 iterate through all elements in an array list
        System.out.println("Iterating through ArrayList:");
        for (String color : colors) {
            System.out.println(color);
        }

        //Task 3  insert an element into the array list at the first position
        colors.add(0, "Pink");
        System.out.println("ArrayList after inserting first element:" + colors);

        //Task 4  retrieve an element (at a specified index) from a given array list
        String retrievedColor = colors.get(3);
        System.out.println("Element at index 3: " + retrievedColor);

        //Task 5 update specific array element by given element
        colors.set(1, "Black");
        System.out.println("After updating index 1: " + colors);

        //Task 6 remove the third element from an array list
        colors.remove(2);
        System.out.println("After removing the third element from a array list': " + colors);

        //Task 7 search an element in an array list
        String searchColor = "Green";
        if (colors.contains(searchColor)) {
            System.out.println(searchColor + " is found in the ArrayList.");
        } else {
            System.out.println(searchColor + " is not found in the ArrayList.");
        }

        //Task 8 sort a given array list
        Collections.sort(colors);
        System.out.println("Sorted ArrayList: " + colors);

        //Task 9 copy one array list into another
        ArrayList<String> copyColors = new ArrayList<>(colors);
        System.out.println("Copied ArrayList: " + copyColors);

        //Task 10 reverse elements in an array list
        Collections.reverse(copyColors);
        System.out.println("Reversed ArrayList: " + copyColors);

        //Task 11 compare two array lists
        boolean areEqual = colors.equals(copyColors);
        System.out.println("ArrayLists are equal: " + areEqual);

        //Task 12 empty an array list
        copyColors.clear();
        System.out.println("ArrayList after clearing: " + copyColors);

        //Task 13 test an array list is empty or not
        if (colors.isEmpty()) {
            System.out.println("The ArrayList is empty.");
        } else {
            System.out.println("The ArrayList is not empty.");
        }

        //Task 14 increase the size of an array list
        colors.ensureCapacity(100);
        System.out.println(
                "ArrayList can now store up to 100 elements.");

        //Task 15 trim the capacity of an array list the current list size
        colors.trimToSize();
        System.out.println("Size of ArrayList: " + colors.size());
    }
}

