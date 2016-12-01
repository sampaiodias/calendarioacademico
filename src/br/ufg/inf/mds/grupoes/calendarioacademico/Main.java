/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufg.inf.mds.grupoes.calendarioacademico;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author lucas
 */
public class Main {
    
    public static List<Mes> meses;
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("***** CALENDÁRIO ACADÊMICO UFG *****\n");
        
        meses = gerarEventos(lerArquivos());
        
        exibirOpcoesMenu();
    }
    
    public static void exibirOpcoesMenu(){
        System.out.println("Insira o número da operação desejada.");
        System.out.println("1 - Exibir um Mês");
        System.out.println("2 - Procurar um Evento");
        if (SistemaLogin.isLogado()){
            System.out.println("6 - Adicionar um Evento");
            System.out.println("7 - Editar um Evento");
            System.out.println("8 - Remover um Evento");
        }
        System.out.println("9 - Entrar/Sair como Administrador");
        System.out.println("0 - Salvar e Sair");
        executar(getOpcao());
    }
    
    public static int getOpcao(){
        Scanner leitor = new Scanner(System.in);
        int x = Integer.parseInt(leitor.nextLine());
        System.out.println("");
        return x;
    }
    
    public static void executar(int opcao){
        Scanner leitor = new Scanner(System.in);
        String entrada;
        switch (opcao) {
            case 1: 
                exibirMes();
                break;
            case 2: 
                System.out.println("Busca por:");
                System.out.println("1 - Nome");
                System.out.println("2 - Descrição");
                int x = getOpcao();
                switch (x){
                    case 1:
                        System.out.println("Insira o conteúdo da busca: ");
                        entrada = leitor.nextLine();
                        System.out.println(GerenciadorEventos.pesquisarPorNome
                            (meses, entrada));
                        break;
                    case 2:
                        System.out.println("Insira o conteúdo da busca: ");
                        entrada = leitor.nextLine();
                        System.out.println(GerenciadorEventos.
                                pesquisarPorDescricao(meses, entrada));
                        break;
                    default:
                        System.out.println("Opção Inválida!");
                        break;
                }
                break;
            case 6: 
                System.out.println("ADICIONAR EVENTO");
                break;
            case 7: 
                System.out.println("EDITAR EVENTO");
                break;
            case 8: 
                System.out.println("REMOVER EVENTO");
                break;
            case 0: 
                System.out.println("Programa encerrado com sucesso!");
                System.exit(0);
                break;
            case 9: 
                login();
                break;
            default:
                System.out.println("Opção Inválida! \n");
                break;
        }
        System.out.println("");
        exibirOpcoesMenu();
    }
    
    public static void login(){
        Scanner leitor = new Scanner(System.in);
        if (SistemaLogin.isLogado()) {
            SistemaLogin.deslogar();
            System.out.println("Administrador foi desconectado");
        } else {
            System.out.println("Insira seu usuário: ");
            String usuario = leitor.nextLine();
            System.out.println("Insira sua senha: ");
            String senha = leitor.nextLine();
            try {
                SistemaLogin.tentarLogar(usuario, senha);
            } catch (Exception ex) {
                Logger.getLogger(Main.class.getName()).log
                    (Level.SEVERE, null, ex);
            }
            System.out.println("");
            if(SistemaLogin.isLogado()){
                System.out.println("Login efetuado com sucesso!");
            } else {
                System.out.println("Usuário ou senha errada.");
            }
        }
    }
    
    public static String lerArquivos(){
        String resultado = "";
        
//        LeitorArquivoTexto dbReader = 
//                new LeitorArquivoTexto("assets/eventos/goias2016.txt");
//        try {
//            resultado += dbReader.ler();
//        } catch (IOException ex) {
//            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        
//        dbReader = 
//                new LeitorArquivoTexto("assets/eventos/goias2016.txt");
//        try {
//            resultado += dbReader.ler();
//        } catch (IOException ex) {
//            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        
//        dbReader = 
//                new LeitorArquivoTexto("assets/eventos/catalao2016.txt");
//        try {
//            resultado += dbReader.ler();
//        } catch (IOException ex) {
//            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        
//        dbReader = 
//                new LeitorArquivoTexto("assets/eventos/goiania2016.txt");
//        try {
//            resultado += dbReader.ler();
//        } catch (IOException ex) {
//            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        
//        dbReader = 
//                new LeitorArquivoTexto("assets/eventos/jatai.txt");
//        try {
//            resultado += dbReader.ler();
//        } catch (IOException ex) {
//            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
//        }

        LeitorArquivoTexto dbReader = 
                new LeitorArquivoTexto("assets/eventos/eventos.txt");
        try {
            resultado += dbReader.ler();
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return resultado;
    }
    
    public static List<Mes> gerarEventos(String eventos){
        List<Mes> temp = new ArrayList<>();
        List<String> infoSeparadas = Arrays.asList(eventos.split("~"));
        String nome = "";
        String descricao = "";
        int dia = 0;
        int mes = 0;
        int ano = 0;
        int regional = 0;
        int contador = 0;
        
        for(String info : infoSeparadas){
            switch (contador){
                case 0:
                    nome = info;
                    break;
                case 1:
                    dia = Integer.parseInt(info);
                    break;
                case 2:
                    mes = Integer.parseInt(info);
                    break;
                case 3:
                    ano = Integer.parseInt(info);
                    break;
                case 4:
                    regional = Integer.parseInt(info);
                    break;
                case 5:
                    descricao = info;
                    boolean achou = false;
                    for(Mes x : temp){
                        if (x.getAno() == ano &&
                                x.getCodMes() == mes &&
                                x.getCodRegional() == regional){
                            achou = true;
                            x.addEvento(nome, dia, descricao);
                        }
                    }
                    if (!achou){
                        Mes novoMes = new Mes(ano, mes, regional);
                        novoMes.addEvento(nome, dia, descricao);
                        temp.add(novoMes);
                    }
                    break;
                case 6:
                    contador = 0;
                    nome = info;
                    break;
            }
            contador++;
        }
        
        return temp;
    }
    
    public static void exibirMes(){
        Scanner leitor = new Scanner(System.in);
        System.out.println("Insira o número do mês: ");
        int mes = Integer.parseInt(leitor.nextLine());
        System.out.println("Insira o ano: ");
        int ano = Integer.parseInt(leitor.nextLine());
        System.out.println("Insira o número da regional: ");
        int regional = Integer.parseInt(leitor.nextLine());
        System.out.println("");
        try {
            //PROCURAR O MÊS NA LISTA MESES
            boolean achou = false;
            for(Mes x : meses){
                if (x.getAno() == ano &&
                        x.getCodMes() == mes &&
                        x.getCodRegional() == regional){
                    achou = true;
                    System.out.println(x.exibirGraficamenteMes());
                }
            }
            if (!achou){
                System.out.println("Mês não encontrado.");
            }
        } catch (Exception e) {
            System.out.println("ERRO!");
        }
    }
}
