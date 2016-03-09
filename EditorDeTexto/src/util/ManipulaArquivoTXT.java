package util;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author Helio Franca
 */
public class ManipulaArquivoTXT {

    
    //Método utilizado para gravar o texto na maquina, passando como parâmetros as informações de nome do arquivo e conteúdo.
    public static boolean gravarArquivoTXT(String nomeArquivo, String conteudo) throws IOException {

        
        FileWriter fout = new FileWriter(nomeArquivo);
        PrintWriter pout = new PrintWriter(fout);

        pout.println(conteudo);

        pout.close();  
        fout.close(); 

        return true;  

    }

    //Método utilizado para abrir um arquivo de texto da maquina.
    public static String lerArquivoTXT(String nomeArquivo) throws IOException, FileNotFoundException {

        FileReader fr = new FileReader(nomeArquivo);
        BufferedReader br = new BufferedReader(fr);

        String linha = br.readLine();
        String retorno = "";

        while (linha != null) {
            retorno += linha + "\n";
            linha = br.readLine();
        }

        fr.close();
        br.close();

        return retorno;

    }
}
