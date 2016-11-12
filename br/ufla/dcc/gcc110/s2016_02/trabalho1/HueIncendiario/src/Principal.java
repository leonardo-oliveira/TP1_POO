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
    */
  private static void showMenu() {
    int option = 0;
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
      System.out.println("+ [4] - Listar Todos os Aplicativos                               +");
      System.out.println("+                                                                 +");
      System.out.println("+=================================================================+\n");
      System.out.print("+ [OPÇÃO DESEJADA]:");
      option = sc.nextInt();

      switch(option) {
        case 1:
          System.out.println("+ [4] - Listar Todos os Aplicativos                               +");
          break;
        case 2:
          break;
        case 3:
          break;
        case 4:
          break;
        case 5:
          break;
        default:
          System.out.println("+ [X] Ops: "+option+" não apresenta-se como opção válida. Por favor, escolha outra opção.\n");
          break;
      }

    }
  }

}
