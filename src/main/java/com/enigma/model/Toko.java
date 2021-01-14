package com.enigma.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ms_toko")
public class Toko {

	private Integer id;

	@Id
	@Column(name = "kode_toko")
	private String kodeToko;

	@Column(name = "nama_toko")
	private String namaToko;

	@Column(name = "alamat")
	private String alamat;

	@Column(name = "wilayah")
	private String wilayah;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getKodeToko() {
		return kodeToko;
	}

	public void setKodeToko(String kodeToko) {
		this.kodeToko = kodeToko;
	}

	public String getNamaToko() {
		return namaToko;
	}

	public void setNamaToko(String namaToko) {
		this.namaToko = namaToko;
	}

	public String getAlamat() {
		return alamat;
	}

	public void setAlamat(String alamat) {
		this.alamat = alamat;
	}

	public String getWilayah() {
		return wilayah;
	}

	public void setWilayah(String wilayah) {
		this.wilayah = wilayah;
	}

	public Toko(Integer id, String kodeToko, String namaToko, String alamat, String wilayah) {
		super();
		this.id = id;
		this.kodeToko = kodeToko;
		this.namaToko = namaToko;
		this.alamat = alamat;
		this.wilayah = wilayah;
	}

	public Toko() {

	}
}
