package http;

import java.net.URL;
import java.net.URLConnection;
import java.util.Map;

public class JavaHttpAdapter implements HttpAdapter{

    @Override
    public void post(String url, Map<String, Object> dados) {
        // Implementação de exemplo apenas.
        try {
            URL apiUrl = new URL(url);
            URLConnection connection = apiUrl.openConnection();
            connection.connect();
            // Restante do código da requisição post...
        }
        catch (Exception e) {
            throw new RuntimeException("Erro ao enviar a requisição HTTP", e);
        }
    }

}
