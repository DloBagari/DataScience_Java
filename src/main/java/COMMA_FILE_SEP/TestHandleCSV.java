package COMMA_FILE_SEP;

import java.io.IOException;

/**
 * Created by dlo on 06/05/17.
 */
public class TestHandleCSV {
    public static void main(String[] args) throws IOException {
        HandleCSV handler = new HandleCSV("Data/DemoData.csv");
        handler.DisplayArray();
    }
}
