/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ikhsan.posyandu.controller;

import com.ikhsan.posyandu.dao.BalitaDao;
import com.ikhsan.posyandu.entity.Balita;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author feda
 */

@Controller
@RequestMapping("/balita")
public class BalitaController {
    @Autowired
    private BalitaDao b;
    
    @InitBinder
    public void initBinder(WebDataBinder binder){
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }
    
    @RequestMapping("/list")
    public void daftarBalita(Model m){
        m.addAttribute("daftarBalita", b.findAll());
        
    }
    
    @RequestMapping("/hapus")
    public String hapus(@RequestParam("id") String id){
        b.delete(id);
        return "redirect:list";
    }
    
     @RequestMapping(value = "/form", method = RequestMethod.GET)
    public String tampilkanForm(@RequestParam(value = "id", required = false)String id, Model m){
        
        m.addAttribute("balita", new Balita());
        
        if(id != null && !id.isEmpty()){
            Balita bb = b.findOne(id);
            if(bb != null){
                m.addAttribute("balita", bb);
            }
        }
        
        return "/balita/form";
    }
    
    @RequestMapping(value="/form", method = RequestMethod.POST)
    public String prosesForm(@Valid Balita bb, BindingResult errors){
        if(errors.hasErrors()){
            return "/balita/form";
        }
        b.save(bb);
        return "redirect:list";
    }
}
