import java.awt.*;
import java.io.*;
import java.awt.image.*;
import javax.imageio.ImageIO;

public class StickerBuild {
    /**
     * 
     */
    public void cria(InputStream inputStream,String nomeArquivo) throws Exception{
        // leitura da imagem
        //InputStream inputStream = new URL("https://m.media-amazon.com/images/M/MV5BN2EyZjM3NzUtNWUzMi00MTgxLWI0NTctMzY4M2VlOTdjZWRiXkEyXkFqcGdeQXVyNDUzOTQ5MjY@._V1_UX128_CR0,3,128,176_AL_.jpg").openStream();
        //InputStream inputStream = new FileInputStream(new File("entrada/TopMovies_1.jpg"));
        var imagemOriginal = ImageIO.read(inputStream);
        // criar nova imagem em memória com transparência e com tamanho novo
        int largura = imagemOriginal.getWidth();
        int altura = imagemOriginal.getHeight();
        int novaAltura = altura + 200;
        var novaImagem = new BufferedImage(largura,novaAltura, BufferedImage.TRANSLUCENT);
        // copiar a imagem original para novo imagem em memoria
        Graphics2D graphics = (Graphics2D) novaImagem.getGraphics();
        // escrever frase na nova imagem
        graphics.drawImage(imagemOriginal,0,0,null);

        //configurar a fonte
        var fonte = new Font(Font.SANS_SERIF,Font.BOLD,32);
        graphics.setColor(Color.MAGENTA);
        graphics.setFont(fonte);

        graphics.drawString("CHAMAA", 0, (novaAltura-16));

        //escrever a nova imagem em arquivo
        ImageIO.write(novaImagem, "png",new File("saida/" + nomeArquivo));

    }
}
