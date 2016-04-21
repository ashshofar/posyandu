/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ikhsan.posyandu.controller;

import com.ikhsan.posyandu.dao.JabatanDao;
import com.ikhsan.posyandu.dao.UserDao;
import com.ikhsan.posyandu.entity.Jabatan;
import com.ikhsan.posyandu.entity.User;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author feda
 */
@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserDao u;
    private JabatanDao j;
    
    @InitBinder
    public void initBinder(WebDataBinder binder){
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }
    
    @RequestMapping("/list")
    public void daftarUser(Model m){
        m.addAttribute("daftarUser", u.findAll());
    }
    
    @RequestMapping("/delete")
    public String hapus(@RequestParam("id") String id){
        u.delete(id);
        return "redirect:list";
    }
    
    @RequestMapping(value = "/form", method = RequestMethod.GET)
    public String tampilkanForm(@RequestParam(value = "id", required = false)String id, Model m){
        
        m.addAttribute("user", new User());
        
        if(id != null && !id.isEmpty()){
            User ut = u.findOne(id);
            if(ut != null){
                m.addAttribute("user", ut);
            }
        }
        
        return "/user/form";
    }
    
    @RequestMapping(value="/form", method = RequestMethod.POST)
    public String prosesForm(@Valid User ut, BindingResult errors){
        if(errors.hasErrors()){
            return "/user/form";
        }
        u.save(ut);
        return "redirect:list";
    }     
    
    @RequestMapping(value = "/show", method = RequestMethod.GET)
    public String showUser(@RequestParam(value = "id", required = false)String id, Model m){
        
        m.addAttribute("user", new User());
        
        if(id != null && !id.isEmpty()){
            User ut = u.findOne(id);
            if(ut != null){
                m.addAttribute("user", ut);
            }
        }
        
        return "/user/show";
    }
}
