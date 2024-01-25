import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MyForm {
    private JButton szamoljButton;
    private JTextField xYTextField;
    private JCheckBox elfogadomAFelteteleketCheckBox;
    private javax.swing.JPanel JPanel;
    private JLabel JLabel2;

    public MyForm() {
        szamoljButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                double a = Double.parseDouble(xYTextField.getText().split("\\+")[0]);
                double b = Double.parseDouble(xYTextField.getText().split("\\+")[1]);
                System.out.println(a+b);
                /*
                if (elfogadomAFelteteleketCheckBox.isSelected()) {
                    JLabel2.setText(String.valueOf(a+b));
                } else {
                    JLabel2.setText("Fogadja el a felteteleket!");
                }
                 */

            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("MyForm");
        frame.setContentPane(new MyForm().JPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }


}
