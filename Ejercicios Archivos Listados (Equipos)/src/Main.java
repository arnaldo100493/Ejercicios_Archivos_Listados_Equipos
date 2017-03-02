/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author FABAME
 */
public class Main {

    public static Console c = new Console("EQUIPOS");

    public Main() {

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        /* 
         *
         * Entregue por pantalla los promedios de puntaje de cada equipo
         * y el participante con el mayor puntaje de la competencia, 
         * indicando nombre, puntaje y equipo.
         *
         */
        Archivo a1 = new Archivo("participantes.txt");
        if (a1.reset()) {
            int mayorPuntaje = 0;
            String nombreMejorParticipante = "";
            int equipoMejorParticipante = 0;

            String linea = a1.readLine();
            int cantidadEquipos = Integer.parseInt(linea);
            for (int i = 1; i <= cantidadEquipos; i++) {
                // Para cada equipo leo los participantes
                linea = a1.readLine();
                int cantidadParticipantes = Integer.parseInt(linea);
                int sumaEquipo = 0;
                for (int j = 0; j < cantidadParticipantes; j++) {
                    // Para cada participante del equipo
                    linea = a1.readLine();

                    // Dividir información del participante
                    String[] arreglo = linea.split("#");
                    String nombre = arreglo[0];
                    String puntajeString = arreglo[1];

                    int puntaje = Integer.parseInt(puntajeString);
                    sumaEquipo += puntaje;

                    if (puntaje > mayorPuntaje) {
                        mayorPuntaje = puntaje;
                        nombreMejorParticipante = nombre;
                        equipoMejorParticipante = i;
                    }
                }
                int promedioEquipo = sumaEquipo / cantidadParticipantes;
                c.println("Promedio Equipo: " + i + ": " + promedioEquipo);
            }
            c.println("El mejor participante es: ");
            c.println(nombreMejorParticipante + "(" + mayorPuntaje + " puntos)");
            c.println("Equipo: " + equipoMejorParticipante);
        } else {
            c.println("ERROR DE ARCHIVO.");
        }
    }
}
