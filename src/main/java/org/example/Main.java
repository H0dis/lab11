import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main extends JFrame {

    private JTextField textField;
    private JTextArea textArea;
    private JButton button;
    private JComboBox<String> comboBox;
    private JCheckBox checkBox;
    private JRadioButton radioButton1;
    private JRadioButton radioButton2;
    private ButtonGroup radioGroup;

    public Main() {
        setTitle("Formular ");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        textField = new JTextField(20);
        textArea = new JTextArea(10, 20);
        button = new JButton("introducere");

        String[] options = {"Optiune 1", "Optiune 2", "Optiune 3"};
        comboBox = new JComboBox<>(options);

        checkBox = new JCheckBox("Bifa");

        radioButton1 = new JRadioButton("Radio 1");
        radioButton2 = new JRadioButton("Radio 2");
        radioGroup = new ButtonGroup();
        radioGroup.add(radioButton1);
        radioGroup.add(radioButton2);

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String text = textField.getText();
                String selectedOption = (String) comboBox.getSelectedItem();
                boolean isChecked = checkBox.isSelected();
                String selectedRadio = radioButton1.isSelected() ? "Radio 1" : "Radio 2";

                textArea.append("Text introdus: " + text + "\n");
                textArea.append("Optiune selectata: " + selectedOption + "\n");
                textArea.append("Bifa selectata: " + isChecked + "\n");
                textArea.append("Radio selectat: " + selectedRadio + "\n");

                textField.setText("");
            }
        });

        setLayout(new BorderLayout());

        JPanel inputPanel = new JPanel();
        inputPanel.add(new JLabel("Text: "));
        inputPanel.add(textField);
        inputPanel.add(button);
        inputPanel.add(new JLabel("Selectare optiune: "));
        inputPanel.add(comboBox);
        inputPanel.add(checkBox);
        inputPanel.add(new JLabel("Selectare radio: "));
        inputPanel.add(radioButton1);
        inputPanel.add(radioButton2);

        JScrollPane scrollPane = new JScrollPane(textArea);

        add(inputPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);

        JButton chooseBackgroundButton = new JButton("Choose Background");
        chooseBackgroundButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Color backgroundColor = JColorChooser.showDialog(Main.this,
                        "Choose background color", Color.white);
                if (backgroundColor != null) {
                    inputPanel.setBackground(backgroundColor);
                    textArea.setBackground(backgroundColor);
                }
            }
        });
        add(chooseBackgroundButton, BorderLayout.SOUTH);

        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Main();
            }
        });
    }
}
