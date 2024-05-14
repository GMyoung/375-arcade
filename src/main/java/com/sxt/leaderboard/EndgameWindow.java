package com.sxt.leaderboard;
//Generated by GuiGenie - Copyright (c) 2004 Mario Awad.
//Home Page http://guigenie.cjb.net - Check often for new versions!

import com.opencsv.exceptions.CsvException;
import com.sxt.GameWin;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.*;

public class EndgameWindow extends JFrame {
    private JButton resetButton;
    private JLabel gameStateLabel;
    private JLabel scoreLabel;
    private JLabel enterNameLabel;
    private JTextField nameField;
    private JList leaderBoardList;

    public EndgameWindow(GameWin gameWin) {
        setTitle("Game Over");
        setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //construct preComponents
        String[] leaderBoardListItems = LeaderBoard.getLeaderBoardEntries();

        //construct components
        resetButton = new JButton ("Restart");
        resetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!nameField.getText().isEmpty()) {
                    try {
                        LeaderBoard.addNewLeaderBoardEntry(GameWin.score, nameField.getText());
                    } catch (IOException | CsvException ex) {
                        throw new RuntimeException(ex);
                    }
                }
                gameWin.restart();
                closeEngameWindow();
            }
        });
        gameStateLabel = new JLabel ("gameStateHere");
        scoreLabel = new JLabel ("Score: " + GameWin.score);
        enterNameLabel = new JLabel ("Enter Name");
        nameField = new JTextField (5);
        leaderBoardList = new JList(leaderBoardListItems);

        //adjust size and set layout
        setSize(new Dimension (335, 355));
        setLayout (null);

        //add components
        add (resetButton);
        add (gameStateLabel);
        add (scoreLabel);
        add (nameField);
        add(enterNameLabel);
        add (leaderBoardList);

        //set component bounds (only needed by Absolute Positioning)
        resetButton.setBounds (100, 280, 100, 20);
        gameStateLabel.setBounds (120, 10, 100, 25);
        scoreLabel.setBounds (40, 250, 100, 25);
        enterNameLabel.setBounds (185, 225, 100, 25);
        nameField.setBounds (185, 255, 100, 25);
        leaderBoardList.setBounds (30, 40, 255, 150);
        this.setVisible(true);
    }

    private void closeEngameWindow() {
        this.setVisible(false);
    }


//    public static void main (String[] args) {
//        new EndgameWindow(this);
//    }
}