/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edo_metodo_euler;

import java.awt.BasicStroke;
import java.awt.Color;
import javax.swing.JFrame;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.ui.RefineryUtilities;

/**
 *
 * @author antonio
 */
public class GraficoEuler extends JFrame{
    
    
    public GraficoEuler(String applicationTitle, double [] valoresYReal, double [] valoresYEuler, double [] valoresX){
        super(applicationTitle);
        JFreeChart lineChart = ChartFactory.createXYLineChart("Método de Euler Resultados","X" ,"Y", criarDataset(valoresYReal, valoresYEuler, valoresX), PlotOrientation.VERTICAL, true, true, false);
    
        ChartPanel painel = new ChartPanel(lineChart);
        
        //Configurações Visuais
        XYPlot plot = lineChart.getXYPlot();
        XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer( );
        
        renderer.setSeriesPaint( 0 , Color.GREEN );
        renderer.setSeriesStroke( 0 , new BasicStroke( 1.0f ) );
        
        renderer.setSeriesPaint( 1 , Color.RED );
        renderer.setSeriesStroke( 1 , new BasicStroke( 1.0f ) );
        
        plot.setBackgroundPaint(Color.DARK_GRAY);
        plot.setRenderer(renderer);
        
        renderer.setBaseShapesVisible(false);//Tirar para elucidar os pontos
        
        setSize(640 , 480 );
        setContentPane(painel);
    
    
    
    
    
    
    }
    
    public XYDataset criarDataset (double [] valoresYReal, double [] valoresYEuler, double [] valoresX){
        XYSeriesCollection dataset = new XYSeriesCollection(); 
        
        XYSeries serieYReal = new XYSeries("Valores Y Analitico");
        for(int i = 0; i < valoresYReal.length; i++){//-1, RESOLVER DEPOIS
            serieYReal.add(valoresX[i], valoresYReal[i]);
        
        
        
        }
        
        
        XYSeries serieYEuler = new XYSeries("Valores Y Euler");
        
        for(int i = 0; i < valoresYEuler.length; i++){
            serieYEuler.add(valoresX[i], valoresYEuler[i]);
        
        
        
        
        
        
        }
        
        dataset.addSeries(serieYReal);
        dataset.addSeries(serieYEuler);
        
        
        
        
        return dataset;   
    
    
    
    
    
    
    }
    
    public void constroiGrafico(double [] valoresYReal, double [] valoresYEuler, double [] valoresX){
        GraficoEuler graficoE = new GraficoEuler("Euler", valoresYReal, valoresYEuler, valoresX);
        graficoE.pack();
        RefineryUtilities.centerFrameOnScreen(graficoE);
        graficoE.setVisible(true);
    
    
    
    
    
    }
    
    
    
    
    
    
    
}
