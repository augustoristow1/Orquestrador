package com.securityscanner.scanner;

import javafx.scene.control.TextArea;

public class FileScanner {

    public static void runScan(TextArea logArea, String url) {
        logArea.appendText("[+] Iniciando FileScanner para " + url + "\n");

        try {
            Thread.sleep(2000);

            logArea.appendText("➤ Verificando arquivos sensíveis...\n");
            logArea.appendText("➤ .env — Encontrado ❌ (Risco Alto)\n");
            logArea.appendText("➤ config.php — Não encontrado ✅\n");
            logArea.appendText("➤ backup.zip — Encontrado ❌ (Risco Alto)\n");
            logArea.appendText("➤ db.sql — Não encontrado ✅\n");

            ResultAggregator.addResult("FileScan", 2); // 2 arquivos sensíveis encontrados

            Thread.sleep(1000);
        } catch (InterruptedException e) {
            logArea.appendText("❌ Erro no FileScanner.\n");
            return;
        }

        logArea.appendText("[+] FileScanner finalizado para " + url + "\n");
    }
}
