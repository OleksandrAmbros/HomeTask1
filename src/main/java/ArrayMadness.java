import java.util.*;
import java.util.stream.IntStream;

public class ArrayMadness {

    public static void main(String[] args) {
        /*Создайте массив, содержащий 10 первых нечетных чисел. Выведете элементы массива на консоль в одну строку, разделяя запятой.*/
        int[] firstArray = {1, 3, 5, 7, 9, 11, 13, 15, 17, 19};
        System.out.println("Task #1: 10 first odd numbers");
        for (int i = 0; i < firstArray.length; i++) {
            System.out.print(firstArray[i] + ",");
        }
        /*Поменять наибольший и наименьший элементы массива местами.*/
        System.out.println("\n" + "Task #2: max and min elements of Array");
        int max = firstArray[0];
        int imax = 0;
        int min = firstArray[0];
        int imin = 0;
        for (int i = 1; i < firstArray.length; i++) {
            if (firstArray[i] > max) {
                max = firstArray[i];
                imax = i;
            }
            if (firstArray[i] < min) {
                min = firstArray[i];
                imin = i;
            }
        }
        firstArray[imax] = min;
        firstArray[imin] = max;
        System.out.println("Max element of Array:" + " " + max);
        System.out.println("Min element of Array:" + " " + min);
        System.out.println("Swapped the maximum and minimum element:");
        for (int element : firstArray) {
            System.out.print(element + ",");
        }
        /*Найти среднее арифметическое всех элементов массива*/
        System.out.println("\n" + "Task #3: arithmetic average mean");
        int total = 0;
        for (int element : firstArray) {
            total += element;
        }
        int average = total / firstArray.length;
        System.out.println("Sum of elements:" + total + " " + "arithmetic average:" + average);
        /*Создайте массив из 13 случайных целых чисел из отрезка [-1;1], выведите массив на экран в строку.
        Определите какой элемент встречается в массиве чаще всего и выведите об этом сообщение на экран (element + count)*/
        System.out.println("Task #4: random Array[-1;1]");
        Random random = new Random();
        IntStream ints = random.ints(-1, 2).limit(13);
        int[] secondArray = ints.toArray();

        for (int element : secondArray) {
            System.out.print(element + ",");
        }
        Arrays.sort(secondArray);
        int value1 = 0;
        int value2 = 0;
        int value3 = 0;
        int count1 = 0;
        int count2 = 0;
        int count3 = 0;
        System.out.println();
        for (int i = 1; i < secondArray.length; i++) {
            if (secondArray[i - 1] == secondArray[i]) {
                if (secondArray[i] == -1) {
                    value1 = -1;
                    count1 += 1;
                } else if (secondArray[i] == 0) {
                    value2 = 0;
                    count2 += 1;
                } else {
                    value3 = 1;
                    count3 += 1;
                }
            }
        }
        if (count1 > count2 && count1 > count3) {
            System.out.print("The number " + value1 + " is displayed " + (count1 + 1) + " times" + "\n");
        }
        if (count1 > count2 && count1 == count3) {
            System.out.print("The number " + value1 + " is displayed " + (count1 + 1) + " times" + "\n");
            System.out.print("The number " + value3 + " is displayed " + (count3 + 1) + " times" + "\n");
        }
        if (count1 == count2 && count1 > count3) {
            System.out.print("The number " + value1 + " is displayed " + (count1 + 1) + " times" + "\n");
            System.out.print("The number " + value2 + " is displayed " + (count2 + 1) + " times" + "\n");
        }
        if (count2 > count1 && count2 > count3) {
            System.out.print("The number " + value2 + " is displayed " + (count2 + 1) + " times" + "\n");
        }
        if (count2 > count1 && count2 == count3) {
            System.out.print("The number " + value2 + " is displayed " + (count2 + 1) + " times" + "\n");
            System.out.print("The number " + value3 + " is displayed " + (count3 + 1) + " times" + "\n");
        }
        if (count3 > count1 && count3 > count2) {
            System.out.print("The number " + value3 + " is displayed " + (count3 + 1) + " times" + "\n");
        }
        /*Cоздаем список(ArrayList) строк, считываем 5 строк с клавиатуры и добавляем их в список, затем находим самую короткую строку и выводим её на экран.
        Если таких строк несколько — выводим их все, каждую с новой строки.*/
        System.out.println("Task #5: ArrayList");
        ArrayList<String> firstArrayList = new ArrayList<>();
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter the strings(enter the empty string, if you want to end entering): " + "\n");
        while (true) {
            String current = scan.nextLine();
            if (current.equals("")) break;
            firstArrayList.add(current);
        }
        System.out.print("Shortest strings: " + "\n");
        int minstring = Integer.MAX_VALUE;
        for (String string : firstArrayList) {
            if (string.length() < minstring) {
                minstring = string.length();
            }
        }
        for (String string : firstArrayList) {
            if (string.length() == minstring) {
                System.out.println(string);
            }
        }
        /*Пользователь вводит(через консоль) набор чисел в виде одной строки например (“1, 2, 3, 4, 4, 5”).
        Избавиться от повторяющихся элементов в строке и вывести результат на экран. Сделать проверку - если пользователь ввел 3 или меньше чисел, предложить ввести числа еще раз пока не будет больше 3х чисел*/
        System.out.println("Task #6: delete duplicates");
        System.out.println("Enter more than three numbers with a space(enter the Enter key, if you want to end entering): ");
        int numberCount;
        Set<String> set = new HashSet<String>();
        boolean flag = false;
        while (!flag) {
            String scan2 = new Scanner(System.in).nextLine();
            set.addAll(Arrays.asList(scan2.split(" ")));
            numberCount = Arrays.asList(scan2.split(" ")).size();
            if (numberCount > 3) {
                flag = true;
            }
            System.out.println("Enter more than three numbers");
        }
        System.out.println(set);
    }
}



