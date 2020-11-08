package cifrado.vigenere;

import java.util.ArrayList;
import java.util.Arrays;

public class Datos {

    char[][] matriz = new char[27][27];
    String abc = "abcdefghijklmnñopqrstuvwxyz";
    private boolean cifrado = false;

    public String Cifrar(String clave, String palabra) {
        System.out.println("CIFRAR");
        clave = clave.toLowerCase();
        palabra = palabra.toLowerCase();
        ArrayList<String> palabras = new ArrayList<String>();
        String p = "";
        String nuevaPalabra = "";
        String palabraConClave = "";

        //Generar Tabla
        for (int i = 0; i < abc.length(); i++) {
            for (int j = 0; j < abc.length(); j++) {
                matriz[i][j] = abc.charAt((j + i) % 27);
            }
        }
        System.out.println(Arrays.deepToString(matriz).replace("], ", "]\n").replace("[[", "[").replace("]]", "]"));

        //Separar la frase en palabras
        for (int i = 0; i < palabra.length(); i++) {
            if (palabra.charAt(i) == ' ') {
                System.out.println(p);
                palabras.add(p);
                p = "";
            } else {
                p += palabra.charAt(i);
            }
        }
        palabras.add(p);
        System.out.println(p);
        p = "";

        //Reemplazar las palabras con la clave
        for (String elemento : palabras) {
            for (int i = 0; i < elemento.length(); i++) {
                if (abc.indexOf(elemento.charAt(i)) > -1) {
                    p += clave.charAt(i % clave.length());
                } else {
                    p += elemento.charAt(i);
                }
            }
            palabraConClave += p + " ";
            System.out.println(p);
            p = "";
        }
        int x = 0, y = 0;
        System.out.println(palabraConClave);
        //Buscar en la tabla
        for (int i = 0; i < palabraConClave.length(); i++) {
            if (abc.indexOf(palabraConClave.charAt(i)) > -1) {
                x = abc.indexOf(palabra.charAt(i));
                y = abc.indexOf(palabraConClave.charAt(i));
                nuevaPalabra += matriz[x][y];
            } else {
                nuevaPalabra += palabraConClave.charAt(i);
            }
        }

        System.out.println(x + "," + y);
        System.out.println(nuevaPalabra);
        return nuevaPalabra;
    }

    public String Descifrar(String clave, String palabra) {
        System.out.println("DESCIFRAR");
        //Generar Tabla
        for (int i = 0; i < abc.length(); i++) {
            for (int j = 0; j < abc.length(); j++) {
                matriz[i][j] = abc.charAt((j + i) % 27);
            }
        }
        System.out.println(Arrays.deepToString(matriz).replace("], ", "]\n").replace("[[", "[").replace("]]", "]"));
        String p = "";
        ArrayList<String> palabras = new ArrayList<>();
        String nuevaPalabra = "", palabraConClave = "";
        clave = clave.toLowerCase();
        palabra = palabra.toLowerCase();
        //Separar la frase en palabras
        for (int i = 0; i < palabra.length(); i++) {
            if (palabra.charAt(i) == ' ') {
                System.out.println(p);
                palabras.add(p);
                p = "";
            } else {
                p += palabra.charAt(i);
            }
        }
        palabras.add(p);
        System.out.println(p);
        p = "";
        //Reemplazar las palabras con la clave
        for (String elemento : palabras) {
            for (int i = 0; i < elemento.length(); i++) {
                if (abc.indexOf(elemento.charAt(i)) > -1) {
                    p += clave.charAt(i % clave.length());
                } else {
                    p += elemento.charAt(i);
                }
            }
            palabraConClave += p + " ";
            System.out.println(p);
            p = "";
        }
        int x = 0, y = 0;
        for (int i = 0; i < palabraConClave.length(); i++) {
            if (abc.indexOf(palabraConClave.charAt(i)) > -1) {
                y = abc.indexOf(palabraConClave.charAt(i));
                for (int j = 0; j < abc.length(); j++) {
                    if (matriz[y][j] == palabra.charAt(i)) {
                        nuevaPalabra += matriz[0][j];
                    }
                }
            } else {
                nuevaPalabra += palabraConClave.charAt(i);
            }
        }
        //System.out.println(palabraConClave);
        System.out.println(nuevaPalabra);
        return nuevaPalabra;
    }

    public boolean isCifrado() {
        return cifrado;
    }

    public void setCifrado(boolean cifrado) {
        this.cifrado = cifrado;
    }
}
