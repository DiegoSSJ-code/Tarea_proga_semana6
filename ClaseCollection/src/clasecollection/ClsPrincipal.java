/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clasecollection;

import java.util.*;
import modelos.MdVendedor;
import nuevaComision.ClsNuevaComision;


/**
 *
 * @author Win10
 */
public class ClsPrincipal {
    public static void main(String[] args) {
        ClsNuevaComision comi = new ClsNuevaComision();
        comi.menu();
        /*List<MdVendedor> Todos = new ArrayList<MdVendedor>();
        
        MdVendedor vende = new MdVendedor();
        vende.nombre = "Maria";
        vende.enero = 200;
        vende.febrero = 100;1
        
        vende.marzo = 40;
        Todos.add(vende);
        
        MdVendedor vende2 = new MdVendedor();
        vende.nombre = "Daniela";
        vende.enero = 600;
        vende.febrero = 200;
        vende.marzo = 10;
        Todos.add(vende2);
        vende = new MdVendedor();
        
        System.out.println("vende.nombre = "+ vende.nombre);
        System.out.println("vende.nombre = "+ vende2.nombre);*/
    }
    
    public static void imprimir(Collection coleccion){
        
        for (Object elemento: coleccion){
            System.out.println("Elemento (item)="+elemento);
        }
    }
}
