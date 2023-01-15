package primerapractica;

import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JTextField;

public class obtenerRuta {

    public static void selecionarArchivo(JTextField txtRuta1, JTextField txtPeso) {
        JFileChooser seleccionarArchivo = new JFileChooser();
        seleccionarArchivo.setDialogTitle("Seleccione el archivo...");
        seleccionarArchivo.setFileSelectionMode(JFileChooser.FILES_ONLY);
        seleccionarArchivo.showOpenDialog(seleccionarArchivo);
        txtRuta1.setText(seleccionarArchivo.getSelectedFile().getPath());
        bytesOperations.contadorBytes(seleccionarArchivo.getSelectedFile(), txtPeso);
    }

    public static void seleccionarCarpeta(JTextField txtRuta2) {
        JFileChooser seleccionarCarpeta = new JFileChooser();
        seleccionarCarpeta.setDialogTitle("Seleccione la carpeta para guardar los archivos...");
        seleccionarCarpeta.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        seleccionarCarpeta.showOpenDialog(seleccionarCarpeta);
        txtRuta2.setText(seleccionarCarpeta.getSelectedFile().getPath());
    }

}
