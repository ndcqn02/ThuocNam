package com.example.studentmanagementfirebase;

public class ThuocNam {

    private String tenKhoaHoc, tenThuongGoi, dacTinh, mauLa, congDung, duocTinh, chuY, hinhAnh;

    public ThuocNam(String tenKhoaHoc, String tenThuongGoi, String dacTinh, String mauLa, String congDung, String duocTinh, String chuY, String hinhAnh) {
        this.tenKhoaHoc = tenKhoaHoc;
        this.tenThuongGoi = tenThuongGoi;
        this.dacTinh = dacTinh;
        this.mauLa = mauLa;
        this.congDung = congDung;
        this.duocTinh = duocTinh;
        this.chuY = chuY;
        this.hinhAnh = hinhAnh;
    }

    public ThuocNam() {
    }

    public String getTenKhoaHoc() {
        return tenKhoaHoc;
    }

    public void setTenKhoaHoc(String tenKhoaHoc) {
        this.tenKhoaHoc = tenKhoaHoc;
    }

    public String getTenThuongGoi() {
        return tenThuongGoi;
    }

    public void setTenThuongGoi(String tenThuongGoi) {
        this.tenThuongGoi = tenThuongGoi;
    }

    public String getDacTinh() {
        return dacTinh;
    }

    public void setDacTinh(String dacTinh) {
        this.dacTinh = dacTinh;
    }

    public String getMauLa() {
        return mauLa;
    }

    public void setMauLa(String mauLa) {
        this.mauLa = mauLa;
    }

    public String getCongDung() {
        return congDung;
    }

    public void setCongDung(String congDung) {
        this.congDung = congDung;
    }

    public String getDuocTinh() {
        return duocTinh;
    }

    public void setDuocTinh(String duocTinh) {
        this.duocTinh = duocTinh;
    }

    public String getChuY() {
        return chuY;
    }

    public void setChuY(String chuY) {
        this.chuY = chuY;
    }

    public String getHinhAnh() {
        return hinhAnh;
    }

    public void setHinhAnh(String hinhAnh) {
        this.hinhAnh = hinhAnh;
    }
}

