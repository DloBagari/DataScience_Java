package Tokenizer;

import com.google.common.base.Splitter;
import org.apache.commons.lang3.text.StrMatcher;
import org.apache.commons.lang3.text.StrTokenizer;

import java.util.StringTokenizer;

/**
 * tokenizer  with core-java, and third-party
 */
public class Tokenizers {
    public static void main(String[] args) {
        String text = "In lexical analysis, tokenization is the process of breaking" + "" +
                " a stream of text up into words, phrases, symbols, or other meaningful" + "" +
                " elements called tokens. The list of tokens becomes input for further processing" + " +" +
                " such as parsing or text mining. Tokenization is useful both in linguistics (where it is a" +
                "form of text segmentation), and in computer science, where it forms part of lexical analysis.";

        //StringTokenizer() simple and old, String.split() is much efficient
        StringTokenizer tokenizer = new StringTokenizer(text," ");
        while (tokenizer.hasMoreTokens()) {
            System.out.println(tokenizer.nextToken());
        }

        //third-party tokenizer StrTokenizer form apache
        //more control and flexibility
        //delimiter by default is white-spaces
        StrTokenizer tokenizer1 = new StrTokenizer(text);
        while (tokenizer1.hasNext()) {
            System.out.println(tokenizer1.next());
        }
        //delimiter can be a simple char or a more complex StrMatcher object
        tokenizer1 = new StrTokenizer(text, ",");
        while (tokenizer1.hasNext()) {
            System.out.println(tokenizer1.next());
        }

        //google Guava is an open source set of utility java classes
        //because its chain methods split.omit empty String. trim
        //guava is considered as best tokenizer for java
        Splitter splitter = Splitter.on(" ").omitEmptyStrings().trimResults();
        Iterable<String> words = splitter.split(text);
        for (String s:words)
            System.out.println(s);

    }
}
