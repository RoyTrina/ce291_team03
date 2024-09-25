import java.awt.*;
import java.util.ArrayList;
import org.jfree.chart.*;
import org.jfree.data.statistics.*;
import org.jfree.chart.plot.PlotOrientation;
import javax.swing.*;

public class Histogram {

    private SimpleHistogramDataset data;

    public Histogram(ArrayList<Integer> array, String type) {
        JFrame frame = new JFrame();

        //adjust size and set layout
        frame.setPreferredSize (new Dimension (800, 500));
        frame.setLayout (null);


        //uses a double array to input data, SimpleHistogramDataset doesn't allow for ArrayList Integers, so putting the data into a double array was a better option
        int count = array.size();
        double[] set = new double[count];

        int c = 0;
        for (int x : array) {
            set[c] = x;
            c++;
        }
        
        // create a SimpleHistogramDataset, including the Histogram Bin (width of the Bar on X Axis) goes up to 0-100, in 10 unit increments
        data = new SimpleHistogramDataset("Key");
        data.addBin(new SimpleHistogramBin(0, 10, true, false));
        data.addBin(new SimpleHistogramBin(10, 20, true, false));
        data.addBin(new SimpleHistogramBin(20, 30, true, false));
        data.addBin(new SimpleHistogramBin(30, 40, true, false));
        data.addBin(new SimpleHistogramBin(40, 50, true, false));
        data.addBin(new SimpleHistogramBin(50, 60, true, false));
        data.addBin(new SimpleHistogramBin(60, 70, true, false));
        data.addBin(new SimpleHistogramBin(70, 80, true, false));
        data.addBin(new SimpleHistogramBin(80, 90, true, false));
        data.addBin(new SimpleHistogramBin(90, 100, true, true));
        data.addObservations(set);

        // create the chart with integer axis labels
        JFreeChart chart = ChartFactory.createHistogram("Histogram for " + type, "Mark Achieved", "Frequency", data, PlotOrientation.VERTICAL, false, false, false);

        // set up the UI
        ChartPanel panel = new ChartPanel(chart);
        frame.getContentPane().setLayout(new BorderLayout());
        frame.getContentPane().add(panel);

        frame.setVisible(true);
        frame.pack();
    }
}
