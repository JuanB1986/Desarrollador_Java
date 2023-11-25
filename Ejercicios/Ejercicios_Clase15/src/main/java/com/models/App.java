package com.models;

import java.nio.charset.Charset;

import com.Hmi.HmiController;
import com.Hmi.HmiData;

public class App 
{
    public static void main( String[] args )
    {
    	HmiController.getVista(); 
   	
    	Cancion objCancion1= new Cancion("La Ciudad De La Furia","Soda Stereo","Doble Vida",1988);
    	
    	System.out.println( objCancion1.display()+"	"+objCancion1.getPopularidad().getLikes()+"L "+objCancion1.getPopularidad().getDislikes()+"D "+objCancion1.getPopularidad().getReproducciones()+"R" );
    	
    	objCancion1.setReproducciones(1001);
    	System.out.println( objCancion1.display()+"	"+objCancion1.getPopularidad().getLikes()+"L "+objCancion1.getPopularidad().getDislikes()+"D "+objCancion1.getPopularidad().getReproducciones()+"R" );
    	
    	objCancion1.setLikes(20001);  
    	objCancion1.setReproducciones(50001);
    	System.out.println( objCancion1.display()+"	"+objCancion1.getPopularidad().getLikes()+"L "+objCancion1.getPopularidad().getDislikes()+"D "+objCancion1.getPopularidad().getReproducciones()+"R" );
        
    	objCancion1.setDislikes(5000);    	
    	System.out.println( objCancion1.display()+"	"+objCancion1.getPopularidad().getLikes()+"L "+objCancion1.getPopularidad().getDislikes()+"D "+objCancion1.getPopularidad().getReproducciones()+"R" );
    	
    	objCancion1.setDislikes(0); 
    	System.out.println( objCancion1.display()+"	"+objCancion1.getPopularidad().getLikes()+"L "+objCancion1.getPopularidad().getDislikes()+"D "+objCancion1.getPopularidad().getReproducciones()+"R" );
    
     	objCancion1.setHsSinReproducir(24);
    	System.out.println( objCancion1.display()+"	"+objCancion1.getPopularidad().getLikes()+"L "+objCancion1.getPopularidad().getDislikes()+"D "+objCancion1.getPopularidad().getReproducciones()+"R" );
    	
     	objCancion1.setHsSinReproducir(0);
    	System.out.println( objCancion1.display()+"	"+objCancion1.getPopularidad().getLikes()+"L "+objCancion1.getPopularidad().getDislikes()+"D "+objCancion1.getPopularidad().getReproducciones()+"R" );
    	
    	//Prueba interfaz gráfica.
    	
    	byte emojiLike[]= 	{(byte)0xF0,(byte)0x9F,(byte)0x91,(byte)0x8D};
    	byte emojiDisike[]= {(byte)0xF0,(byte)0x9F,(byte)0x91,(byte)0x8E};
    	byte emojiReprod[]= {(byte)0xE2,(byte)0x92,(byte)0xB6};
    	
    	HmiData.setText(objCancion1.display(),0);
    	HmiData.setText(String.valueOf(new String(emojiLike, Charset.forName("utf-8"))+" " +objCancion1.getPopularidad().getLikes()),1);
    	HmiData.setText(String.valueOf(new String(emojiDisike, Charset.forName("utf-8")) +" "+objCancion1.getPopularidad().getDislikes()),2);
    	HmiData.setText(String.valueOf(new String(emojiReprod, Charset.forName("utf-8"))+" "+objCancion1.getPopularidad().getReproducciones()),3);
    	
    	byte b1[]={0x2,0x2,0x2,0x2};
    	String f = new String(b1, Charset.forName("utf-8"));
    }
}
