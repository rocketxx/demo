package com.example.demo.controller;

import com.example.demo.model.Order;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.PdfDocument;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import java.io.ByteArrayOutputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.FileNotFoundException;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class PdfEmailController {

    @Autowired
    private JavaMailSender mailSender;

    @PostMapping("/send-pdf-email")
    public String sendPdfEmail(@RequestBody Map<String, Object> jsonData, 
                               @RequestParam String recipientEmail) {
        try {
            byte[] pdfBytes = generatePdf(jsonData);
            sendEmailWithAttachment(recipientEmail, pdfBytes);

            return "Email inviata con successo";
        } catch (Exception e) {
            e.printStackTrace();
            return "Errore nell'invio dell'email: " + e.getMessage();
        }
    }

    private byte[] generatePdf(Map<String, Object> jsonData) throws FileNotFoundException, DocumentException {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        // PdfWriter writer = new PdfWriter(null, outputStream);
        PdfDocument pdf = new PdfDocument();
        Document document = new Document();

        for (Map.Entry<String, Object> entry : jsonData.entrySet()) {
            document.add(new Paragraph(entry.getKey() + ": " + entry.getValue().toString()));
        }

        document.close();
        return outputStream.toByteArray();
    }

    private void sendEmailWithAttachment(String recipientEmail, byte[] pdfBytes) throws MessagingException {
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);

        helper.setTo(recipientEmail);
        helper.setSubject("Ecco il PDF generato");
        helper.setText("In allegato trovi il PDF generato a partire dal JSON fornito.");

        ByteArrayResource pdfResource = new ByteArrayResource(pdfBytes);
        helper.addAttachment("documento.pdf", pdfResource);

        mailSender.send(message);
    }

    @PostMapping("/create-pdf-order")
    public ResponseEntity<byte[]> createPdfOrder() {
        // Creazione del documento PDF
        Document document = new Document();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

        try {
            // Creazione del writer per il documento
            PdfWriter.getInstance(document, byteArrayOutputStream);
            document.open();

            // Aggiunta del titolo
            Font titleFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 18);
            Paragraph title = new Paragraph("Ordine", titleFont);
            title.setAlignment(Paragraph.ALIGN_CENTER);
            document.add(title);

            // Aggiunta di uno spazio vuoto
            document.add(new Paragraph(" "));

            // Aggiunta del paragrafo
            Font contentFont = FontFactory.getFont(FontFactory.HELVETICA, 12);
            Paragraph content = new Paragraph("Panino con patatine, maionese e salsa rosa", contentFont);
            content.setAlignment(Paragraph.ALIGN_LEFT);
            document.add(content);

            document.close();
        } catch (DocumentException e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body(null); // Risposta in caso di errore
        }

        // Conversione del documento in array di byte
        byte[] pdfBytes = byteArrayOutputStream.toByteArray();

        // Creazione della risposta con il PDF generato
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_PDF);
        headers.setContentDispositionFormData("attachment", "ordine.pdf");
        headers.setContentLength(pdfBytes.length);

        return ResponseEntity.ok()
                .headers(headers)
                .body(pdfBytes);
    }

    @PostMapping("/create-pdf-with-input-order")
    public ResponseEntity<byte[]> createPdfOrderFromOrderEntity(@RequestBody Order order) {
        // Creazione del documento PDF
        Document document = new Document();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

        try {
            // Creazione del writer per il documento
            PdfWriter.getInstance(document, byteArrayOutputStream);
            document.open();

            // Aggiunta del titolo
            Font titleFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 18);
            Paragraph title = new Paragraph("Ordine", titleFont);
            title.setAlignment(Paragraph.ALIGN_CENTER);
            document.add(title);

            // Aggiunta di uno spazio vuoto
            document.add(new Paragraph(" "));

            // Aggiunta del paragrafo
            Font contentFont = FontFactory.getFont(FontFactory.HELVETICA, 12);
            Paragraph content = new Paragraph( "Da inviare in: "+ order.getDeliveryAddress(), contentFont);
            Paragraph content2 = new Paragraph( "Totale: "+ order.getTotalPrice(), contentFont);
            // Paragraph content = new Paragraph(order.getItems().get(0).getNote(), contentFont);
            content.setAlignment(Paragraph.ALIGN_LEFT);
            document.add(content);
            document.add(content2);

            document.close();
        } catch (DocumentException e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body(null); // Risposta in caso di errore
        }

        // Conversione del documento in array di byte
        byte[] pdfBytes = byteArrayOutputStream.toByteArray();

        // Creazione della risposta con il PDF generato
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_PDF);
        headers.setContentDispositionFormData("attachment", "ordine.pdf");
        headers.setContentLength(pdfBytes.length);

        return ResponseEntity.ok()
                .headers(headers)
                .body(pdfBytes);
    }
}
