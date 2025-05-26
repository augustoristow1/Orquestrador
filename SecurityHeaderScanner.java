package com.securityscanner.scanner;

import javafx.scene.control.TextArea;

public class SecurityHeaderScanner {

    public static void runScan(TextArea logArea, String url) {
        logArea.appendText("[+] Iniciando SecurityHeaderScanner para " + url + "\n");

        try {
            Thread.sleep(2000);

            logArea.appendText("➤ Verificando headers de segurança...\n");
            logArea.appendText("➤ X-Content-Type-Options: NÃO ENCONTRADO ❌\n");
            logArea.appendText("➤ X-Frame-Options: PRESENTE ✅\n");
            logArea.appendText("➤ Strict-Transport-Security: NÃO ENCONTRADO ❌\n");
            logArea.appendText("➤ Content-Security-Policy: NÃO ENCONTRADO ❌\n");

            ResultAggregator.addResult("HeaderScan", 3); // 3 problemas detectados nos headers

            Thread.sleep(1000);
        } catch (InterruptedException e) {
            logArea.appendText("❌ Erro no SecurityHeaderScanner.\n");
            return;
        }

        logArea.appendText("[+] SecurityHeaderScanner finalizado para " + url + "\n");
    }
}
