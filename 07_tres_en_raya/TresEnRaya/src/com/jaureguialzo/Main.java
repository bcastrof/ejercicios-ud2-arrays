package com.jaureguialzo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void visualizarTablero(int[][] t) {

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {

                switch (t[i][j]) {
                    case 0:
                        System.out.print(" o ");
                        break;
                    case 1:
                        System.out.print(" x ");
                        break;
                    case 7:
                        System.out.print(" . ");
                        break;
                }
            }
            System.out.println();
        }
    }


    public static boolean hayGanador(int[][] t) {

        // Primero un jugador y luego el otro
        for (int i = 0; i < 2; i++) {

            // Filas
            if (t[0][0] == i && t[0][1] == i && t[0][2] == i) {
                return true;
            }
            if (t[1][0] == i && t[1][1] == i && t[1][2] == i) {
                return true;
            }
            if (t[2][0] == i && t[2][1] == i && t[2][2] == i) {
                return true;
            }

            // Columnas
            for (int j = 0; j < 3; j++ ) {
                if (t[0][j] == i && t[1][j] == i && t[2][j] == i) {
                    return true;
                }
            }

            // Diagonales
            if (t[0][0] == i && t[1][1] == i && t[2][2] == i) {
                return true;
            }
            if (t[0][2] == i && t[1][1] == i && t[2][0] == i) {
                return true;
            }
        }

        // No hay ganador
        return false;
    }


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Crear el tablero
        int[][] tablero = new int[3][3];

        // Inicializar las casillas vacías
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                tablero[i][j] = 7;
            }
        }

        // Mostrar el tablero
        visualizarTablero(tablero);

        // Ver a quien le toca jugar
        int turno = 0;
        int tiradas = 0;

        // Bucle de juego
        do {
            // El usuario elije casilla
            System.out.print("Fila (0-2): ");
            int fila = Integer.parseInt(br.readLine());
            System.out.print("Columna (0-2): ");
            int columna = Integer.parseInt(br.readLine());

            // Ver si la tirada es válida y actualizar el tablero
            if (tablero[fila][columna] == 7) {
                // Válida
                tablero[fila][columna] = turno;

                // Contabilizar la tirada
                tiradas += 1;

                // Cambio de turno
                if (turno == 0) {
                    turno = 1;
                } else {
                    turno = 0;
                }

                // Mostrar el tablero
                visualizarTablero(tablero);

            } else {
                System.err.println("Casilla ocupada...");
            }

        } while (tiradas < 9 && !hayGanador(tablero));

        // ¿Por qué hemos parado?
        if (tiradas < 9) {
            System.out.println("¡Has ganado!");
        } else {
            System.out.println("Empate...");
        }
    }
}
