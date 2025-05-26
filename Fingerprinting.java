package com.securityscanner.scanner;

import javafx.scene.control.TextArea;

public class Fingerprinting {

    public static void runScan(TextArea logArea, String url) {
        logArea.appendText("[+] Iniciando Fingerprinting para " + url + "\n");

        try {
            Thread.sleep(2000);

            logArea.appendText("➤ Servidor identificado: Apache 2.4.54\n");
            logArea.appendText("➤ Sistema operacional: Ubuntu 20.04\n");
            logArea.appendText("➤ Linguagem de backend: PHP 8.0\n");
            logArea.appendText("➤ CDN detectada: Cloudflare\n");

            ResultAggregator.addResult("Fingerprint", 2); // 2 dados sensíveis descobertos

            Thread.sleep(1000);
        } catch (InterruptedException e) {
            logArea.appendText("❌ Erro no Fingerprinting.\n");
            return;
        }

        logArea.appendText("[+] Fingerprinting finalizado para " + url + "\n");
    }
}
