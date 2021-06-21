package src.juego;

import src.tablero.Tablero;
import src.usuario.TablaUsuarios;


public class Juego {

    private Tablero damas = new Tablero();
    private TablaUsuarios usuarios = new TablaUsuarios();
    String ganador = "";

    public Juego(String juego){
        System.out.println(juego+"\n");
        initJuego();
    }

    private void initJuego() {
        int opcion;

        do {

            System.out.println("\n------BIENVENIDO AL JUEGO DE DAMAS--------");
            System.out.println("1. Jugar Damas ");
            System.out.println("2. Ingresar Jugadores ");
            System.out.println("3. Mostrar Jugadores  ");
            System.out.println("4. Mostrar Jugadores por Victorias");
            System.out.println("5. Salir");
            opcion = Datos.opcionMensaje("Opcion:");

            switch (opcion){
                case 1:
                     System.out.println("\n-----       Jugar Damas       -----\n");  jugarDamas();
                     break;
                case 2: 
                     System.out.println("\n------Ingresar Jugadores-------\n"); usuarios.ingresarJugador();
                     break; 
                case 3: 
                     System.out.println("\n------Mostrar Informaación Jugadores-----\n"); usuarios.informacionUsuario();
                     break; 
                case 4: 
                     System.out.println("\n-----Mostrar Jugadores por Victorias-----\n");
                     break;
                case 5: 
                     System.out.println("\n-----     Gracias por Jugar     -----\n");
                     break;
                default:
                     System.out.println("\n-----   Opción seleccionada inválida  -----\n");
                     break;
            }

        }while (opcion != 5);
    }

    // Metodo para jugar 
    public void jugarDamas() {
        int idJugadorNo1, idJugadorNo2;
        int revancha;

        do {

            Datos.mostrarMensaje("Para jugar ingrese información - \n");
            idJugadorNo1 = Datos.opcionMensaje("ID Jugador No 1: ");
            Datos.mostrarMensaje(usuarios.informacionEspecificaUser(idJugadorNo1));


            idJugadorNo2 = Datos.opcionMensaje("\nID Jugador No 2: ");
            Datos.mostrarMensaje(usuarios.informacionEspecificaUser(idJugadorNo2)+"\n");

            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            Datos.mostrarMensaje("\n\n\n ¡PIEDRA PAPEL O TIJERAS! \n");
            piedraPapelTijeras();
            if(ganador.equals("Gano J1")){
            Datos.mostrarMensaje("\n\nPor haber ganado, el jugador " + usuarios.informacionEspecificaUser(idJugadorNo1)+ " mueve primero\n\n");
            Datos.mostrarMensaje("\n\n* "+usuarios.informacionEspecificaUser(idJugadorNo1)+" Jugador 1: Fichas Rojas\n");
            Datos.mostrarMensaje("\n\n* "+usuarios.informacionEspecificaUser(idJugadorNo2)+" Jugador 2: Fichas Verdes \n\n");
            }
            if(ganador.equals("Gano J2")){
            Datos.mostrarMensaje("\n\nPor haber ganado, el jugador " + usuarios.informacionEspecificaUser(idJugadorNo2)+ " mueve primero\n\n");
            Datos.mostrarMensaje("\n\n* "+usuarios.informacionEspecificaUser(idJugadorNo2)+" Jugador 2: Fichas Rojas\n");
            Datos.mostrarMensaje("\n\n* "+usuarios.informacionEspecificaUser(idJugadorNo1)+" Jugador 1: Fichas Verdes \n\n");

            }

            damas.initTablero();

            revancha = Datos.opcionMensaje("\n ¿Desea jugar nuevamente?" +
                                "\t1 = SI         2 = NO: ");

        }while (revancha!=2);
    }

    //Metodo juego piedra papel o tijeras
    public String piedraPapelTijeras(){
        int opcionJ1, opcionJ2;

        do {

            Datos.mostrarMensaje("\n Jugador 1: \n");
            opcionJ1 = Datos.opcionMensaje("1. Piedra\t2. Papel\t3.Tijeras - Opcion: ");
            Datos.mostrarMensaje("\n Jugador 2\n");
            opcionJ2 = Datos.opcionMensaje("1. Piedra\t2. Papel\t3.Tijeras - Opcion: ");

            if(opcionJ1 == 1 && opcionJ2 == 1 || opcionJ1 == 2 && opcionJ2 == 2 || opcionJ1 == 3 && opcionJ2 == 3){
                Datos.mostrarMensaje("\n\n--------Es un empate----------");
                ganador = "Empate";
            } else if(opcionJ1 == 2 && opcionJ2 == 1 || opcionJ1 == 3 && opcionJ2 == 2 || opcionJ1 == 1 && opcionJ2 == 3){
                Datos.mostrarMensaje("\n\n----------Jugador 2 Perdió----------");
                ganador = "Gano J1";
            } else if(opcionJ1 == 1 && opcionJ2 == 2 || opcionJ1 == 2 && opcionJ2 == 3 || opcionJ1 == 3 && opcionJ2 == 1){
                Datos.mostrarMensaje("\n\n-------Jugador 1 Perdió--------");
                ganador = "Gano J2";
            }

        }while (ganador.equals("Empate"));

        return ganador;
    }

}