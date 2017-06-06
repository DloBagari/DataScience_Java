package CleaningData;

import com.google.common.base.Joiner;

/**
 * Data might need to be cleaned when they has been acquired, make data more useful and easier to analyse
 */
public class Cleaning {
    public static void main(String[] args) {
        String text = "In lexical % , tokenization 76 the process 9j breaking" + "" +
                " a stream of text up into words, phrases, 34a, or other meaningful" + "" +
                " elements called tokens. The list of tokens becomes input for further processing" + " +" +
                " such as parsing or text mining. Tokenization is useful both in linguistics (where it is a" +
                "form of text segmentation), and in computer science, where it forms part of lexical analysis.";

        //to lowe case and replace all numbers and anything that is not a word OR whitespace character with a single
        //space
        text = text.toLowerCase().replaceAll("[\\d[^\\w\\s]]+", " ");
        System.out.println(text);
        text = text.trim();
        //replace multiple whitespace with a single one
        text = text.replaceAll("\\s+", " ");
        System.out.println(text);
        //split in case anything not a word character \\W
        text = text.replaceAll("[\\d[\\W\\s]]+"," ");
        System.out.println(text);
        //split on not a word character //W
        String[] parts = text.split("\\W+");
        for (String s: parts)
            System.out.println(s);
        //split text in any not word character and numbers and join them with a comma
        parts = text.split("[^\\w\\d]+");
        text = String.join(",", parts);
        System.out.println(text);

        //an alternate version of the join is using google guava Joiner
        String text2 = Joiner.on(",").skipNulls().join(parts);
        System.out.println(text2);


    }
}
