package com.example.demo.controller;


import com.example.demo.dto.ResultadoOperacaoDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.demo.service.CalculadoraService;

@RestController
@RequestMapping("/api/calculadora")
public class CalculadoraController {

    private final CalculadoraService calculadoraService;

    public CalculadoraController(CalculadoraService calculadoraService) {
        this.calculadoraService = calculadoraService;
    }

    @RequestMapping(value = "/adicao", method = {RequestMethod.GET, RequestMethod.POST})
    public ResultadoOperacaoDTO adicao(
            @RequestParam double a,
            @RequestParam double b
    ) {
        double resultado = calculadoraService.somar(a, b);

        return new ResultadoOperacaoDTO(
                "adição",
                a,
                b,
                resultado
        );
    }

    @RequestMapping(value = "/subtracao", method = {RequestMethod.GET, RequestMethod.POST})
    public ResultadoOperacaoDTO subtracao(
            @RequestParam double a,
            @RequestParam double b
    ) {
        double resultado = calculadoraService.subtrair(a, b);

        return new ResultadoOperacaoDTO(
                "subtração",
                a,
                b,
                resultado
        );
    }

    @RequestMapping(value = "/multiplicacao", method = {RequestMethod.GET, RequestMethod.POST})
    public ResultadoOperacaoDTO multiplicacao(
            @RequestParam double a,
            @RequestParam double b
    ) {
        double resultado = calculadoraService.multiplicar(a, b);

        return new ResultadoOperacaoDTO(
                "multiplicação",
                a,
                b,
                resultado
        );
    }

    @RequestMapping(value = "/divisao", method = {RequestMethod.GET, RequestMethod.POST})
    public ResponseEntity<?> divisao(
            @RequestParam double a,
            @RequestParam double b
    ) {
        try {
            double resultado = calculadoraService.dividir(a, b);

            return ResponseEntity.ok(
                    new ResultadoOperacaoDTO(
                            "divisão",
                            a,
                            b,
                            resultado
                    )
            );
        } catch (IllegalArgumentException ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }

    @RequestMapping(value = "/exponenciacao", method = {RequestMethod.GET, RequestMethod.POST})
    public ResultadoOperacaoDTO exponenciacao(
            @RequestParam double a,
            @RequestParam double b
    ) {
        double resultado = calculadoraService.exponenciar(a, b);

        return new ResultadoOperacaoDTO(
                "exponenciação",
                a,
                b,
                resultado
        );
    }
}
