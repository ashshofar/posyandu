/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ikhsan.posyandu.controller;

import com.ikhsan.posyandu.dao.AssigmentDao;
import com.ikhsan.posyandu.entity.Assigment;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author feda
 */
@Controller
@RequestMapping("/assigment")
public class AssigmentController {
   
    @Autowired
    private AssigmentDao a;
    
    @RequestMapping("/list")
    public void daftarAssigment(Model m){
        m.addAttribute("daftarAssigment", a.findAll());
    }
    
    @RequestMapping("/delete")
    public String hapus(@RequestParam("id") String id){
        a.delete(id);
        return "redirect:list";
    }
    
    @RequestMapping(value = "/form", method = RequestMethod.GET)
    public String tampilkanForm(@RequestParam(value = "id", required = false)String id, Model m){
        
        m.addAttribute("assigment", new Assigment());
        
        if(id != null && !id.isEmpty()){
            Assigment at = a.findOne(id);
            if(at != null){
                m.addAttribute("assigment", at);
            }
        }
        
        return "/assigment/form";
    }
    
    @RequestMapping(value="/form", method = RequestMethod.POST)
    public String prosesForm(@Valid Assigment at, BindingResult errors){
        if(errors.hasErrors()){
            return "/assigment/form";
        }
        a.save(at);
        return "redirect:list";
    }     
    
    @RequestMapping(value = "/show", method = RequestMethod.GET)
    public String showAssigment(@RequestParam(value = "id", required = false)String id, Model m){
        
        m.addAttribute("user", new Assigment());
        
        if(id != null && !id.isEmpty()){
            Assigment at = a.findOne(id);
            if(at != null){
                m.addAttribute("assigment", at);
            }
        }
        
        return "/assigment/show";
    }
    
}
