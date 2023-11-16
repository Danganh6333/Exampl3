package dangchph33497.fpoly.example3;

public class DTO {
    public int Image;
    public String tenNhac;
    public String tenCaSi;

    public DTO(int image, String tenNhac, String tenCaSi) {
        Image = image;
        this.tenNhac = tenNhac;
        this.tenCaSi = tenCaSi;
    }

    public int getImage() {
        return Image;
    }

    public void setImage(int image) {
        Image = image;
    }

    public String getTenNhac() {
        return tenNhac;
    }

    public void setTenNhac(String tenNhac) {
        this.tenNhac = tenNhac;
    }

    public String getTenCaSi() {
        return tenCaSi;
    }

    public void setTenCaSi(String tenCaSi) {
        this.tenCaSi = tenCaSi;
    }

    public DTO() {
    }
}
