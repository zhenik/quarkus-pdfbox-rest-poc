package org.acme.rest.json;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDDocumentInformation;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;

// https://www.tutorialspoint.com/pdfbox/pdfbox_quick_guide.htm
@Path("pdf")
public class PdfResource {

  @GET
  @Produces(MediaType.APPLICATION_OCTET_STREAM)
  public Response generateReport() throws IOException {
    genPdf();
    File temp = new File("/tmp/pdfBoxHelloWorld.pdf");
    final Response.ResponseBuilder response = Response.ok(temp);
    response.header("Content-Disposition", "attachment;filename=" + "lol.pdf");
    return response.build();
  }

  void genPdf() throws IOException {
    PDDocument document = new PDDocument();
    PDDocumentInformation information = new PDDocumentInformation();
    information.setAuthor("Fellow author");
    information.setCreationDate(Calendar.getInstance());
    information.setCreator("Fellow creator");
    information.setTitle("Report list bal bla bla");
    document.setDocumentInformation(information);
    PDPage page = new PDPage();
    document.addPage(page);

    PDPageContentStream contentStream = new PDPageContentStream(document, page);

    contentStream.setFont(PDType1Font.COURIER, 12);
    contentStream.beginText();
    contentStream.showText("Hello World");
    contentStream.endText();
    contentStream.close();
    document.save("/tmp/pdfBoxHelloWorld.pdf");
    document.close();
  }
}
