/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bd2.ifes.edu.br.TattooProject;

import java.io.File;
import java.util.List;
import java.util.concurrent.TimeUnit;
import static org.netlib.lapack.Dlacon.i;
import org.openimaj.feature.local.list.LocalFeatureList;
import org.openimaj.image.ImageUtilities;
import org.openimaj.image.MBFImage;
import org.openimaj.image.feature.local.engine.asift.ASIFTEngine;
import org.openimaj.image.feature.local.keypoints.Keypoint;

/**
 *
 * @author Bassini
 */
public class ImageExtractorThread extends Thread {

    List<Imagem> imagens;
    String imgNome;
    
    public ImageExtractorThread(ThreadGroup group ,List imagens, String img){
        
        super(group, "imagem "+img);
        
        this.imagens = imagens;
        this.imgNome = img;
    }
    
    
    public void run() {
        
        try{
        
            long inicioTime = System.currentTimeMillis();
                
            MBFImage image = ImageUtilities.readMBF(new File("imagens/"+imgNome+".jpg"));
            //DoGSIFTEngine engine = new DoGSIFTEngine();
            //LocalFeatureList<Keypoint> imageKeypoints = engine.findFeatures(image.flatten());
            ASIFTEngine engine = new ASIFTEngine();
            LocalFeatureList<Keypoint> imageKeypoints = engine.findKeypoints(image.flatten());
            //ColourASIFTEngine engine = new ColourASIFTEngine();
            //LocalFeatureList<Keypoint> imageKeypoints = engine.findKeypoints(image);
            
            Imagem imagem = new Imagem(imgNome, imageKeypoints);
            imagens.add(imagem);

            long finalTime = System.currentTimeMillis();

            long elapsedTime = finalTime - inicioTime;

            long segundos = TimeUnit.MILLISECONDS.toSeconds(elapsedTime);
            long resto = elapsedTime-(segundos*1000);

            System.out.println("Imagem "+imgNome+" : "+ segundos +","+resto+" segundos");
        }
        catch(Exception e){
            System.out.println("Erro Extração dos Pontos: "+e.getMessage());
        }
    }
    
    
}
