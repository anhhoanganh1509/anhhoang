package com.sakadream.test.bean;

import java.sql.Timestamp;

public class Category {
	private long categoryId;
	private String categoryName;
	private byte[] categoryImage;
	private long chaId;
	private Timestamp ngayTao;
	private String nguoiTao;
	private Timestamp ngaySua;
	private String nguoiSua;
	private int daXoa;
	private String base64Image;
	
	public Category() {
        
	}
	
	public Category(long categoryId, String categoryName, byte[] categoryImage, long chaId, Timestamp ngayTao,
			String nguoiTao, Timestamp ngaySua, String nguoiSua, int daXoa, String base64Image) {
		this.categoryId = categoryId;
		this.categoryName = categoryName;
		this.categoryImage = categoryImage;
		this.chaId = chaId;
		this.ngayTao = ngayTao;
		this.nguoiTao = nguoiTao;
		this.ngaySua = ngaySua;
		this.nguoiSua = nguoiSua;
		this.daXoa = daXoa;
		this.base64Image = base64Image;
	}
	
	public long getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(long categoryId) {
		this.categoryId = categoryId;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public byte[] getCategoryImage() {
		return categoryImage;
	}
	public void setCategoryImage(byte[] categoryImage) {
		this.categoryImage = categoryImage;
	}
	public long getChaId() {
		return chaId;
	}
	public void setChaId(long chaId) {
		this.chaId = chaId;
	}
	public Timestamp getNgayTao() {
		return ngayTao;
	}
	public void setNgayTao(Timestamp ngayTao) {
		this.ngayTao = ngayTao;
	}
	public String getNguoiTao() {
		return nguoiTao;
	}
	public void setNguoiTao(String nguoiTao) {
		this.nguoiTao = nguoiTao;
	}
	public Timestamp getNgaySua() {
		return ngaySua;
	}
	public void setNgaySua(Timestamp ngaySua) {
		this.ngaySua = ngaySua;
	}
	public String getNguoiSua() {
		return nguoiSua;
	}
	public void setNguoiSua(String nguoiSua) {
		this.nguoiSua = nguoiSua;
	}
	public int getDaXoa() {
		return daXoa;
	}
	public void setDaXoa(int daXoa) {
		this.daXoa = daXoa;
	}
	public String getBase64Image() {
		return base64Image;
	}
	public void setBase64Image(String base64Image) {
		this.base64Image = base64Image;
	}
	
}
