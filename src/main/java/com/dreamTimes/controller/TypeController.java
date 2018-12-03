package com.dreamTimes.controller;

import com.dreamTimes.beans.Type;
import com.dreamTimes.dao.TypeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class TypeController {

    @Autowired
    private TypeDao typeDao;

    @RequestMapping(value = "selectType",method = RequestMethod.GET)
    @ResponseBody
    public List<Type> select(){
        List<Type> list = typeDao.selectAll();
        return list;
    }
}
