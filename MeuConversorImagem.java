package javaapplication_05;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.imageio.IIOImage;
import javax.imageio.ImageIO;
import javax.imageio.ImageWriteParam;
import javax.imageio.ImageWriter;
import javax.imageio.stream.ImageOutputStream;

public class MeuConversorImagem extends ConversorImagemAED{

    public MeuConversorImagem(String urlImagemOrigem){
        super(urlImagemOrigem);
    }

    public void solarizeImage(String urlImagemDestino) {
        try {
         
            // Criar nova imagem buffered 
            BufferedImage solarizedImage = new BufferedImage(imagem.getWidth(), imagem.getHeight(), BufferedImage.TYPE_INT_RGB);
    
            // Iterar sobre cada pixel da imagem
            for (int y = 0; y < imagem.getHeight(); y++) {
                for (int x = 0; x < imagem.getWidth(); x++) {
                    // Extrair os valores r,g,b dos pixeis
                    int rgb = imagem.getRGB(x, y);
                    int r = (rgb >> 16) & 0xFF;
                    int g = (rgb >> 8) & 0xFF;
                    int b = rgb & 0xFF;
    
                    // Calcular a media dos valores r,g,b
                    int avg = (r + g + b) / 3;
    
                    // Aplicar o efeito
                    if (avg > 128) {
                        r = 255 - r;
                        g = 255 - g;
                        b = 255 - b;
                    } else {
                        r = 0;
                        g = 0;
                        b = 0;
                    }
                    
    
                    // Defenir os novos valores do pixel
                    int newRgb = (r << 16) | (g << 8) | b;
                    solarizedImage.setRGB(x, y, newRgb);
                }
            }
    
            // Guardar
            ImageIO.write(solarizedImage, "jpg", new File(urlImagemDestino));
    
            System.out.println("Imagem solarized sucesso!");
    
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    
    public void solarizeImage2(String urlImagemDestino) {
        try {
             
            
            BufferedImage solarizedImage = new BufferedImage(imagem.getWidth(), imagem.getHeight(), BufferedImage.TYPE_INT_RGB);
    
            
            for (int y = 0; y < imagem.getHeight(); y++) {
                for (int x = 0; x < imagem.getWidth(); x++) {
                    
                    int rgb = imagem.getRGB(x, y);
                    int r = (rgb >> 16) & 0xFF;
                    int g = (rgb >> 8) & 0xFF;
                    int b = rgb & 0xFF;
    
                   
                    int avg = (r + g + b) / 3;
    
                    // Neste efeio solarizeImage2 sera media < 128
                    // Anterior o efeito era media > 128
                    if (avg < 128) {
                        r = 255 - r;
                        g = 255 - g;
                        b = 255 - b;
                    } else {
                        r = 0;
                        g = 0;
                        b = 0;
                    }
                    
    
                   
                    int newRgb = (r << 16) | (g << 8) | b;
                    solarizedImage.setRGB(x, y, newRgb);
                }
            }
    
            
            ImageIO.write(solarizedImage, "jpg", new File(urlImagemDestino));
    
            System.out.println("Imagem solarized 2 sucesso!");
    
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }


    public void solarizeImage3(String urlImagemDestino) {
        try {
            
    
            
            BufferedImage solarizedImage = new BufferedImage(imagem.getWidth(), imagem.getHeight(), BufferedImage.TYPE_INT_RGB);
    
            
            for (int y = 0; y < imagem.getHeight(); y++) {
                for (int x = 0; x < imagem.getWidth(); x++) {
                    
                    int rgb = imagem.getRGB(x, y);
                    int r = (rgb >> 16) & 0xFF;
                    int g = (rgb >> 8) & 0xFF;
                    int b = rgb & 0xFF;
    
                  
                    int avg = (r + g + b) / 3;
    
                    
                    if (avg < 128) {
                        r = (int) (r * 1.5);
                        g = (int) (g * 1.5);
                        b = (int) (b * 1.5);
                    } else {
                        r = (int) (255 - (255 - r) * 1.5);
                        g = (int) (255 - (255 - g) * 1.5);
                        b = (int) (255 - (255 - b) * 1.5);
                    }
    
                    //  Valores de cor entre 0-255
                    r = Math.min(255, Math.max(0, r));
                    g = Math.min(255, Math.max(0, g));
                    b = Math.min(255, Math.max(0, b));
    
                    // Definir os novos valores do pixel
                    int newRgb = (r << 16) | (g << 8) | b;
                    solarizedImage.setRGB(x, y, newRgb);
                }
            }
    
            
            ImageIO.write(solarizedImage, "jpg", new File(urlImagemDestino));
    
            System.out.println("Imagem solarized 3 successfully!");
    
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void solarizeImagePearl(String urlImagemDestino) {
        try {

            
            BufferedImage solarizedImage = new BufferedImage(imagem.getWidth(), imagem.getHeight(), BufferedImage.TYPE_INT_RGB);
            
            
            for (int y = 0; y < imagem.getHeight(); y++) {
                for (int x = 0; x < imagem.getWidth(); x++) {
                    
                    
                    int rgb = imagem.getRGB(x, y);
                    int r = (rgb >> 16) & 0xFF;
                    int g = (rgb >> 8) & 0xFF;
                    int b = rgb & 0xFF;
                    
                    // Aplica o efeito de solarização perolado
                    if (r < 128) {
                        r = 255 - r;
                    }
                    if (g < 128) {
                        g = 255 - g;
                    }
                    if (b < 128) {
                        b = 255 - b;
                    }

                    int newRgb = (r << 16) | (g << 8) | b;

                    solarizedImage.setRGB(x, y, newRgb);
                }
            }
            ImageIO.write(solarizedImage, "jpg", new File(urlImagemDestino));
            System.out.println("Imagem solarized pearl sucesso!");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    
    void mergeFiles(List<String> files, String fileName) {
        
        int heightTotal = 0;
        int maxWidth = 100;

        List<BufferedImage> images = new ArrayList<>();
        try {
            for (String file : files) {
                BufferedImage image = ImageIO.read(new File(file));
                images.add(image);
            }


        for (BufferedImage bufferedImage : images) {
            heightTotal += bufferedImage.getHeight();
            if (bufferedImage.getWidth() > maxWidth) {
                maxWidth = bufferedImage.getWidth();
            }
        }


        int heightCurr = 0;
        BufferedImage concatImage = new BufferedImage(maxWidth, heightTotal, BufferedImage.TYPE_INT_RGB);
        Graphics2D g2d = concatImage.createGraphics();
        for (BufferedImage bufferedImage : images) {
            g2d.drawImage(bufferedImage, 0, heightCurr, null);
            heightCurr += bufferedImage.getHeight();
        }

        File compressedImageFile = new File(fileName);
        OutputStream outputStream = new FileOutputStream(compressedImageFile);

        float imageQuality = 0.7f;
        Iterator<ImageWriter> imageWriters = ImageIO.getImageWritersByFormatName("jpeg");

        if (!imageWriters.hasNext())
            throw new IllegalStateException("Writers Not Found!!");

        ImageWriter imageWriter = imageWriters.next();
        ImageOutputStream imageOutputStream = ImageIO.createImageOutputStream(outputStream);
        imageWriter.setOutput(imageOutputStream);

        ImageWriteParam imageWriteParam = imageWriter.getDefaultWriteParam();

        //Set the compress quality metrics
        imageWriteParam.setCompressionMode(ImageWriteParam.MODE_EXPLICIT);
        imageWriteParam.setCompressionQuality(imageQuality);

        //Criar imagem
        imageWriter.write(null, new IIOImage(concatImage, null, null), imageWriteParam);

        //fechar
        outputStream.close();
        imageOutputStream.close();
        imageWriter.dispose();
            } catch (IOException e) {
              throw new RuntimeException(e);
        }
    }  

    
}
