package com.example.resultadosposicionesparcial2;

public class Resultado {
    private String equipoL;
    private String equipoV;
    private String golesL;
    private String golesV;
    private String faltasL;
    private String faltasV;

    public Resultado(String equipoL, String equipoV, String golesL, String golesV, String faltasL, String faltasV) {
        this.equipoL = equipoL;
        this.equipoV = equipoV;
        this.golesL = golesL;
        this.golesV = golesV;
        this.faltasL = faltasL;
        this.faltasV = faltasV;
    }

    public String getEquipoL() {
        return equipoL;
    }

    public void setEquipoL(String equipoL) {
        this.equipoL = equipoL;
    }

    public String getEquipoV() {
        return equipoV;
    }

    public void setEquipoV(String equipoV) {
        this.equipoV = equipoV;
    }

    public String getGolesL() {
        return golesL;
    }

    public void setGolesL(String golesL) {
        this.golesL = golesL;
    }

    public String getGolesV() {
        return golesV;
    }

    public void setGolesV(String golesV) {
        this.golesV = golesV;
    }

    public String getFaltasL() {
        return faltasL;
    }

    public void setFaltasL(String faltasL) {
        this.faltasL = faltasL;
    }

    public String getFaltasV() {
        return faltasV;
    }

    public void setFaltasV(String faltasV) {
        this.faltasV = faltasV;
    }
}
