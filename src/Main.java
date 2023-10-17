import java.util.Random;

public class Main {
    public static int[] arrLengths = {3,5,7,8,9};
    public static void main(String[] args) {
        int[][] arr = {
                new int[3],
                new int[5],
                new int[7],
                new int[8],
                new int[9]
        };

        // fill
        Random rnd = new Random();
        for(int i = 0; i < 5; i++){
            for(int j = 0; j < arr[i].length; j++){
                int n = rnd.nextInt(50) + 50;
                arr[i][j] = n;
            }
        }

        System.out.print("\n\nunsorter array:\n");
        // cout
        for(int i = 0; i < 5; i++){
            for(int j = 0; j < arrLengths[i]; j++){
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }

        // sorting
        int[] total = new int[32];
        int z = 0;
        for(int i = 0; i < 5; i++){
            for(int j = 0; j < arrLengths[i]; j++){
                total[z++] = arr[i][j];
            }
        }
        int[] sortedArray = sortArray(total);
        int[][] newArrays = new int[5][];
        int id = 0;
        int zId = 0;
        for(int i = 0; i < 32; i++){
            int n = sortedArray[i];
            if(newArrays[id] == null)
                newArrays[id] = new int[arrLengths[id]];
            newArrays[id][zId] = n;
            zId++;
            if(zId >= arrLengths[id])
            {
                id++;
                zId = 0;
            }

        }


        // cout sorted
        System.out.println("Sorted:");
        for(int i = 0; i < 5; i++){
            for(int j = 0; j < newArrays[i].length; j++){
                System.out.print(newArrays[i][j] + " ");
            }
            System.out.println();
        }
    }
    private static int[] sortArray(int[] arr){
        int[] newArr = arr.clone();

        for(int i = 0; i < arr.length; i++){
            for(int j = 1; j < arr.length; j++){
                int pE = newArr[j-1];
                int cE = newArr[j];
                if(cE < pE){
                    newArr[j-1] = cE;
                    newArr[j] = pE;
                }
            }
        }

        return newArr;
    }
}