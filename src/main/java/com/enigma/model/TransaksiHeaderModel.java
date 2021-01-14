package com.enigma.model;

import java.math.BigDecimal;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.Id;
import javax.persistence.JoinColumn;

import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "transaksi_header")
public class TransaksiHeaderModel {
	
	@Id
	@Column(name = "no_transaksi")
	private String noTransaksi;
	@Column(name = "tgl_transaksi")
	private Date tglTransaksi;
	@Column(name = "total_penjualan")
	private Integer totalPenjualan;
	@Column(name = "total_pajak")
	private BigDecimal totalPajak;
	@Column(name = "discount")
	private Integer discount;

	@ManyToOne
	@JoinColumn(name = "kode_toko")
	Toko toko;


	@OneToOne
	@JoinColumn(name = "no_transaksi")
	TransaksiDetailModel transaksiDetail;

	public TransaksiHeaderModel() {

	}
	

	public TransaksiHeaderModel(Integer id, Date tglTransaksi, Integer totalPenjualan, BigDecimal totalPajak,
			Integer discount, Toko toko, TransaksiDetailModel transaksiDetail) {
		super();
		this.tglTransaksi = tglTransaksi;
		this.totalPenjualan = totalPenjualan;
		this.totalPajak = totalPajak;
		this.discount = discount;
		this.toko = toko;
		this.transaksiDetail = transaksiDetail;
	}


	public Date getTglTransaksi() {
		return tglTransaksi;
	}

	public void setTglTransaksi(Date tglTransaksi) {
		this.tglTransaksi = tglTransaksi;
	}

	public Integer getTotalPenjualan() {
		return totalPenjualan;
	}

	public void setTotalPenjualan(Integer totalPenjualan) {
		this.totalPenjualan = totalPenjualan;
	}

	public BigDecimal getTotalPajak() {
		return totalPajak;
	}

	public void setTotalPajak(BigDecimal totalPajak) {
		this.totalPajak = totalPajak;
	}

	public Integer getDiscount() {
		return discount;
	}

	public void setDiscount(Integer discount) {
		this.discount = discount;
	}

	public Toko getToko() {
		return toko;
	}

	public void setToko(Toko toko) {
		this.toko = toko;
	}

	public TransaksiDetailModel getTransaksiDetail() {
		return transaksiDetail;
	}

	public void setTransaksiDetail(TransaksiDetailModel transaksiDetail) {
		this.transaksiDetail = transaksiDetail;
	}

	
}
