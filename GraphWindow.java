package com.securityscanner.app;

import com.securityscanner.scanner.ResultAggregator;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.chart.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.Map;

public class GraphWindow {

    public static void showGraph() {
        Platform.runLater(() -> {
            Stage stage = new Stage();
            stage.setTitle("Gráfico de Resultados");

            CategoryAxis xAxis = new CategoryAxis();
            xAxis.setLabel("Scanner");

            NumberAxis yAxis = new NumberAxis();
            yAxis.setLabel("Problemas encontrados");

            BarChart<String, Number> barChart = new BarChart<>(xAxis, yAxis);
            barChart.setTitle("Resultados da Análise de Segurança");

            XYChart.Series<String, Number> dataSeries = new XYChart.Series<>();
            dataSeries.setName("Detectado");

            for (Map.Entry<String, Integer> entry : ResultAggregator.getResults().entrySet()) {
                dataSeries.getData().add(new XYChart.Data<>(entry.getKey(), entry.getValue()));
            }

            barChart.getData().add(dataSeries);

            VBox vbox = new VBox(barChart);
            Scene scene = new Scene(vbox, 600, 400);
            stage.setScene(scene);
            stage.show();
        });
    }
}
