import java.util.Scanner;
import java.util.ArrayList;
import java.io.*;
import java.sql.Timestamp;

/*
  * Classe responsavel pelas operações ou comportamentos gerais dos aplicativos.
  * Alterar, modificar, deletar, buscar... Por se tratarem de uma complexidade
  * maior, tornou-se viavel a elaboração da presente classe.
  *
  */
public class AplicativoOperacoes  implements Serializable{

  private int numberOfApps;
  private int numberOfOperations;

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
    *
    *
    */
  public void register() {

    boolean control = true;
    Aplicativo app = new Aplicativo();
    ArrayList<Aplicativo> appArray = new ArrayList<Aplicativo>();

    while(control) {
      System.out.println("\n+ [CADASTRO DE APLICATIVO]:                                     +");
      System.out.print("+ [#] Nome do Aplicativo: ");
      app.setAppName(sc.nextLine());

      System.out.print("+ [#] Autor/Empresa Responsavel: ");
      app.setAuthor(sc.nextLine());

      System.out.print("+ [#] Licença Comercial: ");
      app.setLicense(sc.nextLine());

      System.out.print("+ [#] Versão do Aplicativo: ");
      app.setVersion(sc.next());

      System.out.print("+ [#] Valor: ");
      app.setPrice(sc.nextDouble());

      System.out.print("+ [#] Possui Periodo Trial [N/y]: ");
      if(sc.next().toLowerCase().equals("y")) {
        System.out.print("+ [#] Informe a Quantidade de Dias para Trial: ");
        app.setTrial(sc.nextInt());
      }else
        app.setTrial(0);

      System.out.print("+ [#] Qual o Peso em Mega Bytes do Aplicativo: ");
      app.setWeight(sc.nextDouble());

      System.out.print("+ [#] Versão Requerida do Sistema Oepracional: ");
      app.setSoVersion(sc.nextLine());

      System.out.print("+ [#] País ('All' para todos): ");
      app.setCountry(sc.nextLine());

      Principal.clearConsole();
      System.out.print("+ [#] Deseja Cadastrar Outro Aplicativo [n/y]: ");
      app.setDateRegister(getDate());
      ++numberOfApps;
      appArray.add(app);
      Principal.clearConsole();
      if((sc.next().toLowerCase()).equals("n"))
        control = !control;
    }

    while(verifyChanges(appArray)) {
      ArrayList<Integer> removeIndex = new ArrayList<Integer>();

      System.out.print("+ [#] Qual dos registros deseja remover (Insira os ID separados por espaço, 0 para não digitar mais): ");

      while(sc.nextInt() != 0) {
        removeIndex.add(sc.nextInt());
      }

      for(Integer inte : removeIndex) {
        for(Aplicativo appIndex : appArray) {
          if(appIndex.getId() == inte) {
            appArray.remove(appIndex);
          }
        }
      }
    }
    saveDate(appArray);
    Principal.clearConsole();
  }

  private String getDate() {

  }

  private String getHour() {

  }

  private boolean verifyChanges(ArrayList<Aplicativo> appArray){

    System.out.println("\n+ [#] Deseja efetuar as seguintes modificações: ");
    for(Aplicativo app : appArray) {
      showAppData(app);
    }
    System.out.println("+ [#] Sim ou não [y/n]:");
    if(sc.next().toLowerCase().equals("y"))
      return true;

    return false;
  }

  /*
    * Metodo responsavel por gravar os dados dos novos aplicativos registrados em
    * um arquivo data.
    *
    * @param appArray (Parametro do tipo ArrayList contendo todos os aplicativos registrados.).
    *
    */
  public void saveDate(ArrayList<Aplicativo> appArray) {

    try {
      ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("data/data"));
      for(Aplicativo app : appArray) {
        oos.writeObject(app);
      }
      oos.close();
    } catch(IOException e) {
      e.printStackTrace();
    }

  }

  /**
    * Método responsavel pela modificação dos estados do objeto aplicativo.
    * Modifica quaisquer atributos do objeto aplicativo. Ao término de sua execução,
    * registra as modificações necessárias no arquivo.
    *
    *
    */
  public void modifyApp() {

    System.out.println("\n+ [ALTERAÇÃO DE CADASTRO]:                                      +");
    System.out.println("+ [#] Deseja Buscar o Cadastro por Qual Dado: ");
    System.out.println("+ [1] - Nome\n+ [2] - ID");

    if(sc.nextInt() == 1) {
      System.out.print("+ [#] Nome do Aplicativo a Ser Alterado: ");
      app = search(sc.nextLine());
    }else
      System.out.println("+ [#] Numero ID do Aplicativo a Ser Buscado: ");
      //app = search(sc.nextInt());

    showAppData(app);
    //System.out.println("\n+ [ALTERAÇÃO DE CADASTRO]:                                      +");

  }

  /**
    * Método responsavel pela busca de aplicativos cadastrados no sistema.
    * Efetua a leitura do arquivo de registros em busca do dado informado.
    *
    *
    */
  public void searchApp() {

    System.out.println("\n+ [BUSCA POR CADASTRO]:                                         +");
    while(control) {
      System.out.println("+ [#] Deseja Buscar o Cadastro por Qual Dado: ");
      System.out.println("+ [1] - Nome\n+ [2] - ID");

      if(sc.nextInt() == 1) {
        System.out.print("+ [#] Nome do Aplicativo a Ser Alterado: ");
        app = search(sc.nextLine());
      }else {
        System.out.println("+ [#] Numero ID do Aplicativo a Ser Buscado: ");
        //app = search(sc.nextInt());
      }
      showAppData(app);

      System.out.println("+ [#] Deseja realizar outra busca [N/y]: ");
      if(sc.next().toLowerCase().equals("n")) control = !control;
    }
    Principal.clearConsole();
  }

  private void showAppData(Aplicativo app) {
    System.out.println("+-----------------------------------------------------------------+");
    System.out.println("+ [#] ID: "+app.getId());
    System.out.println("+ [#] Nome do Aplicativo: "+app.getAppName());
    System.out.println("+ [#] Autor/Empresa: "+app.getAuthor());
    System.out.println("+ [#] Licença Comercial: "+app.getLicense());
    System.out.println("+ [#] Preço: "+app.getPrice());
    System.out.println("+ [#] Versão: "+app.getVersion());
    System.out.println("+ [#] País: "+app.getCountry());
    System.out.println("+ [#] Peso (Mb): "+app.getWeight());
    System.out.println("+ [#] Periodo de Trial: "+app.getTrial());
    System.out.println("+ [#] Versão do Sistema Operacional: "+app.getSoVersion());
    System.out.println("+ [#] Data de Registro do Aplicativo: "+app.getDateRegister() + " " + app.getHourRegister());
    System.out.println("+-----------------------------------------------------------------+");
  }

  /**
    * Método responsavel pela busca de um objeto aplicativo por via do atributo appName.
    * Efetua a leitura do arquivo de dados, carrega a lista de objetos em uma estrutura ArrayList,
    * percorre tal array em busca de um objeto cujo o estado de seu atributo appName seja igual ao parametro
    * passado pelo usuario na chamada da função.
    *
    * @params appName (Parametro do tipo String, estado do atributo appName do objeto.)
    * @return Aplicativo (Retorna um objeto do tipo Aplicativo.)
    */
  private Aplicativo search(String appName) {

    try {
      ObjectInputStream oi = new ObjectInputStream(new FileInputStream("data/data.dat"));
      Aplicativo app = null;
      ArrayList<Aplicativo> appArray = new ArrayList<Aplicativo>();

      while((app = oi.readObject()) != null) {
        if(app instanceof Aplicativo) {
          Aplicativo appx = (Aplicativo) app;
          appArray.add(appx);
        }
      }

      for(Aplicativo appIndex : appArray) {
        if(appIndex.getAppName().equals(appName))
          return appIndex;
      }
      System.out.println("+ [X] Registro não encontrado!");

    }catch(Exception e) {
      System.out.println("+ [X] Ops: Houve uma falha na leitura do arquivo. ERRO("+e.toString()+").");
    }
  }

  /**
    * Método responsavel pela busca de um objeto aplicativo por via do atributo ID.
    * Efetua a leitura do arquivo de dados, carrega a lista de objetos em uma estrutura ArrayList,
    * percorre tal array em busca de um objeto cujo o estado de seu atributo ID seja igual ao parametro
    * passado pelo usuario na chamada da função.
    *
    * @params idApp (Parametro do tipo inteiro, estado do ID do objeto.)
    * @return Aplicativo (Retorna um objeto do tipo Aplicativo.)
    */
  private Aplicativo search(int idApp) {
    try {
      ObjectInputStream oi = new ObjectInputStream(new FileInputStream("data/data.dat"));
      Aplicativo app = null;
      ArrayList<Aplicativo> appArray = new ArrayList<Aplicativo>();

      while((app = oi.readObject()) != null) {
        if(app instanceof Aplicativo) {
          Aplicativo appx = (Aplicativo) app;
          appArray.add(appx);
        }
      }

      for(Aplicativo appIndex : appArray) {
        if(appIndex.getId().equals(idApp))
          return appIndex;
      }
      System.out.println("+ [X] Registro não encontrado!");

    }catch(Exception e) {
      System.out.println("+ [X] Ops: Houve uma falha na leitura do arquivo. ERRO("+e.toString()+").");
    }
  }

  /**
    * Método responsavel pela remoção de um objeto Aplicativo do arquivo de dados. Efetua a leitura do arquivo
    * de dados, em seguida, carrega em uma array list a lista de objetos pertencentes ao arquivo.
    * Em seguida, efetua uma busca pelo objeto procurado, comparando uma String recebida por parametro referente
    * ao estado do atribudo appName do objeto. Ao encontrar, remove-se o objeto do array list e em seguida, grava
    * novamente no arquivo.
    *
    * @params appName (Parametro do tipo String, contendo o nome do aplicativo.)
    */
  public void removeApp(String appName) {
    try {
      ObjectInputStream oi = new ObjectInputStream(new FileInputStream("data/data.dat"));
      Aplicativo app = null;
      ArrayList<Aplicativo> appArray = new ArrayList<Aplicativo>();

      while((app = oi.readObject()) != null) {
        if(app instanceof Aplicativo) {
          Aplicativo appx = (Aplicativo) app;
          appArray.add(appx);
        }
      }
      int contador = 0;
      for(Aplicativo appIndex : appArray) {
        if(appIndex.getAppName().equals(appName)){
          appArray.remove(contador);
          saveDate(appArray);
          return;
        }
        contador++;
      }
      System.out.println("+ [X] Registro não encontrado!");

    }catch(Exception e) {
      System.out.println("+ [X] Ops: Houve uma falha na leitura do arquivo. ERRO("+e.toString()+").");
    }
  }

  /**
    * Método responsavel pela exibição e listagem de todos os objetos armazenados no arquivo de dados.
    * Carrega um array list com todos os objetos, percorre-o imprimindo na tela todos os objetos.
    *
    */
  public void showListOfApps(){
    try {
      ObjectInputStream oi = new ObjectInputStream(new FileInputStream("data/data.dat"));
      Aplicativo app = null;
      ArrayList<Aplicativo> appArray = new ArrayList<Aplicativo>();

      while((app = oi.readObject()) != null) {
        if(app instanceof Aplicativo) {
          Aplicativo appx = (Aplicativo) app;
          appArray.add(appx);
        }
      }
      for(Aplicativo appIndex : appArray) {
        SyStem.out.println("Aplicativo: " + appIndex.getAppName());
      }
      return;
      }catch(Exception e) {
      System.out.println("+ [X] Ops: Houve uma falha na leitura do arquivo. ERRO("+e.toString()+").");
    }
  }
/*
  public static void generateLogFile(ArrayList<Aplicativo> appArray, String nameOfMethod) {
    try {
      FileWriter arq = new FileWriter("data/log.txt");
      ++numberOfOperations;
      switch(nameOfMethod){
        case "removeApp":
          arq.write("["+numberOfOperations+"] ("+ getHour()+"/"+getDate()+"): Remoção do(s) seguinte(s) aplicativo(s): ");
          for(Aplicativo appIndex : appArray)
            arq.write("+ + Aplicativo: "+appIndex.getAppName()+".");
          break;

        case "searchApp":
          arq.write("["+numberOfOperations+"] ("+ getHour()+"/"+getDate()+"): Busca pelo(s) aplicativo(s): ");
          for(Aplicativo appIndex : appArray)
            arq.write("+ + Aplicativo: "+appIndex.getAppName()+".");
          break;

        case: "register":
          arq.write("["+numberOfOperations+"] ("+ getHour()+"/"+getDate()+"): Registro do(s) seguinte(s) aplicativo(s): ");
          for(Aplicativo appIndex : appArray)
            arq.write("+ + Aplicativo: "+appIndex.getAppName()+".");
          break;

        case "showListOfApps":
          arq.write("["+numberOfOperations+"] ("+ getHour()+"/"+getDate()+"): Listagem de todos os aplicativos cadastrados: ");
          for(Aplicativo appIndex : appArray)
            arq.write("+ + Aplicativo: "+appIndex.getAppName()+".");
          break;

        default:
          arq.write("[X]: Operação não reconhecida.");
          break;
      }
    }catch (Exception e) {
      System.out.println("+ [X] Ops: Houve um erro na geração do arquivo de log. ERRO("+e.toString()+").");
    }
  }

  public static void generateLogFile(Aplicativo app) {
    try {
      FileWriter arq = new FileWriter("data/log.txt");
      ++numberOfOperations;
      switch(nameOfMethod) {
        case: "modifyApp":
          arq.write("["+numberOfOperations+"] ("+ getHour()+"/"+getDate()+"): Modificação do seguinte aplicativo: "+app.getAppName()+".");
          break;

        default:
          arq.write("[X]: Operação não reconhecida.");
          break;
      }
    }catch (Exception e) {
      System.out.println("+ [X] Ops: Houve um erro na geração do arquivo de log. ERRO("+e.toString()+").");
  //public void showListOfApps(){}
  */
}
