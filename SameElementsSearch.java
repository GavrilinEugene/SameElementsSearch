import java.util.Arrays;

/**
 * Created by Dell on 24.10.2016.
 */

public class SameElementsSearch {

    public static String[] sameElementsSearch(String[] array) {

        // отсортируем, чтобы все одинаковые элементы шли друг за другом
        Arrays.sort(array);
        String[] arraySameElements = new String[array.length];
        int index = 0;
        boolean flSameElement = false;

        // пройдём по массиву и сложим в arraySameElements уникальные повторяющиеся элементы
        for(int i = 0; i < array.length - 1; i++){
            while(i < array.length - 1 && array[i].equals(array[i+1])){
                i++;
                flSameElement = true;
            }
            if(flSameElement)
                arraySameElements[index++] = array[i];
            flSameElement = false;
        }

        // убираем лишние нулевые элементы
        String[] result = new String[index];
        System.arraycopy(arraySameElements, 0, result, 0, result.length);
        return result;
    }

    public static boolean testSameElementSearch(){

        String[] array = {"aa", "bb", "ba", "bb", "aa", "BB"};
        String[] testEqualElements = sameElementsSearch(array);
        String[] correctArray = {"aa","bb"};
        if(!Arrays.equals(correctArray, testEqualElements))
            return false;

        String[] array1 = {"aa", "aa", "AA", "aaa", "a", "Aa"};
        String[] testEqualElements1 = sameElementsSearch(array1);
        String[] correctArray1 = {"aa"};

        return Arrays.equals(correctArray1, testEqualElements1);
    }

    /*
     * форматированный вывод массива
     */
    public static void printArray(String[] array){
        System.out.print("{");
        for(String element: array)
            System.out.print(element + " ");
        System.out.println("}");
    }

    public static void main(String[] args) {

        boolean passTests = testSameElementSearch();
        if(passTests){
            System.out.println("Running tests: true");
        }
        else{
            System.out.println("Running tests: false");
        }

        String[] array = {"BB", "cc", "ba", "bb", "ca", "BB"};
        printArray(array);
        System.out.println("Equal elements in array:");
        String[] equalElements = sameElementsSearch(array);
        printArray(equalElements);
    }
}

