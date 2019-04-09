package com.lm16.service.impl;


import com.lm16.bean.Father;
import com.lm16.mapper.FatherMapper;
import com.lm16.service.FatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FatherServiceImpl implements FatherService {

    @Autowired
    private FatherMapper fatherMapper;

    @Override
    public List<Father> list() {
        return fatherMapper.list();
    }
}
