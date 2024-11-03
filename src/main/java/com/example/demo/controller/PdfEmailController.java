package com.example.demo.controller;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.ByteArrayOutputStream;
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
            // Genera il PDF
            byte[] pdfBytes = generatePdf(jsonData);

            // Invia l'email con il PDF come allegato
            sendEmailWithAttachment(recipientEmail, pdfBytes);

            return "Email inviata con successo";
        } catch (Exception e) {
            e.printStackTrace();
            return "Errore nell'invio dell'email: " + e.getMessage();
        }
    }

    private byte[] generatePdf(Map<String, Object> jsonData) throws DocumentException {
        // Usa un ByteArrayOutputStream per generare il PDF in memoria
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        Document document = new Document();
        PdfWriter.getInstance(document, outputStream);

        // Apre il documento per scrivere contenuti
        document.open();
        
        // Creazione del contenuto PDF dal JSON
        for (Map.Entry<String, Object> entry : jsonData.entrySet()) {
            document.add(new Paragraph(entry.getKey() + ": " + entry.getValue().toString()));
        }

        // Chiudi il documento
        document.close();
        
        // Ritorna il contenuto del PDF come array di byte
        return outputStream.toByteArray();
    }

    private void sendEmailWithAttachment(String recipientEmail, byte[] pdfBytes) throws MessagingException {
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);

        // Configura i dettagli dell'email
        helper.setTo(recipientEmail);
        helper.setSubject("Ecco il PDF generato");
        helper.setText("In allegato trovi il PDF generato a partire dal JSON fornito.");

        // Allegato come risorsa in memoria
        ByteArrayResource pdfResource = new ByteArrayResource(pdfBytes);
        helper.addAttachment("documento.pdf", pdfResource);

        // Invia l'email
        mailSender.send(message);
    }
}
