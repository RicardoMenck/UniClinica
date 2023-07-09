package com.UniClinica.Controller;

import com.UniClinica.models.Registro;
import com.UniClinica.repository.RegistroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class RegistroController {

    @Autowired
    private RegistroRepository er;

    @RequestMapping(value="/cadastrarRegistro", method = RequestMethod.GET)
    public String form(){
        return "registro/formRegistro";
    }

    @RequestMapping(value="/cadastrarRegistro", method = RequestMethod.POST)
    public String form(Registro registro){

        er.save(registro);

        return "redirect:/cadastrarRegistro";
    }

    @RequestMapping
    public ModelAndView listaRegistros() {
        ModelAndView mv = new ModelAndView("index");
        Iterable<Registro> registro = er.findAll();
        mv.addObject("registros", registro);
        return mv;
    }

    @RequestMapping("/{codigo}")
    public ModelAndView detalhesRegistro(@PathVariable("codigo") long codigo) {
        Registro registro = er.findByCodigo(codigo);
        ModelAndView mv = new ModelAndView("registro/detalhesRegistro");
        mv.addObject("registro", registro);
        return mv;
    }
}
