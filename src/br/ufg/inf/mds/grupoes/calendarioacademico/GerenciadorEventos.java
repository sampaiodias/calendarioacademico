package br.ufg.inf.mds.grupoes.calendarioacademico;

import java.text.DateFormatSymbols;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

/**
 *
 * @author Augusto Moura ~ Github: augusto-moura
 */
public class GerenciadorEventos {

  public static String pesquisarPorNome
        (final List<Mes> meses, final String entrada) {
    final StringBuilder construtor = new StringBuilder();

    for (final Mes mes : meses) {
      List<Evento> ev = mes.getListaEventos();
      for(Evento x : ev){
          if (x.getNome().contains(entrada)){
              construtor.append(String.format("** %s/%s/%s Regional %s**\n"
                      + "%s: %s \n\n", 
            x.getDia(), mes.getCodMes(), mes.getAno(), mes.getCodRegional(), 
            x.getNome(), x.getDescricao()));
          }
      }
    }

    return construtor.toString();
  }
        
  public static String pesquisarPorDescricao
        (final List<Mes> meses, final String entrada) {
    final StringBuilder construtor = new StringBuilder();

    for (final Mes mes : meses) {
      List<Evento> ev = mes.getListaEventos();
      for(Evento x : ev){
          if (x.getDescricao().contains(entrada)){
              construtor.append(String.format("** %s/%s/%s Regional %s**\n"
                      + "%s: %s \n\n", 
            x.getDia(), mes.getCodMes(), mes.getAno(), mes.getCodRegional(), 
            x.getNome(), x.getDescricao()));
          }
      }
    }

    return construtor.toString();
  }
  
}