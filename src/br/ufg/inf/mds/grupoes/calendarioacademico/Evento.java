/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufg.inf.mds.grupoes.calendarioacademico;

import java.util.Calendar;

/**
 *
 * @author lucas
 */
public class Evento {
  private String nome;
  private Calendar data;
  private String descricao;
  private String regiao;

  public String getRegiao() {
    return regiao;
  }

  public void setRegiao(String regiao) {
    this.regiao = regiao;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public String getDescricao() {
    return descricao;
  }

  public void setDescricao(String descricao) {
    this.descricao = descricao;
  }

  public Calendar getData() {
    return data;
  }

  public void setData(Calendar data) {
    this.data = data;
  }
}
