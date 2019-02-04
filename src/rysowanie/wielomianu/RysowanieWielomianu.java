/*
 * Program przygotowany przez Damian Kargol
 * Rysuje funkcje zadanego stopnia linowa kwadratową wielomianową 
 * 
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
        double a[] = new double[n+1]; // tablica przechowująca współczynniki wielomianów 
        
        for(int k=n; k>=0; k--)  
        {
            a[k] = odczyt.nextDouble();
        }
        System.out.println("Twój wielomian to :");
        // pętla pokazująca obliczony wielomian 
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
		XYSeries series = new XYSeries("XY WYkres funkcji");
                // początek pętli obliczającej kolejne wartości funkcji 
		for(int x = xp; x<xk; x++)
                {
                    for(int i =0; i<=n; i++) // pętla działająca jak szereg obliczająca wartosć Y w zadanym X
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
			"x", // x-axis Opis
			"y", // y-axis Opis
			dataset, // Dane
			PlotOrientation.VERTICAL, // Orjentacja wykresu /HORIZONTAL
			true, // pozkaż legende
			true, // podpowiedzi tooltips
			false
		);
 
		//Dodanie wykresu do okna
		ChartFrame frame1=new ChartFrame("WYkres",chart);
		frame1.setVisible(true);
		frame1.setSize(500,400);
	}
}
