/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufg.inf.mds.grupoes.calendarioacademico;

import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author lucas
 */
public class Main {
    
    public List<Mes> meses;
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("***** CALENDÁRIO ACADÊMICO UFG *****\n");
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
        switch (opcao) {
            case 1: 
                System.out.println("Insira o número do mês: ");
                int numMes = Integer.parseInt(leitor.nextLine());
                System.out.println("Insira o ano: ");
                int numAno = Integer.parseInt(leitor.nextLine());
                System.out.println("Insira o número da regional: ");
                int numRegional = Integer.parseInt(leitor.nextLine());
                try {
                    //PROCURAR O MÊS NA LISTA MESES
                    //EXIBIR GRAFICAMENTE
                    //meses.get(0).exibirGraficamenteMes();
                } catch (Exception e) {
                    System.out.println("ERRO!");
                }
                break;
            case 2: 
                System.out.println("EXIBIR MÊS");
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
}
