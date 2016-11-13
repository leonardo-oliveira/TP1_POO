//package br.ufla.dcc.gcc110.s2016_02.trabalho1.HueIncendiario;

/**
  * Classe responsavel pela representação da abstração das entidades de Aplicativos a serem
  * computados no software.
  * Define o conjunto de caracteristicas dos aplicativos a serem cadastrados e manipulados no sistema.
  *
  * @author Lucas Fonseca dos Santos, Leonardo Carvalho de Oliveira, Caio Vinicius.
  *
  */

public class Aplicativo {

  private String name;       //nome do app
  private String author;     //Autor/empresa
  private String version;    //Versao
  private String country;    //Pais
  private String license;    //Tipo da Licença
  private String soVersion;  //Versão do SO
  private double price;      //Preço
  private double weight;     //Peso em Mega Bytes
  private int trial;         //Quantidade de dias para teste

  /**
    *
    */
  public Aplicativo(){

  }

  public void setAppName(String name) {
    this.name = name;
  }

  public String getAppName() {
    return name;
  }

  public void setAuthor(String author) {
    this.author = author;
  }

  public String getAuthor() {
    return author;
  }

  public void setVersion(String version) {
    this.version = version;
  }

  public String getVersion() {
    return version;
  }

  public void setCountry(String country) {
    this.country = country;
  }

  public String getCountry() {
    return country;
  }

  public void setLicense(String license) {
    this.license = license;
  }

  public String getLicense() {
    return license;
  }

  public void setSoVersion(String soVersion) {
    this.soVersion = soVersion;
  }

  public String getSoVersion() {
    return soVersion;
  }

  public void setPrice(double price) {
    this.price = price;
  }

  public double getPrice() {
    return price;
  }

  public void setWeight(double weight) {
    this.weight = weight;
  }

  public double getWeight() {
    return weight;
  }

  public void setTrial(int trial) {
    this.trial = trial;
  }
}
