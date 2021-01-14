package com.enigma.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "transaksi_detail")
public class TransaksiDetailModel {

	@Id
	private Integer id;
	@Column(name = "no_transaksi")
	private String noTransaksi;
	@Column(name = "tgl_transaksi")
	private Date tglTransaksi;
	@Column(name = "total_qty")
	private Integer qty;

	@ManyToOne
	@JoinColumn(name = "product_id")
	Product product;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNoTransaksi() {
		return noTransaksi;
	}

	public void setNoTransaksi(String noTransaksi) {
		this.noTransaksi = noTransaksi;
	}

	public Date getTglTransaksi() {
		return tglTransaksi;
	}

	public void setTglTransaksi(Date tglTransaksi) {
		this.tglTransaksi = tglTransaksi;
	}

	public Integer getQty() {
		return qty;
	}

	public void setQty(Integer qty) {
		this.qty = qty;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public TransaksiDetailModel(Integer id, String noTransaksi, Date tglTransaksi, Integer qty, Product product) {
		super();
		this.id = id;
		this.noTransaksi = noTransaksi;
		this.tglTransaksi = tglTransaksi;
		this.qty = qty;
		this.product = product;
	}

	public TransaksiDetailModel() {

	}

}
