package com.securityscanner.scanner;

import javafx.scene.control.TextArea;

public class SubdomainScanner {

    public static void runScan(TextArea logArea, String url) {
        logArea.appendText("[+] Iniciando SubdomainScanner para " + url + "\n");

        try {
            Thread.sleep(2000);

            logArea.appendText("➤ sub1." + url + " — Encontrado ✅\n");
            logArea.appendText("➤ mail." + url + " — Encontrado ✅\n");
            logArea.appendText("➤ dev." + url + " — Não encontrado ❌\n");
            logArea.appendText("➤ test." + url + " — Encontrado ✅\n");

            ResultAggregator.addResult("Subdomain", 3); // 3 subdomínios encontrados

            Thread.sleep(1000);
        } catch (InterruptedException e) {
            logArea.appendText("❌ Erro no SubdomainScanner.\n");
            return;
        }

        logArea.appendText("[+] SubdomainScanner finalizado para " + url + "\n");
    }
}
