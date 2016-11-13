import java.util.Scanner;

/*
  * Classe responsavel pelas operações ou comportamentos gerais dos aplicativos.
  * Alterar, modificar, deletar, buscar... Por se tratarem de uma complexidade
  * maior, tornou-se viavel a elaboração da presente classe.
  *
  */
public class AplicativoOperacoes {

  private int numberOfApps;

  Scanner sc = new Scanner(System.in);
  Aplicativo app = new Aplicativo();

  public AplicativoOperacoes() {
    numberOfApps = 0;
  }

  /**
    * Metodo responsavel pelo cadastro do novo aplicativo ao sistema. Efetua a
    * captura de dados do usuario, validando as informações e gravando todas as
    * informações em um arquivo ao termino da chamada.
    * Ao término da execução, registra em um arquivo binario, todos os apps cadastrados.
    */
  public void register() {

    boolean control = true;
    Aplicativo[] appVector = new Aplicativo[10];
    Aplicativo app = new Aplicativo();
    int count = 0;

    while(control) {
      System.out.println("\n+ [CADASTRO DE APLICATIVO]:                                     +");
      System.out.print("+ [#] Nome do Aplicativo: ");
      appVector[count].setAppName(sc.nextLine());

      System.out.print("+ [#] Autor/Empresa Responsavel: ");
      appVector[count].setAuthor(sc.nextLine());

      System.out.print("+ [#] Licença Comercial: ");
      appVector[count].setLicense(sc.nextLine());

      System.out.print("+ [#] Valor: ");
      appVector[count].setPrice(sc.nextDouble());

      System.out.print("+ [#] Possui Periodo Trial [N/y]: ");
      if(sc.next().equals("y")) {
        System.out.print("+ [#] Informe a Quantidade de Dias para Trial: ");
        appVector[count].setTrial(sc.nextInt());
      }else
        appVector[count].setTrial(0);

      System.out.print("+ [#] Qual o Peso em Mega Bytes do Aplicativo: ");
      appVector[count].setWeight(sc.nextDouble());

      System.out.print("+ [#] Versão Atual do Aplicativo: ");
      appVector[count].setVersion(sc.nextLine());

      System.out.print("+ [#] Versão Requerida do Sistema Oepracional: ");
      appVector[count].setSoVersion(sc.nextLine());

      System.out.print("+ [#] Deseja Cadastrar Outro Aplicativo [n/y]: ");
      ++numberOfApps;
      if(sc.next().equals("n"))
        control = !control;
    }

    //File arq = new File("data/apps.bin");
    //BufferedOutputStream in = new BufferedOutputStream();
  }

  /**
    * Método responsavel pela modificação dos estados do objeto aplicativo.
    * Modifica quaisquer atributos do objeto aplicativo. Ao término de sua execução,
    * registra as modificações necessárias no arquivo.
    */
  public void modifyApp() {

    System.out.println("\n+ [ALTERAÇÃO DE CADASTRO]:                                      +");
    System.out.println("+ [#] Deseja Buscar o Cadastro por Qual Dado: ");
    System.out.println("+ [1] - Nome\n+ [2] - ID");

    if(sc.nextInt() == 1) {
      System.out.print("+ [#] Nome do Aplicativo a Ser Alterado: ");
      //app = search(sc.nextLine());
    }else
      System.out.println("+ [#] Numero ID do Aplicativo a Ser Buscado: ");
      //app = search(sc.nextInt());

    //terminar...
  }

  /**
    * Método responsavel pela busca de aplicativos cadastrados no sistema.
    * Efetua a leitura do arquivo de registros em busca do dado informado.
    */
  public void searchApp() {

    System.out.println("\n+ [BUSCA POR CADASTRO]:                                         +");
    System.out.println("+ [#] Deseja Buscar o Cadastro por Qual Dado: ");
    System.out.println("+ [1] - Nome\n+ [2] - ID");

    if(sc.nextInt() == 1) {
      System.out.print("+ [#] Nome do Aplicativo a Ser Alterado: ");
      //app = search(sc.nextLine());
    }else
      System.out.println("+ [#] Numero ID do Aplicativo a Ser Buscado: ");
      //app = search(sc.nextInt());

  }

  //private Aplicativo search(String appName) {}
  //private Aplicativo search(int idApp) {}
  //public void removeApp() {}
  //public void showListOfApps(){}
}
