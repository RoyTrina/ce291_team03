import java.util.ArrayList;
import org.jfree.chart.*;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.chart.plot.PlotOrientation;

public class BarChart {

    public BarChart(ArrayList<Integer> array, String type) {
        int count = array.size();

        //uses a double array to input data, DefaultCategoryDataset doesn't allow for ArrayList Integers, so putting the data into a double array was a better option
        double[] set = new double[count];

        int c = 0;
        for (int x : array) {
            set[c] = x;
            c++;
        }

        // creates a dataset to allow data to be inputted
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        count = 1;
        for (double i : set) {
            dataset.addValue(i, "Marks", Integer.toString(count));
            count++;
        }

        // bar chart of results
        // create the chart with integer axis labels
        JFreeChart chart = ChartFactory.createBarChart("Bar Chart for " + type, "Data", "Mark", dataset, PlotOrientation.VERTICAL, false, false, false);
        ChartFrame frame = new ChartFrame("Bar Chart", chart);
        frame.setVisible(true);
        frame.setSize(800,500);
    }
}
