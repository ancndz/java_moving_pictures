package java.kursovaya.app;

import javax.swing.*;


public class CenterPanel extends JPanel {

    //коэффициенты уравнения
    private double coefA = 1;
    private double coefB = 0;
    private double coefC = 0;

    //
    private double rightBorder = 100;
    private double leftBorder = -100;

    //название функции здесь задается для того, что бы было при вхождении в программу
    private String functionName = "Прямая";
    //private ChangeFunc.Functions function = ChangeFunc.Functions.LINE;
    //чарт - компонент, на котором отображается поле с графиком
    //private JFreeChart chart = createChart();

    public void setBorders(double[] borders) {
        this.rightBorder = borders[1];
        this.leftBorder = borders[0];
    }

    public void setParams(double[] params) {
        this.coefA = params[0];
        this.coefB = params[1];
        this.coefC = params[2];
    }

    public void setFunctionName(String functionName) {
        this.functionName = functionName;
    }

    /*public void setFunction(ChangeFunc.Functions function) {
        this.function = function;
    }*/

    //метод для пересчета данных по функции, сохраненной в этом объекте (см. выше - function)
    /*public XYSeriesCollection makeDataSet() {
        XYSeriesCollection dataset = new XYSeriesCollection();
        //канал - название
        XYSeries channel = new XYSeries("Функция " + functionName);
        double i;
        for (i = this.leftBorder; i <= this.rightBorder; i++) {
            channel.add(i, this.function.function(i, this.coefA, this.coefB, this.coefC));
        }
        dataset.addSeries(channel);
        return dataset;
    }*/

    //создание чарта - области, на котором расположены данные
    /*private JFreeChart createChart(){
        return ChartFactory.createXYLineChart(
                createGraphName() ,
                "X" ,
                "Y" ,
                makeDataSet(),
                PlotOrientation.VERTICAL ,
                true , false , false);
    }*/

    public double getCoefA() {
        return coefA;
    }

    public double getCoefB() {
        return coefB;
    }

    public double getCoefC() {
        return coefC;
    }

    public String getFunctionName() {
        return functionName;
    }

    public String createGraphName() {
        return "График функции " + "\"" + this.functionName + "\"";
    }

    /*public JFreeChart getChart() {
        this.chart.setTitle(createGraphName());
        return chart;
    }*/

    //чарт панель - на ней расположен чарт
    /*public ChartPanel getChartPanel() {
        return new ChartPanel(this.chart);
    }*/

    private static final long serialVersionUID = 1L;
}

