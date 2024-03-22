package br.com.desafio.service;

import br.com.desafio.vo.InputVO;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class ManipulacaoStringServiceTest {

    private ManipulacaoStringService manipulacaoStringService = new ManipulacaoStringService();

    @Test
    public void dadoInputNuloQuandoVerificaPalindromoDeveRetornarFalso (){
        InputVO inputVO = null;
        boolean palindro = manipulacaoStringService.verificaPalindromo(inputVO);
        assertFalse(palindro);
    }

    @Test
    public void dadoInputTextoNuloQuandoVerificaPalindromoDeveRetornarFalso (){
        InputVO inputVO = new InputVO();
        boolean palindro = manipulacaoStringService.verificaPalindromo(inputVO);
        assertFalse(palindro);
    }

    @Test
    public void dadoUmTextoPalindromoQuandoVerificaPalindromoDeveRetornarVerdadeiro (){
        InputVO inputVO = new InputVO("socorram me subi no onibus em marrocos");
        boolean palindro = manipulacaoStringService.verificaPalindromo(inputVO);
        assertTrue(palindro);
    }

    @Test
    public void dadoUmTextoNaoPalindromoQuandoVerificaPalindromoDeveRetornarFalso (){
        InputVO inputVO = new InputVO("qualquer");
        boolean palindro = manipulacaoStringService.verificaPalindromo(inputVO);
        assertFalse(palindro);
    }

    @Test
    public void dadoUmInputNuloQuandoContaCaracteresDeveRetornarUmMapVazio (){
        InputVO inputVO = null;
        Map<Character, Integer> qtdCaracteres = manipulacaoStringService.contaCaracteres(inputVO);
        assertTrue(qtdCaracteres.isEmpty());
    }

    @Test
    public void dadoUmTextoNuloQuandoContaCaracteresDeveRetornarUmMapVazio (){
        InputVO inputVO = new InputVO();
        Map<Character, Integer> qtdCaracteres = manipulacaoStringService.contaCaracteres(inputVO);
        assertTrue(qtdCaracteres.isEmpty());

    }@Test
    public void dadoUmTextoNãoNuloQuandoContaCaracteresDeveRetornarQuandidadeDeCaracteres (){
        InputVO inputVO = new InputVO("arara");
        Map<Character, Integer> qtdCaracteres = manipulacaoStringService.contaCaracteres(inputVO);
        assertFalse(qtdCaracteres.isEmpty());
        assertEquals(2, qtdCaracteres.size());
        assertEquals(3, qtdCaracteres.get('a'));
        assertEquals(2, qtdCaracteres.get('r'));
    }
}