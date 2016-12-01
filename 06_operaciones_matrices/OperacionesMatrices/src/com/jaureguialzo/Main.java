package com.jaureguialzo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

public class Main {

    public static int[][] suma(int[][] m1, int[][] m2) {

        // Medir lo que llega en m1
        int filas = m1.length;  // Filas de la matriz
        int columnas = m1[0].length;

        // Crear la matriz de resultado
        int[][] r = new int[filas][columnas];

        // Recorrer y sumar
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                r[i][j] = m1[i][j] + m2[i][j];
            }
        }

        // Devolver el resultado
        return r;
    }

    public static int[][] productoEscalar(int[][] m, int e) {

        // Medir lo que llega en m
        int filas = m.length;  // Filas de la matriz
        int columnas = m[0].length;

        // Crear la matriz de resultado
        int[][] r = new int[filas][columnas];

        // Recorrer y multiplicamos
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                r[i][j] = e * m[i][j];
            }
        }

        // Devolver el resultado
        return r;
    }

    public static int[][] producto(int[][] m1, int[][] m2) {

        // Medir lo que llega en m1
        int filas = m1.length;  // Filas de la matriz
        int columnas = m1[0].length;

        // Crear la matriz de resultado
        int[][] r = new int[filas][columnas];

        // Recorrer y sumar
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                for (int k = 0; k < columnas; k++) {
                    r[i][j] += m1[i][k] * m2[k][j];
                }
            }
        }

        // Devolver el resultado
        return r;
    }

    public static int[][] traspuesta(int[][] m) {

        // Medir lo que llega en m
        int filas = m.length;  // Filas de la matriz
        int columnas = m[0].length;

        // Crear la matriz de resultado
        int[][] r = new int[columnas][filas];

        // Recorrer y trasponer
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                r[j][i] = m[i][j];
            }
        }

        // Devolver el resultado
        return r;
    }

    public static void visualizar(int[][] m) {

        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[0].length; j++) {
                System.out.format("%4d", m[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Declarar las variables
        int[][] m1 = new int[4][4];
        int[][] m2 = new int[4][4];

        // Generador de números aleatorios
        Random r = new Random(5);

        // Inicializamos las matrices
        for (int f = 0; f < 4; f++) {
            for (int c = 0; c < 4; c++) {
                m1[f][c] = r.nextInt(10);
                m2[f][c] = r.nextInt(10);
            }
        }

        // Visualizarlas
        System.out.println("m1");
        visualizar(m1);
        System.out.println("m2");
        visualizar(m2);

        // Sumar las matrices
        System.out.println("Suma de m1 + m2");
        visualizar(suma(m1, m2));

        // Producto por un escalar
        System.out.print("Escribe un número: ");
        int n = Integer.parseInt(br.readLine());

        System.out.println("Producto de m1 x n");
        visualizar(productoEscalar(m1, n));

        // Producto
        System.out.println("Producto de m1 x m2");
        visualizar(producto(m1, m2));

        // Traspuesta
        System.out.println("Traspuesta de m2");
        visualizar(traspuesta(m2));

    }
}
