package aldeamo.test.service.impl;

import aldeamo.test.service.BarService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

@Service
public class BarServiceImpl implements BarService {

    private List<Integer> primeArray;
    private List<Integer> arrayA;
    private List<Integer> arrayB ;
    private final HashMap<Integer, List<Integer> > arraysMap = new HashMap<>();

    public BarServiceImpl() {
        primeArray = new ArrayList<>(Arrays.asList(2,3,5,7,11,17));
        arraysMap.put( 1 , (Arrays.asList(2,4,5,6,7,8)) );
        arraysMap.put( 2 , (Arrays.asList(3,7,9,5,4,2)) );
        arraysMap.put( 3 , (Arrays.asList(5,7,9,11,13)) );
        arraysMap.put( 4 , (Arrays.asList(6,4,2,12,15)) );
        arraysMap.put( 5 , (Arrays.asList(7,10,15,11,9)) );
        /**
         * Example input
         */
        arraysMap.put( 6 , (Arrays.asList(2,3,4,5,6,7)) );
    }

    @Override
    public List<Integer> primeOperation(int Q, int idArray) {
        arrayB = new ArrayList<>();
        arrayA = arraysMap.get(idArray);
        for(int j = 0; j < Q; j++){
            ArrayList<Integer> temp = new ArrayList<>();
            for(int i = arrayA.size() - 1; i < arrayA.size() && i >= 0; i--){
                if(arrayA.get(i) % primeArray.get(j) == 0){
                    arrayB.add(arrayA.get(i));
                }else{
                    temp.add(arrayA.get(i));
                }
            }
            arrayA = temp;
        }
        if(arrayA.size() == 1) arrayB.add(arrayA.get(0));
        System.out.println(arrayB);
        return arrayB;
    }
}
