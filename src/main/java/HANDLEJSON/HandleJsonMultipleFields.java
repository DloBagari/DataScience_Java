package HANDLEJSON;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

import java.io.File;
import java.io.IOException;


/**
 * parse a json file multiple fields.
 */
public class HandleJsonMultipleFields {
    public static void main(String[] args) throws IOException{
        JsonFactory jsonFactory = new JsonFactory();
        JsonParser parser = jsonFactory.createParser(new File("input/persons.json"));
        while (parser.nextToken() != JsonToken.END_OBJECT) {
            String token = parser.getCurrentName();
            if ("persons".equals(token)) {
                //skip "{"
                parser.nextToken();
                parser.nextToken();
                token = parser.getCurrentName();
                if ("groupname".equals(token)) {
                    parser.nextToken();
                    String groupname = parser.getText();
                    System.out.println("____________________");
                    System.out.println("Group: " + groupname);
                    parser.nextToken();
                    token = parser.getCurrentName();
                    if ("person".equals(token)) {
                        System.out.println("Found Person:");
                        parsePerson(parser);
                    }
                }
                System.out.println("____________________");
            }
        }
        parser.close();
    }

    /**
     * parse an array in json file
     * @param parser
     * @throws IOException
     */
    private static void parsePerson(JsonParser parser) throws IOException {
        while (parser.nextToken() != JsonToken.END_ARRAY) {
            String token = parser.getCurrentName();
            if ("firstname".equals(token)) {
                parser.nextToken();
                System.out.println("---------------------");
                System.out.println("First name: " + parser.getText());
            }

            if ("lastname".equals(token)) {
                parser.nextToken();
                System.out.println("Last name: " + parser.getText());
            }

            if ("phone".equals(token)) {
                parser.nextToken();
                System.out.println("Phone Number: " + parser.getLongValue());
            }

            if ("address".equals(token)) {
                System.out.println("Address: " );
                parser.nextToken();
                while (parser.nextToken() != JsonToken.END_ARRAY) {
                    System.out.print(parser.getText());
                }
                System.out.println();
            }
        }
    }
}
