package ratonGloton;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JOptionPane;
import javax.swing.Timer;

public class Raton extends Juego {
	
	
	
public static void movimientoRaton() {//dar movimiento al gato
		
	
		
		timer = new Timer(200,(ActionListener) new ActionListener() {//esto es un bucle infinito que da una vuelta cada 200 miliswgundos  
			                                                             
			public void actionPerformed(ActionEvent e) {  //esto registra cada 200 milisegundos si se ha pulsado alguna tecla de movimiento             
				
				if(arriba==1 && (mat[px][py-1]==1 || mat[px][py-1]==0)) {//mira si hay un espacio 1 o 0 para avanzar
					if(mat[px][py-1]==1) { //cuando por donde pasa gato es una casilla de sprite de comida le suma 5 puntos y lo muestra en la ventana, el IF va en esta posicion porque si no contaria mal los puntos
						puntos+=5;
						records.setText("PUNTOS: "+puntos);
					}
					mat[px][py]=0;//""limpia la posicion donde estaba gato""
					matAux[px][py]=mat[px][py];//iguala la matriz auxiliar a la del mapa para cambiar el rastro del movimiento de los personajes por un nuevo sprite de suelo
					py=py-1;//mueve de posicion a gato
					mat[px][py]=3;//con este pones el gato en la posicion que vaya siendo correspondiente
					Tablero.pintarMatriz();
					
				}
				
				if(abajo==1 && (mat[px][py+1]==1 || mat[px][py+1]==0)) {//mira si hay un espacio 1 o 0 para avanzar
					if(mat[px-1][py]==1) { //cuando por donde pasa gato es una casilla de sprite de comida le suma 5 puntos y lo muestra en la ventana
						puntos+=5;
						records.setText("PUNTOS: "+puntos);
					}
					mat[px][py]=0;//""limpia la posicion donde estaba gato""
					matAux[px][py]=mat[px][py];//iguala la matriz auxiliar a la del mapa para cambiar el rastro del movimiento de los personajes por un nuevo sprite de suelo
					py=py+1;//mueve de posicion a gato
					mat[px][py]=3;//con este pones el pacman en la posicion que vaya siendo correspondiente
					Tablero.pintarMatriz();	
				}
				
				if(izq==1 && (mat[px-1][py]==1 || mat[px-1][py]==0)) {//mira si hay un espacio 1 o 0 para avanzar
					if(mat[px-1][py]==1) { //cuando por donde pasa pacman es una casilla de sprite de comida le suma 5 puntos y lo muestra en la ventana
						puntos+=5;
						records.setText("PUNTOS: "+puntos);
					}
					mat[px][py]=0;//""limpia la posicion donde estaba gato""
					matAux[px][py]=mat[px][py];//iguala la matriz auxiliar a la del mapa para cambiar el rastro del movimiento de los personajes por un nuevo sprite de suelo
					px=px-1;//mueve de posicion a gato
					mat[px][py]=3;//con este pones el gato en la posicion que vaya siendo correspondiente
					Tablero.pintarMatriz();
					
					
					
				}
				
				if(der==1 && (mat[px+1][py]==1 || mat[px+1][py]==0)) {//mira si hay un espacio 1 o 0 para avanzar
					if(mat[px+1][py]==1) { //cuando por donde pasa gato es una casilla de sprite de comida le suma 5 puntos y lo muestra en la ventana
						puntos+=5;
						records.setText("PUNTOS: "+puntos);
					}
					mat[px][py]=0;//""limpia la posicion donde estaba pacman""
					matAux[px][py]=mat[px][py];//iguala la matriz auxiliar a la del mapa para cambiar el rastro del movimiento de los personajes por un nuevo sprite de suelo
					px=px+1;//mueve de posicion a gato
					mat[px][py]=3;//con este pones el gato en la posicion que vaya siendo correspondiente
					Tablero.pintarMatriz();
					
				}
				
				//para saber cuando ganamos
				int enc=0;
				for(int i=0;i<mat.length && enc==0;i++) {//recoorre la matiz mat
					for(int j=0;j<mat.length && enc==0;j++) {//recorre la matriz mat
						if(mat[i][j]==1){//siempre que haya un sprite de comida (se representa por 1) en alguna posicion del nivel enc sera 1, porque aun queda comida
							enc=1;
						}
						
					}
					
				}
				if(enc==0) {
					JOptionPane.showMessageDialog(ventana, "FELICIDADES, HAS GANADO");
					panelJuego.setVisible(false);
					panelMenu.setVisible(true);
					timer.stop();
					
				}
				
				
				if(mat[px][py-1]==7 || mat[px][py+1]==7 || mat[px-1][py]==7 || mat[px+1][py]==7){//si el gato esta arriba. abajo,izq o der del gato, muere
					gato1.timer.stop(); //detiene el bucle timer
					gato2.timer.stop();
					gato3.timer.stop();
					JOptionPane.showMessageDialog(ventana, "Fin de partida");//muestra el mensaje
					panelJuego.setVisible(false);//oculta el panel del juego
					panelMenu.setVisible(true);//hace que se muestre el menu, vuelves al menu cuando pierdes
					timer.stop();
				}
			
			}
		});       
	

		
		
		
		
		
		
		
	}

}
