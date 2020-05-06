package com.mtala3t.steganography.ui;

import java.awt.Color;

import javax.swing.*;

import com.mtala3t.steganography.util.SoundManger;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainWindow extends JFrame {

    /**
     * create Menu
     *
     */
    private static final long serialVersionUID = 9005253017639855720L;
    EmbedMessage embedMessage;
    NewClass newClass;
    private JDesktopPane panel;

    private JMenuBar jMenuBar;
    private JMenu fileMenu;
    private JMenu helpMenu;

    private JMenuItem extractMenu;
    private JMenuItem embedMenu;
    private JMenuItem embedImageMenu;
    private JMenuItem extractImageMenu;
    private JMenuItem exitmenu;
//    private JMenuItem aboutMenu;

    public javax.swing.JPanel piclabel;

    public MainWindow() {
        initComponents();
        setSize(610, 455);
        setLocation(350, 150);
        setResizable(false);

    }

    private void initComponents() {

        panel = new JDesktopPane();
        panel.setBackground(Color.WHITE);
        jMenuBar = new JMenuBar();

        fileMenu = new JMenu();
        embedMenu = new JMenuItem();
        extractMenu = new JMenuItem();
        exitmenu = new JMenuItem();
        extractImageMenu = new JMenuItem();
        embedImageMenu = new JMenuItem();
        helpMenu = new JMenu();
//        aboutMenu = new JMenuItem();

        JTextField jt = new JTextField();
        jt.setText("abc");
        jt.setBounds(10, 10, 100, 100);
        
        
        setTitle("Steganography");
        piclabel = new javax.swing.JPanel();
        piclabel.setBounds(0, 0, 600, 400);
//        add(piclabel);
        
        JButton buttonEmbedAudio = new JButton();
        buttonEmbedAudio.setText("Embed Data To Audio");
        buttonEmbedAudio.setBounds(10, 0, 590, 70);
        panel.add(buttonEmbedAudio);
        buttonEmbedAudio.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                embedMenuActionPerformed(e);
            }
        });
        JButton buttonExportAudio = new JButton();
        buttonExportAudio.setText("Export Data From Audio");
        buttonExportAudio.setBounds(10, 70, 590, 70);
        buttonExportAudio.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                extractmenuActionPerformed(e);
            }
        });
        panel.add(buttonExportAudio);
        
        JButton buttonEmbedImage = new JButton();
        buttonEmbedImage.setText("Embed Data To Image");
        buttonEmbedImage.setBounds(10, 140, 590, 70);
        buttonEmbedImage.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                embedMessage = new EmbedMessage();
                embedMessage.setVisible(true);
            }
        });
        panel.add(buttonEmbedImage);

        JButton buttonExportImage = new JButton();
        buttonExportImage.setText("Export Data From Image");
        buttonExportImage.setBounds(10, 210, 590, 70);
        buttonExportImage.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                newClass = new NewClass();
                newClass.setVisible(true);
            }
        });
        panel.add(buttonExportImage);
        
        JButton buttonExit = new JButton();
        buttonExit.setText("Exit");
        buttonExit.setBounds(10, 280, 590, 70);
        buttonExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        panel.add(buttonExit);
        
        
//        piclabel.add(jt);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                exitForm(evt);
            }
        });
        getContentPane().add(panel, java.awt.BorderLayout.CENTER);

//        fileMenu.setMnemonic('F');
//        fileMenu.setText("File");
//        helpMenu.setMnemonic('h');
//        helpMenu.setText("Help");
//        embedMenu.setMnemonic('m');
//        embedMenu.setText("Embed Data to Audio");
//        embedMenu.addActionListener(new java.awt.event.ActionListener() {
//            public void actionPerformed(java.awt.event.ActionEvent evt) {
//                embedMenuActionPerformed(evt);
//            }
//        });
//        fileMenu.add(embedMenu);
//        extractMenu.setMnemonic('t');
//        extractMenu.setText("Extract Data From ");
//        extractMenu.addActionListener(new java.awt.event.ActionListener() {
//            public void actionPerformed(java.awt.event.ActionEvent evt) {
//                extractmenuActionPerformed(evt);
//            }
//        });
//
//        fileMenu.add(extractMenu);
//
//        embedImageMenu.setMnemonic('I');
//        embedImageMenu.setText("Embed Image");
//        embedImageMenu.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                embedMessage = new EmbedMessage();
//                embedMessage.setVisible(true);
//
//                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//            }
//        });
//        fileMenu.add(embedImageMenu);
//
//        extractImageMenu.setMnemonic('i');
//        extractImageMenu.setText("Extract Image");
//        extractImageMenu.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                newClass = new NewClass();
//                newClass.setVisible(true);
////                        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//            }
//        });
//
//        fileMenu.add(extractImageMenu);
//
//        exitmenu.setMnemonic('x');
//        exitmenu.setText("Exit");
//        exitmenu.addActionListener(new java.awt.event.ActionListener() {
//            public void actionPerformed(java.awt.event.ActionEvent evt) {
//                exitmenuActionPerformed(evt);
//            }
//        });

//        helpMenu.add(aboutMenu);
//        aboutMenu.setMnemonic('a');
//        aboutMenu.setText("About");
//        aboutMenu.addActionListener(new java.awt.event.ActionListener() {
//            public void actionPerformed(java.awt.event.ActionEvent evt) {
//                aboutMenuActionPerformed(evt);
//            }
//        });
        fileMenu.add(exitmenu);
//        helpMenu.add(aboutMenu);
        jMenuBar.add(fileMenu);
        jMenuBar.add(helpMenu);

        setJMenuBar(jMenuBar);
        pack();
    }

    private void exitmenuActionPerformed(java.awt.event.ActionEvent evt) {

        System.exit(0);
    }

    private void extractmenuActionPerformed(java.awt.event.ActionEvent evt) {
        piclabel.setVisible(false);
        WizardFrame wf = new ExtractAction(this).getWizardFrame();
        panel.add(wf);
        wf.moveToFront();
    }

    private void embedMenuActionPerformed(java.awt.event.ActionEvent evt) {

        System.out.println("Embed Action Selected..");

        piclabel.setVisible(false);
        WizardFrame wf = new EmbedAction(this).getWizardFrame();
        panel.add(wf);
        wf.moveToFront();
    }

    private void aboutMenuActionPerformed(java.awt.event.ActionEvent evt) {
        javax.swing.JOptionPane.showMessageDialog(this,
                "Steganography\n\n" + "Created by : Group6",
                "About", javax.swing.JOptionPane.PLAIN_MESSAGE);
    }

    private void exitForm(java.awt.event.WindowEvent evt) {

        //System.exit(0);
        Exit();

    }

    public void Exit() {
        int res = JOptionPane.showConfirmDialog(this, "Are you sure you want to exit?", "Exit Confirmation", JOptionPane.YES_NO_OPTION);

//        if (res == JOptionPane.YES_OPTION) {
//
//            SoundManger souManger = new SoundManger("Sounds/goodbye.wav");
//            souManger.play();
//
//            setVisible(false);
//            dispose();
//            System.exit(0);
//
//        } else {
//            setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
//        }
    }

}
