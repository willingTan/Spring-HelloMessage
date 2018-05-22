package com.learn.spring.json.biz;

import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.annotation.Isolation;  
import org.springframework.transaction.annotation.Propagation;
import com.learn.spring.json.dao.InformDao;
import com.learn.spring.json.entity.Inform;

@Transactional(propagation=Propagation.REQUIRED,isolation=Isolation.DEFAULT)  
@Service("informBiz")  
public class InformBiz {
    /* 
     * 自动注入InformDao 
     */  
    @Autowired  
    private InformDao informDao;
    @Autowired
    private Inform inform;
    
    public Inform findById(Integer info_id){  
    	String resource="com/learn/spring/json/util/my-config.xml";
		Reader reader=null;
		SqlSession session;
		try {
			reader=Resources.getResourceAsReader(resource);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		SqlSessionFactory sqlMapper=  new SqlSessionFactoryBuilder().build(reader);
		session=sqlMapper.openSession();
		try {
			informDao=session.getMapper(InformDao.class);//接口的实现
			inform=informDao.findById(info_id);
			session.commit();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		return inform;
	}
}
