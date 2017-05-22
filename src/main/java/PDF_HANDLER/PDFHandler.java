package PDF_HANDLER;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

import java.io.File;
import java.io.IOException;

/**
 * open pdf file and extract text from it using apache PDFBox.
 */
public class PDFHandler {
    private PDDocument document;
    private final PDFTextStripper textStripper = new PDFTextStripper();
    public PDFHandler(String fileName) throws IOException{
        //load file into PDDocument.
        document = PDDocument.load(new File(fileName));
    }

    public void displayContext() throws IOException {
        System.out.println(textStripper.getText(document));
    }
}
