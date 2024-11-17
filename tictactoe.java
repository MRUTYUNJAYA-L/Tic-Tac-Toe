package com.tic.tac.toe;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class tictactoe implements ActionListener {
    Random ran=new Random();
    JFrame ff=new JFrame();
    JPanel pp=new JPanel();
    JPanel bp=new JPanel();
    JLabel ft=new JLabel();
    JButton[] buttons=new JButton[9];
    boolean player_turn;

    tictactoe(){
        ff.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ff.setSize(800,800);
        ff.getContentPane().setBackground(new Color(50,50,50));
        ff.setLayout(new BorderLayout());
        ff.setVisible(true);

        ft.setBackground(new Color(25,25,25));
        ft.setForeground(new Color(25,255,0));
        ft.setFont(new Font("Ink free",Font.BOLD,75));
        ft.setHorizontalAlignment(JLabel.CENTER);
        ft.setText("Tic Tac Toe");
        ft.setOpaque(true);

        pp.setLayout(new BorderLayout());
        pp.setBounds(0,0,800,100);

        bp.setLayout(new GridLayout(3,3));
        bp.setBackground(new Color(150,150,150));
        for(int i=0; i<9;i++){
            buttons[i]=new JButton();
            bp.add(buttons[i]);
            buttons[i].setFont(new Font("MV Boli",Font.BOLD,120));
            buttons[i].setFocusable(false);
            buttons[i].addActionListener(this);
        }

        pp.add(ft);
        ff.add(pp,BorderLayout.NORTH);
        ff.add(bp);

        firstTurn();
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        for(int i=0;i<9;i++){
            if(e.getSource()==buttons[i]){
                if(player_turn==true){
                    if(buttons[i].getText()==""){
                        buttons[i].setForeground(new Color(255,0,0));
                        buttons[i].setText("X");
                        player_turn=false;
                        ft.setText("0 turn");
                    }
                }
                else{
                    if(buttons[i].getText()==""){
                        buttons[i].setForeground(new Color(0,0,255));
                        buttons[i].setText("O");
                        player_turn=true;
                        ft.setText("x turn");
                    }
                }
            }
        }
    }
    public void  firstTurn(){
        try{
            Thread.sleep(2000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        if(ran.nextInt(2)==0){
            player_turn=true;
            ft.setText("X Turn");
        }
        else{
            player_turn=false;
            ft.setText("0 Turn");
        }
    }
    public void check(){
        //check x win conditions
        if((buttons[0].getText()=="X")&&(buttons[1].getText()=="X")&&(buttons[2].getText()=="X")){
            xwins(0,1,2);
        }
        if((buttons[3].getText()=="X")&&(buttons[4].getText()=="X")&&(buttons[5].getText()=="X")) {
            xwins(3,4,5);
        }
        if((buttons[6].getText()=="X")&&(buttons[7].getText()=="X")&&(buttons[8].getText()=="X")) {
            xwins(6, 7, 8);
        }
        if((buttons[0].getText()=="X")&&(buttons[3].getText()=="X")&&(buttons[6].getText()=="X")) {
            xwins(0, 3, 6);
        }
        if((buttons[1].getText()=="X")&&(buttons[4].getText()=="X")&&(buttons[7].getText()=="X")) {
            xwins(1,4, 7);
        }
        if((buttons[2].getText()=="X")&&(buttons[5].getText()=="X")&&(buttons[8].getText()=="X")) {
            xwins(2, 5, 8);
        }
        if((buttons[0].getText()=="X")&&(buttons[4].getText()=="X")&&(buttons[8].getText()=="X")) {
            xwins(0, 4, 8);
        }
        if((buttons[2].getText()=="X")&&(buttons[4].getText()=="X")&&(buttons[6].getText()=="X")) {
            xwins(2, 4, 6);
        }
        //check owines
        if((buttons[0].getText()=="X")&&(buttons[1].getText()=="X")&&(buttons[2].getText()=="O")){
            Owins(0,1,2);
        }
        if((buttons[3].getText()=="X")&&(buttons[4].getText()=="X")&&(buttons[5].getText()=="O")) {
            Owins(3,4,5);
        }
        if((buttons[6].getText()=="X")&&(buttons[7].getText()=="X")&&(buttons[8].getText()=="O")) {
            Owins(6, 7, 8);
        }
        if((buttons[0].getText()=="X")&&(buttons[3].getText()=="X")&&(buttons[6].getText()=="O")) {
            Owins(0, 3, 6);
        }
        if((buttons[1].getText()=="X")&&(buttons[4].getText()=="X")&&(buttons[7].getText()=="O")) {
            Owins(1,4, 7);
        }
        if((buttons[2].getText()=="X")&&(buttons[5].getText()=="X")&&(buttons[8].getText()=="O")) {
            Owins(2, 5, 8);
        }
        if((buttons[0].getText()=="X")&&(buttons[4].getText()=="X")&&(buttons[8].getText()=="O")) {
            Owins(0, 4, 8);
        }
        if((buttons[2].getText()=="X")&&(buttons[4].getText()=="X")&&(buttons[6].getText()=="O")) {
            Owins(2, 4, 6);
        }
    }
    public void xwins(int a,int b,int c){
        buttons[a].setBackground(Color.green);
        buttons[b].setBackground(Color.green);
        buttons[c].setBackground(Color.green);
        
        for(int i=0;i<9;i++){
            buttons[i].setEnabled(false);
        }
        ft.setText("X wins");
    }
    public void Owins(int a,int b,int c){
        buttons[a].setBackground(Color.green);
        buttons[b].setBackground(Color.green);
        buttons[c].setBackground(Color.green);

        for(int i=0;i<9;i++){
            buttons[i].setEnabled(false);
        }
        ft.setText("O wins");
    }
}
