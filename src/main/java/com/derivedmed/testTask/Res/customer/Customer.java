package com.derivedmed.testTask.Res.customer;

import com.derivedmed.testTask.Res.shop.Position;

import java.util.*;

/**
 * Customer can send request to shop.
 */
public class Customer {
    /**
     * Generating request. It returns Map where every entry is position and count that customer needs to buy.
     * @param catalouge
     * @return
     */
    public Map<Position, Integer> buy(List<Position> catalouge) {
        Set<Integer> positionNumbers = new HashSet<>();
        Map<Position, Integer> tobuylist = new HashMap<>();
        int numOfPositions = 1 + (int) (Math.random() * catalouge.size());
        for (int i = 0; i < numOfPositions; i++) {
            int positionNumber = (int) (Math.random() * catalouge.size());
            positionNumbers.add(positionNumber);
        }
        for (Integer positionNumber : positionNumbers) {
            int count = 1 + (int) (Math.random() * 10);
            tobuylist.put(catalouge.get(positionNumber), count);
        }
        return tobuylist;
    }
}
