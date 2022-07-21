import java.io.InputStream;
import java.net.URL;
import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {

        //String url = "https://alura-imdb-api.herokuapp.com/movies";
        String url = "https://raw.githubusercontent.com/alura-cursos/imersao-java/api/NASA-APOD.json";
        var http = new ClienteHTTP();
        String json = http.buscaDados(url);

        ExtratorDeConteudoDaNasa extrator = new ExtratorDeConteudoDaNasa();
        List<conteudo> conteudos = extrator.extraiConteudos(json);

        var geradora = new StickerBuild();

        for (int i = 0; i < 10; i++) {

            conteudo conteudo = conteudos.get(i);
            String titulo = conteudo.getTitulo();
            String nomeArquivo = titulo + ".png";
            InputStream inputStream = new URL(conteudo.getUrlImagem()).openStream();
            geradora.cria(inputStream,nomeArquivo);

            System.out.println(conteudo.getTitulo());
            System.out.println();

        }
    }
}
