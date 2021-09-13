package com.example.translator.service;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public interface OrdenInvServ {

   public ArrayList<String> LeerArchivo() throws IOException;
   public FileOutputStream CopiarArchivo() throws IOException;
   public List<String> Cambio() throws IOException;

  // public void whenCopyInputStreamToOutputStream_thenCorrect() throws IOException;
}
