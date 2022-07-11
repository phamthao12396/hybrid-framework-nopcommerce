package javaOOP;

public class Topic_01_Sinh_Vien {
	private int maSinhVien;
	private String hoTen;
	private float diemLyThuyet, diemThucHanh;

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

	public static float diemTrungBinh(float diemLyThuyet, float diemThucHanh) {
		float diemTB = (diemLyThuyet + diemThucHanh * 2) / 3;
		return diemTB;
	}

	public static void showSV(int maSV, String name, float diemTB) {
		System.out.println("Ma SV: " + maSV);
		System.out.println("Name: " + name);
		System.out.println("DIEM TB: " + diemTB);
	}

	public static void main(String[] args) {
		Topic_01_Sinh_Vien sv1 = new Topic_01_Sinh_Vien(01, "Thao", 5.5f, 7.5f);
		Topic_01_Sinh_Vien sv2 = new Topic_01_Sinh_Vien(02, "Thu", 6.5f, 8.5f);
		Topic_01_Sinh_Vien sv3 = new Topic_01_Sinh_Vien(03, "Thuong", 7.5f, 9.5f);
		showSV(sv1.maSinhVien, sv1.hoTen, diemTrungBinh(sv1.diemLyThuyet, sv1.diemThucHanh));
		showSV(sv2.maSinhVien, sv2.hoTen, diemTrungBinh(sv2.diemLyThuyet, sv2.diemThucHanh));
		showSV(sv3.maSinhVien, sv3.hoTen, diemTrungBinh(sv3.diemLyThuyet, sv3.diemThucHanh));
		System.out.println(" ");
	}
}
