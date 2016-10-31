import java.util.Arrays;

public class SameElementsSearch {

    public static String[] searchEqualElements(String[] arrayOfStrings) {

        // отсортируем, чтобы все одинаковые элементы шли друг за другом
        Arrays.sort(arrayOfStrings);
        return createArrayOfUniqueElements(arrayOfStrings);
    }

    private static String[] createArrayOfUniqueElements(String[] arrayOfStrings){
        String[] arraySameElements = new String[arrayOfStrings.length];
        int equalElementsCount = 0;

        for(int arrayIndex = 0; arrayIndex < arrayOfStrings.length - 1; arrayIndex++){
            int skippedEqualElements = skippedEqualElements(arrayOfStrings, arrayIndex);
            if(skippedEqualElements > 0)
                arraySameElements[equalElementsCount++] = arrayOfStrings[arrayIndex];
        }
        return cutArrayByLength(arraySameElements, equalElementsCount);
    }

    private static int skippedEqualElements(String[] arrayOfStrings, int arrayIndex){
        int skippedEqualElements = 0;
        while(arrayIndex < arrayOfStrings.length - 1 &&
                arrayOfStrings[arrayIndex].equals(arrayOfStrings[arrayIndex+1])){
            arrayIndex++;
            skippedEqualElements++;
        }
        return skippedEqualElements;
    }

    private static String[] cutArrayByLength(String[] arrayOfStrings, int arrayLength){
        String[] ret = new String[arrayLength];
        System.arraycopy(arrayOfStrings, 0, ret, 0, arrayLength);
        return ret;
    }

    public static boolean testSameElementSearch(){

        String[] array = {"aa", "bb", "ba", "bb", "aa", "BB"};
        String[] testEqualElements = searchEqualElements(array);
        String[] expectedArrayOfEqualElements = {"aa","bb"};

        return Arrays.equals(testEqualElements, expectedArrayOfEqualElements);
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

    private static boolean checkTests() {
        System.out.print("running tests: ");
        boolean testResult = testSameElementSearch();
        if(testResult == true)
            System.out.println("TRUE");
        else
            System.out.println("FALSE");
        return testResult;
    }

    public static void main(String[] args) {

        boolean passTests = checkTests();
        if(!passTests)
            return;

        String[] array = {"BB", "cc", "ba", "bb", "ca", "BB"};
        printArray(array);
        System.out.println("Equal elements in array:");
        String[] equalElements = searchEqualElements(array);
        printArray(equalElements);
    }
}

