package br.com.desafio.service;

import br.com.desafio.vo.InputVO;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class ManipulacaoStringService {

    public boolean verificaPalindromo (InputVO inputVO){

        if (inputVO == null || StringUtils.isBlank(inputVO.getTexto())){
            return false;
        }
        String plain = inputVO.getTexto().replaceAll(" ","");
        StringBuilder reverse = new StringBuilder(plain).reverse();
        return reverse.toString().equalsIgnoreCase(plain);
    }

    public Map<Character, Integer> contaCaracteres (InputVO inputVO){

        Map<Character, Integer> qtdCaracteres = new HashMap<>();

        if (inputVO == null || StringUtils.isBlank(inputVO.getTexto())){
            return qtdCaracteres;
        }

        Set<Character> characterSet = inputVO.getTexto().replaceAll(" ", "").chars().mapToObj(c -> (char) c).collect(Collectors.toSet());

        characterSet.forEach(c -> {
            int count = StringUtils.countMatches(inputVO.getTexto(), c);
            qtdCaracteres.put(c, count);
        });
        return qtdCaracteres;
    }
}
