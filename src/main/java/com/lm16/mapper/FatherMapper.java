package com.lm16.mapper;

import com.lm16.bean.Father;

import java.util.List;

public interface FatherMapper {

    Father get(int id);
    int post(Father father);

    int put(Father father);
    void delete(int id);

    List<Father> list();
}
