/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package hackENCE;
import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
//se inserto  un uevo pak

/**
 *permite  abrir  un dir e hacer una
 * busqueda de los archivos de texto plano
 * y hacer un pequeño  ajuste.
 * @author EDUARDO CASTILLO
 */
public class directorio {


	public static void main (String args []){

	String fic="C:/Users/xxl/Documents/prueba";
			//JOptionPane.showInputDialog("incerte directorio");
			//creacion de direccion de ntrada
		File  fichero= new File (fic);
		String listaArchivo[] = fichero.list();
		String inf="";
		String nom_arc;//archivo a leer
		// checar si primero es un directorio
		if (fichero.isDirectory()) {
			for (int x=0; x<listaArchivo.length;x++)
			       inf+=x+".-"+ listaArchivo[x] +"\n";
				//muestra la coleccion de archivo.
			       JOptionPane.showMessageDialog(null, inf);

                               // incerta la posicion de el archivo a hack
                int y=Integer.parseInt(JOptionPane.showInputDialog("# de archivo a protejer"));
		///###  cchecar cuando no es un numero.
                nom_arc =listaArchivo[y];
		JOptionPane.showMessageDialog(null, "archivo seleccionadao: "+ nom_arc);
		//manipulacion de los archivos
				try {
		//archivo para leer , se hace por medio del la busqueda de directorio.
		// falta hacer el metodo para leer y escrivir en los new   file.
		File  f_leer =new File ("C:/Users/EDUARDO CASTILLO/Documents/prueba/"+nom_arc);
		FileReader archivoreader = new FileReader (f_leer);
		BufferedReader leer =new BufferedReader (archivoreader);

		//crear new directorio al cual se manda el archivo
		java.io.File dir = new File("C:/Users/EDUARDO CASTILLO/Documents/pruebanew");
		dir.mkdirs() ;
		//archivo al que se escribe.
		File new_file =new File (dir+"/"+"modline2.txt");
		FileWriter archivo = new FileWriter (new_file);
		   PrintWriter bufer  = new PrintWriter ( archivo );

		   //lee line por line debuelbe texto
		  /* String l ="";
		   while ((l=leer.readLine())!=null){
			   bufer.println(l);
		   }*/
		// para leer y debuelve codigo ascii
		   int read=0;
			while (read !=-1 ){
				read=leer.read();
				// el read contiene el codigo ascii
			//char c=(char) read;// comvertir ascii a caracter.
				//escribe en al new file
				 if (read==10) /// para el salto de linea
                            bufer.println(read);
				 else
			bufer.print(read);
			}
			//cierre de los archivos
		   f_leer.exists();
		   new_file.exists();
		   archivo.close();
		   bufer.close();
		   archivoreader.close();
		   leer.close();
		   JOptionPane.showMessageDialog(null, "proceso terminado");

	} // cuierre de try
		catch ( IOException excepcionEs ){
		JOptionPane.showMessageDialog(null, "error de archivo");

	}


}

	}

}
