package pdfverification.service;

import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.parser.PdfTextExtractor;

import java.io.IOException;

public class PDFParser {

    public PdfReader readPdf(byte[] pdfData) throws IOException {
        PdfReader reader = new PdfReader(pdfData);

        return reader;
    }

    public String getRawText(PdfReader reader, Integer pageNr) throws IOException {
        return PdfTextExtractor.getTextFromPage(reader, pageNr);
    }
}
