import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;

public class Window extends JPanel {

    //extra features
    private JLabel label;
    private JCheckBox darkMode;

    // Initialise Content Tables
    private JList subjectList;
    private DefaultTableModel defaultTable;
    private JTable table;

    private String filename;

    private ArrayList<Student> array;
    private JFrame frame;

    private Color frameBackgroundColor;

    // Constructor
    @SuppressWarnings("unchecked")
    public Window(ArrayList<Student> students, String file) {
        filename = file;

        // clones the array that has been passed through to a private variable into this, this is used for the other classes Histogram and Barchart
        array = (ArrayList<Student>)students.clone();

        // creates the window for the program
        frame = new JFrame ("Student Marks Analyser - Analysing " + file);
        frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
        frameBackgroundColor = frame.getBackground();

        //construct preComponents
        DefaultListModel<String> subjectsList = new DefaultListModel<>();
        String[] subjects = {"Average Mark", "CE101FY", "CE101SP", "CE141AU", "CE141FY", "CE142AU", "CE142FY", "CE151AU", "CE152SP", "CE153AU", "CE154SP", "CE155SP", "CE161AU", "CE162SP", "CE163AU", "CE164SP"};
        // adds this to a JList, bottom left list on the program
        for (String i : subjects) {
            subjectsList.addElement(i);
        }

        //set up menubar contents
        JMenu fileMenu = new JMenu ("File");
        JMenuItem exitItem = new JMenuItem ("Exit");
        exitItem.addActionListener(new exit());
        fileMenu.add (exitItem);
        JMenuItem open_fileItem = new JMenuItem ("Open File");
        open_fileItem.addActionListener(new buttonOpenClick());
        fileMenu.add (open_fileItem);

        JMenu helpMenu = new JMenu ("Help");
        JMenuItem contentsItem = new JMenuItem ("How to Use");
        contentsItem.addActionListener(new howTo());
        helpMenu.add (contentsItem);
        JMenuItem aboutItem = new JMenuItem ("About");
        aboutItem.addActionListener(new aboutProduct());
        helpMenu.add (aboutItem);

        //construct components
        // Initialise Button Variables with Action Listeners
        JButton openButton = new JButton("Open File");
        openButton.addActionListener(new buttonOpenClick());

        JButton averageButton = new JButton("Mean, Mode, Median for Subject");
        averageButton.addActionListener(new averagesOutput());

        JButton barChartButton = new JButton("Open Bar Chart");
        barChartButton.addActionListener(new openBarChart());

        JButton histogramButton = new JButton("Open Histogram");
        histogramButton.addActionListener(new openHistogram());

        JButton filterSubject = new JButton("Filter by Subject");
        filterSubject.addActionListener(new filterBySubject());

        JButton exportPDF = new JButton("Export All Data to PDF");
        exportPDF.addActionListener(new exportData());

        subjectList = new JList (subjectsList);
        subjectList.setFont(new Font("Arial", Font.BOLD, 18));
        DefaultListCellRenderer renderer =  (DefaultListCellRenderer)subjectList.getCellRenderer();
        renderer.setHorizontalAlignment(JLabel.CENTER);

        darkMode = new JCheckBox ("Toggle Dark Mode");
        darkMode.addActionListener(new darkMode());

        // Creating the main function of the Program, the table output
        // Using a DefaultTableModel to allow the use of a 2D array
        // array is the csv file converted and colNames is the column names of the first row of the csv file
        //Required for table
        String[] colNames = {"Reg. No", "ExNo", "Stage", "CE101FY", "CE101SP", "CE141AU", "CE141FY", "CE142AU", "CE142FY", "CE151AU", "CE152SP"
                , "CE153AU", "CE154SP", "CE155SP", "CE161AU", "CE162SP", "CE163AU", "CE164SP", "Average"};
        defaultTable = new DefaultTableModel(colNames,0);
        for (Student s : array) {
            String[] temp;
            temp = s.output();
            int count = 0;
            for (String i : s.output()){
                if (i.equals("-1")){
                    temp[count] = "";
                }
                count++;
            }
            defaultTable.addRow(temp);
        }
        table = new JTable(defaultTable);
        table.getColumnModel().getColumn(0).setPreferredWidth(100);
        table.getColumnModel().getColumn(2).setPreferredWidth(175);
        table.setAutoCreateRowSorter(true);
        table.getTableHeader().setReorderingAllowed(false);
        JScrollPane scrollBox = new JScrollPane(table);
        // This is used to allow for sorting on the program (currently used for Filtering Best/Worst Students)
        TableRowSorter<TableModel> sorter = new TableRowSorter<>(table.getModel());
        table.setRowSorter(sorter);

        label = new JLabel ("Student Marks Analyser - Team 03");

        //add menubar
        JMenuBar menuBar = new JMenuBar();
        menuBar.add (fileMenu);
        menuBar.add (helpMenu);

        //adjust size and set layout
        frame.setPreferredSize (new Dimension (1500, 850));
        frame.setLayout (null);

        //add components
        frame.add(openButton);
        frame.add(averageButton);
        frame.add(barChartButton);
        frame.add(histogramButton);
        frame.add(exportPDF);
        frame.add(subjectList);
        frame.add(scrollBox);
        frame.add(label);
        frame.add(filterSubject);
        frame.add(darkMode);
        frame.add(menuBar);

        //set component bounds (only needed by Absolute Positioning)
        openButton.setBounds (25, 80, 250, 30);
        filterSubject.setBounds (25, 120, 250, 30);
        averageButton.setBounds (25, 160, 250, 30);
        barChartButton.setBounds (25, 200, 250, 30);
        histogramButton.setBounds (25, 240, 250, 30);
        exportPDF.setBounds (25, 280, 250, 30);
        subjectList.setBounds (25, 330, 250, 410);
        scrollBox.setBounds (295, 40, 1175, 750);
        label.setBounds (50, 40, 205, 30);
        darkMode.setBounds (85, 755, 130, 30);
        menuBar.setBounds (0, 0, 1500, 25);

        frame.pack();
        frame.setVisible (true);
        frame.setResizable(false);
    }

    // exit closes the program and returns exit code 0, quite simple.
    public class exit implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            System.exit(0);
        }
    }

    // aboutProduct Executes a JDialog in ContextMenu
    public class aboutProduct implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            ContextMenu.about();
        }
    }

    // aboutProduct Executes a JDialog in ContextMenu
    public class howTo implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            ContextMenu.tutorial();
        }
    }

    // buttonOpenClick executes Student.main() which opens a new fileReader
    public class buttonOpenClick implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            for (Student i : array) {
                i.callMain();
                frame.dispose();
                break;
            }
        }
    }

    public class openBarChart implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            JFrame message = new JFrame();
            ArrayList<Integer> data = new ArrayList<>();

            int index = subjectList.getSelectedIndex();
            if (index == 0) {

            }

            else if (index != -1) {
                String selection = (String) subjectList.getSelectedValue();
                for (Student s : array) {
                    if (s.getMark(selection) != -1) {
                        data.add(s.getMark(selection));
                    }
                }

                new BarChart(data, selection);
            }

            else {
                JOptionPane.showMessageDialog(message, "There was no subject selected in the list, please select a subject on the left list.");
            }
        }
    }

    public class openHistogram implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            JFrame message = new JFrame();
            ArrayList<Integer> data = new ArrayList<Integer>();

            int index = subjectList.getSelectedIndex();
            if (index == 0) {

            }

            else if (index != -1) {
                String selection = (String) subjectList.getSelectedValue();
                for (Student s : array) {
                    if (s.getMark(selection) != -1) {
                        data.add(s.getMark(selection));
                    }
                }

                new Histogram(data, selection);
            }

            else {
                JOptionPane.showMessageDialog(message, "There was no subject selected in the list, please select a subject on the left list.");
            }
        }
    }

    public class averagesOutput implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            JFrame message = new JFrame();
            ArrayList<Integer> data = new ArrayList<>();

            int modeVal;
            double meanVal;
            double medianVal;
            String modeValError = "No valid Modal Value";

            int index = subjectList.getSelectedIndex();
            if (index == 0) {

            }

            else if (index != -1) {
                String selection = (String) subjectList.getSelectedValue();
                for (Student s : array) {
                    if (s.getMark(selection) != -1) {
                        data.add(s.getMark(selection));
                    }
                }

                Collections.sort(data);

                if (data.size() == 0) {
                    JOptionPane.showMessageDialog(message, "The selected subject has no data for it.");
                }

                else {
                    //insert mean variable
                    meanVal = Statistics.findMean(data);

                    //insert median variable
                    medianVal = Statistics.findMedian(data);

                    //insert mode variable
                    if (Statistics.findMode(data) != 0) {
                        modeVal = Statistics.findMode(data);
                        JOptionPane.showMessageDialog(message, "Mean, Mode, Median for Subject " + selection + "\nMean: " + meanVal + "\nMode: " + modeVal + "\nMedian: " + medianVal);
                    }
                    else {
                        JOptionPane.showMessageDialog(message, "Mean, Mode, Median for Subject " + selection + "\nMean: " + meanVal + "\nMode: " + modeValError + "\nMedian: " + medianVal);
                    }

                }

            }

            else {
                JOptionPane.showMessageDialog(message, "There was no subject selected in the list, please select a subject on the left list.");
            }
        }
    }

    public class filterBySubject implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            JFrame message = new JFrame();
            int index = subjectList.getSelectedIndex();

            if (index == 0) {
                outputAll();
            }

            else if (index != -1) {
                String selection = (String) subjectList.getSelectedValue();
                defaultTable.setRowCount(0);
                for (Student s : array) {
                    String[] temp;
                    temp = s.output();
                    int count = 0;
                    if (s.isDoing(selection)) {
                        for (String i : s.output()){
                            if (i.equals("-1")){
                                temp[count] = "";
                            }
                            count++;
                        }
                        defaultTable.addRow(temp);
                    }
                }
            }

            else {
                JOptionPane.showMessageDialog(message, "There was no subject selected in the list, please select a subject on the left list.");
                outputAll();
            }
        }

        private void outputAll() {
            for (Student s : array) {
                String[] temp;
                temp = s.output();
                int count = 0;
                for (String i : s.output()){
                    if (i.equals("-1")){
                        temp[count] = "";
                    }
                    count++;
                }
                defaultTable.addRow(temp);
            }
        }
    }

    public class exportData implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            JFrame message = new JFrame();
            JOptionPane.showMessageDialog(message, "Export Data to PDF.");
            ExportPDF.export(array, filename);
        }
    }

    public class darkMode implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if (darkMode.isSelected()) {
                //change main background
                frame.getContentPane().setBackground(Color.decode("#121212"));

                //change subjectList details
                subjectList.setBackground(Color.decode("#3C3C46"));
                subjectList.setForeground(Color.decode("#FFFFFF"));

                //change defaultTableModel
                table.setBackground(Color.decode("#3C3C46"));
                table.setForeground(Color.decode("#FFFFFF"));

                //change text
                label.setForeground(Color.decode("#FFFFFF"));

                //change darkMode toggle
                darkMode.setBackground(Color.decode("#121212"));
                darkMode.setForeground(Color.decode("#FFFFFF"));
            }
            else {
                //change main background
                frame.getContentPane().setBackground(frameBackgroundColor);

                //change subjectList details
                subjectList.setBackground(Color.WHITE);
                subjectList.setForeground(Color.decode("#333333"));

                //change defaultTableModel
                table.setBackground(Color.decode("#EEEEEE"));
                table.setForeground(Color.decode("#333333"));

                //change text
                label.setBackground(Color.BLACK);
                label.setForeground(Color.decode("#333333"));

                //change darkMode toggle
                darkMode.setBackground(Color.decode("#EEEEEE"));
                darkMode.setForeground(Color.decode("#333333"));
            }
        }
    }
}