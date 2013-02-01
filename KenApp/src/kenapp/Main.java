/**
 * Copyright (c) 2010 princehaku
 * All right reserved.
 */
package kenapp;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author princehaku
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {

        int imgname = 0;
        String name = "";

        FileOutputStream of = new FileOutputStream("apple-data.txt",true);
        
        String imgbuff = "";

        for (imgname = 0; imgname < 380; imgname++) {

            for (int nimg = 0; nimg <= 9; nimg++) {
                name = String.format("%1$04d", imgname*10+nimg);
                System.out.println("图片" + name);
                File imageFile = new File("C:\\Users\\princehaku\\Desktop\\badapp\\badapp00" + name + ".png");
                BufferedImage img = ImageIO.read(imageFile);
                int colorpix = 0;
                //图片开始读取
                int pos=imgname*10+nimg;
                imgbuff="pic["+pos+"]=\"";
                for (int y = 0; y < 24; y++) {
                    for (int x = 0; x < 32; x++) {
                        colorpix = img.getRGB(x, y);
                        //1是黑色..其他是0
                        if (colorpix == -16777216) {
                            //System.out.print("*");
                            imgbuff = imgbuff + "1";
                        } else {
                            //System.out.print(" ");
                            imgbuff = imgbuff + " ";
                        }
                    }
                    //imgbuff = imgbuff + "\r\n";
                    //System.out.println("\r");
                }
                //一张图片结束
                //System.out.println("\r");
                imgbuff = imgbuff + "\";\r\n";
                of.write(imgbuff.getBytes());
            }
            imgbuff="";
        }
        System.out.println("\r\n处理结束");
    }
}
