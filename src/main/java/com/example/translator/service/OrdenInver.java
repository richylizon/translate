package com.example.translator.service;



import org.springframework.stereotype.Service;

import java.io.*;

import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.function.BinaryOperator;

@Service
public class OrdenInver implements OrdenInvServ {

    @Override
    public ArrayList<String> LeerArchivo() throws IOException {
        ArrayList<String> result = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("src/main/resources/static/Original.txt"))) {
            while (br.ready()) {
                result.add(br.readLine());
            }
        }
        Collections.reverse(result);
        return result;
    }

    @Override
    public FileOutputStream CopiarArchivo() throws IOException {
        Path out = Paths.get("src/main/resources/static/estrofasEnOrdenInverso.txt");
        List<String> result = LeerArchivo();
        Files.write(out, result, Charset.defaultCharset());
        return (FileOutputStream) out;
    }

    @Override
    public List<String> Cambio() throws IOException {
        List<String> result = LeerArchivo();
        String maxOccurredElement = result.stream()
                .reduce(BinaryOperator.maxBy((o1, o2) -> Collections.frequency(result, o1) -
                        Collections.frequency(result, o2))).orElse(null);
        //System.out.println(maxOccurredElement);
        Collections.replaceAll(result, maxOccurredElement, "you");
        Path out = Paths.get("src/main/resources/static/Finaloutput.txt");
        Files.write(out, result, Charset.defaultCharset());
        return result;
    }
}


