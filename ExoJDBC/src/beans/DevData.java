/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

/**
 *
 * @author Bright
 */
public class DevData {

  private String Developpeur;
  private String Jour;
  private int NbScripts;

  public DevData() {

  }

  public DevData(String Developpeur) {
    this.Developpeur = Developpeur;
  }

  public DevData(String Developpeur, int NbScripts) {
    this.Developpeur = Developpeur;
    this.NbScripts = NbScripts;
  }

  // public DevData(String Jour, int NbScripts) {
  //   this.Jour = Jour;
  //   this.NbScripts = NbScripts;
  // }
  public DevData(int NbScripts) {
    this.NbScripts = NbScripts;
  }

  public DevData(String Developpeur, String Jour, int NbScripts) {
    this.Developpeur = Developpeur;
    this.Jour = Jour;
    this.NbScripts = NbScripts;
  }

  public int getNbScripts() {
    return NbScripts;
  }

  public void setNbScripts(int NbScripts) {
    this.NbScripts = NbScripts;
  }

  public String getDeveloppeur() {
    return Developpeur;
  }

  public void setDeveloppeur(String Developpeur) {
    this.Developpeur = Developpeur;
  }

  public String getJour() {
    return Jour;
  }

  public void setJour(String Jour) {
    this.Jour = Jour;
  }

  @Override
  public String toString() {
    return ("devdata{" +
        "Developpeur=" +
        Developpeur +
        ", Jour=" +
        Jour +
        ", NbScripts=" +
        NbScripts +
        '}');
  }
}
