package com.example.myapplication;

import java.util.ArrayList;

public interface Selectable<T> {
    ArrayList<T> selectAll();
    T select(int id);
}
