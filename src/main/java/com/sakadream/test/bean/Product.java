package com.sakadream.test.bean;

import java.sql.Timestamp;

public class Product {
	private long productId;
	private long productMa;
	private String productName;
	private byte[] productImage;
	private long sanId;
	private String productPrice;
	private String productDescription;
	private Timestamp ngayTao;
	private String nguoiTao;
	private Timestamp ngaySua;
	private String nguoiSua;
	private int daXoa;
	private String base64Image;
	private String categoryName;
	private String Name;
    private String Value;
	public Product() {
        
	}
	public Product(long productId, long productMa, String productName, byte[] productImage, long sanId,
			String productPrice, String productDescription, Timestamp ngayTao, String nguoiTao, Timestamp ngaySua,
			String nguoiSua, int daXoa, String base64Image, String categoryName) {
                
		this.productId = productId;
		this.productMa = productMa;
		this.productName = productName;
		this.productImage = productImage;
		this.sanId = sanId;
		this.productPrice = productPrice;
		this.productDescription = productDescription;
		this.ngayTao = ngayTao;
		this.nguoiTao = nguoiTao;
		this.ngaySua = ngaySua;
		this.nguoiSua = nguoiSua;
		this.daXoa = daXoa;
		this.base64Image = base64Image;
		this.categoryName = categoryName;
	}
	public long getProductId() {
		return productId;
	}
	public void setProductId(long productId) {
		this.productId = productId;
	}
	public long getProductMa() {
		return productMa;
	}
	public void setProductMa(long productMa) {
		this.productMa = productMa;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public byte[] getProductImage() {
		return productImage;
	}
	public void setProductImage(byte[] productImage) {
		this.productImage = productImage;
	}
	
	public long getSanId() {
		return sanId;
	}
	public void setSanId(long sanId) {
		this.sanId = sanId;
	}
	public String getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(String productPrice) {
		this.productPrice = productPrice;
	}
	public String getProductDescription() {
		return productDescription;
	}
	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
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
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getValue() {
		return Value;
	}
	public void setValue(String value) {
		Value = value;
	}
	
}
