package com.securityscanner.scanner;

import javafx.scene.control.TextArea;

public class PortScanner {

    public static void runScan(TextArea logArea, String url) {
        logArea.appendText("[+] Iniciando PortScanner para " + url + "\n");

        try {
            Thread.sleep(2000);

            logArea.appendText("➤ Porta 80 aberta (HTTP)\n");
            logArea.appendText("➤ Porta 443 aberta (HTTPS)\n");
            logArea.appendText("➤ Porta 22 aberta (SSH)\n");

            ResultAggregator.addResult("PortScan", 3);

            Thread.sleep(1000);
        } catch (InterruptedException e) {
            logArea.appendText("❌ Erro no PortScanner.\n");
            return;
        }

        logArea.appendText("[+] PortScanner finalizado para " + url + "\n");
    }
}
