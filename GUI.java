package Course_project;

import com.sun.org.apache.xpath.internal.SourceTree;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * Created by Игорь on 31.10.2016.
 */
// fdfd
public class GUI extends JFrame {
    private JLabel name, info, ic,statusbar;
    private int[][] resmult;
    private JButton click, read2, read1,multiply;
    private JTextArea matric = new JTextArea(10,21);
    private File file;
    private double arr1[][];
    private double arr2 [][];
    GUI() {
        super("Matrix calculator");
        matric.setEditable(false);
        getContentPane().setLayout(null);
        statusbar = new JLabel("Готов к работе");
        name = new JLabel("Matrix calculator");
        name.setFont(new Font("Italic", Font.ITALIC + Font.BOLD, 20));
        name.setForeground(new Color(52, 121, 238));
        add(name).setBounds(312, 95, 190, 18); // Matrix calculator
        info = new JLabel("Developer: Horuzhiy Igor");
        info.setBounds(300, 520, 190, 18);
        info.setFont(new Font("Italic", Font.ITALIC + Font.BOLD, 15));
        add(info);
        ImageIcon icon = new ImageIcon(getClass().getResource("Calculator.png"));
        ic = new JLabel(icon);
        add(ic).setBounds(235, 30, 300, 420); // Icon
        ImageIcon icok = new ImageIcon(getClass().getResource("ok.png"));
        click = new JButton(icok);
        add(click).setBounds(370, 465, 50, 50);
        read1 = new JButton("Ввести первую матрицу");
        read2 = new JButton("Ввести вторую матрицу");
        multiply = new JButton("Перемножить матрицы А и B");
        click.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                getContentPane().removeAll();
                getContentPane().repaint();
                add(matric).setBounds(500,170,100,100);
                add(statusbar).setBounds(1,537,500,100);
                add(read1).setBounds(10, 10, 180, 20);  // First button of openning matrix
                add(read2).setBounds(10, 40, 180, 20);  // Second button of openning matrix
                add(multiply).setBounds(10,70,180,20);  // Multiplying first and second matrix
            }
        });   // Нажатие на вход
        multiply.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Operations tt = new Operations();
                if(tt.multiplyMatrix(arr1,arr2) == null ){
                    statusbar.setText("Количество столбцов первой матрицы не равно количеству строк второй матрицы");
                }
                else {
                   resmult =  tt.multiplyMatrix(arr1, arr2);
                    mtoar(resmult);
                }
            }
        });
        read1Action r1 = new read1Action();
        read1.addActionListener(r1);            // Чтение первой матрицы
        read2Action r2 = new read2Action();
        read2.addActionListener(r2);            // Чтение второй матрицы
    }
    private class read1Action implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            JFrame fr = new JFrame();
            JFileChooser dialog = new JFileChooser();
            dialog.setBounds(0, 0, 500, 500);
            dialog.setFileSelectionMode(JFileChooser.FILES_ONLY);
            dialog.setApproveButtonText("Выбрать");
            dialog.setMultiSelectionEnabled(false);
            dialog.showOpenDialog(fr);
            dialog.setVisible(true);
            file = dialog.getSelectedFile();
            ReadMatrix r1 = new ReadMatrix();
            r1.open(file);
            try {
                arr1 = r1.readFile(file);
                statusbar.setText("Файл открыт, матрица загружена");
            } catch (IOException e1) {
                statusbar.setText("Не удалось открыть файл");
            }
            r1.close();
        }
    }
    private class read2Action implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            JFrame fr = new JFrame();
            JFileChooser dialog = new JFileChooser();
            dialog.setBounds(0, 0, 500, 500);
            dialog.setFileSelectionMode(JFileChooser.FILES_ONLY);
            dialog.setApproveButtonText("Выбрать собственноручно");
            dialog.setMultiSelectionEnabled(false);
            dialog.showOpenDialog(fr);
            dialog.setVisible(true);
            file = dialog.getSelectedFile();
            ReadMatrix r1 = new ReadMatrix();
            r1.open(file);
            try {
                arr2 = r1.readFile(file);
                statusbar.setText("Файл открыт, 2-ая матрица загружена");
            } catch (IOException e1) {
                statusbar.setText("Не удалось открыть файл");
            }
            r1.close();
        }
    }
    public void mtoar(int arr [][]){
        System.out.println(arr[0].length);
        System.out.println(arr.length);
        String matricaString = "";
        for(int i=0; i<arr.length; i++){
            for( int j=0; j<arr[0].length; j++){
                matricaString += arr[i][j] + "  ";
            }
            matricaString += "\n";
        }
        matric.setText(matricaString);
    }
}


