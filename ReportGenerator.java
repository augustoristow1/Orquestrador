package com.securityscanner.scanner;

import javafx.scene.control.TextArea;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;

public class ReportGenerator {

    public static void generate(TextArea logArea, String url) {
        logArea.appendText("[+] Gerando relatório para " + url + "\n");

        String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss"));
        String filename = "Relatorio_" + url.replaceAll("[^a-zA-Z0-9]", "_") + "_" + timestamp + ".txt";

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            writer.write("========== Relatório de Análise de Segurança ==========\n");
            writer.write("Alvo: " + url + "\n");
            writer.write("Data e Hora: " + LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")) + "\n\n");

            writer.write("========== Resumo dos Scanners ==========\n");
            for (Map.Entry<String, Integer> entry : ResultAggregator.getResults().entrySet()) {
                writer.write(entry.getKey() + " → " + entry.getValue() + " problema(s) encontrado(s)\n");
            }

            writer.write("\n========== Logs Detalhados ==========\n");
            writer.write(logArea.getText());
            writer.flush();

            logArea.appendText("[+] Relatório gerado com sucesso: " + filename + "\n");
        } catch (IOException e) {
            logArea.appendText("❌ Erro ao gerar o relatório.\n");
            e.printStackTrace();
        }
    }
}
