package br.com.desafio.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Map;

@Data
public class OutputVO {

    @JsonProperty("palindromo")
    private boolean palindromo;

    @JsonProperty("ocorrencias_caracteres")
    private Map<Character, Integer> caracteres;

}
