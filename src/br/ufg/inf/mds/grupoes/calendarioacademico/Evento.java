/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufg.inf.mds.grupoes.calendarioacademico;

/**
 *
 * @author lucas
 */
public class Evento {
  private String nome;
  private int dia;
  private String descricao;
  
  Evento(String nome, int dia, String descricao){
      this.nome = nome;
      this.dia = dia;
      this.descricao = descricao;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public int getDia() {
    return dia;
  }

  public void setDia(int dia) {
    this.dia = dia;
  }

  public String getDescricao() {
    return descricao;
  }

  public void setDescricao(String descricao) {
    this.descricao = descricao;
  }
}
