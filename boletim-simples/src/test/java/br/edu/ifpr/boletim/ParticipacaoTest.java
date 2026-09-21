package br.edu.ifpr.boletim;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ParticipacaoTest {

    @Test
    void deveSomarTresPontosQuandoEntregouEParticipou() {
        Participacao part = new Participacao();
        assertEquals(3, part.calcularPontos(true, true));
    }

    @Test
    void deveSomarDoisPontosQuandoApenasEntregou() {
        Participacao part = new Participacao();
        assertEquals(2, part.calcularPontos(true, false));
    }

    @Test
    void deveSomarUmPontoQuandoApenasParticipou() {
        Participacao part = new Participacao();
        assertEquals(1, part.calcularPontos(false, true));
    }

    @Test
    void deveRetornarZeroQuandoNaoFezNada() {
        Participacao part = new Participacao();
        assertEquals(0, part.calcularPontos(false, false));
    }
}