package service.impl;

import bean.User_info;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import dao.User_infoDao;
import dao.impl.User_infoDaoImpl;
import service.User_infoService;

public class User_infoServiceImpl implements User_infoService {

    private User_infoDao user_infoDao = new User_infoDaoImpl();

    @Override
    public String getList() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(user_infoDao.getList());

        return json;
    }

    @Override
    public User_info getBean(String TrueName) {
        return user_infoDao.getBean(TrueName);
    }

//    @Override
//    public void create(User_info User_info) {
//        User_infoDao.create(User_info);
//    }
//
//    @Override
//    public void delete(String name) {
//        User_infoDao.delete(name);
//    }
//
//    @Override
//    public void update(User_info User_info) {
//        User_infoDao.update(User_info);
//    }
}
