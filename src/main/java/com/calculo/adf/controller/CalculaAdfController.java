package com.calculo.adf.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/calculoadf")
public class CalculaAdfController {

    @PostMapping("/fator")
    @ResponseStatus(HttpStatus.OK)
    public String getFatorAdf(@RequestParam("prazo") int prazo, @RequestParam("taxaAdf") double taxaAdf){
        double fatorAdf = getCalculoFatorAdf(prazo, taxaAdf);
        return "Fator ADF: " + fatorAdf;
    }

    @PostMapping("/valor")
    @ResponseStatus(HttpStatus.OK)
    public String getValorAdf(@RequestParam("prazo") int prazo, @RequestParam("taxaAdf") double taxaAdf, @RequestParam("valorTtv") double valorTtv){
        double valorAdf = getCalculoValorAdf(prazo, taxaAdf, valorTtv);
        return "Valor ADF: " + valorAdf;
    }

    @PostMapping("/taxa")
    @ResponseStatus(HttpStatus.OK)
    public String getTaxaAdf(@RequestParam("prazo") int prazo, @RequestParam("fatorAdf") double fatorAdf){
        double taxaAdf = getCalculoTaxaAdf(prazo, fatorAdf);
        return "Taxa ADF: " + taxaAdf;
    }

    public double getCalculoFatorAdf(int prazo, double taxaAdf){
        double taxaCalculada = (taxaAdf / 100 + 1);
        double prazoCalculado = ((double)prazo / 30);
        double fatorAdf = Math.pow(taxaCalculada, prazoCalculado) - 1;

        return fatorAdf;
    }

    public double getCalculoValorAdf(int prazo, double taxaAdf, double valorTtv){
        double fatorAdf = getCalculoFatorAdf(prazo, taxaAdf);
        double valorAdf = valorTtv * fatorAdf;
        return valorAdf;
    }

    public double getCalculoTaxaAdf(int prazo, double fatorAdf){
        double prazoCalculado = (30 / (double)prazo);
        double taxaAdf = Math.pow(fatorAdf, prazoCalculado);
        taxaAdf = (taxaAdf - 1) * 100;
        return taxaAdf;
    }

}

