package POTA.Estruturas;

import java.io.IOException;

public class programaPrincipal {

    public static void main(String[] args) throws IOException {

        arquivo arquivo = new arquivo();
        ordenacao ordenar = new ordenacao();
        int[] arrayDesordenado = new int[65000];
        int[] arrayOrdenado = new int[65000];

        arrayDesordenado = arquivo.lerArquivo("C:\\database\\database.txt");

        //arrayOrdenado = ordenar.insertionSort(arrayDesordenado);
        //arrayOrdenado = ordenar.selectionSort(arrayDesordenado);
        //arrayOrdenado = ordenar.bubbleSort(arrayDesordenado);
        arrayOrdenado = ordenar.mergeSort(arrayDesordenado);
        arrayOrdenado = ordenar.quickSort(arrayDesordenado);
        arrayOrdenado = ordenar.heapSort(arrayDesordenado);
        arquivo.gravarArquivo("C:\\database\\databaseOrdenada.txt", arrayOrdenado);
    }
}
