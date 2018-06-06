package com.lori.aspa.services;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;

import org.springframework.stereotype.Service;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Image;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.draw.LineSeparator;
import com.lori.aspa.dto.AuthorizationDTO;

@Service
public class PdfExporter {
	
	final Font veryBigBoldFont = new Font(Font.FontFamily.HELVETICA, 18, Font.BOLD);
    final Font italicFont = new Font(Font.FontFamily.TIMES_ROMAN, 11, Font.ITALIC);
    final Font veryBigFont = new Font(Font.FontFamily.HELVETICA, 18);
    final Font bigBoldFont = new Font(Font.FontFamily.HELVETICA, 14, Font.BOLD);
    final Font bigFont = new Font(Font.FontFamily.HELVETICA, 12, Font.BOLD);
    final Font normalBoldFont = new Font(Font.FontFamily.HELVETICA, 12, Font.BOLD);
    final Font normalFont = new Font(Font.FontFamily.TIMES_ROMAN, 13);
    final Font smallFont = new Font(Font.FontFamily.HELVETICA, 10);
    final Font smallBoldFont = new Font(Font.FontFamily.HELVETICA, 10, Font.BOLD);

    final int LEFT = PdfPCell.ALIGN_LEFT;
    final int RIGHT = PdfPCell.ALIGN_RIGHT;
    final int CENTER = PdfPCell.ALIGN_CENTER;
    final int JUSTIFIED = PdfPCell.ALIGN_JUSTIFIED_ALL;
    final int MIDDLE = PdfPCell.ALIGN_MIDDLE;
    
    final Chunk SEPARATOR = new Chunk(new LineSeparator(1f, 95, BaseColor.BLACK, Element.ALIGN_CENTER, 0));

    public InputStream authorizationPdf(AuthorizationDTO auth) {

    	//StreamedContent file;
        try {

            /*double value = 0;/*
            if (tickets != null && !tickets.isEmpty()) {
                for (Ticket t : tickets) {
                    if (t.getStatus().equals("PA PAGUAR")) {
                        value += new Double(t.getAmount());
                    }
                }
            }
*/
        	 Document document = new Document(PageSize.A4, 5, 5, 20, 5);
             ByteArrayOutputStream baos = new ByteArrayOutputStream();
             PdfWriter.getInstance(document, baos);

             document.open();
        /*
            String imageUrl = "http://www.quicklyjava.com/wp-content/themes"
                     + "/hybrid-news/images/sitelogo.png";
             Image image = Image.getInstance(new URL(imageUrl));
             document.add(image);
         */
             
             
             Paragraph paragraf;
             float[] widths;
             PdfPTable table3;
             
             
             Image image = Image.getInstance("C:/test/logo.png");
             image.setAlignment(CENTER);
             image.scalePercent(100, 70);
             document.add(image);

             table3 = new PdfPTable(1);
             table3.getDefaultCell().setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
             table3.getDefaultCell().setBorder(PdfPCell.NO_BORDER);
             table3.setWidthPercentage(90);
             table3.addCell(new Phrase("MINISTRIA E BRENDSHME", bigFont));
             document.add(table3);

             table3 = new PdfPTable(1);
             table3.getDefaultCell().setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
             table3.getDefaultCell().setBorder(PdfPCell.NO_BORDER);
             table3.setWidthPercentage(90);
             table3.addCell(new Phrase("DREJTORIA E PËRGJITHSHME E POLICISË SË SHTETIT", bigFont));
             document.add(table3);

             paragraf = new Paragraph("\n");
             document.add(paragraf);

             PdfPTable table = new PdfPTable(2);

             table.setWidthPercentage(88);
             table.getDefaultCell().setBorder(PdfPCell.NO_BORDER);
             table.getDefaultCell().setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
             table.addCell(new Phrase("Nr._______Prot.", new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.NORMAL)));
             table.getDefaultCell().setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
             table.addCell(new Phrase("Tiranë, më datë____.____.2018", new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.NORMAL)));

             //cell.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
             //PdfPCell cell = new PdfPCell(new Phrase("Tiranë, më datë____.____.2018", new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.NORMAL)));
             //cell.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
             //cell.setBorder(PdfPCell.NO_BORDER);
             document.add(table);

             paragraf = new Paragraph("\n");
             document.add(paragraf);

             table = new PdfPTable(1);
             table.getDefaultCell().setBorder(PdfPCell.NO_BORDER);
             table.getDefaultCell().setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
             table.addCell(new Phrase("Adresa: Bulevardi “Bajram Curri” Tiranë - Shqipëri,  Tel/Fax +355 42222179", italicFont));
             document.add(table);

             paragraf = new Paragraph("\n");
             document.add(paragraf);

             table = new PdfPTable(1);
             table.getDefaultCell().setBorder(PdfPCell.NO_BORDER);
             table.getDefaultCell().setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
             table.addCell(new Phrase("A U T O R I Z I M", bigBoldFont));
             document.add(table);

             paragraf = new Paragraph("\n");
             document.add(paragraf);
             paragraf = new Paragraph("\n");
             document.add(paragraf);
       
             table = new PdfPTable(1);
             table.getDefaultCell().setBorder(PdfPCell.NO_BORDER);
             table.getDefaultCell().setHorizontalAlignment(PdfPCell.ALIGN_JUSTIFIED);
             table.setWidthPercentage(90);
             table.addCell(new Phrase("Mbështetur në Planin e Veprimit Nr. 499 Prot, datë 26.04.2018, me qëllim realizimin e porosive të lëna nga Drejtori i Përgjithshem i Policisë së Shtetit, Drejtues Madhor Ardi VELIU ,mbi programimin e masave per sezonin turistik 2018 si dhe te objektivave të organizatës në funksion të garantimit të rendit e sigurisë publike gjatë fluksit veror, për plotësimin e nevojave për sigurimin dhe mbajtjen në gatishmëri të mjeteve të ndërlidhjes dhe komunikimit, si ato fikse e të lëvizshme, pajisjeve të tjera të nevojshme për kryerjen e detyrave gjatë periudhës verore:", normalFont));
             document.add(table);

             paragraf = new Paragraph("\n");
             document.add(paragraf);

             table = new PdfPTable(1);
             table.getDefaultCell().setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
             table.getDefaultCell().setBorder(PdfPCell.NO_BORDER);
             table.setWidthPercentage(90);
             table.addCell(new Phrase("I. Objekt i shërbimit : ", normalBoldFont));
             document.add(table);

             paragraf = new Paragraph("\n");
             document.add(paragraf);

             table = new PdfPTable(1);
             table.getDefaultCell().setHorizontalAlignment(PdfPCell.ALIGN_JUSTIFIED);
             table.getDefaultCell().setBorder(PdfPCell.NO_BORDER);
             table.setWidthPercentage(90);
             table.addCell(new Phrase("Konfigurimi, formatimi dhe kontroll i parametrave teknike të kompjuterëve, printerëve dhe skanerëve të pashaportave në PKK Porti Vlorë, PKKKakavijë, PKK Porti Sarandë, PKK Tre Urat.", normalFont));
             document.add(table);

             paragraf = new Paragraph("\n");
             document.add(paragraf);

             table = new PdfPTable(1);
             table.getDefaultCell().setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
             table.getDefaultCell().setBorder(PdfPCell.NO_BORDER);
             table.setWidthPercentage(90);
             table.addCell(new Phrase("II. Njësia shpenzuese : ", normalBoldFont));
             document.add(table);

             paragraf = new Paragraph("\n");
             document.add(paragraf);

             table = new PdfPTable(1);
             table.getDefaultCell().setHorizontalAlignment(PdfPCell.ALIGN_JUSTIFIED);
             table.getDefaultCell().setBorder(PdfPCell.NO_BORDER);
             table.setWidthPercentage(90);
             table.addCell(new Phrase("1. PKK Porti Vlorë\n"
                     + "2. PKK Kakavijë \n"
                     + "3. PKK Porti Sarandë\n"
                     + "4. PKK Tre Urat", normalFont));
             document.add(table);

             paragraf = new Paragraph("\n");
             document.add(paragraf);

             widths = new float[]{4f, 6f};
             table = new PdfPTable(2);
             table.setWidthPercentage(90);
             table.setWidths(widths);
             table.getDefaultCell().setBorder(PdfPCell.NO_BORDER);
             table.addCell(new Phrase("III. Koha e realizimit të shërbimit : ", normalBoldFont));
             table.addCell(new Phrase("19.05.2018-21.05.2018", normalFont));
             document.add(table);

             paragraf = new Paragraph("\n");
             document.add(paragraf);

             table = new PdfPTable(1);
             table.getDefaultCell().setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
             table.getDefaultCell().setBorder(PdfPCell.NO_BORDER);
             table.setWidthPercentage(90);
             table.addCell(new Phrase("IV. Grupi i punës : ", normalBoldFont));
             document.add(table);

             paragraf = new Paragraph("\n");
             document.add(paragraf);

             table = new PdfPTable(1);
             table.getDefaultCell().setHorizontalAlignment(PdfPCell.ALIGN_JUSTIFIED);
             table.getDefaultCell().setBorder(PdfPCell.NO_BORDER);
             table.setWidthPercentage(90);
             table.addCell(new Phrase("1. Lorela Shehu \n"
                     + "2. Bruno Veizaj \n"
                     + "3. Besjana Zjarri \n"
                     + "4. Kleivis Hasani", normalFont));
             document.add(table);

             paragraf = new Paragraph("\n");
             document.add(paragraf);

             widths = new float[]{0.3f, 9.7f};
             table = new PdfPTable(2);
             table.setWidthPercentage(90);
             table.setWidths(widths);
             table.getDefaultCell().setBorder(PdfPCell.NO_BORDER);
             table.addCell(new Phrase("V.", normalBoldFont));
             table.addCell(new Phrase("Punonjësit që do të aktivizohen për kryerjen e shërbimit, do të trajtohen financiarisht sipas përcaktimit ne VKM nr. 997, datë 10.12.2010 “Për trajtimin financiar të punonjësve që dërgohen me shërbim jashtë qendrës së punës, brenda vendit”, i ndryshuar.", normalFont));
             document.add(table);

             paragraf = new Paragraph("\n");
             document.add(paragraf);

             table = new PdfPTable(1);
             table.getDefaultCell().setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
             table.getDefaultCell().setBorder(PdfPCell.NO_BORDER);
             table.setWidthPercentage(90);
             table.addCell(new Phrase("VI. Raportimi :  ", normalBoldFont));
             document.add(table);

             paragraf = new Paragraph("\n");
             document.add(paragraf);

             table = new PdfPTable(1);
             table.getDefaultCell().setHorizontalAlignment(PdfPCell.ALIGN_JUSTIFIED);
             table.getDefaultCell().setBorder(PdfPCell.NO_BORDER);
             table.setWidthPercentage(90);
             table.addCell(new Phrase("Në përfundim të kryerjes së shërbimit, të hartohet informacioni ne lidhje me punën e bere.", normalFont));
             document.add(table);

             paragraf = new Paragraph("\n");
             document.add(paragraf);
             paragraf = new Paragraph("\n");
             document.add(paragraf);

             table = new PdfPTable(1);
             table.getDefaultCell().setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
             table.getDefaultCell().setBorder(PdfPCell.NO_BORDER);
             table.setWidthPercentage(90);
             table.addCell(new Phrase("DREJTORI I PËRGJITHSHËM I POLICISË SË SHTETIT\n\n", new Font(Font.FontFamily.TIMES_ROMAN, 13, Font.BOLD)));
             document.add(table);

             table = new PdfPTable(1);
             table.getDefaultCell().setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
             table.getDefaultCell().setBorder(PdfPCell.NO_BORDER);
             table.setWidthPercentage(90);
             table.addCell(new Phrase("Drejtues Madhor  Ardi VELIU\n", new Font(Font.FontFamily.TIMES_ROMAN, 13, Font.BOLD)));
             document.add(table);

             //document.add(paragraf);
             paragraf = new Paragraph("\n");
             document.add(paragraf);
             paragraf = new Paragraph("\n");
             document.add(paragraf);

             table = new PdfPTable(1);
             table.getDefaultCell().setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
             table.getDefaultCell().setBorder(PdfPCell.NO_BORDER);
             table.setWidthPercentage(90);
             table.addCell(new Phrase("Konc/printoi", normalFont));
             document.add(table);

             table = new PdfPTable(1);
             table.getDefaultCell().setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
             table.getDefaultCell().setBorder(PdfPCell.NO_BORDER);
             table.setWidthPercentage(90);
             table.addCell(new Phrase("Alda TELHAJ", normalFont));
             document.add(table);

             table = new PdfPTable(1);
             table.getDefaultCell().setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
             table.getDefaultCell().setBorder(PdfPCell.NO_BORDER);
             table.setWidthPercentage(90);
             table.addCell(new Phrase("Shefi i Sektorit Helpdesk", normalFont));
             document.add(table);

             table = new PdfPTable(1);
             table.getDefaultCell().setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
             table.getDefaultCell().setBorder(PdfPCell.NO_BORDER);
             table.setWidthPercentage(90);
             table.addCell(new Phrase("Alda TELHAJ", normalFont));
             document.add(table);

             paragraf = new Paragraph("\n");
             document.add(paragraf);

             table = new PdfPTable(1);
             table.getDefaultCell().setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
             table.getDefaultCell().setBorder(PdfPCell.NO_BORDER);
             table.setWidthPercentage(90);
             table.addCell(new Phrase("Drejtori i TI", normalFont));
             document.add(table);

             table = new PdfPTable(1);
             table.getDefaultCell().setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
             table.getDefaultCell().setBorder(PdfPCell.NO_BORDER);
             table.setWidthPercentage(90);
             table.addCell(new Phrase("Kryekomisar Ernest DIMASHI", normalFont));
             document.add(table);

             paragraf = new Paragraph("\n");
             document.add(paragraf);

             table = new PdfPTable(1);
             table.getDefaultCell().setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
             table.getDefaultCell().setBorder(PdfPCell.NO_BORDER);
             table.setWidthPercentage(90);
             table.addCell(new Phrase("Drejtor i Departamentit për Shërbimet Mbështetëse", normalFont));
             document.add(table);

             table = new PdfPTable(1);
             table.getDefaultCell().setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
             table.getDefaultCell().setBorder(PdfPCell.NO_BORDER);
             table.setWidthPercentage(90);
             table.addCell(new Phrase("Drejtues i Lartë Theodhori GRAVANI", normalFont));
             document.add(table);

             document.close();

             InputStream stream = new ByteArrayInputStream(baos.toByteArray());
             //file = new DefaultStreamedContent(stream, "application/pdf");
             return stream;

         } catch (Exception e) {
             e.printStackTrace();
             return null;
         }

     }
  

}

