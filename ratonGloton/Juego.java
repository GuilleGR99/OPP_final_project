package ratonGloton;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Juego {
	
	//ATRIBUTOS   //los STATIC son para modificarlo desde otra clase y que ese cambio se haga en cualquier lugar donde este la variable
	 static JFrame ventana;
	
	//presentacion
	static JPanel panelPresentacion;
	JButton iniciar;
	JLabel fondoPresentacion; 
	ImageIcon imagenFondoPres;
	
	//menu
	static JPanel panelMenu;//atributo del menu
	static	JButton botones[];//arrays de botones para el menu
	static	JLabel fondoMenu; //Fondo para el menu
	static	ImageIcon imagenFondoMenu;//imagen de fondo para el menu
	
	//juego
	static JPanel panelJuego;
	static JLabel fondoJuego;
	static ImageIcon imagenFondoJuego;
	static int[][]mat;//matriz logica donde hacemos cambios y otra donde vamos a mostrar esos cambios
	static JLabel[] []matriz;
	static int px;//posicion en x para el raton
	static int py;//posicion en y para el raton
	static String jugador;
	static JLabel nombre;//Para mostrar el nombre del jugador
	static int puntos;
	static JLabel records;//para mostrar los puntos segun vamos comiendo
	
	//movimiento
	static int abajo;
	static int arriba;
	static int izq;
	static int der;
	static Timer timer;
	
	//Gatos
	static Gato gato1;
	static Gato gato2;
	static Gato gato3;
	static int matAux[][];//para que despues de que un gato pase por una posicion de suelo vuelva a ponerse el sprite de suelo

	public Juego() { //Constructor de Juego
		
		//CREACION VENTANA creacion de la ventana donde se montaran el resto de pantallas
		ventana= new JFrame("RATON GLOTON");//"Crear nuevo JFrame con nombre RATON GLOTON
		ventana.setSize(700, 700);//Dar tamaño a la ventana
		ventana.setLayout(null);//permite colocar los componentes como imagenes en botones
		ventana.setLocationRelativeTo(null);//coloca la ventana principal en el medio de la pantalla d el oredenador
		ventana.setResizable(false);//desactiva el boton de expandir pantalla en la ventana.
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//cuando le demos a la x roja se cierra completamente y no se queda en segundo plano
		
		//PANEL DE PRESENTACION
		panelPresentacion= new JPanel();
		panelPresentacion.setLayout(null);//para que nos permita poner las componenetes del panel donde queramos
		panelPresentacion.setBounds(0,0,ventana.getWidth(),ventana.getHeight());//crea un rectangulo en la posicion que se indique, se le da una posicion y coge el ancho y largo de la ventana
		panelPresentacion.setVisible(true);
		panelPresentacion.setBackground(Color.black);//Le da color al fondo
		ventana.add(panelPresentacion,-1);//aqui montas el panel de presentacion en la ventana , el -1 hace referencia a que lo montara como una capa
		
		//boton iniciar la presentacion
		iniciar=new JButton("COMENZAR"); //iniciacion del boton iniciar
		iniciar.setBounds(300, 300, 100, 30);;//le da posicion y tamaño, jugar con ello para colocarlo donde quiera
		iniciar.setVisible(true);//para que se vea el boton iniciar
		iniciar.setBackground(Color.white);//Le da color al boton,
		panelPresentacion.add(iniciar,0);//agregas el boton iniciar encima del panelPresentacion, el 0 hace referencia a que lo montara como una capa
		
		//"Fondo de la presentacion"
		fondoPresentacion= new JLabel(); //inicias fondoPresentacion
		fondoPresentacion.setBounds(0, 0, ventana.getWidth(), ventana.getHeight());//dices la posicion y tamaño de el fondo de presentacion, como ocupara toda la ventana coges su ancho y largo mediante metodos
		imagenFondoPres= new ImageIcon("imagenes/fondoPresentacion.jpg");//Carga la imagen que tenga en la ruta colocada
		imagenFondoPres=new ImageIcon(imagenFondoPres.getImage().getScaledInstance(ventana.getWidth(), ventana.getHeight(), Image.SCALE_DEFAULT));//reescala la imagen anterior al tamaño de la ventana
		fondoPresentacion.setIcon(imagenFondoPres);//agrega la imagen
		fondoPresentacion.setVisible(true);//para ver la imagen
		panelPresentacion.add(fondoPresentacion,0);//agregas el fondo de presentacion encima del panelPresentacion, el 0 hace referencia a que lo montara como una capa
		
		//MENU
		botones=new JButton[2];//DAR TAMAÑO AL ARRAYS DE BOTONES "poner el mismo numero de botones que haya en el menu
		for(int i=0;i<botones.length;i++) {//"BUCLE PARA RELLENAR LOS BOTONES DEL MENU
			botones[i]=new JButton();	
		}//fin menu
		
		
		
		
		
		//boton iniciar presentacion 
		iniciar.addMouseListener(new MouseAdapter() {//MouseListener coge las entradas del raton
			public void mousePressed(MouseEvent e) {//Setter, cuando haces click sobre iniciar imprime en la consola iniciar
				System.out.println("iniciar");//"quito esto para que no imprima nada en la consola(el de este y resto de TODOS los botones"
				Menu.menu();//LLAMA AL METODO MENU,"cuando pulsas en boton menu este ejecuta el metodo menu
				Menu.eventoMenu();//LLAMA AL METODO DE EVENTO MENU, DONDE ESTAN TODOS LOS BOTONES
			}
		});
		
		//juego 
		mat=new int[15][15]; 
		int seleccionNivel=Integer.parseInt(JOptionPane.showInputDialog("Eligue nivel:\n 1:Pasadizos\n 2:Prisión\n 3:Plaza"));
		mat=Tablero.tablero(seleccionNivel);//CON ESTO SE PUEDE ELEGIR EL NIVEL, la matriz de numeros es igual al tablero que le pasa "la opcion de nievel 1????"	
		
		matriz=new JLabel [15][15];
		matAux= new int[15][15];//mat aux es para poner el sprite suelo despues de que pase el gato
		for(int i =0;i<mat.length;i++) { //"avanza por la matriz mat"
			for(int j=0;j<mat.length;j++) {
				matriz[i][j]=new JLabel();
				matAux[i][j]=mat[i][j];//se transfiere la posicion de matAux a mat
			}
		}
		
		/////////
		
		//imagen raton
		px=1; // tanto px como py sirven para dar una posicion inicial al raton, si fuese 0,0 seria en el muro y estaria mal
		py=1;
		mat[px][py]=3;//la matriz de las posiciones en x e y del raton es igual a 3.  3 es nuestro personaje
	
			
		
		
		//inicializo las variables de movimiento a 0, " ¿esto lo podria hacer donde los atributos?"
		abajo=0;
		arriba=0;
		izq=0;
		der=0;
		
		
		ventana.add(panelPresentacion);//aqui montas el panel de presentacion en la ventana , el -1 hace referencia a que lo montara como una capa
		
		ventana.setVisible(true);	
	}//FIN DEL CONSTRUCTOR
	
	
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	public static void crearPartida() {//METODO GETTER PARA JUGAR (¿Cambiar nombre a crear partida?
		
		panelMenu.setVisible(false);//aqui es false porque estamos cambiando de capa del menu al juego
		panelJuego= new JPanel();
		panelJuego.setLayout(null);//para que nos permita poner las componenetes del panel donde queramos
		panelJuego.setBounds(0,0,ventana.getWidth(),ventana.getHeight());//crea un rectangulo en la posicion que se indique, se le da una posicion y coge el ancho y largo de la ventana
		panelJuego.setVisible(true);
		
		
		//"Fondo del juego"
		fondoJuego= new JLabel(); //inicias fondoPresentacion
		fondoJuego.setBounds(0, 0, ventana.getWidth(), ventana.getHeight());//dices la posicion y tamaño de el fondo de presentacion, como ocupara toda la ventana coges su ancho y largo mediante metodos
		imagenFondoJuego= new ImageIcon("imagenes/fondoMenu.jpg");//Carga la imagen que tenga en la ruta colocada
		imagenFondoJuego=new ImageIcon(imagenFondoMenu.getImage().getScaledInstance(ventana.getWidth(), ventana.getHeight(), Image.SCALE_DEFAULT));//reescala la imagen anterior al tamaño de la ventana
		fondoJuego.setIcon(imagenFondoMenu);//agrega la imagen, he dejado la imagen del menu
		fondoJuego.setVisible(true);//para ver la imagen
		panelJuego.add(fondoJuego,0);//agregas el fondo del menu encima del panelMenu, el 0 hace referencia a que lo montara como una capa
		/////////fin fondo juego
		
		//fotos del tablero
		for(int i=0;i<mat.length;i++) { 
			for(int j=0;j<mat.length;j++) {
				matriz[i][j].setIcon(new ImageIcon("imagenes/"+mat[i][j]+".png"));//coge la imagen de la direccion segun i j que son los numeros con los que hemos compuesto el laberinto
				matriz[i][j].setBounds(100+(i*30),100+(j*30),30,30);//esto es igual que para los botones del menu, pero lo estamos haciendo para construir el laberinto
				matriz[i][j].setVisible(true);
				panelJuego.add(matriz[i][j],0);
			}
		}
		
		//NOMBRE JUGADOR para que aparezca el nombre del jugador en el panel de juego
		nombre=new JLabel("JUGADOR: "+jugador);
		nombre.setBounds(20,20,150,30);
		nombre.setForeground(Color.white);
		panelJuego.add(nombre,0);
		nombre.setVisible(true);
		
		//PUNTOS JUGADOR para que aparezcan los puntos del jugador en el panel de juego
		puntos=0;
		records=new JLabel("PUNTOS: "+puntos);
		records.setBounds(ventana.getWidth()-(150+20), 20, 150, 30);
		records.setVisible(true);
		panelJuego.add(records,0);
		records.setForeground(Color.white);
		
		
		Raton.movimientoRaton();//llama al metodo mover que es del raton
		
		//INSTANCIAS DE FANTASMAS
		/*gato*/gato1=new Gato (10,10); //creacion de una instancia de gato, crear varios para tener mas gato
		/*gato*/gato2=new Gato (10,10); //creacion de una instancia de gato, crear varios para tener mas gato
		/*gato*/gato3=new Gato (10,10); //creacion de una instancia de gato, crear varios para tener mas gato
		
		ventana.add(panelJuego);
		
		timer.start(); //esto inicia esto arranca timer //timer es una variable definida donde los atributos
		
		ventana.addKeyListener(new KeyListener(){
			
			
			@Override	
            public void keyPressed(KeyEvent e) { //metodo para cuando mantienes presionada una tecla 
				
			if(e.getKeyCode()==KeyEvent.VK_UP) {
			System.out.println("tecla hacia arriba");
			if(mat[px][py-1]==1 || mat[px][py-1]==0)//"se mueve si la posicion de arriba [py+1] es 1 que es el sprite de la comida o es 0 que es el sprite del suelo, es para que el movimiento respete los muros"
				arriba=1;
				abajo=0;
				izq=0;
				der=0;
			}
				
			if(e.getKeyCode()==KeyEvent.VK_DOWN) {
			System.out.println("tecla hacia abajo");
			if(mat[px][py+1]==1 || mat[px][py+1]==0)
				arriba=0;
				abajo=1;
				izq=0;
				der=0;
			}
				
			if(e.getKeyCode()==KeyEvent.VK_LEFT) {
			System.out.println("tecla hacia izquierda");
			if(mat[px-1][py]==1 || mat[px-1][py]==0)
				arriba=0;
				abajo=0;
				izq=1;
				der=0;
			
			}
				
			if(e.getKeyCode()==KeyEvent.VK_RIGHT) {
			System.out.println("tecla hacia derecha");
			if(mat[px+1][py]==1 || mat[px+1][py]==0) //"se mueve si la posicion a la derecha de [px+1] es 1 que es el sprite de la comida o es 0 que es el sprite del suelo, es para que el movimiento respete los muros
				arriba=0;
				abajo=0;
				izq=0;
				der=1;
			
			}
				
			}
			
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			
			
			
		});
		
	}//FIN METODO JUGAR
	
	
	  
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	
}

