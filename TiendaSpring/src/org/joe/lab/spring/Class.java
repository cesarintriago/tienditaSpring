package org.joe.lab.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class Class {

    private final MySessionBean sessionBean;

    private StoreDAO sdao;

    @Autowired
    public Class(MySessionBean sessionBean) {
        this.sessionBean = sessionBean;
    }

    @Autowired
    public void setDao(StoreDAO dao) {
        this.sdao = dao;
    }

    @RequestMapping({"/","/index"})
    public ModelAndView Index() {
        ModelAndView model = new ModelAndView("index");

        if(sessionBean.getSession()) {
            model.addObject("login", "getLogin");
        }
        return model;
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView login(
            @RequestParam(value="user",required=false,defaultValue="") String user,
            @RequestParam(value="pwd",required=false,defaultValue="") String pwd) {
        System.out.println(user);
        System.out.println(pwd);
        sessionBean.startSession();

        ModelAndView model = new ModelAndView("login");
        model.addObject("user",new User(1,"Diego"));
        return model;
    }

    @RequestMapping("department/{department}")
    public ModelAndView getDepartmentItems(@PathVariable("department") String department){
        ModelAndView model = new ModelAndView("department");
        List<Products> products = sdao.getProducts(department);
        model.addObject("department",department);
        model.addObject("items",products);
        return model;
    }

    @RequestMapping("card")
    public ModelAndView getCard() {
        ModelAndView model = new ModelAndView("department");
        model.addObject("items",sessionBean.getProducts());
        return model;
    }
}
