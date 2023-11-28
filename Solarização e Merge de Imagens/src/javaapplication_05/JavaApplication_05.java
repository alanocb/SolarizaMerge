package javaapplication_05;

import java.util.ArrayList;
import java.util.List;


public class JavaApplication_05 {

   
    public static void main(String[] args) {

       MeuConversorImagem conversor = new MeuConversorImagem("./imagens/vanGoghFlower.jpg");

       conversor.solarizeImage("./imagens/vanGoghFlowerSolarize.jpg");
       conversor.solarizeImage2("./imagens/vanGoghFlowerSolarize2.jpg");
       conversor.solarizeImage3("./imagens/vanGoghFlowerSolarize3.jpg");
       conversor.solarizeImagePearl("./imagens/vanGoghFlowerSolarizePearl.jpg");

       List<String> files = new ArrayList<>();
       files.add("./imagens/vanGoghFlowerSolarize.jpg");
       files.add("./imagens/vanGoghFlowerSolarize2.jpg");
       files.add("./imagens/vanGoghFlowerSolarize3.jpg");
       files.add("./imagens/vanGoghFlowerSolarizePearl.jpg");
       conversor.mergeFiles(files, "./imagens/vanGoghFlowerMerge.jpg");
         
    }
    
}
