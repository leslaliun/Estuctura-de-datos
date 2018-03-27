package servidor;

public class Recursividad {

    String numeros;

    public Recursividad() {
        numeros = "";
    }

    public String invertir(int vector[], int n) {
        if (n < 0) {
            return vector[0] + "";
        } else {
            numeros += vector[n] + ",";
            invertir(vector, n - 1);
        }
        return numeros.substring(0, numeros.length()-1);
    }
}
