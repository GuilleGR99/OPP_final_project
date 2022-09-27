package ratonGloton;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Menu extends Juego {
	
	
	public static void menu() {//CREACION DE METODO SETTER DEL MENU PARA IR DEL JUEGO A ÉL
		
		panelPresentacion.setVisible(false);//aqui es false porque estamos cambiando de capa de la presentacion al menu
		panelMenu= new JPanel();
		panelMenu.setLayout(null);//para que nos permita poner las componenetes de l panel donde queramos
		panelMenu.setBounds(0,0,ventana.getWidth(),ventana.getHeight());//crea un rectangulo en la posicion que se indique, se le da una posicion y coge el ancho y largo de la ventana
		panelMenu.setVisible(true);
		
		
		//"Fondo del menu"
		fondoMenu= new JLabel(); //inicias fondoPresentacion
		fondoMenu.setBounds(0, 0, ventana.getWidth(), ventana.getHeight());//dices la posicion y tamaño de el fondo de presentacion, como ocupara toda la ventana coges su ancho y largo mediante metodos
		imagenFondoMenu= new ImageIcon("imagenes/fondoMenu.jpg");//Carga la imagen que tenga en la ruta colocada
		imagenFondoMenu=new ImageIcon(imagenFondoMenu.getImage().getScaledInstance(ventana.getWidth(), ventana.getHeight(), Image.SCALE_DEFAULT));//reescala la imagen anterior al tamaño de la ventana
		fondoMenu.setIcon(imagenFondoMenu);//agrega la imagen
		fondoMenu.setVisible(true);//para ver la imagen
		panelMenu.add(fondoMenu,0);//agregas el fondo del menu encima del panelMenu, el 0 hace referencia a que lo montara como una capa
		
		botones[0].setText("JUGAR");//NOMBRAMOS A LOS BOTONES "como solo voy a tener el de jugar podria borrar el resto para lo quito de que sean array y elimino el bucle para posicionarlo"
		botones[1].setText("SALIR");
		
		for(int i=0;i<botones.length;i++) {
			botones[i].setBounds(250,(i*50)+150,200,40); //coloca las botones en la posicion dada y despues (i*1)+ hace que se vayan colocando 1 debajo de otro
			botones[i].setVisible(true);
			botones[i].setBackground(Color.white);
			panelMenu.add(botones[i]);
		}
		
	ventana.add(panelMenu);//"añades a la ventana el panel del menu"
		
	}//FIN METODO MENU
	
	public static void eventoMenu() {//GETTER DEL MENU PARA AÑADIR FUNCIONALIDAD A LOS BOTONES DEL MENU
	
		//jugar
		botones[0].addMouseListener(new MouseAdapter() {//MouseListener coge las entradas del raton
			public void mousePressed(MouseEvent e) {//Setter, cuando haces click sobre jugar imprime en la consola jugar
				System.out.println("jugar");//"quito esto para que no imprima nada en la consola(el de este y resto de TODOS los botones"
				//pones estos de abajo  aqui y no en el metodo jugar para que no aparezcan cada vez continuamente,¿probar a ponerlo en el metodo jugar?
				jugador=JOptionPane.showInputDialog(ventana,"Nombre jugador:");//ventana JOptin para que el jugador escriba su nombre
				while(jugador==null || jugador.compareTo("")==0) { //bucle while para asegurarte de que el jagador escribe su nombre,¿toquetear?
					jugador=JOptionPane.showInputDialog(ventana,"Nombre invalido\n Nombre jugador:");	
				}
				/////////////////////////////////////77
				crearPartida();//LLAMA AL METODO JUGAR
				
			}
		});
		
		//salir
		botones[1].addMouseListener(new MouseAdapter() {//MouseListener coge las entradas del raton
			public void mousePressed(MouseEvent e) {//Setter, cuando haces click sobre salir imprime en la consola salir
				System.out.println("salir");//"quito esto para que no imprima nada en la consola(el de este y resto de TODOS los botones"
				System.exit(0);//CON ESTO HAGO QUE LA VENTANA SE CIERRE
			}
		});
	
	}

	
}
