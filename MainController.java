package com.securityscanner.app;

import com.securityscanner.scanner.*;
import javafx.application.Platform;
import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class MainController {

    @FXML
    private TextArea logArea;

    @FXML
    private TextField urlField;

    private String getUrl() {
        String url = urlField.getText();
        if (url.isEmpty()) {
            appendLog("❌ Por favor, insira uma URL.");
            return null;
        }
        return url;
    }

    private void runInBackground(Runnable task) {
        Task<Void> backgroundTask = new Task<>() {
            @Override
            protected Void call() {
                task.run();
                return null;
            }
        };
        new Thread(backgroundTask).start();
    }

    private void appendLog(String message) {
        Platform.runLater(() -> logArea.appendText(message + "\n"));
    }

    @FXML
    private void runHeaderScan() {
        String url = getUrl();
        if (url == null) return;
        runInBackground(() -> SecurityHeaderScanner.runScan(logArea, url));
    }

    @FXML
    private void runPortScan() {
        String url = getUrl();
        if (url == null) return;
        runInBackground(() -> PortScanner.runScan(logArea, url));
    }

    @FXML
    private void runDirScan() {
        String url = getUrl();
        if (url == null) return;
        runInBackground(() -> DirectoryBruteForce.runScan(logArea, url));
    }

    @FXML
    private void runFingerprint() {
        String url = getUrl();
        if (url == null) return;
        runInBackground(() -> Fingerprinting.runScan(logArea, url));
    }

    @FXML
    private void runCveSearch() {
        String url = getUrl();
        if (url == null) return;
        runInBackground(() -> CVESearch.runScan(logArea, url));
    }

    @FXML
    private void runSubdomainScan() {
        String url = getUrl();
        if (url == null) return;
        runInBackground(() -> SubdomainScanner.runScan(logArea, url));
    }

    @FXML
    private void runSSLScan() {
        String url = getUrl();
        if (url == null) return;
        runInBackground(() -> SSLScanner.runScan(logArea, url));
    }

    @FXML
    private void runFileScan() {
        String url = getUrl();
        if (url == null) return;
        runInBackground(() -> FileScanner.runScan(logArea, url));
    }

    @FXML
    private void runCookieCheck() {
        String url = getUrl();
        if (url == null) return;
        runInBackground(() -> CookieScanner.runScan(logArea, url));
    }

    @FXML
    private void generateReport() {
        String url = getUrl();
        if (url == null) return;
        runInBackground(() -> ReportGenerator.generate(logArea, url));
    }

    @FXML
    private void generatePDF() {
        String url = getUrl();
        if (url == null) return;
        runInBackground(() -> PDFReportGenerator.generate(logArea, url));
    }

    @FXML
    private void showGraph() {
        GraphWindow.showGraph();
    }
}
