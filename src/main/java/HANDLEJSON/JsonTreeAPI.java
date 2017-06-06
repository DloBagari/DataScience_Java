package HANDLEJSON;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.JsonNodeType;

import java.io.*;
import java.util.Iterator;

/**
 * using the Tree Model to process each element og the json file
 */
public class JsonTreeAPI {
    public static void main(String[] args) throws IOException{
        ObjectMapper mapper = new ObjectMapper();
        JsonNode node = mapper.readTree(new File("input/persons.json"));
        //iterate over fields
        Iterator<String> fieldsNames = node.fieldNames();
        //since json file has one fields "persons"
        //we obtain a JsonNode instance representing the field and iterate over it
        JsonNode jsonNode = node.get("persons");
        Iterator<JsonNode> elements = jsonNode.iterator();
        while (elements.hasNext()) {
            //get the element
            JsonNode element = elements.next();
            //find the type of the element
            JsonNodeType nodeType = element.getNodeType();
            if (nodeType == JsonNodeType.STRING) {
                System.out.println("Group: " + element.textValue());
            }
            //if element is array
            if (nodeType == JsonNodeType.ARRAY) {
                Iterator<JsonNode> fields = element.iterator();
                while (fields.hasNext()) {
                   parsePerson(fields.next());
                }
            }

        }
    }

    private static void parsePerson(JsonNode next) {
        Iterator<JsonNode> fields = next.iterator();
        while (fields.hasNext()) {
            JsonNode node = fields.next();
            System.out.println(node.asText());
        }
    }
}
