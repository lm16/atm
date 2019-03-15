package dao;

import bean.User_info;

import java.util.List;

public interface User_infoDao {

    List<User_info> getList();

    User_info getBean(String TrueName);

//    void create(User_info User_info);
//
//    void delete(String name);
//
//    void update(User_info User_info);
}
