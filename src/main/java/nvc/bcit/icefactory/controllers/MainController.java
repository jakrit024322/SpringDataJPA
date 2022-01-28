package nvc.bcit.icefactory.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import nvc.bcit.icefactory.model.Factory;
import nvc.bcit.icefactory.service.FactoryService;

@Controller
public class MainController {

    @Autowired
    FactoryService factoryService;
    
    @GetMapping("/")
    public String index(){
        return "index";
    }

    @GetMapping("/factory")
    public ModelAndView factory(){
        List<Factory> factorys = factoryService.findAll();
        return new ModelAndView("factory","factorys",factorys);
    }  
    

    @GetMapping("/factory/{id}")
    public ModelAndView getFactoryById(@PathVariable int id){
        Factory factorys = factoryService.getById(id);
        return new ModelAndView("factory","factorys",factorys);
    }
}
