package gui.admin;

/*
IT Tallaght - 2015, S2
Computing - Year 2, Project
Group 17 (George - 05/04/2015)
*/

import gui.DataProcessor;
import gui.FormValidator;
import gui.UIElements;
import javax.print.*;
import javax.print.event.PrintJobAdapter;
import javax.print.event.PrintJobEvent;
import javax.swing.*;
import javax.swing.border.EtchedBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.Scanner;

public class Log extends JDialog implements ActionListener {

    private JDialog log;
    private JTextArea taMain;
    private JPanel pnlMain, pnlSouth;
    private JButton btnBack, btnSave, btnClear, btnPrint;
    private JFileChooser saver;
    File logFile = new File("src/res/log.txt");
    Scanner in;

    // Read more: http://www.javaexperience.com/java-file-printing-example-to-print-files-in-java/#ixzz3XabTfK5i
    PrintJobWatcher watcher;
    InputStream fileIn;
    DocFlavor flavor;

    public Log(JDialog parent) { // passing in the parent keeps this window above it and inherits parents characteristics (on top for example), but allows click access to parent. to disallow click access log.setModal(true)

        log = new JDialog(parent);
        log.setTitle("System Log");
        log.setSize(500, 400);
        log.setLocationRelativeTo(null);
//        log.setResizable(false);
        log.setModal(true);
        log.setLayout(new BorderLayout());

// MAIN PANEL

        // create main panel that will hold the scroll pane
        pnlMain = new JPanel(new GridLayout()); // to stretch one item across the whole panel use either new BorderLayout() or new GridLayout(). GridBagLayout() centers, does not stretch, neither does FlowLayout()
        pnlMain.setBackground(UIElements.getColour());

        // create text area
        taMain = new JTextArea();
        taMain.setEditable(false);
        taMain.setLineWrap(true);

        // create the scroll pane that will contain the text area
        JScrollPane scroll = new JScrollPane(taMain);
        scroll.setBorder(new EtchedBorder(EtchedBorder.LOWERED));
        scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        // add scroll main panel (jpanel -> scroll -> area)
        pnlMain.add(scroll);

        // add main panel to jdialog
        log.add(pnlMain, BorderLayout.CENTER);

// BUTTONS PANEL

        // create the buttons panel that will hold the buttons
        pnlSouth = new JPanel(new FlowLayout(FlowLayout.CENTER));
        pnlSouth.setBackground(UIElements.getColour());

        // create buttons and add them to south panel
        btnBack = new JButton("Back");
        btnBack.setPreferredSize(new Dimension(100, 28));
        btnBack.setIcon(new ImageIcon(UIElements.cancel6));
        btnBack.addActionListener(this);
        pnlSouth.add(btnBack);

        btnPrint = new JButton("Print");
        btnPrint.setPreferredSize(new Dimension(100, 28));
        btnPrint.setIcon(new ImageIcon(UIElements.print16));
        btnPrint.addActionListener(this);
        pnlSouth.add(btnPrint);

        btnSave = new JButton("Save");
        btnSave.setPreferredSize(new Dimension(100, 28));
        btnSave.setIcon(new ImageIcon(UIElements.save16));
        btnSave.addActionListener(this);
        pnlSouth.add(btnSave);

        btnClear = new JButton("Clear");
        btnClear.setPreferredSize(new Dimension(100, 28));
        btnClear.setIcon(new ImageIcon(UIElements.remove16));
        btnClear.addActionListener(this);
        pnlSouth.add(btnClear);

        // add south panel to jpanel
        log.add(pnlSouth, BorderLayout.SOUTH);

        displayLog();

        // make jdialog to visible
        log.setVisible(true);
    }

// METHODS

    public void displayLog() {
        try {
            in = new Scanner(new FileReader(logFile));
            while (in.hasNextLine()) {
                taMain.append(in.nextLine() + "\r\n"); // note: if writing(out) don't use "\n" - that only works on *nix windows Notepad will not recognize this and show everything in one line. User either "\r\n" (Windows) or System.getProperty("line.separator") - which is system independent
            }
        } catch (IOException io) {
            JOptionPane.showMessageDialog(null, "Log File Not Found");
        }
    }

    public void saveLogFile() {
        try {
            BufferedWriter logWriter = new BufferedWriter(new FileWriter(saver.getSelectedFile()));
            logWriter.write(taMain.getText());
            logWriter.close();
            JOptionPane.showMessageDialog(null, "Log file saved in - " + saver.getSelectedFile());
        } catch (IOException io) {
            JOptionPane.showMessageDialog(null, "Problem Saving File");
        }
    }

    public void cleanLog() {
        if (FormValidator.isEmptyField(taMain.getText())) {
            JOptionPane.showMessageDialog(null, "Log file is empty. Nothing to clear");
        } else {
            try {
                FileWriter logCleaner = new FileWriter(logFile);
                logCleaner.write(""); // clears the log file
                taMain.setText(""); // clears the text area
                JOptionPane.showMessageDialog(null, "Log file cleared");
            } catch (IOException o) {
                JOptionPane.showMessageDialog(null, "Problem clearing log");
            }
        }
    }

// BUTTON ACTIONS

    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(btnBack)) {
            log.dispose();
        } else if (e.getSource().equals(btnClear)) {
            cleanLog();
        } else if (e.getSource().equals(btnPrint)) {
            if (!FormValidator.isEmptyField(taMain.getText())) {

                try {
                    fileIn = new FileInputStream(logFile);
                } catch (FileNotFoundException fnf) {
                    JOptionPane.showMessageDialog(null, "File not found", "Non-existent file", JOptionPane.ERROR_MESSAGE);
                }

                PrintService defaultPrinter = PrintServiceLookup.lookupDefaultPrintService();

                if (defaultPrinter != null) {
                    flavor = DocFlavor.INPUT_STREAM.AUTOSENSE;
                    // AttributeSet attributeSet = new HashAttributeSet();
                    //  attributeSet.add(new PrinterName("Default Printer", null));
                    DocPrintJob job = defaultPrinter.createPrintJob();
                    Doc doc = new SimpleDoc(fileIn, flavor, null);
                    watcher = new PrintJobWatcher(job);
                    try {
                        job.print(doc, null);
                    } catch (PrintException pe) {
                        JOptionPane.showMessageDialog(null, "Problem with printer", "Printer does not work", JOptionPane.ERROR_MESSAGE);
                    }
                    watcher.waitForDone();
                    try {
                        fileIn.close();
                    } catch (IOException io) {
                        JOptionPane.showMessageDialog(null, "Could not close file", "File in use", JOptionPane.ERROR_MESSAGE);
                    }
                    JOptionPane.showMessageDialog(null, "Printing in progress", "Print", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "No default print service found", "Print", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Log file is empty. Nothing to print");
            }
        }
        else if (e.getSource().equals(btnSave)) {
            if (!FormValidator.isEmptyField(taMain.getText())) {
                saver = new JFileChooser();
                //saver.setCurrentDirectory(new File("%UserProfile%\\Desktop")); // save default location
                saver.setFileFilter(DataProcessor.logFilter);
                saver.setSelectedFile(new File("System.log")); // open the window opens up, populate filename field with "System.log, basically open the save dialog with "System.log" written into it already
                int choice = saver.showSaveDialog(this); // what button did the user click? save choice in int
                if (choice == JFileChooser.APPROVE_OPTION) { // if user clicked "Save"
                    File tempFile = new File(saver.getSelectedFile() + ""); // "cheat" to turn getSelectedFile into string
                    if (tempFile.exists()) { // if a user clicks an existing file by accident, "get" its name and warn that it'll be overwritten. tempFile above was created for this
                        choice = JOptionPane.showConfirmDialog(this, "File with such name already exists. Do you want to replace it?"); // pop this menu up and ask if the user wants to replace the file
                        if (choice == JOptionPane.YES_NO_OPTION) { // if they click yes, then overwrite the existing file
                            saveLogFile(); // call the method write the file. If "No" is clicked, close window
                        }
                    } else {
                        saveLogFile(); // if existing file has not been clicked, call the method, write the file
                    }
                }
            }
            else {
                JOptionPane.showMessageDialog(null, "Log file is empty. Nothing to save");
            }
        }
    }

    // inner static class for printing
    static class PrintJobWatcher {
        // true iff it is safe to close the print job's input stream
        boolean done = false;

        PrintJobWatcher(DocPrintJob job) {
            // Add a listener to the print job
            job.addPrintJobListener(new PrintJobAdapter() {
                public void printJobCanceled(PrintJobEvent pje) {
                    allDone();
                }

                public void printJobCompleted(PrintJobEvent pje) {
                    allDone();
                }

                public void printJobFailed(PrintJobEvent pje) {
                    allDone();
                }

                public void printJobNoMoreEvents(PrintJobEvent pje) {
                    allDone();
                }

                void allDone() {
                    synchronized (PrintJobWatcher.this) {
                        done = true;
                        PrintJobWatcher.this.notify();
                    }
                }
            });
        }

        public synchronized void waitForDone() {
            try {
                while (!done) {
                    wait();
                }
            } catch (InterruptedException e) {
                System.out.println("Wait interrupted");
            }
        }
    }
}