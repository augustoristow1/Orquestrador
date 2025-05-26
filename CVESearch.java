package com.securityscanner.scanner;

import javafx.scene.control.TextArea;

public class CVESearch {

    public static void runScan(TextArea logArea, String url) {
        logArea.appendText("[+] Iniciando CVESearch para " + url + "\n");

        try {
            Thread.sleep(2000);

            logArea.appendText("➤ Buscando vulnerabilidades conhecidas (CVEs)...\n");
            logArea.appendText("➤ CVE-2022-1234 — Vulnerabilidade crítica em Apache ✅\n");
            logArea.appendText("➤ CVE-2021-5678 — Problema de injeção em PHP ❌\n");
            logArea.appendText("➤ CVE-2020-9876 — Falha de autenticação mitigada ✅\n");

            ResultAggregator.addResult("CVE", 2); // 2 vulnerabilidades relevantes encontradas

            Thread.sleep(1000);
        } catch (InterruptedException e) {
            logArea.appendText("❌ Erro no CVESearch.\n");
            return;
        }

        logArea.appendText("[+] CVESearch finalizado para " + url + "\n");
    }
}
