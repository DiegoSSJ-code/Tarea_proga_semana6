/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nuevaComision;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import javax.swing.JOptionPane;
import modelos.MdVendedor;

/**
 *
 * @author Win10
 */
public class ClsNuevaComision {
    public List<MdVendedor> Todos = new ArrayList<MdVendedor>();
    Scanner t = new Scanner(System.in);
    Locale locale = new Locale("es", "GT");
    NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(locale);
    private String i;
    
    public MdVendedor Ingreso_informacion(){
        MdVendedor vende = new MdVendedor();
        System.out.println("Ingrese nombre: ");
        vende.setNombre(t.nextLine());
        System.out.println("Enero:");
        vende.setEnero(t.nextDouble());
        System.out.println("Febrero: ");
        vende.setFebrero(t.nextDouble());
        System.out.println("Marzo: ");
        vende.setMarzo(t.nextDouble());
        System.out.println("IngreseId: ");
        vende.setId(t.nextInt());
        Todos.add(vende);
        return vende;
    }
    
    public void desplegarDatos(){
        for(MdVendedor ele: Todos){
            System.out.println("Nombre = "+ele.getNombre());
            System.out.println("Enero = "+currencyFormatter.format(ele.getEnero()));
            System.out.println("Febrero = "+currencyFormatter.format(ele.getFebrero()));
            System.out.println("Marzo = "+currencyFormatter.format(ele.getMarzo())); 
            System.out.println("--------------------");
        }
        for(MdVendedor cal: Todos){
            double total = 0.00;
            double prom = 0.00;
            total = cal.getEnero() + cal.getFebrero() + cal.getMarzo();
            prom = total / 3;
            cal.setTotalM(total);
            cal.setPromedio(prom);
            System.out.println("Total meses = "+currencyFormatter.format(cal.getTotalM()));
            System.out.println("Promedio = "+currencyFormatter.format(cal.getPromedio()));
            System.out.println("--------------------");
        }
    }
    
    public static void LimpiarPantalla(){
        try{
            Robot presrobt = new Robot();
            presrobt.keyPress(KeyEvent.VK_CONTROL);
            presrobt.keyPress(KeyEvent.VK_L);
            presrobt.keyRelease(KeyEvent.VK_CONTROL);
            presrobt.keyRelease(KeyEvent.VK_CONTROL);
        }catch(Exception e){
            System.out.println(""+e.getMessage());
        }
    }
    
    public void CambiarDatos(){
        int ID;
        System.out.println("Ingrese el ID del vendedor que quiere modificar: ");
        ID = t.nextInt();
        String blank;
        System.out.println("CARGANDO...");
        blank = t.nextLine();
        System.out.println("Ingrese el nuevo nombre: ");
        Todos.get(ID).setNombre(t.nextLine());
        System.out.println("Ingrese la nueva venta de enero: ");
        Todos.get(ID).setEnero(t.nextDouble());
        System.out.println("Ingrese la nueva venta de febrero: ");
        Todos.get(ID).setFebrero(t.nextDouble());
        System.out.println("Ingrese la nueva venta de marzo: ");
        Todos.get(ID).setMarzo(t.nextDouble());
        desplegarDatos();
        LimpiarPantalla();
    }
    public void mxmes (){
        String op = "";
        double total = 0;
        do{
            System.out.println("1-Total de ventas enero");
            System.out.println("2-Total de ventas febrero");
            System.out.println("3-Total de ventas marzo");
            System.out.println("4-Regresar");
            op = t.nextLine();
            switch(op){
                case "1": 
                    for(MdVendedor ene : Todos){
                        total += ene.getEnero();
                        System.out.println("El total de enero es: "+total);
                    }
                    break;
                case "2":
                    for(MdVendedor feb : Todos){
                        total += feb.getFebrero();
                        System.out.println("El total de febrero es: "+total);
                    }
                    break;
                case "3":
                    for(MdVendedor mar: Todos){
                        total += mar.getMarzo();
                        System.out.println("El total de marzo es: "+total);
                    }
                    break;
                case "4":
                    System.out.println("");
                    break;
                default:
                    menu();
            }
        }while(!equals("5"));
    }
    public void Maxmeses(){
        String op = "";
        do{
            System.out.println("1-Quien vendio más.");
            System.out.println("2-Quien vendio menos");
            op = t.nextLine();
        }while (equals("4"));
    }
    public void UnidadPrueba(String nom, double ene,double feb, double mar){
        MdVendedor vende = new MdVendedor();
        vende.setNombre(nom);
        vende.setEnero(ene);
        vende.setFebrero(feb);
        vende.setMarzo(mar);
    }
    public boolean BuscarPorNombre (String nombre){
        boolean listo = false;
        int i = 0;
        while (listo == false && i<Todos.size()){
            if(Todos.get(i).getNombre().compareToIgnoreCase(nombre)==0) {
                listo = true;
            } else {
                    i++;
            }
        }
        if(listo){
            System.out.println("Nombre: "+Todos.get(i).getNombre());
            System.out.println("Enero: "+Todos.get(i).getEnero());
            System.out.println("Febrero: "+Todos.get(i).getFebrero());
            System.out.println("Marzo: "+Todos.get(i).getMarzo());
            System.out.println("Total ventas: "+Todos.get(i).getTotalM());
            System.out.println("Promedio: "+Todos.get(i).getPromedio());
            return false;
        }else{
            System.out.println("El nombre no existe en nuestra base. Intente con uno nuevamente");
            return true;
        }        
    }
    
    public void menu(){
        String op = "";
        do{
            System.out.println("1-Ingreso Informacion");
            System.out.println("2-Ver Infomracion");
            System.out.println("3-Modificar datos");
            System.out.println("4-Maximo de ventas por mes");
            System.out.println("5-Buscar por nombre");
            System.out.println("6-Salir");
            op = t.nextLine();
            switch(op){
                case "1":
                    Ingreso_informacion();
                    break;
                case"2":
                    desplegarDatos();
                    break;
                case"3":
                    CambiarDatos();
                    break;
                case"4":
                    mxmes();
                    break;
                case"5":
                    boolean llave = false;
                    do{
                        String nombre;
                        System.out.println("Ingrese nombre:");
                        nombre = t.nextLine();
                        llave = BuscarPorNombre(nombre);
                    }while(llave);
            }
        }while(!op.equals("6"));
    }
}
