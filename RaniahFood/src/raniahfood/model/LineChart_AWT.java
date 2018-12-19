/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package raniahfood.model;

/**
 *
 * @author Rizki Achmad Riyanto <your.name at your.org>
 */
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

public class LineChart_AWT extends ApplicationFrame  {

   public LineChart_AWT( String applicationTitle , String chartTitle,int[] array ) {
      super(applicationTitle);
      JFreeChart lineChart = ChartFactory.createLineChart(
         chartTitle,
         "Bulan","Pendapatan",
         createDataset(array),
         PlotOrientation.VERTICAL,
         true,true,false);
         
      ChartPanel chartPanel = new ChartPanel( lineChart );
      chartPanel.setPreferredSize( new java.awt.Dimension( 1200 , 600 ) );
      setContentPane( chartPanel );
       WindowAdapter windowAdapter = new WindowAdapter()
       {
           public void windowClosing(WindowEvent we)
           {
               setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
           }
       };
       addWindowListener(windowAdapter);
//      this.addWindowListener(new WindowAdapter() {
//        public void windowClosing(WindowEvent we) {
//            this.setVisible(false);
//        }
//      });
   }

   private DefaultCategoryDataset createDataset(int[] array) {
      DefaultCategoryDataset dataset = new DefaultCategoryDataset( );
      dataset.addValue( array[0] , "bulan" , "Januari" );
      dataset.addValue( array[1] , "bulan" , "Februari" );
      dataset.addValue( array[2] , "bulan" ,  "Maret" );
      dataset.addValue( array[3] , "bulan" , "April" );
      dataset.addValue( array[4] , "bulan" , "Mei" );
      dataset.addValue( array[5] , "bulan" , "Juni" );
      dataset.addValue( array[6] , "bulan" , "Agustus" );
      dataset.addValue( array[7] , "bulan" , "September" );
      dataset.addValue( array[8] , "bulan" ,  "Oktober" );
      dataset.addValue( array[9] , "bulan" , "November" );
      dataset.addValue( array[10] , "bulan" , "Desember" );
      return dataset;
   }
   
}
