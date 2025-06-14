package BinaryTree;

public class Ordenament {

    /*
     * Métodos Simples 
     * • Seleção 
     * • Inserção 
     * • BubbleSort 
     * 
     * Métodos Eficientes 
     * • ShellSort 
     * • MergeSort 
     * • HeapSort 
     * • QuickSort 
     */
}

class ShellSort {

    public static void shellSort(Comparable[] a) {
        for (int gap = a.length / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < a.length; i++) {
                Comparable tmp = a[i];
                int j = i;
                for (; j >= gap && tmp.compareTo(a[j - gap]) < 0; j -= gap) {
                    a[j] = a[j - gap];
                }
                a[j] = tmp;
            }
        }
    }
}

class SelectionSort {
    public static void selectionSort(Comparable[] a) {
        for (int ref = 0; ref < a.length - 1; ref++) { // elemento de referência
            int min = ref;
            for (int j = ref + 1; j < a.length; j++) { // procura o mínimo
                if (a[j].compareTo(a[min]) < 0) {
                    min = j;
                }
            }
            if (min != ref) { // troca ref com min
                Comparable tmp = a[min];
                a[min] = a[ref];
                a[ref] = tmp;
            }
        }
    }
}

class HeapSort {
    public static void heapSort(Comparable[] a) {
        for (int i = a.length / 2 - 1; i >= 0; i--) { // Constroi o heap máximo
            percDown(a, i, a.length);
        }
        for (int i = a.length - 1; i > 0; i--) {
            swapReferences(a, 0, i); // apaga os máximos
            percDown(a, 0, i);
        }
    }

    private static void swapReferences(Object[] a, int index1, int index2) {
        Object tmp = a[index1];
        a[index1] = a[index2];
        a[index2] = tmp;
    }

    private static void percDown(Comparable[] a, int i, int n) {
        int child;
        Comparable tmp;
        for (tmp = a[i]; leftChild(i) < n; i = child) {
            child = leftChild(i);
            if (child != n - 1 && a[child].compareTo(a[child + 1]) < 0) {
                child++;
            }
            if (tmp.compareTo(a[child]) < 0) {
                a[i] = a[child];
            } else {
                break;
            }
        }
        a[i] = tmp;
    }

    private static int leftChild(int i) {
        return 2 * i + 1;
    }
}

class MergeSort {
    public static void mergeSort(Comparable[] a) {
        Comparable[] tmpArray = new Comparable[a.length];
        mergeSort(a, tmpArray, 0, a.length - 1);
    }

    private static void mergeSort(Comparable[] a, Comparable[] tmpArray, int left, int right) {
        // a – vetor a ser processado
        // tmpArray – vetor temporário para colocar o resultado da fusão
        // left – posição inicial do sub-vetor a ser processado
        // right – posição final do sub-vetor a ser processado
        if (left < right) {
            int center = (left + right) / 2;
            mergeSort(a, tmpArray, left, center);
            mergeSort(a, tmpArray, center + 1, right);
            merge(a, tmpArray, left, center + 1, right);
        }
    }

    private static void merge(Comparable[] a, Comparable[] tmpArray, int leftPos, int rightPos, int rightEnd) {
        int leftEnd = rightPos - 1;
        int tmpPos = leftPos;
        int numElements = rightEnd - leftPos + 1;

        while (leftPos <= leftEnd && rightPos <= rightEnd) {
            if (a[leftPos].compareTo(a[rightPos]) <= 0) {
                tmpArray[tmpPos++] = a[leftPos++];
            } else {
                tmpArray[tmpPos++] = a[rightPos++];
            }
        }

        while (leftPos <= leftEnd) { // Copia o resto da primeira metade
            tmpArray[tmpPos++] = a[leftPos++];
        }

        while (rightPos <= rightEnd) { // Copia o resto da segunda metade
            tmpArray[tmpPos++] = a[rightPos++];
        }

        // Copia os elementos de tmpArray de volta ao vetor original
        for (int i = 0; i < numElements; i++, rightEnd--) {
            a[rightEnd] = tmpArray[rightEnd];
        }
    }
}

class QuickSort {
    public static void quickSort(Comparable[] a) {
        quickSort(a, 0, a.length - 1);
    }

    private static void quickSort(Comparable[] a, int left, int right) {
        if (left + 10 <= right) {
            // Inicializa o pivô (mediana de três) e coloca o pivô no final do vetor -1
            Comparable pivot = median3(a, left, right);
            // Inicia a partição do vetor (elem. menores-pivo- elem. Maiores)
            int i = left, j = right - 1;
            for (;;) {
                while (a[++i].compareTo(pivot) < 0) {}
                while (a[--j].compareTo(pivot) > 0) {}
                if (i < j) {
                    swapReferences(a, i, j);
                } else {
                    break;
                }
            }
            swapReferences(a, i, right - 1); // Restaura o pivô
            quickSort(a, left, i - 1); // ordena S1
            quickSort(a, i + 1, right); // ordena S2
        } else { // ordena vetores com até 10 elementos com algoritmo de Inserção
            insertionSort(a, left, right);
        }
    }

    private static Comparable median3(Comparable[] a, int left, int right) {
        int center = (left + right) / 2;
        // Ordena os elementos no início, meio e final do vetor
        if (a[center].compareTo(a[left]) < 0) {
            swapReferences(a, left, center);
        }
        if (a[right].compareTo(a[left]) < 0) {
            swapReferences(a, left, right);
        }
        if (a[right].compareTo(a[center]) < 0) {
            swapReferences(a, center, right);
        }
        // Posiciona o pivô no final -1
        swapReferences(a, center, right - 1);
        // Retorna o pivô
        return a[right - 1];
    }

    private static void swapReferences(Object[] a, int index1, int index2) {
        Object tmp = a[index1];
        a[index1] = a[index2];
        a[index2] = tmp;
    }

    private static void insertionSort(Comparable[] a, int left, int right) {
        for (int i = left + 1; i <= right; i++) {
            Comparable tmp = a[i];
            int j;
            for (j = i; j > left && tmp.compareTo(a[j - 1]) < 0; j--) {
                a[j] = a[j - 1];
            }
            a[j] = tmp;
        }
    }
}

class BubbleSort {
    public static void bubbleSort(Comparable[] a) {
        for (int i = 0; i < a.length - 1; i++) {
            for (int j = 0; j < a.length - 1 - i; j++) {
                if (a[j].compareTo(a[j + 1]) > 0) {
                    Comparable tmp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = tmp;
                }
            }
        }
    }
}
