package App02;

public class Main {
    public static void main(String[] args) {
        // Crear programa de ingeniería mecánica
        IngMecanica mecanica = new IngMecanica();
        mecanica.acreditarPrograma();
        mecanica.actualizarPensum("2024");
        mecanica.mostrarInformacion();
        mecanica.realizarPractica();
        mecanica.evaluarProyectoFinal();

        System.out.println();

        // Crear programa de derecho
        Derecho derecho = new Derecho();
        derecho.acreditarPrograma();
        derecho.actualizarPensum("2023");
        derecho.mostrarInformacion();
        derecho.hacerSimulacroJuicio();
        derecho.revisarNormativa();
    }
}
