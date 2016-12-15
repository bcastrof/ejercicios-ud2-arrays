package com.jaureguialzo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Arrays de datos
        String[] preguntas = {
                "¿Cuantos lados tiene un triángulo?",
                "¿Cual es la capital de Vietnam?",
                "¿Cual es el pez más grande del mundo?"
        };

        String[] respuestas = new String[3];

        respuestas[0] = "Tres.";
        respuestas[1] = "Hanoi.";
        respuestas[2] = "Tiburón ballena.";

        // Recuento
        int correctas = 0;
        int incorrectas = 0;

        // Generador de números aleatorios
        Random r = new Random();

        char continuar;
        do {

            // Tirar el dado
            int dado = r.nextInt(preguntas.length);

            // Preguntar y obtener las respuestas
            System.out.println("P: " + preguntas[dado]);

            System.out.print("Pulsa ENTER para ver la respuesta...");
            br.readLine();

            System.out.println("R: " + respuestas[dado]);

            char respuesta;
            do {
                System.out.print("¿Has acertado? (s|n): ");
                respuesta = br.readLine().toLowerCase().charAt(0);
            } while (respuesta != 's' && respuesta != 'n');

            // Recuento
            if (respuesta == 's') {
                correctas += 1;
            } else {
                incorrectas++;
            }

            do {
                System.out.print("¿Quieres continuar? (s|n): ");
                continuar = br.readLine().toLowerCase().charAt(0);
            } while (continuar != 's' && continuar != 'n');

        } while (continuar == 's');


        // Recuento
        System.out.println("Correctas: " + correctas);
        System.out.println("Incorrectas: " + incorrectas);

    }
}
