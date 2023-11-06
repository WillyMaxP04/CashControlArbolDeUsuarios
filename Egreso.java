package com.mycompany.cashcontroljava;

public class Egreso extends Cuenta{
    String EntidadFinanciera;

    public Egreso(String Categoria, String MedioDePago, Boolean TipoDeCiclo, Float Magnitud, int NumCuotas, int NumRegistro, String entidad) {
        super(Categoria, MedioDePago, TipoDeCiclo, Magnitud, NumCuotas, NumRegistro);
        this.EntidadFinanciera = entidad;
    }

    public String getEntidadFinanciera() {
        return EntidadFinanciera;
    }

    public void setEntidadFinanciera(String EntidadFinanciera) {
        this.EntidadFinanciera = EntidadFinanciera;
    }
    
    public float AnalisisDeCostos(){
        if(this.EntidadFinanciera.equals("BANCOLOMBIA")){
            return (this.Magnitud * (3/20));
        }else if(this.EntidadFinanciera.equals("BANCO DE BOGOTA")){
            return (this.Magnitud * (1/10));
        }else{
            return (this.Magnitud * (1/5));
        }
    }
}
