import javax.swing.*;

public class Main {
    private JPanel panelprincipal;
    private JTextField textField1;
    private JComboBox comboBox1;
    private JButton button1;
    private JButton button2;
    private JButton button3;

    public static void main(String[] args){
        JFrame frame = new JFrame("Control de stock");
        frame.setContentPane(new Main().panelprincipal);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
