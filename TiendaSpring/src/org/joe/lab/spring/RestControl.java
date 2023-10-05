package org.joe.lab.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestControl {

    private final MySessionBean sessionBean;

    @Autowired
    public RestControl(MySessionBean sessionBean) {
        this.sessionBean = sessionBean;
    }

    @RequestMapping(value = "/addCar/{item}",method = RequestMethod.POST)
    public ResponseEntity<Void> getBoxes(@PathVariable("item") String item){
        sessionBean.addToList(item);
        return new  ResponseEntity<>(HttpStatus.OK);
    }
}
