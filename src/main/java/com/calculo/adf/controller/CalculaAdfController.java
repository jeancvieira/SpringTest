package com.calculo.adf.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/calculoadf")
public class CalculaAdfController {

    @PostMapping("/fator")
    @ResponseStatus(HttpStatus.OK)
    public String getFatorAdf(@RequestParam("prazo") int prazo, @RequestParam("taxaADF") double taxaAdf){
        double taxaCalculado = (taxaAdf / 100 + 1);
        double prazoCalculado = ((double)prazo / 30);
        double fatorAdf = Math.pow(taxaCalculado, prazoCalculado) - 1;
        return "Fator ADF: " + fatorAdf;
    }

    @PostMapping("/taxa")
    @ResponseStatus(HttpStatus.OK)
    public String getTaxaAdf(){
        return "Taxa ADF: ";
    }

}
