/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servlet;

/**
 *
 * @author gagan
 */
public class Dairy{
    String date;
    String entry;
    Dairy(String d,String e){
        date=d;
        entry=e;
    }
    @Override
    public String toString(){
        return "Date of entry is: "+date + "Entry is: "+entry;
    }
    
}
