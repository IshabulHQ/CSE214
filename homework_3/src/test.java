public class test {

    public static void mystery(int[] data, int first, int last){
        int counter = 0;
        int newCounter = 0;

        if(first <= last){
            int middle = (first + last) / 2;

            counter++;
            System.out.println("Activated" + counter);
            mystery(data,first,middle-1);
            System.out.println(data[middle] + "  ");
            newCounter++;
            System.out.println("Activated new" + newCounter);
            mystery(data,middle+1,last);
        }
    }

    public static void main(String []args){
        int[] data = {22,11,33,55,44};
        int first = 0;
        int last = 4;
        System.out.println((13 % 12));
    }
}
