package mkl.testarea.itext5.content;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.junit.BeforeClass;
import org.junit.Test;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfWriter;

/**
 * @author mkl
 */
public class AddSpecialCharacters {
    final static File RESULT_FOLDER = new File("target/test-outputs", "content");

    @BeforeClass
    public static void setUpBeforeClass() throws Exception
    {
        RESULT_FOLDER.mkdirs();
    }

    /**
     * <a href="https://stackoverflow.com/questions/55947168/how-to-display-multilingual-or-any-unicode-special-character-in-itextpdf-pdf-whi">
     * How to display multilingual or any UNICODE special character in itextpdf PDF which is accepted from UI?
     * </a>
     * <p>
     * Cannot reproduce the issue with current c:\Windows\Fonts\arial.ttf.
     * </p>
     */
    @Test
    public void testAddLikeKiranBadave() throws IOException, DocumentException
    {
        try (   FileOutputStream stream = new FileOutputStream(new File(RESULT_FOLDER, "specialCharactersLikeKiranBadave.pdf"))    )
        {
            Document document = new Document();
            PdfWriter writer = PdfWriter.getInstance(document, stream);
            document.open();

            BaseFont bf = BaseFont.createFont("c:\\Windows\\Fonts\\arial.ttf", BaseFont.IDENTITY_H, BaseFont.EMBEDDED);

            Paragraph p = new Paragraph("Şinasi ıssız ile ağaç", new Font(bf, 22));

            document.add(p);

            document.close();
        }
    }
}