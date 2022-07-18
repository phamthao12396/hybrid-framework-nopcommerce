package javaOOP;

public class Topic_01_Sinh_Vien {
	private int maSinhVien;
	private String hoTen;
	private float diemLyThuyet, diemThucHanh;
	public static final int DIEMTB = 0;

	protected Topic_01_Sinh_Vien() {
		super();
	}

	protected Topic_01_Sinh_Vien(int maSinhVien, String hoTen, float diemLyThuyet, float diemThucHanh) {
		super();
		this.maSinhVien = maSinhVien;
		this.hoTen = hoTen;
		this.diemLyThuyet = diemLyThuyet;
		this.diemThucHanh = diemThucHanh;
	}

	public int getMaSinhVien() {
		return maSinhVien;
	}

	public void setMaSinhVien(int maSinhVien) {
		this.maSinhVien = maSinhVien;
	}

	public String getHoTen() {
		return hoTen;
	}

	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}

	public float getDiemLyThuyet() {
		return diemLyThuyet;
	}

	public void setDiemLyThuyet(float diemLyThuyet) {
		this.diemLyThuyet = diemLyThuyet;
	}

	public float getDiemThucHanh() {
		return diemThucHanh;
	}

	public void setDiemThucHanh(float diemThucHanh) {
		this.diemThucHanh = diemThucHanh;
	}

	public float diemTrungBinh() {
		float diemTB = (diemLyThuyet + diemThucHanh * 2) / 3;
		return diemTB;
	}

	public void showSV() {
		System.out.println("Ma SV: " + getMaSinhVien());
		System.out.println("Name: " + getHoTen());
		System.out.println("DIEM TB: " + diemTrungBinh());
	}

	public static void main(String[] args) {
		Topic_01_Sinh_Vien sv1 = new Topic_01_Sinh_Vien(01, "Thao", 5.5f, 7.5f);
		Topic_01_Sinh_Vien sv2 = new Topic_01_Sinh_Vien(02, "Thu", 6.5f, 8.5f);
		Topic_01_Sinh_Vien sv3 = new Topic_01_Sinh_Vien(03, "Thuong", 7.5f, 9.5f);
		sv1.showSV();
		sv2.showSV();
		sv3.showSV();
	}
}
