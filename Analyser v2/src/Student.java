import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;
import java.util.List;

public class Student
{

    // initialising variables to hold Data for one student
    private static String filename;
    private static File selectedFile;
    private int RegNo, ExNo;
    private String Stage;
    private int CE101FY, CE101SP, CE141AU, CE141FY, CE142AU, CE142FY, CE151AU, CE152SP, CE153AU, CE154SP, CE155SP, CE161AU, CE162SP, CE163AU, CE164SP;
    private int TC_MK;

    // constructor to add student mark into Student Object
    public Student(int reg, int ex, String stg, int ce101fy, int ce101sp, int ce141au, int ce141fy, int ce142au, int ce142fy, int ce151au, int ce152sp, int ce153au, int ce154sp, int ce155sp, int ce161au, int ce162sp, int ce163au, int ce164sp, int tc_mk)
    {
        RegNo = reg; ExNo = ex;
        Stage = stg;
        CE101FY = ce101fy; CE101SP = ce101sp; CE141AU = ce141au; CE141FY = ce141fy;
        CE142AU = ce142au; CE142FY = ce142fy; CE151AU = ce151au; CE152SP = ce152sp;
        CE153AU = ce153au; CE154SP = ce154sp; CE155SP = ce155sp; CE161AU = ce161au;
        CE162SP = ce162sp; CE163AU = ce163au; CE164SP = ce164sp;
        TC_MK = tc_mk;
    }

    // calling main method to "Open New File" from Window
    public void callMain() {
        // Calling the main() method
        main(null);
    }

    // outputs a String Array for Histogram/ Bar Chart functions
    public String[] output() {
        return new String[]{String.valueOf(RegNo), String.valueOf(ExNo), Stage, String.valueOf(CE101FY), String.valueOf(CE101SP), String.valueOf(CE141AU), String.valueOf(CE141FY), String.valueOf(CE142AU), String.valueOf(CE142FY), String.valueOf(CE151AU), String.valueOf(CE152SP), String.valueOf(CE153AU), String.valueOf(CE154SP), String.valueOf(CE155SP), String.valueOf(CE161AU), String.valueOf(CE162SP), String.valueOf(CE163AU), String.valueOf(CE164SP), String.valueOf(TC_MK)};
    }

    // returns the private variable integer when the subject string is called in
    public int getMark(String subject) {
        if (subject.equals("CE101FY")) { if (CE101FY != -1) { return CE101FY; } }
        if (subject.equals("CE101SP")) { if (CE101SP != -1) { return CE101SP; } }
        if (subject.equals("CE141AU")) { if (CE141AU != -1) { return CE141AU; } }
        if (subject.equals("CE141FY")) { if (CE141FY != -1) { return CE141FY; } }
        if (subject.equals("CE142AU")) { if (CE142AU != -1) { return CE142AU; } }
        if (subject.equals("CE142FY")) { if (CE142FY != -1) { return CE142FY; } }
        if (subject.equals("CE151AU")) { if (CE151AU != -1) { return CE151AU; } }
        if (subject.equals("CE152SP")) { if (CE152SP != -1) { return CE152SP; } }
        if (subject.equals("CE153AU")) { if (CE153AU != -1) { return CE153AU; } }
        if (subject.equals("CE154SP")) { if (CE154SP != -1) { return CE154SP; } }
        if (subject.equals("CE155SP")) { if (CE155SP != -1) { return CE155SP; } }
        if (subject.equals("CE161AU")) { if (CE161AU != -1) { return CE161AU; } }
        if (subject.equals("CE162SP")) { if (CE162SP != -1) { return CE162SP; } }
        if (subject.equals("CE163AU")) { if (CE163AU != -1) { return CE163AU; } }
        if (subject.equals("CE164SP")) { if (CE164SP != -1) { return CE164SP; } }
        return -1;
    }

    // custom function to return a boolean to determine if the item passed through as argument is not -1, which is a empty cell in the excel
    public boolean isDoing(String subject) {
        if (subject.equals("CE101FY")) { if (CE101FY != -1) { return true; } }
        if (subject.equals("CE101SP")) { if (CE101SP != -1) { return true; } }
        if (subject.equals("CE141AU")) { if (CE141AU != -1) { return true; } }
        if (subject.equals("CE141FY")) { if (CE141FY != -1) { return true; } }
        if (subject.equals("CE142AU")) { if (CE142AU != -1) { return true; } }
        if (subject.equals("CE142FY")) { if (CE142FY != -1) { return true; } }
        if (subject.equals("CE151AU")) { if (CE151AU != -1) { return true; } }
        if (subject.equals("CE152SP")) { if (CE152SP != -1) { return true; } }
        if (subject.equals("CE153AU")) { if (CE153AU != -1) { return true; } }
        if (subject.equals("CE154SP")) { if (CE154SP != -1) { return true; } }
        if (subject.equals("CE155SP")) { if (CE155SP != -1) { return true; } }
        if (subject.equals("CE161AU")) { if (CE161AU != -1) { return true; } }
        if (subject.equals("CE162SP")) { if (CE162SP != -1) { return true; } }
        if (subject.equals("CE163AU")) { if (CE163AU != -1) { return true; } }
        if (subject.equals("CE164SP")) { if (CE164SP != -1) { return true; } }
        return false;
    }

    // custom function to return the string of courses of what a student does
    public String getCourses() {
        List<String> courses = new ArrayList<String>();
        StringBuilder text = new StringBuilder();

        if (CE101FY > -1) { courses.add("CE101FY"); }
        if (CE101SP > -1) { courses.add("CE101SP"); }
        if (CE141AU > -1) { courses.add("CE141AU"); }
        if (CE141FY > -1) { courses.add("CE141FY"); }
        if (CE142FY > -1) { courses.add("CE142FY"); }
        if (CE142AU > -1) { courses.add("CE142AU"); }
        if (CE151AU > -1) { courses.add("CE151AU"); }
        if (CE152SP > -1) { courses.add("CE152SP"); }
        if (CE153AU > -1) { courses.add("CE153AU"); }
        if (CE154SP > -1) { courses.add("CE154SP"); }
        if (CE155SP > -1) { courses.add("CE155SP"); }
        if (CE161AU > -1) { courses.add("CE161AU"); }
        if (CE162SP > -1) { courses.add("CE162SP"); }
        if (CE163AU > -1) { courses.add("CE163AU"); }
        if (CE164SP > -1) { courses.add("CE164SP"); }

        int count = courses.size();
        int tempCount = 0;
        for (String course : courses)
        {
            if (tempCount == count) { text.append(course); }
            else { text.append(course).append(", "); }
            count++;
        }
        return text.toString();
    }

    public String toString()
    {
        return "Registration Number: " + RegNo + ", Ex Number: " + ExNo + ", Courses: " + getCourses() + "AvgMark: " + TC_MK;
    }

    public static void main(String[] args)
    {
        ArrayList<Student> students = new ArrayList<Student>();
        try {
            // using a JFileChooser to allow the user to get a file anywhere on their computer, allows for ease of use.
            JFrame window = new JFrame("Choose a file for Marks Analysis");
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
            FileNameExtensionFilter filter = new FileNameExtensionFilter(".csv Files", "csv");
            fileChooser.setFileFilter(filter);
            int result = fileChooser.showOpenDialog(window);
            if (result == JFileChooser.APPROVE_OPTION) {
                selectedFile = fileChooser.getSelectedFile();
            }

            filename = fileChooser.getSelectedFile().getName();
            filename = filename.substring(0, filename.length() - 4);
        }
        // when cancel is
        catch (Exception ignored){
        }

        try (BufferedReader br = new BufferedReader(new FileReader(selectedFile))) {
            String line;

            // takes the first row in the csv file of the column names
            // only needs to run this once as there is only one row of Column names
            line = br.readLine();

            // runs a for loop to read every line of the csv file, each line of a csv file is split
            // with a comma - split helps with this function.
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                int count = 0;
                for (String i : values) {
                    if (i.equals("")) {
                        values[count]="-1";
                    }
                    count++;
                }
                Student student = new Student(Integer.parseInt(values[0]), Integer.parseInt(values[1]), values[2], Integer.parseInt(values[3]), Integer.parseInt(values[4]), Integer.parseInt(values[5]), Integer.parseInt(values[6]), Integer.parseInt(values[7]), Integer.parseInt(values[8]), Integer.parseInt(values[9]), Integer.parseInt(values[10]), Integer.parseInt(values[11]), Integer.parseInt(values[12]), Integer.parseInt(values[13]), Integer.parseInt(values[14]), Integer.parseInt(values[15]), Integer.parseInt(values[16]), Integer.parseInt(values[17]), Integer.parseInt(values[19]));
                students.add(student);
            }
            // using a empty 'sort' string to call into the Reference.Window Class
            String sort = "";
            new Window(students, filename);
        }

        // catch statement to output when file is incorrect format
        catch (NullPointerException ignored){
        }

        // catch statement to output when file is incorrect format
        catch (NumberFormatException e){
            JFrame error = new JFrame();
            JOptionPane.showMessageDialog(error, "Incorrect Format for Marks Analyser\nProgram will quit.");
        }

        // catch statement to output when the filename is not found by FileReader.
        catch (FileNotFoundException e) {
            JFrame error = new JFrame();
            JOptionPane.showMessageDialog(error, "File was not found. Please input correct file.\nProgram will quit.");
        }
        // catch statement when program has an error but isn't a FileNotFoundException
        catch (Exception e) {
            JFrame error = new JFrame();
            JOptionPane.showMessageDialog(error, "Program has encountered an error.\nProgram will quit.");
            e.printStackTrace();
        }
    }
}