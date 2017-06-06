package HANDLEJSON;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

import java.io.File;
import java.io.IOException;

/**
 * Created by dlo on 29/05/17.
 */
public class HandleJson {
    public static void main(String[] args) throws IOException {
        JsonFactory jsonFactory = new JsonFactory();
        JsonParser jsonParser = jsonFactory.createParser(new File("input/personInfo.json"));
        //process json file
        //tracker moves from key to value not from key to key.
        while (jsonParser.nextToken() != JsonToken.END_OBJECT) {
            //
            String token = jsonParser.getCurrentName();
            if ("fistName".equals(token)){
                //move to the value which is the next token
                jsonParser.nextToken();
                System.out.println("First Name: " + jsonParser.getText());
            }
            if ("lastName".equals(token)) {
                jsonParser.nextToken();
                System.out.println("Last Name: " + jsonParser.getText());
            }
            if ("phone".equals(token)) {
                jsonParser.nextToken();
                System.out.println("phone: " + jsonParser.getText());
            }
            if ("address".equalsIgnoreCase(token)) {
                jsonParser.nextToken();
                System.out.print("Address: ");
                while (jsonParser.nextToken() != JsonToken.END_ARRAY) {
                    System.out.print( jsonParser.getText() + " ");
                }

            }
        }
    }
}
