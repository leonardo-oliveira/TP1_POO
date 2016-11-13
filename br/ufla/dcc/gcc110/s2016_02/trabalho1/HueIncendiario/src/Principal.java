import java.util.Scanner;

/**
  * Classe responsavel pela execução do software.
  * Contém o metodo main para ser chamado executando toda a computação.
  * @author Lucas Fonseca dos Santos, Leonardo Carvalho de Oliveira, Caio Vinicius.
  *
  */
public class Principal {

  public static void main(String[] args) {
    showMenu();
  }

  /**
    * Metodo responsavel pela exibição do menu principal do sistema e a captura
    * da entrada de dados do usuario.
    *
    * @return void Não há retorno.
    */
  private static void showMenu() {
    int option = 0;
    int auxInt = 0;
    String auxString;

    Scanner sc = new Scanner(System.in);
    System.out.print("\033[H\033[2J");
    System.out.flush();

    while(option != 99) {
      System.out.println("+=======================[ HUE INCENDIARIO ]=======================+");
      System.out.println("+                Sistema de Cadastro de Aplicativos               +");
      System.out.println("+                                                                 +");
      System.out.println("+ [OPÇÕES]:                                                       +");
      System.out.println("+ [1] - Cadastrar Novo Aplicativo                                 +");
      System.out.println("+ [2] - Alterar Dados Cadastrais de um Aplicativo                 +");
      System.out.println("+ [3] - Remover um Aplicativo                                     +");
      System.out.println("+ [4] - Buscar um Aplicativo                                      +");
      System.out.println("+ [5] - Listar Todos os Aplicativos                               +");
      System.out.println("+                                                                 +");
      System.out.println("+=================================================================+\n");
      System.out.print("+ [OPÇÃO DESEJADA]:");
      option = sc.nextInt();
      AplicativoOperacoes app = new AplicativoOperacoes();

      switch(option) {
        case 1:
          app.register();
          break;

        case 2:
          //app.alterar();
          break;

        case 3:
          //app.removeApp();
          break;

        case 4:
          //app.searchApp();
          break;

        case 5:
          //app.showListOfApps();
          break;

        default:
          System.out.println("+ [X] Ops: "+option+" não apresenta-se como opção válida. Por favor, escolha outra opção.\n");
          break;
      }

    }
  }

  /*
    * Metodo estatico por não requerer a criacao de um objeto para seu uso. Responsavel apenas
    * por limpar toda a tela do console.
    *
    *
    */
  public static void clearConsole() {
    System.out.print("\033[H\033[2J");
    System.out.flush();
  }

}
