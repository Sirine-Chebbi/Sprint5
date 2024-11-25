package com.sirine.series.entities;
import java.util.Date;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class Serie {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long idSerie;
	

	private String nomSerie;

	private Double nbSerie;
	private Date dateSortie;

	@ManyToOne
	private Genre genre;
	
	/*@OneToOne
	private Image image;*/
	
	@OneToMany (mappedBy = "serie")
	 private List<Image> images;

	
	 private String imagePath;


	public Serie() {
		super();
	}
	
	public Serie(String nomSerie, Double nbS, Date dateSortie) {
		super();
		this.nomSerie = nomSerie;
		this.nbSerie = nbS;
		this.dateSortie = dateSortie;
	}


	


	public Long getIdSerie() {
		return idSerie;
	}

	public void setIdSerie(Long idSerie) {
		this.idSerie = idSerie;
	}

	public String getNomSerie() {
		return nomSerie;
	}

	public void setNomSerie(String nomSerie) {
		this.nomSerie = nomSerie;
	}

	public Double getNbSerie() {
		return nbSerie;
	}

	public void setNbSerie(Double nbSerie) {
		this.nbSerie = nbSerie;
	}

	public Date getDateSortie() {
		return dateSortie;
	}

	public void setDateSortie(Date dateSortie) {
		this.dateSortie = dateSortie;
	}
	
	public Genre getGenre() {
		return genre;
	}

	public void setGenre(Genre genre) {
		this.genre = genre;
	}

	@Override
	public String toString() {
		return "Serie [idSerie=" + idSerie + ", nomSerie=" + nomSerie + ", nbSerie=" + nbSerie + ", dateSortie="
				+ dateSortie + "]";
	}
	
	public List<Image> getImages() {
		return images;
	}

	public void setImages(List<Image> images) {
		this.images = images;
	}

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	

	

}
	