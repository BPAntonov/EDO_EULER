/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edo_metodo_euler;

/**
 *
 * @author antonio
 */

import java.lang.Math;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;
import org.jfree.ui.RefineryUtilities;

public class Solucao {
    
    private double valor_h;//Variacao do "x"
    private double tabela_solucao;
    
    private double[] valoresX;
    private double[] valoresYReal;
    private double[] valoresYEuler;
    
    
    public Solucao(){
    
    
    
    }
    
    
    public double y_derivada(double x, double y){//Retorna y'
        return ((Math.cos(x) * Math.sin(x) - (x*(Math.pow(y,2)))) / (((-1)*y)*(1 - (Math.pow(x,2)))));
    
    }
    
    public double y_solucao_analitica(double x){//Retorna o cálculo pela solucao analitica, feita a mao
        return(Math.sqrt(((Math.pow(Math.sin(x), 2)) - 4) / (Math.pow(x,2) - 1)));
    
    
    
    
    
    }
    
    public double erro(double yreal, double yobtido){//Retorna o erro obtido com a iteração;
        return (Math.abs(yreal - yobtido));
    
    
    }
    
    public void driver(){
        ArrayList<Double> valoresX = new ArrayList<Double>();
        ArrayList<Double> valoresYReal = new ArrayList<Double>();
        ArrayList<Double> valoresYEuler = new ArrayList<Double>();
        
        
        int n = 0;
        //BigDecimal aux_x;
        
        
        double x = 0;
        this.valor_h = 0.01;
        
        
        //DecimalFormat nF = new DecimalFormat("#.###");//Corta os 3 decimais
        
        
        double yr = this.y_solucao_analitica(x);//Preparação da 1 iteração
        double y = yr;

        System.out.println(" N " + " X " + " Y " + " YR " + " Erro ");
        
        //https://stackoverflow.com/questions/11017367/adding-really-small-values-in-java

        

        while(x<1){
            
            valoresX.add(x);
            valoresYReal.add(yr);
            valoresYEuler.add(y);
            
            
            System.out.println(n + " | " + x + " | " + y +" | " + yr +" | "+(this.erro(yr, y)));//Imprime a saida da iteracao 
            
            x = x + this.valor_h;
            
            yr = this.y_solucao_analitica(x);//Valor gerado na funcao c/ resolução analítica
 
            
            y = y + this.y_derivada(x, y) * this.valor_h;//Yk+1//Formula do Método de euler
            
            
            
            n++;//Conta iteracoes
        }
        
        this.valoresX = new double [valoresX.size()];
        this.valoresYReal = new double [valoresYReal.size()];
        this.valoresYEuler = new double [valoresYEuler.size()];
        
        for(int i = 0; i < valoresX.size(); i++){
            this.valoresX[i] = valoresX.get(i);
            this.valoresYReal[i] = valoresYReal.get(i);
            this.valoresYEuler[i] = valoresYEuler.get(i);
        
        
        
        
        }

    
    
    
    
    }
    
    public void gerarGrafico(){
        GraficoEuler g1 = new GraficoEuler("Euler", this.valoresYReal, this.valoresYEuler, this.valoresX);
        g1.pack();
        RefineryUtilities.centerFrameOnScreen(g1);
        g1.setVisible(true);
        
    
    
    
    
    }
    
    
    public void impressao_final(){//Imprimir a matriz contendo os valores calculados
    
    
    
    
    
    }
    
    
}
