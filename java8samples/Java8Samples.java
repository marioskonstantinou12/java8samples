package java8samples;

import java.io.File;
import java.io.FileFilter;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 *
 * @author marios
 */
public class Java8Samples {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /*
         Example 1
         Print list elements
         */
        //initialise new string list
        List<String> stringList = Arrays.asList("Apple", "Banana", "Kiwi", "Peach");

        //Old way
        for (String n : stringList) {
            System.out.println(n);
        }

        //New way
        stringList.forEach(n -> System.out.println(n));

        /*
         Example 2
         Check if element (in lowercase) contains a specific character
         */
        //Old way
        for (String s : stringList) {
            if (s.toLowerCase().contains("a")) {
                System.out.println(s);
            }
        }

        //New way
        stringList.stream().filter((n) -> n.toLowerCase().contains("a")).forEach((n) -> {
            System.out.println(n);
        });

        /*
         Example 3
            
         */
        //Old way:
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7);

        System.out.println("Print all numbers:");
        evaluate(list, (n) -> true);

        System.out.println("Print no numbers:");
        evaluate(list, (n) -> false);

        System.out.println("Print even numbers:");
        evaluate(list, (n) -> n % 2 == 0);

        System.out.println("Print odd numbers:");
        evaluate(list, (n) -> n % 2 == 1);

        System.out.println("Print numbers greater than 5:");
        evaluate(list, (n) -> n > 5);

        /*
         Example 4
         Select Hidden files in directory
         */
        //Old way
        File[] hiddenFiles = new File(".").listFiles(new FileFilter() {
            public boolean accept(File file) {
                return file.isHidden();
            }
        });
        
        File[] hiddenFiles2 = new File(".").listFiles(File::isHidden);
        File[] hiddenFiles3 = new File(".").listFiles((File file) -> file.isHidden());

    }

    public static void evaluate(List<Integer> list, Predicate<Integer> predicate) {
        list.stream().filter((n) -> (predicate.test(n))).forEach((n) -> {
            System.out.println(n + " ");
        });

    }

}
