package com.trademark.action;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;

public class ImageAction extends ActionSupport {

    private static final long serialVersionUID = 1L;
    byte[] imageInByte = null;
    String imagePath;

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public ImageAction() {
    }

    public String execute() {
        return SUCCESS;
    }

    public byte[] getCustomImageInBytes() throws IOException {

        BufferedImage originalImage;
        try {
            originalImage = ImageIO.read(getImageFile(this.imagePath));
            // convert BufferedImage to byte array
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ImageIO.write(originalImage, "jpeg", baos);
            baos.flush();
            imageInByte = baos.toByteArray();
            baos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        HttpServletResponse response = ServletActionContext.getResponse();

        response.setContentType("image/jpeg");
        response.getOutputStream().write(imageInByte);
        response.getOutputStream().flush();

        return imageInByte;
    }

    private File getImageFile(String imgPath) {
        File file = new File(imgPath);
        return file;
    }


}
