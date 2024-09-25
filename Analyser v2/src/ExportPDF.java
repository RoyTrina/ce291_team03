import com.itextpdf.text.Document;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import java.io.*;
import java.util.ArrayList;

public class ExportPDF {

    private static String outputFile;
    private static String[] colNames = {"Reg. No", "ExNo", "Stage", "CE101FY", "CE101SP", "CE141AU", "CE141FY", "CE142AU", "CE142FY", "CE151AU", "CE152SP"
            , "CE153AU", "CE154SP", "CE155SP", "CE161AU", "CE162SP", "CE163AU", "CE164SP", "Average"};


    public static void export(ArrayList<Student> data, String filename) {
        try {
            JFrame message = new JFrame();
            outputFile = filename + ".pdf";

            JOptionPane.showMessageDialog(message, "Saving file as " + outputFile);
            Paragraph paragraph = new Paragraph(filename + " Export");

            //create DefaultTableModel (same code as Window.java)
            DefaultTableModel defaultTable = new DefaultTableModel(colNames,0);
            for (Student s : data) {
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
            JTable table = new JTable(defaultTable);
            table.getColumnModel().getColumn(0).setPreferredWidth(100);
            table.getColumnModel().getColumn(2).setPreferredWidth(175);
            table.setAutoCreateRowSorter(true);
            table.getTableHeader().setReorderingAllowed(false);
            JScrollPane scrollBox = new JScrollPane(table);
            // This is used to allow for sorting on the program (currently used for Filtering Best/Worst Students)
            TableRowSorter<TableModel> sorter = new TableRowSorter<>(table.getModel());
            table.setRowSorter(sorter);

            int count = table.getRowCount();

            // initialise document for PDF
            Document document = new Document(PageSize.A4.rotate(),0,0,0,0);
            PdfWriter.getInstance(document, new FileOutputStream(outputFile));
            document.open();

            //create PDF Table
            PdfPTable tablePDF = new PdfPTable(19);
            for (String i : colNames){
                tablePDF.addCell(i);
            }

            // for loop to add cells into PDFPTable
            for (int i = 0; i < count; i++) {
                for (int x = 0; x < 19; x++) {
                    Object obj = returnCell(table, i, x);
                    String str = obj.toString();
                    tablePDF.addCell(str);
                }
            }

            // add table and text to main document
            document.add(paragraph);
            document.add(tablePDF);
            document.close();
        }

        catch (Exception e) {
            JFrame error = new JFrame();
            JOptionPane.showMessageDialog(error, "Program has encountered an error, please make sure the file you are trying to create (" + outputFile + ") is not open in the background.");
        }
    }
    
    // return cell value
    private static Object returnCell(JTable table, int row_index, int col_index) {
        return table.getModel().getValueAt(row_index, col_index);
    }
}
