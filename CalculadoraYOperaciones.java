package com.mycompany.cashcontroljava;

import java.util.ArrayList;

public class CalculadoraYOperaciones {
    public float totalI=0,totalG=0;
    public int contI=0,contG=0;
    
    public double DiferenciaDeValores(float Dat1,float Dat2){
        return Dat1 - Dat2;
    }
    
    public void PorcentajeDeGastos(ArrayList lista){
        
    }
    
    public void PorcentajeIngresos(ArrayList lista){
        
    }
    
    public double CambioDeValoresIngresoMensual(){
        double Cambio=0;
        
        return Cambio;
    }
    
    public double CambioDeValoresGastosMensual(){
        double Cambio=0;
        
        return Cambio;
    }
    
    public float SumaIngresos(float valor){
        contI++;
        totalI += valor;
        return totalI;
    }
    
    public float SumaGastos(float valor){
        contG++;
        totalG += valor;
        return totalG;
    }
}
