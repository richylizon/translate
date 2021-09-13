package com.example.translator.controller;


import com.example.translator.service.OrdenInver;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/inverso")
public class OrdenController {


    OrdenInver ordenInver = new OrdenInver();

    @GetMapping("/leer")
    public ArrayList<String> LeerArchivo() throws IOException {
        return ordenInver.LeerArchivo();
    }

    @GetMapping("/copiado")
    public FileOutputStream CopiarArchivo() throws IOException{
        return ordenInver.CopiarArchivo();
    }

    @GetMapping("/cambio")
    public List<String> Cambio() throws IOException{
        return ordenInver.Cambio() ;
    }

}