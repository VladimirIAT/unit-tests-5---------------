package seminars.five;

import seminars.five.number.MaxNumberModule;
import seminars.five.number.RandomNumberModule;

import java.util.List;

public class Main {
    public static void main (String[] args){
        RandomNumberModule randList = new RandomNumberModule();
        List<Integer> result = randList.generate(6);
        System.out.println("result = " + result);
        MaxNumberModule maxNumberModule = new MaxNumberModule();
        int max = maxNumberModule.findmax(result);

        System.out.println(max);
    }
}
