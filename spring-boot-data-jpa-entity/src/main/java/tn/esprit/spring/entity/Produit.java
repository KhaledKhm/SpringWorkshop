package tn.esprit.spring.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;


import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

//@JsonBackReference
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PUBLIC)
@Table(name = "Produit")
public class Produit implements Serializable{
	

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name="idProduit")
	private Long idProduit;
	
	@Column(name = "code", length = 30)
	private String code;
	
	@Column(name = "libelle", length = 30)
	private String libelle;
	
	@Column(name = "prixUnitaire", length = 30)
	private float prixUnitaire;


	@ManyToOne
	private Rayon rayon;
	
	@ManyToOne
	private Stock stock;
	
	@OneToOne
	private DetailProduit detailProduit;
	
	@OneToMany(mappedBy="produit")
	private Set<DetailFacture> detailFactures;
	
	@ManyToMany
	private Set<Fournisseur> fournisseurs;
	
	/*public Long getIdProduit() {
		return idProduit;
	}

	public void setIdProduit(Long idProduit) {
		this.idProduit = idProduit;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public float getPrixUnitaire() {
		return prixUnitaire;
	}

	public void setPrixUnitaire(float prixUnitaire) {
		this.prixUnitaire = prixUnitaire;
	}*/
	
	
}