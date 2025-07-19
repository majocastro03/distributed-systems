package App01;
public class App {
    public static void main(String[] args) {
        // Crear un docente
        Docente docente = new Docente(
            "Laura", "Martínez", "123456789", 45,
            "Ciencias Sociales", "Derecho Civil", 15, 2010
        );
        docente.actualizarDatosContacto("3124567890", "laura.martinez@uni.edu");
        docente.setSalario(4800000);

        // Crear un estudiante
        Estudiante estudiante = new Estudiante(
            "Carlos", "López", "987654321", 20,
            "Ingeniería Mecánica", 4, 2022
        );
        estudiante.actualizarDatosContacto("3139876543", "carlos.lopez@est.uni.edu");
        estudiante.setPromedio(4.3);

        // Mostrar información
        System.out.println("\n--- DOCENTE ---");
        docente.mostrarInformacion();
        docente.darClase();
        docente.investigar();

        System.out.println("\n--- ESTUDIANTE ---");
        estudiante.mostrarInformacion();
        estudiante.estudiar();
        estudiante.presentarExamen();

        // Mostrar resultados de métodos adicionales
        System.out.println("\n--- MÉTODOS DE LA INTERFAZ ---");
        System.out.println("Nombre completo del docente: " + docente.obtenerNombreCompleto());
        System.out.println("Docente es mayor de edad: " + docente.esMayorDeEdad());
        System.out.println("Antigüedad docente: " + docente.calcularAntiguedad() + " años");

        System.out.println("Nombre completo del estudiante: " + estudiante.obtenerNombreCompleto());
        System.out.println("Estudiante es mayor de edad: " + estudiante.esMayorDeEdad());
        System.out.println("Antigüedad estudiante: " + estudiante.calcularAntiguedad() + " años");
    }
}
