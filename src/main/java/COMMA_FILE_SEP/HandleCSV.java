package COMMA_FILE_SEP;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by dlo on 06/05/17.
 */
public class HandleCSV {
    private String[][] CsvArray;

    /**
     * read CSV file and store values into Array[line not split][values in the line split]
     */
    public HandleCSV(String filename) throws FileNotFoundException{
        Scanner input = new Scanner(new File(filename));
        ArrayList<String> lines  = new ArrayList<>();
        while (input.hasNext()) {
            lines.add(input.nextLine());
        }
        //toArray() takes one argument so that the method will know what type of array to create.
        String[] temp = lines.toArray(new String[1]);
        CsvArray = new String[temp.length][];
        for (int i = 0; i < temp.length; i++) {
            CsvArray[i] = temp[i].split(",");
        }
    }

    /**
     * print an array values
     */
    public void DisplayArray() {
        for (String[] strings : CsvArray) {
            for (String s :strings) {
                System.out.printf("%-10s\t", s);
            }
            System.out.println();
        }
    }

}
