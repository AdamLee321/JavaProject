package gui;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;

/*
IT Tallaght - 2015, S2
Computing - Year 2, Project
Group 17 (George - 01/04/2015)
*/

public class DennisNedry {

    private JDialog dn;
    private JPanel main;
    private JLabel nedry;
    private JButton btnClose;
    private AudioInputStream audioFile;
    private Clip sound;
    private int delay = 8300; //in milliseconds

    public DennisNedry(){

        dn = new JDialog();
        dn.setTitle("Wrong Password!");
        dn.setLayout(new GridLayout());
        dn.setSize(320, 320);
        dn.setResizable(false);
        dn.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        dn.setLocationRelativeTo(null);
        dn.setModal(true);

        main = new JPanel(new FlowLayout());
        main.setBackground(UIElements.getColour());

        // create audio file, pass it to clip player(sound)
        try{
            audioFile = AudioSystem.getAudioInputStream(new File("src/res/images/UI Elements/magicword.wav").getAbsoluteFile());
            sound = AudioSystem.getClip();
            sound.open(audioFile);
        } catch (Exception e){
            JOptionPane.showMessageDialog(null,"Problem Playing Audio");
        }

        nedry = new JLabel(new ImageIcon("src/res/images/UI Elements/nedry.gif"));
        nedry.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                playMagicWord(1);
            }
        });

        // button to close the dialog with anonymous action listener
        btnClose = new JButton("Want To Try Again?");
        btnClose.setPreferredSize(new Dimension(200,30));
        btnClose.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dn.dispose();
            }
        });
        btnClose.setVisible(false); // set invisible by default (will be set visible by the timer)

        // timer to delay showing the button, after around 8 seconds sets the button to visible
        ActionListener taskPerformer = new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                    btnClose.setVisible(true);
            }
        };
        new Timer(delay, taskPerformer).start();

        main.add(nedry);
        main.add(btnClose);
        dn.add(main);

        playMagicWord(2); // play the audio

        dn.setVisible(true);
    }

    public void playMagicWord(int numberOfTimes) {
        try {
            if (sound.isOpen()){
                sound.stop();
            }
            sound.start();
            sound.loop(numberOfTimes); // play the audio three times (0,1,2)
        } catch(Exception ae) {
            System.out.println(ae);
        }
    }
}