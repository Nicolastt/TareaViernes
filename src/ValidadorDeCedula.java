public class ValidadorDeCedula {
    private final String cedula;

    public ValidadorDeCedula(String cedula) {
        this.cedula = cedula;
    }

    public boolean validarCedula() {
        // Cada dígito de la cédula se va a multiplicar por cada coeficiente del arreglo en orden.
        int[] coeficientes = {2, 1, 2, 1, 2, 1, 2, 1, 2};
        int suma = 0;

        // Verificar que la cédula tenga 10 dígitos
        if (this.cedula.length() != 10) {
            System.out.println("La cédula no tiene los 10 dígitos esperados.");
            return false;
        }

        // Multiplicar cada valor numérico de la cédula con el coeficiente correspondiente.
        // En el caso de que el resultado sea mayor que 9 se le resta 9.
        // Finalmente, suma todos los resultados.
        for (int i = 0; i < 9; i++) {
            int valor = coeficientes[i] * Character.getNumericValue(cedula.charAt(i));
            suma += (valor > 9) ? valor - 9 : valor;
        }

        // Math.ceil: Redondear un número decimal hacia el entero superior más cercano
        // Obtener la decena superior y restar el valor de la suma para obtener el dígito verificador.
        int decenaSuperior = (int) Math.ceil((double) suma / 10) * 10;
        int digitoVerificador = decenaSuperior - suma;

        // En el caso de que el dígito verificador sea igual a 10 se reemplaza por 0.
        if (digitoVerificador == 10) {
            digitoVerificador = 0;
        }

        // Verifica que el dígito verificador sea igual al último valor del String cédula
        return digitoVerificador == Character.getNumericValue(cedula.charAt(9));
    }
}
