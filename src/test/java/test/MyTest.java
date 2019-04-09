package test;

import com.lm16.bean.Father;
import com.lm16.mapper.FatherMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.method.P;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class MyTest {

    @Autowired
    private FatherMapper fatherMapper;

//    @Autowired
//    public MyTest(FatherMapper fatherMapper){
//        this.fatherMapper = fatherMapper;
//    }

    @Test
    public void testGet(){
        Father father = new Father();
        father = fatherMapper.get(1);
        System.out.println(father.getName());
    }

    @Test
    public void testPost(){
        Father father = new Father();
        father.setName("张三三");
        fatherMapper.post(father);
    }

    @Test
    public void testPut(){
        Father father = new Father();
        father.setId(1);
        father.setName("一改改");
        fatherMapper.put(father);
    }

    @Test
    public void testDelete(){
        fatherMapper.delete(4);
    }

    @Test
    public void testList(){
        List<Father> list = fatherMapper.list();
        for(Father father: list){
            System.out.println(father.getId()+"==="+father.getName());
        }
    }
}
