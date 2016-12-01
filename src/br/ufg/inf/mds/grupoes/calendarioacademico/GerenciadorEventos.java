package br.ufg.inf.mds.grupoes.calendarioacademico;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 *
 * @author Augusto Moura ~ Github: augusto-moura
 */
public class GerenciadorEventos {

  private List<Evento> eventos;

  public GerenciadorEventos(final List<Evento> eventosInit) {
    this.eventos = eventosInit;
  }

  public List<Evento> pesquisarEventosPorMes(final Integer mes) {
    List<Evento> temp = new ArrayList<>();

    for (final Evento evento : eventos) {
      if (evento.getData().get(Calendar.MONTH) == mes) {
        temp.add(evento);
      }
    }

    return temp;
  }
  
}
