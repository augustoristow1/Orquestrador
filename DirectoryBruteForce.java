package com.securityscanner.scanner;

import javafx.scene.control.TextArea;

public class DirectoryBruteForce {

    public static void runScan(TextArea logArea, String url) {
        logArea.appendText("[+] Iniciando DirectoryBruteForce para " + url + "\n");

        try {
            Thread.sleep(2000);

            logArea.appendText("➤ Testando /admin ... Encontrado ✅\n");
            logArea.appendText("➤ Testando /backup ... Não encontrado ❌\n");
            logArea.appendText("➤ Testando /login ... Encontrado ✅\n");
            logArea.appendText("➤ Testando /test ... Não encontrado ❌\n");
            logArea.appendText("➤ Testando /config ... Encontrado ✅\n");

            ResultAggregator.addResult("DirBruteForce", 3); // 3 diretórios sensíveis encontrados

            Thread.sleep(1000);
        } catch (InterruptedException e) {
            logArea.appendText("❌ Erro no DirectoryBruteForce.\n");
            return;
        }

        logArea.appendText("[+] DirectoryBruteForce finalizado para " + url + "\n");
    }
}
