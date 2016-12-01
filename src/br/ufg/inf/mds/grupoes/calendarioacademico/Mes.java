/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufg.inf.mds.grupoes.calendarioacademico;

import java.text.DateFormatSymbols;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 *
 * @author lucas
 */
public class Mes {

  private int ano;
  private int codMes;
  private int codRegional;
  private List<Evento> listaEventos;

  public Mes(int ano, int codMes, int codRegional) {
    this.ano = ano;
    this.codMes = codMes;
    this.codRegional = codRegional;
    this.listaEventos = new ArrayList<>();
  }

  public Mes(String linha) {
    // TODO: Implementar um método que transforme String em mês
    this(0, 0, 0);
  }

  /**
   * Constrói uma string formatada legível com as informações do mês e uma lista
   * de todos seus eventos.
   *
   * @return Título do mês e lista de todos os eventos
   */
  public final String exibirGraficamenteMes() {
    final StringBuilder construtor = new StringBuilder();
    final Locale local = new Locale("pt", "BR");
    final String nomeMes = DateFormatSymbols.getInstance(local)
            .getMonths()[this.codMes - 1];

    construtor.append(String.format("** %s %s Regional %s **\n", 
            nomeMes.toUpperCase(), this.ano, codRegional));
    for (final Evento evento : this.listaEventos) {
      String texto = String.format("> %s - %s", evento.getDia(),
              evento.getNome());

      construtor.append(texto).append("\n");
    }

    return construtor.toString();
  }

  public int getAno() {
    return ano;
  }

  public void setAno(int ano) {
    this.ano = ano;
  }

  public int getCodMes() {
    return codMes;
  }

  public void setCodMes(int codMes) {
    this.codMes = codMes;
  }

  public int getCodRegional() {
    return codRegional;
  }

  public void setCodRegional(int codRegional) {
    this.codRegional = codRegional;
  }

  public List<Evento> getListaEventos() {
    return listaEventos;
  }

  public void setListaEventos(List<Evento> listaEventos) {
    this.listaEventos = listaEventos;
  }
  
  public void addEvento(String nome, int dia, String descricao){
    this.listaEventos.add(new Evento(nome, dia, descricao));
  }
}
