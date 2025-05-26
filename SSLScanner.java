package com.securityscanner.scanner;

import javafx.scene.control.TextArea;

import javax.net.ssl.HttpsURLConnection;
import java.io.IOException;
import java.net.URL;

public class SSLScanner {

    public static void runScan(TextArea logArea, String url) {
        logArea.appendText("[+] Iniciando SSLScanner para " + url + "\n");

        try {
            // Tenta se conectar usando HTTPS
            URL httpsUrl = new URL("https://" + url);
            HttpsURLConnection conn = (HttpsURLConnection) httpsUrl.openConnection();
            conn.setConnectTimeout(5000);
            conn.connect();

            // Se chegou até aqui, SSL está disponível
            logArea.appendText("➤ Certificado SSL encontrado ✅\n");
            logArea.appendText("➤ Protocolo: " + conn.getCipherSuite() + "\n");

            ResultAggregator.addResult("SSL", 0); // Sem problema

        } catch (IOException e) {
            // Caso erro na conexão HTTPS (SSL inexistente)
            logArea.appendText("❌ SSL NÃO DISPONÍVEL no site " + url + "\n");
            logArea.appendText("➤ Detalhes do erro: " + e.getMessage() + "\n");

            ResultAggregator.addResult("SSL", 1); // Um problema encontrado
        }

        logArea.appendText("[+] SSLScanner finalizado para " + url + "\n");
    }
}
