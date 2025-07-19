package App02;

public class IngMecanica implements ProgramaAcademico {
    private String nombrePrograma;
    private String codigoPrograma;
    private int duracionSemestres;
    private String tituloOtorgado;
    private boolean acreditado;
    private String versionPensum;
    private String laboratorioPrincipal;

    public IngMecanica() {
        this.nombrePrograma = "Ingeniería Mecánica";
        this.codigoPrograma = "IM001";
        this.duracionSemestres = 10;
        this.tituloOtorgado = "Ingeniero Mecánico";
        this.acreditado = false;
        this.versionPensum = "2020";
        this.laboratorioPrincipal = "Laboratorio de Termodinámica";
    }

    // Métodos de la interfaz
    public String getNombrePrograma() { return nombrePrograma; }
    public void setNombrePrograma(String nombre) { this.nombrePrograma = nombre; }

    public String getCodigoPrograma() { return codigoPrograma; }
    public void setCodigoPrograma(String codigo) { this.codigoPrograma = codigo; }

    public int getDuracionSemestres() { return duracionSemestres; }
    public void setDuracionSemestres(int duracion) { this.duracionSemestres = duracion; }

    public String getTituloOtorgado() { return tituloOtorgado; }
    public void setTituloOtorgado(String titulo) { this.tituloOtorgado = titulo; }

    public boolean esProgramaAcreditado() { return acreditado; }
    public void acreditarPrograma() { this.acreditado = true; }

    public void actualizarPensum(String nuevaVersion) {
        this.versionPensum = nuevaVersion;
        System.out.println("Nuevo pensum versión " + nuevaVersion + " actualizado para Ingeniería Mecánica.");
    }

    public void mostrarInformacion() {
        System.out.println("=== INGENIERÍA MECÁNICA ===");
        System.out.println("Nombre: " + nombrePrograma);
        System.out.println("Código: " + codigoPrograma);
        System.out.println("Duración: " + duracionSemestres + " semestres");
        System.out.println("Título: " + tituloOtorgado);
        System.out.println("Acreditado: " + (acreditado ? "Sí" : "No"));
        System.out.println("Pensum: versión " + versionPensum);
        System.out.println("Laboratorio principal: " + laboratorioPrincipal);
    }

    // Métodos adicionales
    public void realizarPractica() {
        System.out.println("Los estudiantes realizan prácticas en " + laboratorioPrincipal);
    }

    public void evaluarProyectoFinal() {
        System.out.println("Evaluando proyecto final de Ingeniería Mecánica...");
    }
}
