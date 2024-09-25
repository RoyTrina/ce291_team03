import javax.swing.*;

public class ContextMenu {
    public static void about() {
        JFrame about = new JFrame("About Student Marks Analyser");
        JOptionPane.showMessageDialog(about, "Marks Analyser, Created By Team 03\nTeam 03 Members:\n- Klive Comia\n- Falah Albinfalah\n- Arpan Patel\n- Trina Roy\n- Mohnseenur Bashar\n- Ben Brown\n- Rakib Siddique\nhttps://cseegit.essex.ac.uk/2019_ce291/ce291_team03/");
    }

    public static void tutorial() {
        JFrame about = new JFrame("How to use Student Marks Analyser");
        JOptionPane.showMessageDialog(about, "Open a .csv file with the relative layout");
        JOptionPane.showMessageDialog(about, "Select a Subject on a Side to use Functions");
        JOptionPane.showMessageDialog(about, "Once selecting a Subject, you can:\n- Filter By Subject\n- Show Mean, Mode, Median \n- Export to Bar Chart/ Histogram");
    }
}
