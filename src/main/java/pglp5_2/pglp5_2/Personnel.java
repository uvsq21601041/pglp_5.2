package pglp5_2.pglp5_2;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.io.Serializable;


public class Personnel implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private  String nom;
    private  String prenom;
    private  String fonction;
    private  LocalDate  Datenaissance;
    private  ArrayList<Integer> telephone;
    private Integer isbn; 
	
	public  String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	
	public String getFonction() {
		return fonction;
	}
	public void setFonction(String fonction) {
		this.fonction = fonction;
	}
	
	
	
	public LocalDate getDatenaissance() {
		return Datenaissance;
		
	}
	
	public void setDatenaissance(LocalDate  Datenaissance)
	{
		this.Datenaissance=Datenaissance;
	}
	
	public ArrayList<Integer> getTelephone() {
		return telephone;
		
	}
	
	public void setTelephone(ArrayList<Integer>  telephone)
	{
		this.telephone=telephone;
	}
	public Integer getIsbn() {
		return isbn;
	}
	public void setIsbn(Integer isbn) {
		this.isbn = isbn;
	}
}
