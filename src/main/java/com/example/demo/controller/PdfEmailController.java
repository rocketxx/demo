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
import org.springframework.mail.SimpleMailMessage;
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


    @PostMapping("/send-email-with-order-pdf")
    public ResponseEntity<String> sendEmailWithAttachment(@RequestParam String recipient, @RequestParam String body, @RequestBody Order order) {
        String subject = "Ordine Dettagliato";

        try {
            // Genera il PDF usando il metodo createPdfOrderFromOrderEntity
            byte[] pdfBytes = createPdfOrderFromOrderEntity(order).getBody();
            if (pdfBytes == null) {
                return ResponseEntity.status(500).body("Errore durante la creazione del PDF");
            }

            // Creazione del messaggio email
            MimeMessage message = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setTo(recipient);
            helper.setSubject(subject);
            helper.setText(body);

            // Aggiunta del PDF come allegato
            ByteArrayResource pdfAttachment = new ByteArrayResource(pdfBytes);
            helper.addAttachment("ordine.pdf", pdfAttachment);

            mailSender.send(message);
            return ResponseEntity.ok("Email inviata con successo a " + recipient);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body("Errore durante l'invio dell'email");
        }
    }

    // Metodo per creare PDF da un oggetto Order
    @PostMapping("/create-pdf-with-input-order")
    public ResponseEntity<byte[]> createPdfOrderFromOrderEntity(@RequestBody Order order) {
        Document document = new Document();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

        try {
            PdfWriter.getInstance(document, byteArrayOutputStream);
            document.open();

            // Aggiunta del titolo
            Font titleFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 18);
            Paragraph title = new Paragraph("Ordine", titleFont);
            title.setAlignment(Paragraph.ALIGN_CENTER);
            document.add(title);

            document.add(new Paragraph(" "));  // Aggiunta di uno spazio vuoto

            // Aggiunta del contenuto basato su `Order`
            Font contentFont = FontFactory.getFont(FontFactory.HELVETICA, 12);
            Paragraph content = new Paragraph("Da inviare in: " + order.getDeliveryAddress(), contentFont);
            Paragraph content2 = new Paragraph("Totale: " + order.getTotalPrice(), contentFont);
            content.setAlignment(Paragraph.ALIGN_LEFT);
            document.add(content);
            document.add(content2);

            document.close();
        } catch (DocumentException e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body(null); // Risposta in caso di errore
        }

        byte[] pdfBytes = byteArrayOutputStream.toByteArray();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_PDF);
        headers.setContentDispositionFormData("attachment", "ordine.pdf");
        headers.setContentLength(pdfBytes.length);

        return ResponseEntity.ok()
                .headers(headers)
                .body(pdfBytes);
    }

}
