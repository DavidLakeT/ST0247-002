package me.DavidLake.DatosAlgoritmos2.Taller08;

public class Taller08 {

    public static void mergeSort(int arr[], int l, int m, int r){
        int i, j, k;
        int n1 = m - l + 1;
        int n2 =  r - m;
        int L[] = new int[n1];
        int R[] = new int[n2];

        for (i = 0; i < n1; i++) L[i] = arr[l + i];
        for (j = 0; j < n2; j++) R[j] = arr[m + 1+ j];

        i = 0;
        j = 0;
        k = l;

        while (i < n1 && j < n2){

            if (L[i] <= R[j]){

                arr[k] = L[i];
                i++;
            } else{

                arr[k] = R[j];
                j++;
            }

            k++;
        }

        while (i < n1){

            arr[k] = L[i];
            i++;
            k++;
        }

        while (j < n2){

            arr[k] = R[j];
            j++;
            k++;
        }
    }

    public static void quicksort(int[] arreglo, int left, int right) {

        int pivote = arreglo[left];
        int i = left;
        int j = right;
        int temp;

        while(i < j){

            while(arreglo[i] <= pivote && i < j) i++;
            while(arreglo[j] > pivote) j--;

            if (i < j) {

                temp= arreglo[i];
                arreglo[i]=arreglo[j];
                arreglo[j]=temp;
            }
        }

        arreglo[left]=arreglo[j];
        arreglo[j]=pivote;

        if(left < j-1) quicksort(arreglo,left,j-1);
        if(j+1 < right) quicksort(arreglo,j+1,right);
    }
}
