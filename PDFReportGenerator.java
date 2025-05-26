package com.securityscanner.scanner;

import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfWriter;
import javafx.scene.control.TextArea;

import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;

public class PDFReportGenerator {

    public static void generate(TextArea logArea, String url) {
        logArea.appendText("[+] Gerando relatório PDF para " + url + "\n");

        String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss"));
        String filename = "Relatorio_" + url.replaceAll("[^a-zA-Z0-9]", "_") + "_" + timestamp + ".pdf";

        Document document = new Document();

        try {
            PdfWriter.getInstance(document, new FileOutputStream(filename));
            document.open();

            document.add(new Paragraph("========== Relatório de Análise de Segurança =========="));
            document.add(new Paragraph("Alvo: " + url));
            document.add(new Paragraph("Data e Hora: " + LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"))));
            document.add(new Paragraph("\n"));

            document.add(new Paragraph("========== Resumo dos Scanners =========="));
            for (Map.Entry<String, Integer> entry : ResultAggregator.getResults().entrySet()) {
                document.add(new Paragraph(entry.getKey() + " → " + entry.getValue() + " problema(s) encontrado(s)"));
            }

            document.add(new Paragraph("\n========== Logs Detalhados =========="));
            document.add(new Paragraph(logArea.getText()));

            document.close();
            logArea.appendText("[+] Relatório PDF gerado com sucesso: " + filename + "\n");
        } catch (DocumentException | IOException e) {
            logArea.appendText("❌ Erro ao gerar o relatório PDF.\n");
            e.printStackTrace();
        }
    }
}
