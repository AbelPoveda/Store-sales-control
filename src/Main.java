import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Main {
    private JPanel panelprincipal;
    private JTextField cantidad;
    private JComboBox articulos;
    private JButton botonfin;
    private JButton botonadd;
    private JTextField total;
    private JButton reset;

    public Main() {
        reset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cantidad.setText("0");
                total.setText("0");
            }
        });
        ArrayList<String> a = new ArrayList<>(Conexion.sacarproductos());
        for (int b=0;b<a.size();b++){
            articulos.addItem(a.get(b));
        }

    }

    public static void main(String[] args){
        JFrame frame = new JFrame("Control de stock");
        frame.setContentPane(new Main().panelprincipal);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
