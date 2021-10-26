package POTA.Estruturas;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class numerosRandomicos {

    public static void main(String[] args) throws IOException {
        File arquivo = new File("c:\\temp\\arquivo.txt");


        if (!arquivo.exists()) {
//cria um arquivo (vazio)
            arquivo.createNewFile();
        }

//caso seja um diretÃ³rio, Ã© possÃ­vel listar seus arquivos e diretÃ³rios
        File[] arquivos = arquivo.listFiles();

//escreve no arquivo
        FileWriter fw = new FileWriter(arquivo, true);

        BufferedWriter bw = new BufferedWriter(fw);
//inicializa gerador de numeros aleatÃ³rios
        Random gerador = new Random();

//gera aleatorio e grava com ;
        for (long x = 0; x < 60000; x++)
            bw.write(gerador.nextInt(65000) + ";");
        bw.newLine();

        bw.close();
        fw.close();
    }


}
