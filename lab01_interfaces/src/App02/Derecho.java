package App02;
public class Derecho implements ProgramaAcademico {
    private String nombrePrograma;
    private String codigoPrograma;
    private int duracionSemestres;
    private String tituloOtorgado;
    private boolean acreditado;
    private String versionPensum;
    private String consultorioJuridico;

    public Derecho() {
        this.nombrePrograma = "Derecho";
        this.codigoPrograma = "DR001";
        this.duracionSemestres = 10;
        this.tituloOtorgado = "Abogado";
        this.acreditado = false;
        this.versionPensum = "2021";
        this.consultorioJuridico = "Consultorio Jurídico U";
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
        System.out.println("Nuevo pensum versión " + nuevaVersion + " actualizado para Derecho.");
    }

    public void mostrarInformacion() {
        System.out.println("=== DERECHO ===");
        System.out.println("Nombre: " + nombrePrograma);
        System.out.println("Código: " + codigoPrograma);
        System.out.println("Duración: " + duracionSemestres + " semestres");
        System.out.println("Título: " + tituloOtorgado);
        System.out.println("Acreditado: " + (acreditado ? "Sí" : "No"));
        System.out.println("Pensum: versión " + versionPensum);
        System.out.println("Consultorio jurídico: " + consultorioJuridico);
    }

    // Métodos adicionales
    public void hacerSimulacroJuicio() {
        System.out.println("Los estudiantes de Derecho realizan un simulacro de juicio en el " + consultorioJuridico);
    }

    public void revisarNormativa() {
        System.out.println("Revisando actualizaciones en la normativa legal vigente...");
    }
}

