package assignment3;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

class Assignment3 extends JFrame {

    static final String file = "src/main/resources/SwordForecasting.csv";
    List<Integer> data;

    Assignment3(String appTitle, String chartTitle) throws IOException {
        super(appTitle);
        data = getData();

        JFreeChart chart = ChartFactory.createXYLineChart(chartTitle, "Months", "Demand", createDataSet(data));
        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new java.awt.Dimension(1000, 540));
        setContentPane(chartPanel);
    }

    private XYDataset createDataSet(List<Integer> data) {
        XYSeries line = new XYSeries("Line");

        for (int i = 0; i < data.size(); i++) {
            line.add(i + 1, data.get(i));
        }

        XYSeriesCollection dataset = new XYSeriesCollection();
        dataset.addSeries(line);
        return dataset;
    }

    static List<Integer> getData() throws IOException {
        BufferedReader in = new BufferedReader(new FileReader(file));

        List<Integer> result = new ArrayList<>();

        String line;
        while ((line = in.readLine()) != null) {
            result.add(Integer.valueOf(line));
        }

        return result;
    }
}
