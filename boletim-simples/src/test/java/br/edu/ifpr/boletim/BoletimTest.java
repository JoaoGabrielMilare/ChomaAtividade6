package br.edu.ifpr.boletim;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class BoletimTest {

    // Testes de verificarSituacao (Cobrindo Limites 4 e 7)
    @Test
    void deveAprovarAlunoComMediaExatamenteSete() {
        Boletim boletim = new Boletim();
        assertEquals("APROVADO", boletim.verificarSituacao(7.0));
    }

    @Test
    void deveRecuperarAlunoComMediaAbaixoDeSete() {
        Boletim boletim = new Boletim();
        assertEquals("RECUPERACAO", boletim.verificarSituacao(6.9));
    }

    @Test
    void deveRecuperarAlunoComMediaExatamenteQuatro() {
        Boletim boletim = new Boletim();
        assertEquals("RECUPERACAO", boletim.verificarSituacao(4.0));
    }

    @Test
    void deveReprovarAlunoComMediaAbaixoDeQuatro() {
        Boletim boletim = new Boletim();
        assertEquals("REPROVADO", boletim.verificarSituacao(3.9));
    }

    // Testes de calcularMedia (Com tolerância para decimais)
    @Test
    void deveCalcularMediaComDecimais() {
        Boletim boletim = new Boletim();
        double resultado = boletim.calcularMedia(5.5, 6.0);
        // O terceiro argumento (0.0001) é a tolerância para a comparação de doubles
        assertEquals(5.75, resultado, 0.0001);
    }

    // Testes de contarAprovados (Cobrindo iterações do laço)
    @Test
    void deveRetornarZeroQuandoArrayForVazio() {
        Boletim boletim = new Boletim();
        double[] notas = new double[]{};
        assertEquals(0, boletim.contarAprovados(notas));
    }

    @Test
    void deveContarAprovadoComApenasUmaIteracao() {
        Boletim boletim = new Boletim();
        double[] notas = new double[]{8.0};
        assertEquals(1, boletim.contarAprovados(notas));
    }

    @Test
    void deveContarVariosAprovadosEReprovados() {
        Boletim boletim = new Boletim();
        double[] notas = new double[]{7.0, 4.0, 8.5, 2.0, 10.0};
        assertEquals(3, boletim.contarAprovados(notas));
    }
}