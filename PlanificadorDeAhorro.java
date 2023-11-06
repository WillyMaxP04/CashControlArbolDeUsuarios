package com.mycompany.cashcontroljava;

public class PlanificadorDeAhorro {
    private float MetaAhorro;
    public float YaAhorrado;
    
    public PlanificadorDeAhorro() {
        YaAhorrado = 0;
    }
    
    public int AnalisisDeSaldo(double diferencia){
        if(diferencia >= 1000000){
            return 6000000;
        }else if(diferencia>=100000){
            return 1000000;
        }else{
            return 500000;
        }
    }
    
    public void CreacionDeMetaAhorro(double diferencia) {
        System.out.println("Opcion de ahorro adecuada (en pesos): "+ AnalisisDeSaldo(diferencia));
        this.MetaAhorro = AnalisisDeSaldo(diferencia);
    }
    
    public void IngresarDinero(float Cantidad){
        YaAhorrado += Cantidad;
    }
    
    public float PorcentajeYaAhorrado(float cantidad){
        return (cantidad/this.MetaAhorro)*100;
    }
}
