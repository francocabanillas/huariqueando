package com.huariqueando.rest.util;

public class AccesoUtil {

    public boolean esClavefuerte(String clave){
        return clave.length()>8;
    }
}
