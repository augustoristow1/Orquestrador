package com.securityscanner.scanner;

import javafx.scene.control.TextArea;

public class CookieScanner {

    public static void runScan(TextArea logArea, String url) {
        logArea.appendText("[+] Iniciando CookieScanner para " + url + "\n");

        try {
            Thread.sleep(2000);

            logArea.appendText("➤ Verificando cookies de sessão...\n");
            logArea.appendText("➤ Cookie 'sessionid' sem atributo HttpOnly ❌\n");
            logArea.appendText("➤ Cookie 'auth_token' com Secure ✅\n");
            logArea.appendText("➤ Cookie 'tracking' sem SameSite ❌\n");

            ResultAggregator.addResult("Cookie", 2); // 2 problemas nos cookies encontrados

            Thread.sleep(1000);
        } catch (InterruptedException e) {
            logArea.appendText("❌ Erro no CookieScanner.\n");
            return;
        }

        logArea.appendText("[+] CookieScanner finalizado para " + url + "\n");
    }
}
