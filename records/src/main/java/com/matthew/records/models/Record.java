package com.matthew.records.models;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="records")
public class Record {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@Size(min=1, max= 30)
	private String artistName;
	@NotBlank
	private String albumName;
	@NotNull
	private String year;
	
	@ManyToMany
	@JoinTable(
		name="likes",
		joinColumns = @JoinColumn(name="record_id"),
		inverseJoinColumns = @JoinColumn(name="user_id")			
			)
	private List<User> likers;
	
    @OneToMany(mappedBy="record", cascade=CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Song> songs;
	
	@OneToOne(mappedBy="record", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	private Label label;
	
	@Column(updatable=false)
	@DateTimeFormat(pattern = "yyy-MM-DD HH:mm:ss")
	private Date createdAt;
	@DateTimeFormat(pattern = "yyy-MM-DD HH:mm:ss")
	private Date updatedAt;
	
	@PrePersist
	protected void onCreate() {
		this.createdAt = new Date();
	}
	
	@PreUpdate
	protected void onUpdate() {
		this.updatedAt = new Date();
	}

	
	public Record() {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getArtistName() {
		return artistName;
	}

	public void setArtistName(String artistName) {
		this.artistName = artistName;
	}

	public String getAlbumName() {
		return albumName;
	}

	public void setAlbumName(String albumName) {
		this.albumName = albumName;
	}



	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public Label getLabel() {
		return label;
	}

	public void setLabel(Label label) {
		this.label = label;
	}

	public List<Song> getSongs() {
		return songs;
	}

	public void setSongs(List<Song> songs) {
		this.songs = songs;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public List<User> getLikers() {
		return likers;
	}

	public void setLikers(List<User> likers) {
		this.likers = likers;
	}


	
	
	
}
