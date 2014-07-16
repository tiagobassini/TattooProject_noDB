/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bd2.ifes.edu.br.TattooProject;



import com.thoughtworks.xstream.converters.basic.DateConverter;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.jfree.data.time.SimpleTimePeriod;
import org.openimaj.feature.local.list.LocalFeatureList;
import org.openimaj.feature.local.matcher.BasicMatcher;
import org.openimaj.feature.local.matcher.LocalFeatureMatcher;
import org.openimaj.feature.local.matcher.MatchingUtilities;
import org.openimaj.feature.local.matcher.consistent.ConsistentLocalFeatureMatcher2d;
import org.openimaj.image.DisplayUtilities;
import org.openimaj.image.ImageUtilities;
import org.openimaj.image.MBFImage;
import org.openimaj.image.colour.RGBColour;
import org.openimaj.image.feature.local.engine.DoGSIFTEngine;
import org.openimaj.image.feature.local.engine.asift.ASIFTEngine;
import org.openimaj.image.feature.local.keypoints.Keypoint;
import org.openimaj.math.geometry.point.Point2d;
import org.openimaj.math.geometry.transforms.AffineTransformModel;
import org.openimaj.math.model.fit.RANSAC;
import org.openimaj.util.pair.Pair;

/**
 *
 * @author tiago
 */
public class ImageProcessor {
    
    
    private final int INICIO =1;
    private final int FIM =17;
            
            
    
    private List<Imagem> imagens;
    
    public ImageProcessor(){
        imagens = new ArrayList();
    }
    
    
    public void carregarBancoImagens() {
        
        try{
            
            ThreadGroup threadPool = new ThreadGroup("imageExtractors");
            
            for(int i=INICIO;i<FIM;i++){
                
                ImageExtractorThread imageExtractorThread = new ImageExtractorThread(threadPool,imagens,""+i);
                imageExtractorThread.start();
                
            }
            
            while(threadPool.activeCount()>0){
                //aguarda 2 segundos e verifica novamente o numero de threads ativas;
                Thread.sleep(2000);
                //System.out.println("Numero de Threads Ativas: "+threadPool.activeCount());
            }
            
            System.out.println("Concluido!!");
        
        }
        catch(Exception e){
            System.out.println("Erro: "+e.getMessage());
        }
        
    }

    private void buscarImage(int img){
        try{
          
            ImageMatcherThread imageMatcherThread = new ImageMatcherThread(imagens, ""+img);
            imageMatcherThread.start();
            
        }
        catch(Exception e){
            System.out.println("ERRO! "+e.getMessage());
        }
    }
    
    
    public void realizarBusca(){
        int opcao;
        
        
        //ThreadGroup threadPool = new ThreadGroup("imageExtractors");
            
        
        for(int i=17;i<33;i++){
            opcao=i;
            System.out.print(i+" ");
            /*
            do{
                System.out.print("Numero da Imagem [17-32]\n ou -1 para sair: ");
                Scanner scanner = new Scanner(System.in);
                opcao = scanner.nextInt();
                if(opcao==-1)
                    break;
            }while(opcao<17||opcao>32);
            
            if(opcao==-1)
                    break;
            */
            buscarImage(opcao);
            
        }
        
    }
    
    
}
