/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rysowanie.wielomianu;



import static java.lang.StrictMath.pow;
import java.util.Scanner;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

/**
 *
 * @author Lenovo
 */
public class RysowanieWielomianu {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner odczyt = new Scanner(System.in);
        System.out.println("Podaj stopień wielomianu");
        int n = odczyt.nextInt();
        System.out.println("Podaj współczynniki wielomianu od tego z najwiekszym stopniem");
        double a[] = new double[n+1];
        for(int k=n; k>=0; k--)  
        {
            a[k] = odczyt.nextDouble();
        }
        System.out.println("Twój wielomian to :");
        for(int k=n; k>=1; k--)  
        {
            System.out.print( a[k] +"x^" +k +" + ");
        }
        System.out.println(a[0]);
        System.out.println("Podaj początek zakresu rysowania");
        int xp = odczyt.nextInt();
        System.out.println("Podaj koniec zakresu rysowania");
        int xk = odczyt.nextInt();
        double y=0;
        double p;
//    		Dane do wykresu 3d
		XYSeries series = new XYSeries("XYGraph");
		for(int x = xp; x<xk; x++)
                {
                    for(int i =0; i<=n; i++)
                    {
                        p = pow(x,i);
                        y = y +a[i]* p;
                        
                    }
                    System.out.println("x = " + x + " y = " +y);
                    series.add(x, y);
                    y=0;
                }
		
		XYSeriesCollection dataset = new XYSeriesCollection();
		dataset.addSeries(series);
		//Tworzymy wykres XY
		JFreeChart chart = ChartFactory.createXYLineChart(
			"Wykres XY",//Tytuł
			"x- Lable", // x-axis Opis
			"y- Lable", // y-axis Opis
			dataset, // Dane
			PlotOrientation.VERTICAL, // Orjentacja wykresu /HORIZONTAL
			true, // pozkaż legende
			true, // podpowiedzi tooltips
			false
		);
 
		//Dodanie wykresu do okna
		ChartFrame frame1=new ChartFrame("XYArea Chart",chart);
		frame1.setVisible(true);
		frame1.setSize(500,400);
	}
}
