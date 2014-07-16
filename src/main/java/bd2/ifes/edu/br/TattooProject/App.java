package bd2.ifes.edu.br.TattooProject;


public class App 
{
    public static void main( String[] args )
    {
    	ImageProcessor processor = new ImageProcessor();
        System.out.println( "Carregar Banco de Imagens..." );
        processor.carregarBancoImagens();
        
        processor.realizarBusca();
        
        //openIMAJ.runSIFT();
        
        //openIMAJ.runSIFTRANSAC();
        System.out.println( "FIM!" );
    }
}
