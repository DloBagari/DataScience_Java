package PDF_HANDLER;

import java.io.IOException;

/**
 * Created by dlo on 22/05/17.
 */
public class Tester {
    public static void main(String[] args) throws IOException {
        PDFHandler pdfHandler = new PDFHandler("input/simple.pdf");
        pdfHandler.displayContext();
    }
}
