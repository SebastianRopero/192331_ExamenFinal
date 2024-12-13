package entities;

public class Agente extends Entidad {
    private String habilidadEspecial;
    private String misionAsignada;
    private String equipoActual;

    public Agente(int id, String nombre, String habilidadEspecial) {
        super(id, nombre);
        this.habilidadEspecial = habilidadEspecial;
    }

    public String getHabilidadEspecial() {
        return habilidadEspecial;
    }

    public void setHabilidadEspecial(String habilidadEspecial) {
        this.habilidadEspecial = habilidadEspecial;
    }

    public String getMisionAsignada() {
        return misionAsignada;
    }

    public void asignarMision(String mision) {
        this.misionAsignada = mision;
    }

    public String getEquipoActual(){
        return equipoActual;
    }

    public void setEquipoActual(String equipo){
        this.equipoActual=equipo;
    }

    public boolean tieneEquipo() {
        return equipoActual != null && !equipoActual.isEmpty();
    }

    

    @Override
    public String toString() {
        return super.toString() + ", Habilidad Especial: " + habilidadEspecial +
                (misionAsignada != null ? ", Misión: " + misionAsignada : "")+
                (equipoActual != null ? ", Equipo: "+equipoActual : "");
    }
}
