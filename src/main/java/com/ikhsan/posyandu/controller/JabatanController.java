/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ikhsan.posyandu.controller;

import com.ikhsan.posyandu.dao.JabatanDao;
import com.ikhsan.posyandu.entity.Jabatan;
import com.ikhsan.posyandu.entity.Orangtua;
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
@RequestMapping("/jabatan")
public class JabatanController {
    @Autowired
    private JabatanDao j;
    
    @RequestMapping("/list")
    public void daftarJabatan(Model m){
        m.addAttribute("daftarJabatan", j.findAll());
    }
    
    @RequestMapping("/delete")
    public String hapus(@RequestParam("id") String id){
        j.delete(id);
        return "redirect:list";
    }
    
    @RequestMapping(value = "/form", method = RequestMethod.GET)
    public String tampilkanForm(@RequestParam(value = "id", required = false)String id, Model m){
        
        m.addAttribute("jabatan", new Jabatan());
        
        if(id != null && !id.isEmpty()){
            Jabatan jt = j.findOne(id);
            if(jt != null){
                m.addAttribute("jabatan", jt);
            }
        }
        
        return "/jabatan/form";
    }
    
    @RequestMapping(value="/form", method = RequestMethod.POST)
    public String prosesForm(@Valid Jabatan jt, BindingResult errors){
        if(errors.hasErrors()){
            return "/jabatan/form";
        }
        j.save(jt);
        return "redirect:list";
    }
    
    @RequestMapping(value = "/show", method = RequestMethod.GET)
    public String showUser(@RequestParam(value = "id", required = false)String id, Model m){
        
        m.addAttribute("jabatan", new Jabatan());
        
        if(id != null && !id.isEmpty()){
            Jabatan jt = j.findOne(id);
            if(jt != null){
                m.addAttribute("jabatan", jt);
            }
        }
        
        return "/jabatan/show";
    }
    
}
