package com.aldeamo.bar.service;

import java.util.List;

public interface BarService {
    List<Integer> primeOperation(int Q, int idArray) throws Exception;

    List<Integer> findById(int id);
}
