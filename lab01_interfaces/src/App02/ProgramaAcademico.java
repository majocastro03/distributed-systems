package App02;
public interface ProgramaAcademico {
    String getNombrePrograma();
    void setNombrePrograma(String nombre);

    String getCodigoPrograma();
    void setCodigoPrograma(String codigo);

    int getDuracionSemestres();
    void setDuracionSemestres(int duracion);

    String getTituloOtorgado();
    void setTituloOtorgado(String titulo);

    void mostrarInformacion();

    boolean esProgramaAcreditado();
    void acreditarPrograma();

    void actualizarPensum(String nuevaVersion);
}