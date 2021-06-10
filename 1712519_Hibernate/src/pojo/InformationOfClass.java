package pojo;

import java.util.Objects;

public class InformationOfClass {
    private String IDClass;
    private int TongSinhVien;
    private int TongNam;
    private int TongNu;

    public InformationOfClass() {
    }

    public InformationOfClass(String IDClass, int tongSinhVien, int tongNam, int tongNu) {
        this.IDClass = IDClass;
        TongSinhVien = tongSinhVien;
        TongNam = tongNam;
        TongNu = tongNu;
    }

    public String getIDClass() {
        return IDClass;
    }

    public void setIDClass(String IDClass) {
        this.IDClass = IDClass;
    }

    public int getTongSinhVien() {
        return TongSinhVien;
    }

    public void setTongSinhVien(int tongSinhVien) {
        TongSinhVien = tongSinhVien;
    }

    public int getTongNam() {
        return TongNam;
    }

    public void setTongNam(int tongNam) {
        TongNam = tongNam;
    }

    public int getTongNu() {
        return TongNu;
    }

    public void setTongNu(int tongNu) {
        TongNu = tongNu;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof InformationOfClass)) return false;
        InformationOfClass that = (InformationOfClass) o;
        return getTongSinhVien() == that.getTongSinhVien() && getTongNam() == that.getTongNam() && getTongNu() == that.getTongNu() && Objects.equals(getIDClass(), that.getIDClass());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getIDClass(), getTongSinhVien(), getTongNam(), getTongNu());
    }

    @Override
    public String toString() {
        return "InformationOfClass{" +
                "IDClass='" + IDClass + '\'' +
                ", TongSinhVien=" + TongSinhVien +
                ", TongNam=" + TongNam +
                ", TongNu=" + TongNu +
                '}';
    }
}
