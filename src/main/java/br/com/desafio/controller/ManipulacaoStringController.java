package br.com.desafio.controller;

import br.com.desafio.service.ManipulacaoStringService;
import br.com.desafio.vo.InputVO;
import br.com.desafio.vo.OutputVO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RequiredArgsConstructor
@RestController
@RequestMapping ("/api/v1/manipulacao-string")
public class ManipulacaoStringController {

    private final ManipulacaoStringService manipulacaoStringService;

    @PostMapping
    public ResponseEntity<OutputVO> manipularString(@RequestBody InputVO inputVO){

        boolean palindromo = manipulacaoStringService.verificaPalindromo(inputVO);
        Map<Character, Integer> qtdCaracteres = manipulacaoStringService.contaCaracteres(inputVO);
        OutputVO outputVO = new OutputVO();
        outputVO.setPalindromo(palindromo);
        outputVO.setCaracteres(qtdCaracteres);
        return ResponseEntity.ok(outputVO);
    }
}
