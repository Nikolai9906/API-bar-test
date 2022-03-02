package com.aldeamo.bar.service.impl;

import com.aldeamo.bar.repository.GlassesArrayRepository;
import com.aldeamo.bar.service.BarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.aldeamo.bar.repository.document.GlassesArray;

import java.util.*;

@Service
public class BarServiceImpl implements BarService {

    private List<Integer> primeArray;
    private List<Integer> arrayA ;
    private List<Integer> arrayB ;

    private final GlassesArrayRepository arrayRepository;


    public BarServiceImpl(@Autowired GlassesArrayRepository arraysRepository) {
        this.arrayRepository = arraysRepository;
        primeArray = new ArrayList<>(Arrays.asList( 2, 3, 5, 7, 11, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97));
    }

    @Override
    public List<Integer> primeOperation(int Q, int idArray) throws Exception {
        arrayB = new ArrayList<>();
        setArrayA(idArray);
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
        return arrayB;
    }

    @Override
    public List<Integer> findById(int id) {
        Optional<GlassesArray> object = arrayRepository.findById(id);
        String[] stringNumbers = object.get().getInput_array().split(",");
        List<Integer> numbers = new ArrayList<>();
        for(String s: stringNumbers) numbers.add(Integer.valueOf(s));
        return numbers;
    }

    public void setArrayA(int idArray)throws Exception{
        arrayA = new ArrayList<>();
        GlassesArray tempGlassArray = arrayRepository.findById(idArray).orElseThrow(() -> new Exception());
        String[] numbers = tempGlassArray.getInput_array().split(",");
        for(String s: numbers) arrayA.add(Integer.valueOf(s));
    }

    
}
