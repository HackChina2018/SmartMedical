package cn.hachchina.nuaa.smartmedical.Bean;

/**
 * Created by Administrator on 2018/5/19.
 */

public class FileBean {
    private String path;

    public FileBean(String name) {
        this.path = name;
    }

    public String getName() {
        return path;
    }

    public void setName(String name) {
        this.path = name;
    }

    @Override
    public String toString() {
        return "File:" + path;
    }
}
