/*
 * 3/16/21, 12:49 PM. Scapin Cristian @JustCris654
 */

package com.justcris.Magazzino;



import javax.swing.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class FormMagazzino extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JTextField txt_id;
    private JTextField txt_name;
    private JTextField txt_price;
    private JTextField txt_quantity;
    private JButton inviaButton;

    public FormMagazzino() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);

        buttonOK.addActionListener(e -> {
            try {
                onOK();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        });


        inviaButton.addActionListener(e -> {
            String id = txt_id.getText();
            String name = txt_name.getText();
            String price = txt_price.getText();
            String quantity = txt_quantity.getText();
            try {
                URL url = new URL("http://localhost:8080/Magazzino_war_exploded/hello-servlet?id=" + id + "&title=" + name + "&price=" + price + "&quantity=" + quantity);
                URLConnection urlConnection = url.openConnection();
                BufferedReader in = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
                String response = in.readLine();
                JOptionPane.showMessageDialog(null, "Aggiunto");
            } catch (IOException malformedURLException) {
                malformedURLException.printStackTrace();
            }

        });
    }

    private void onOK() throws IOException {
        // add your code here

        dispose();
    }


    public static void main(String[] args) {
        FormMagazzino dialog = new FormMagazzino();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
}
