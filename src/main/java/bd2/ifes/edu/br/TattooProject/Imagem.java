/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bd2.ifes.edu.br.TattooProject;

import org.openimaj.feature.local.list.LocalFeatureList;
import org.openimaj.image.feature.local.keypoints.Keypoint;

/**
 *
 * @author Bassini
 */
public class Imagem {
    
    String imgName;
    LocalFeatureList<Keypoint> keypoint;
    
    public Imagem(){
        
    }
    
    public Imagem(String nome, LocalFeatureList<Keypoint> pontos){
        this.imgName = nome;
        this.keypoint = pontos;
    }
    
    
    public String getImgName() {
        return imgName;
    }

    public void setImgName(String imgName) {
        this.imgName = imgName;
    }

    public LocalFeatureList<Keypoint> getKeypoint() {
        return keypoint;
    }

    public void setKeypoint(LocalFeatureList<Keypoint> keypoint) {
        this.keypoint = keypoint;
    }
    
    
    
    
}
