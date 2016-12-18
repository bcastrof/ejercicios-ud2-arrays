package com.jaureguialzo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static com.jaureguialzo.Main.Jugador.*;
import static com.jaureguialzo.Main.Piezas.*;

public class Main {

    public enum Piezas {
        RB, DB, TB, AB, CB, PB,
        RN, DN, TN, AN, CN, PN,
        X
    }

    public enum Jugador {
        B, N
    }

    public static void visualizar(Piezas[][] tablero) {

        System.out.println("    a b c d e f g h");
        System.out.println("  ╔═════════════════╗");

        for (int i = 0; i < tablero.length; i++) {

            System.out.print((8 - i) + " ║ ");
            for (int j = 0; j < tablero[0].length; j++) {

                switch (tablero[i][j]) {
                    case RN:
                        System.out.print("♚");
                        break;
                    case DN:
                        System.out.print("♛");
                        break;
                    case TN:
                        System.out.print("♜");
                        break;
                    case CN:
                        System.out.print("♞");
                        break;
                    case AN:
                        System.out.print("♝");
                        break;
                    case PN:
                        System.out.print("♟");
                        break;
                    case RB:
                        System.out.print("♔");
                        break;
                    case DB:
                        System.out.print("♕");
                        break;
                    case TB:
                        System.out.print("♖");
                        break;
                    case CB:
                        System.out.print("♘");
                        break;
                    case AB:
                        System.out.print("♗");
                        break;
                    case PB:
                        System.out.print("♙");
                        break;
                    default:
                        System.out.print(" ");
                        break;
                }
                System.out.print(" ");
            }
            System.out.println("║ " + (8 - i));
        }

        System.out.println("  ╚═════════════════╝");
        System.out.println("    a b c d e f g h");
        System.out.println();
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Piezas[][] tablero = {
                {TN, CN, AN, DN, RN, AN, CN, TN},
                {PN, PN, PN, PN, PN, PN, PN, PN},
                {X, X, X, X, X, X, X, X},
                {X, X, X, X, X, X, X, X},
                {X, X, X, X, X, X, X, X},
                {X, X, X, X, X, X, X, X},
                {PB, PB, PB, PB, PB, PB, PB, PB},
                {TB, CB, AB, DB, RB, AB, CB, TB},
        };

        visualizar(tablero);

        Jugador turno = B;

        System.out.print(turno + ": ");
        String jugada = br.readLine();

        jugada = "e2e4";

        tablero[6][4] = X;
        tablero[4][4] = PB;

        visualizar(tablero);

    }
}
