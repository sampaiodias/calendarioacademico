/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufg.inf.mds.grupoes.calendarioacademico;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author lucas
 */
public class LeitorArquivoTexto {

  private String caminho;

  public LeitorArquivoTexto(final String caminhoInicial) {
    this.caminho = caminhoInicial;
  }

  public String ler() throws IOException {
    final StringBuilder builder = new StringBuilder();
    try (final BufferedReader buffer = new BufferedReader(new FileReader(this.caminho))) {
      while (buffer.ready()) {
        builder.append(buffer.readLine());
      }
    }
    
    return builder.toString();
  }
}
