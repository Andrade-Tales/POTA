package POTA.APS;


import java.io.IOException;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class estudoComparativo {


    public static void main(String[] args) throws IOException {

        // SCANNER e entrada do tamanho dos vetores;
        Scanner entrada = new Scanner(System.in);

        int contadorheap = 0;
        int numAleatorio;

        System.out.println("Insira o tamanho do vetor: ");

        numAleatorio = entrada.nextInt();

        // CLASSE para gerar o vetor com a quantidade de elementos escolhida;
        int[] v = gerar(numAleatorio);

        System.out.println("\n Vetor inicial: " + Arrays.toString(v));

        bubbleSort(v);
        selectionSort(v);
        insertionSort(v);
        heapSort(v);

        System.out.println("\n Vetor Heap: " + Arrays.toString(v));
        System.out.println("--> Comparações Heap: " + contadorheap);

        int i = 0;
        int f = v.length;

        mergeSort(v, i, f);
        System.out.println("\n Vetor Merge: " + Arrays.toString(v));
        System.out.println("--> Comparações Merge: " + contadormerge);

        quickSort(v, 0, v.length - 1);
        System.out.println("\n Vetor Quick: " + Arrays.toString(v));
        System.out.println("--> Comparações Quick: " + contadorquick);

    }

    public static void bubbleSort(int[] vetor) {
        int aux;
        int contadorBubble = 0;
        boolean controle;

        for (int i = 0; i < vetor.length; i++) {
            controle = true;

            for (int j = 0; j < (vetor.length - 1); j++) {
                contadorBubble++;

                if (vetor[j] > vetor[j + 1]) {
                    aux = vetor[j];
                    vetor[j] = vetor[j + 1];
                    vetor[j + 1] = aux;
                    controle = false;
                }
            }

            if (controle) {
                break;
            }
        }

        System.out.println("\nVetor Bubble: " + Arrays.toString(vetor));
        System.out.println("--> Comparações Bubble: " + contadorBubble);
    }

    public static void selectionSort(int[] vetor) {
        int contadors = 0;
        for (int i = 0; i < vetor.length; i++) {
            int menor = 1;

            for (int j = i + 1; j < vetor.length; j++) {
                contadors++;

                if (vetor[j] < vetor[menor]) {
                    menor = j;
                }
            }
            mudar(vetor, i, menor);
        }

        System.out.println("\nVetor Selection: " + Arrays.toString(vetor));
        System.out.println("--> Comparações Selection: " + contadors);
    }

    public static void mudar(int[] vetor, int i, int menor) {
        int aux = vetor[i];
        vetor[i] = vetor[menor];
        vetor[menor] = aux;
    }

    private static void insertionSort(int[] vetor) {
        int contador = 0;
        int x, j;
        for (int i = 1; i < vetor.length; i++) {

            x = vetor[i];
            j = i - 1;
            contador++;

            while ((j > -0) && vetor[j] > x) {
                vetor[j + 1] = vetor[j];
                j = j - 1;
            }
            vetor[j + 1] = x;
        }

        System.out.println("\nVetor Insertion: " + Arrays.toString(vetor));
        System.out.println("--> Comparações Insertion: " + contador);
    }

    public static int contadorHeap;

    public static void heapSort(int[] v) {

        buildMaxHeap(v);
        int n = v.length;

        for (int i = v.length - 1; i > 0; i--) {
            swap(v, i, 0);
            maxHeapify(v, 0, --n);
        }
    }

    private static void swap(int[] v, int j, int aposJ) {

        int aux = v[j];
        v[j] = v[aposJ];
        v[aposJ] = aux;
    }

    private static void buildMaxHeap(int[] v) {
        for (int i = v.length / 2 - 1; i >= 0; i--) {
            maxHeapify(v, i, v.length);
        }

    }

    private static void maxHeapify(int[] vetor, int pos, int tamanhoDoVetor) {

        int max = 2 * pos + 1, right = max + 1;
        contadorHeap++;
        if (max < tamanhoDoVetor) {
            contadorHeap++;
            if (right < tamanhoDoVetor && vetor[max] < vetor[right])
                max = right;
            contadorHeap++;
            if (vetor[max] > vetor[pos]) {
                swap(vetor, max, pos);
                maxHeapify(vetor, max, tamanhoDoVetor);

            }

        }
    }


    private static int contadormerge = 0;

    public static void mergeSort(int[] vet, int i, int f) {
        contadormerge++;
        if (i < f) {
            int m = (i + f) / 2;
            mergeSort(vet, i, m);
            mergeSort(vet, m + 1, f);
            intercala(vet, i, m, f);
        }
    }

    public static void intercala(int[] vet, int i, int m, int f) {
        int vet2[] = new int[vet.length];
        for (int j = i; j <= m; j++) {
            vet2[j] = vet[j];
        }
        for (int g = m + 1; g < f; g++) {
            vet2[f + m - g] = vet[g];
        }
        int x = i;
        int z = f - 1;

        for (int k = i; k < f; k++) {
            contadormerge++;
            if (vet2[x] <= vet2[z]) {
                vet[k] = vet2[x];
                x = x + 1;

            } else {
                vet[k] = vet2[z];
                z = z - 1;
            }
            System.out.println(contadormerge);
        }

    }

    private static int contadorquick = 0;

    private static int quickSort(int[] vetor, int inicio, int fim) {

        if (inicio < fim) {
            contadorquick++;
            int posicaoPivo = separar(vetor, inicio, fim);
            quickSort(vetor, inicio, posicaoPivo - 1);
            quickSort(vetor, posicaoPivo + 1, fim);
        }
        return contadorquick;
    }

    private static int separar(int[] vetor, int inicio, int fim) {
        int pivo = vetor[inicio];
        int i = inicio + 1, f = fim;

        while (i <= f) {
            contadorquick++;
            if (vetor[i] <= pivo) {
                contadorquick++;
                i++;
            } else if (pivo < vetor[f]) {

                f--;
            } else {
                int troca = vetor[f];
                vetor[i] = vetor[f];
                vetor[f] = troca;
                i++;
                f--;
            }
        }
        vetor[inicio] = vetor[f];
        vetor[f] = pivo;
        return f;

    }


    public static int[] gerar(int n) {

        int numero;
        int[] num = new int[n];
        Random r = new Random();
        for (int i = 0; i < num.length; i++) {
            numero = r.nextInt(20000) + 1;
            for (int j = 0; j < num.length; j++) {
                if (numero == num[j] && j != i) {
                    numero = r.nextInt(20000) + 1;
                } else {
                    num[i] = numero;
                }
            }
        }
        return num;
    }


}