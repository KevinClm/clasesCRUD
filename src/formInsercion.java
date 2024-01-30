import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class formInsercion {
    private JButton conectarALaDBButton;
    public JPanel form1;
    private JTextField nombreTField;
    private JTextField nota1TField;
    private JTextField nota2TField;
    private JButton borrarElementos;
    private JButton insertarDatos;
    private JLabel nombreTxt;
    private JLabel cedulaTxt;
    private JLabel nota1Txt;
    private JLabel nota2Txt;
    private JTextField cedulaTField;
    private JLabel mensajeTxt;

    public formInsercion() {
        conectarALaDBButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                conexionDB miconexion = new conexionDB();
                miconexion.conexionLocal("jdbc:mysql://localhost:3307/estudiantes","root", "");
                //mensajeTxt.setText(miconexion.getMensaje());
            }
        });
        borrarElementos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                nombreTField.setText("");
                cedulaTField.setText("");
                nota1TField.setText("");
                nota2TField.setText("");
            }
        });

        insertarDatos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                insertarDatos datos = new insertarDatos();
            }
        });
    }
}
