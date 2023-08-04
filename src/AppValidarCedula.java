public class AppValidarCedula {
    public static void main(String[] args) {
        String cedula = "1755037163";
        ValidadorDeCedula validadorDeCedula = new ValidadorDeCedula(cedula);
        boolean esValida = validadorDeCedula.validarCedula();
        System.out.println("La cédula " + cedula + " es " + (esValida ? "válida." : "inválida."));
    }
}
