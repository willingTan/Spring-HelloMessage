package com.learn.spring.json.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.learn.spring.json.biz.InformBiz;
import com.learn.spring.json.entity.Inform;
import com.learn.spring.json.util.JsonUtils;
import com.learn.spring.json.util.ListObject;
import com.learn.spring.json.util.ResponseUtils;
import com.learn.spring.json.util.StatusCode;

/* 
 * �����û�����Ŀ����� 
 */  
@Controller
public class InformAction {  
    // �Զ�ע��UserService  
    @Autowired  
    @Qualifier("informBiz")  
    private InformBiz informBiz;  
  
    /* 
     * ��ȡָ��id�Ĺ��� 
     */  
    @RequestMapping(value = "/findById")  
    public void findById(String info_id, HttpServletRequest request, HttpServletResponse response) {  
        Integer id = Integer.parseInt(info_id);
        Inform inform = informBiz.findById(id);
        List<Inform> list = new ArrayList<Inform>();  
        list.add(inform);  
        ListObject listObject = new ListObject();  
        listObject.setItems(list);  
        listObject.setCode(StatusCode.CODE_SUCCESS);  
        listObject.setMsg("���ʳɹ�");  
        ResponseUtils.renderJson(response, JsonUtils.toJson(listObject));  
    }  
}