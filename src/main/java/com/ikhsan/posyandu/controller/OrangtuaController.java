package com.ikhsan.posyandu.controller;

import com.ikhsan.posyandu.dao.OrangtuaDao;
import com.ikhsan.posyandu.entity.Orangtua;
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
@RequestMapping("/orangtua")
public class OrangtuaController {
    @Autowired
    private OrangtuaDao o;
    
    @InitBinder
    public void initBinder(WebDataBinder binder){
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }
    
    @RequestMapping("/list")
    public void daftarOrangtua(Model m){
        m.addAttribute("daftarOrangtua", o.findAll());
        
    }
    
    @RequestMapping("/hapus")
    public String hapus(@RequestParam("id") String id){
        o.delete(id);
        return "redirect:list";
    }
    
    @RequestMapping(value = "/form", method = RequestMethod.GET)
    public String tampilkanForm(@RequestParam(value = "id", required = false)String id, Model m){
        
        m.addAttribute("orangtua", new Orangtua());
        
        if(id != null && !id.isEmpty()){
            Orangtua ot = o.findOne(id);
            if(ot != null){
                m.addAttribute("orangtua", ot);
            }
        }
        
        return "/orangtua/form";
    }
    
    @RequestMapping(value="/form", method = RequestMethod.POST)
    public String prosesForm(@Valid Orangtua ot, BindingResult errors){
        if(errors.hasErrors()){
            return "/orangtua/form";
        }
        o.save(ot);
        return "redirect:list";
    }
}
