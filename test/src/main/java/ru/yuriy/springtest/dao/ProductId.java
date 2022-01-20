package ru.yuriy.springtest.dao;

import java.util.ArrayList;
import java.util.Collections;


public class ProductId {

    private int id = 0;

    public int idCreator(ArrayList<Integer> idList) {

        Collections.sort(idList);

        id = idList.get(idList.size()-1);
        id++;
        return id;
    }

}
