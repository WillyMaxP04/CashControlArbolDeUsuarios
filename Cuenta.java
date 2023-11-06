package com.mycompany.cashcontroljava;

public class Cuenta {
    private String Categoria,MedioDePago;
    private Boolean TipoDeCiclo;
    public Float Magnitud;
    public int NumCuotas, NumRegistro; 

    public Cuenta(String Categoria, String MedioDePago, Boolean TipoDeCiclo, Float Magnitud, int NumCuotas, int NumRegistro) {
        this.Categoria = Categoria;
        this.MedioDePago = MedioDePago;
        this.TipoDeCiclo = TipoDeCiclo;
        this.Magnitud = Magnitud;
        this.NumCuotas = NumCuotas;
        this.NumRegistro = NumRegistro;
    }

    public void ModificarValor(Float valor) {
        this.Magnitud = valor;
    }

    public Float getValor() {
        return Magnitud;
    }
    
    public String ImprimirInfo(){
        return "Numero de Registro: " + this.NumRegistro + ", Valor: " + this.Magnitud + ".";
    }
}
