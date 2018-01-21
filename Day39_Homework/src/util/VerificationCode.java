package util;
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Random;

public class VerificationCode {

        private int w = 100;
        private int h = 35;
        private Random random = new Random();
        private String[] fontNames = new String[]{"宋体", "华文楷体", "黑体", "微软雅黑", "楷体_GB2313"};
        private String resource = "23456789abcdefghjkmnopqrstuvwxyzABCDEFGHJKMNOPQRSTUVWXYZ";
        private Color bgColor = new Color(255, 255, 255);
        private String text;
        private static VerificationCode vc = new VerificationCode();

        private VerificationCode() {
        }

        public static VerificationCode getInstance() {
            return vc;
        }

        private Color randomColor() {
            int red = this.random.nextInt(150);
            int green = this.random.nextInt(150);
            int blue = this.random.nextInt(150);
            return new Color(red, green, blue);
        }

        private Font randomFont() {
            int index = this.random.nextInt(this.fontNames.length);
            int style = this.random.nextInt(4);
            int size = this.random.nextInt(5) + 24;
            return new Font(this.fontNames[index], style, size);
        }

        private void drawLine(BufferedImage image) {
            int num = 6;
            Graphics2D g2 = (Graphics2D)image.getGraphics();

            for(int i = 0; i < num; ++i) {
                int x1 = this.random.nextInt(this.w);
                int y1 = this.random.nextInt(this.h);
                int x2 = this.random.nextInt(this.w);
                int y2 = this.random.nextInt(this.h);
                g2.setStroke(new BasicStroke(1.5F));
                g2.setColor(this.randomColor());
                g2.drawLine(x1, y1, x2, y2);
            }

        }

        private char randomChar() {
            int index = this.random.nextInt(this.resource.length());
            return this.resource.charAt(index);
        }

        private BufferedImage createImage() {
            BufferedImage bi = new BufferedImage(this.w, this.h, 1);
            Graphics2D g2 = (Graphics2D)bi.getGraphics();
            g2.setColor(this.bgColor);
            g2.fillRect(0, 0, this.w, this.h);
            return bi;
        }

        public String getText() {
            return this.text;
        }

        public BufferedImage getVerifyImage() {
            BufferedImage bi = this.createImage();
            Graphics2D g2 = (Graphics2D)bi.getGraphics();
            StringBuilder sb = new StringBuilder();

            for(int i = 0; i < 6; ++i) {
                String s = this.randomChar() + "";
                sb.append(s);
                float x = (float)i * 1.0F * (float)this.w / 6.0F;
                g2.setFont(this.randomFont());
                g2.setColor(this.randomColor());
                g2.drawString(s, x, (float)(this.h - 5));
            }

            this.text = sb.toString();
            this.drawLine(bi);
            return bi;
        }

        public String output(String path) {
            try {
                this.output(this.getVerifyImage(), new FileOutputStream(path));
            } catch (IOException var3) {
                var3.printStackTrace();
            }

            return this.getText();
        }

        public String output(OutputStream os) {
            try {
                this.output(this.getVerifyImage(), os);
            } catch (IOException var3) {
                var3.printStackTrace();
            }

            return this.getText();
        }

        private void output(BufferedImage bi, OutputStream os) throws IOException {
            ImageIO.write(bi, "JPEG", os);
        }


}
