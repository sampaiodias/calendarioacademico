package br.ufg.inf.mds.grupoes.calendarioacademico;

/**
 * Classe para gerenciar o sistema de login.
 *
 * @author Augusto Moura
 */
public abstract class SistemaLogin {

  /**
   * Status se o usuário está logado ou não.
   */
  private static boolean logado = false;

  /**
   * Nome do usuário administrador.
   */
  private static final String NOME_USUARIO = "admin";
  /**
   * Senha do usuário adminstrador.
   */
  private static final String SENHA_USUARIO = "admin";

  /**
   * Tenta logar com os parametros informados e retorna se obteve sucesso.
   *
   * @param usuario Nome de usuário a tentar logar
   * @param senha Senha de usuário a tentar logar
   * @return Login efetuado com sucesso ou não
   * @throws Exception Joga um erro se o usuário já estiver logado
   */
  public static boolean tentarLogar(final String usuario, final String senha)
          throws Exception {
    if (logado) {
      throw new Exception("Já está logado no sistema");
    } else {
      logado = usuario.equals(NOME_USUARIO) && senha.equals(SENHA_USUARIO);
      return logado;
    }
  }

  /**
   * Verifica se o usuário administrador já está logado.
   *
   * @return Administrador logado ou não
   */
  public static boolean isLogado() {
    return logado;
  }
  
  public static void deslogar() {
      logado = false;
  }
}
