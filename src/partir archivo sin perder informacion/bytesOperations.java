package primerapractica;

import java.io.*;
import javax.swing.*;

public class bytesOperations {

    FileInputStream fis = null;
    FileOutputStream fos = null;
    long bytes[] = null;

    public static void contadorBytes(File archivo, JTextField txtPeso) {
        int byteDato = (int) archivo.length();
        txtPeso.setText(byteDato + "");

    }

    public bytesOperations() {
    }

    public void crearArchivos(File archivo, String carpeta, int kb) {
        int candBytes = 0, cont = 0, contt = 1;
        try {
            fis = new FileInputStream(archivo);
            bytes = new long[kb];
            while (true) {
                if (candBytes == -1) {
                    break;
                } else {
                    if (cont != kb) {
                        candBytes = fis.read();
                        bytes[cont] = candBytes;
                        cont++;
                    } else {
                        char letra = 92;
                        String rutaa = carpeta + letra + String.valueOf(contt) + archivo.getName();
                        fos = new FileOutputStream(rutaa);
                        for (int i = 0; i < bytes.length; i++) {
                            fos.write((int) bytes[i]);
                        }
                        fos.close();
                        cont = 0;
                        contt++;
                    }
                }
            }
        } catch (FileNotFoundException ex) {
            System.out.println("Error en: " + ex.getMessage());
        } catch (IOException ex) {
            System.out.println("Error en: " + ex.getMessage());
        }
        JOptionPane.showMessageDialog(null, "Se crearon " + (contt - 1) + " file");
    }

    public void unir(String ruta_origen, String ruta_destino) {
        File archivo = new File(ruta_origen);
        File lista[] = archivo.listFiles();
        int cont = 1, suma = 0;
        try {
            for (int i = 0; i < lista.length; i++) {
                suma += (int) lista[i].length();
            }
            bytes = new long[suma];
            int contbytes = 0;
            for (int i = 0; i < lista.length; i++) {
                for (int j = 0; j < lista.length; j++) {
                    if (cont == ObtenerNumero(lista[j])) {
                        fis = new FileInputStream(lista[j]);
                        while (true) {
                            int elbyte = fis.read();
                            if (elbyte == -1) {
                                break;
                            } else {
                                bytes[contbytes] = elbyte;
                                contbytes++;
                            }
                        }
                        break;
                    }
                }
                cont++;
            }
            char letra = 92;
            String nombrearchi = ObtenerNombre(lista[0]);
            fos = new FileOutputStream(new File(ruta_destino + letra + nombrearchi));
            for (int i = 0; i < bytes.length; i++) {
                fos.write((int) bytes[i]);
            }
        } catch (FileNotFoundException ex) {
            System.out.println("Archivo no encontrado: " + ex);
        } catch (IOException ex) {
            System.out.println("Error al leer: " + ex);
        }
    }

    public String ObtenerNombre(File archivo) {
        String nombrearchi = "";
        for (int i = 0; i < archivo.getName().length(); i++) {
            if (archivo.getName().charAt(i) != '0' && archivo.getName().charAt(i) != '1' && archivo.getName().charAt(i) != '2'
                    && archivo.getName().charAt(i) != '3' && archivo.getName().charAt(i) != '4' && archivo.getName().charAt(i) != '5'
                    && archivo.getName().charAt(i) != '6' && archivo.getName().charAt(i) != '7' && archivo.getName().charAt(i) != '8' && archivo.getName().charAt(i) != '9') {
                nombrearchi += archivo.getName().charAt(i);
            }
        }
        return nombrearchi;
    }

    public int ObtenerNumero(File archivo) {
        String palabra = "";
        int numero;
        for (int i = 0; i < archivo.getName().length(); i++) {
            if (archivo.getName().charAt(i) == '0' || archivo.getName().charAt(i) == '1' || archivo.getName().charAt(i) == '2'
                    || archivo.getName().charAt(i) == '3' || archivo.getName().charAt(i) == '4' || archivo.getName().charAt(i) == '5'
                    || archivo.getName().charAt(i) == '6' || archivo.getName().charAt(i) == '7' || archivo.getName().charAt(i) == '8' || archivo.getName().charAt(i) == '9') {
                palabra += archivo.getName().charAt(i);
            } else {
                break;
            }
        }
        numero = Integer.parseInt(palabra);
        return numero;

    }

}
