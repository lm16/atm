package service;

import bean.User_info;
import com.fasterxml.jackson.core.JsonProcessingException;

public interface User_infoService {

    String getList() throws JsonProcessingException;

    User_info getBean(String name);

//    void create(User_info user);
//
//    void delete(String name);
//
//    void update(User_info user);
}
