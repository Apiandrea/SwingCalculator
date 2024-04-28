import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI extends JFrame {
    private JButton sumButton;
    private JButton divButton;
    private JButton difButton;
    private JButton mulButton;
    private JPanel operationsPanel;
    private JPanel rootPanel;
    private JTextField resField;
    private JPanel resPanel;
    private JSplitPane splitPane;
    private JPanel addendsPanel;
    private JTextField secondAddendField;
    private JTextField firstAddendField;
    private JPanel firstAddendPanel;
    private JPanel secondAddendPanel;
    private JLabel firstLabel;
    private JLabel secondLabel;
    private JLabel resultLabel;
    private JTextArea history;
    private JButton resetHistoryButton;
    private JRadioButton whiteRadioButton;
    private JRadioButton blackRadioButton;
    private JRadioButton colorfullRadioButton;

    public GUI()
    {
        defaultSettings("Calcolatrice - Apiandrea");

        ButtonGroup radioGroup = new ButtonGroup();
        radioGroup.add(whiteRadioButton);
        radioGroup.add(blackRadioButton);
        radioGroup.add(colorfullRadioButton);




        resField.setEditable(false);
        history.setEditable(false);

        // lo setto visibile
        setVisible(true);
        // --------------------

        // Listeners:
        whiteRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                modifyStyle(1);
            }
        });

        blackRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                modifyStyle(2);
            }
        });

        colorfullRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                modifyStyle(3);
            }
        });

        resetHistoryButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                history.setText("History: ");
                history.removeAll();
            }
        });

        sumButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String result = String.valueOf( Double.parseDouble(secondAddendField.getText()) + Double.parseDouble(firstAddendField.getText()) );
                resField.setText(result);
                checkRows(history.getLineCount());
                history.append("\n" + Double.parseDouble(secondAddendField.getText()) + " + " + Double.parseDouble(firstAddendField.getText()) + " = " + result);
            }
        });

        mulButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String result = String.valueOf( Double.parseDouble(secondAddendField.getText()) * Double.parseDouble(firstAddendField.getText()) );
                resField.setText(result);
                checkRows(history.getLineCount());
                history.append("\n" + Double.parseDouble(secondAddendField.getText()) + " * " + Double.parseDouble(firstAddendField.getText()) + " = " + result);
            }
        });

        divButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String result = String.valueOf( Double.parseDouble(secondAddendField.getText()) / Double.parseDouble(firstAddendField.getText()) );
                resField.setText(result);
                checkRows(history.getLineCount());
                history.append("\n" + Double.parseDouble(secondAddendField.getText()) + " / " + Double.parseDouble(firstAddendField.getText()) + " = " + result);
            }
        });

        difButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String result = String.valueOf( Double.parseDouble(secondAddendField.getText()) - Double.parseDouble(firstAddendField.getText()) );
                resField.setText(result);
                checkRows(history.getLineCount());
                history.append("\n" + Double.parseDouble(secondAddendField.getText()) + " - " + Double.parseDouble(firstAddendField.getText()) + " = " + result);
            }
        });

        // ---------------------------------------------
    }

    public void defaultSettings(String title){
        // serve per utilizzare il GUI.form
        setContentPane(rootPanel);
        // ---------------------------

        // set di default del JFrame
        setTitle(title);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(600, 500);
        setResizable(false);
        setLocationRelativeTo(null);
        // ----------------------------
    }

    public void modifyStyle(int scelta){
        switch (scelta){
            case 1:
                firstAddendPanel.setBackground(Color.gray);
                secondAddendPanel.setBackground(Color.gray);
                resPanel.setBackground(Color.gray);
                history.setBackground(Color.white);
                history.setForeground(Color.black);
                break;
            case 2:
                firstAddendPanel.setBackground(Color.black);
                secondAddendPanel.setBackground(Color.black);
                resPanel.setBackground(Color.black);
                history.setBackground(Color.black);
                history.setForeground(Color.white);
                break;
            case 3:
                Color green = new Color(16, 120, 17);

                firstAddendPanel.setBackground(green);
                secondAddendPanel.setBackground(green);
                resPanel.setBackground(new Color(148,22,18));
                history.setBackground(Color.white);
                history.setForeground(Color.black);
                break;
            default:
                break;
        }
    }

    public void checkRows(int nRows)
    {
        if(nRows > 13){
            String tmp = history.getText();
            String tmp2 = tmp.substring(tmp.indexOf("\n", tmp.indexOf("\n")+2));

            history.setText("History:" + tmp2);
        }
    }
}
