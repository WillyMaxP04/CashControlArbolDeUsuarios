package com.mycompany.cashcontroljava;

public class Ingreso extends Cuenta{
    Boolean IngresoactivoOPasivo;

    public Ingreso(String Categoria, String MedioDePago, Boolean TipoDeCiclo, Float Magnitud, int NumCuotas, int NumRegistro, Boolean Tipo) {
        super(Categoria, MedioDePago, TipoDeCiclo, Magnitud, NumCuotas, NumRegistro);
        this.IngresoactivoOPasivo = Tipo;
    }

    public Boolean getIngresoactivoOPasivo() {
        return IngresoactivoOPasivo;
    }

    public void setIngresoactivoOPasivo(Boolean IngresoactivoOPasivo) {
        this.IngresoactivoOPasivo = IngresoactivoOPasivo;
    }
}
