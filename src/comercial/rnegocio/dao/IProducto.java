/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comercial.rnegocio.dao;

import comercial.rnegocio.entidades.*;
import  java.util.*;
public interface IProducto {
     public int insertar (Producto cliente) throws Exception;
  public Producto obtener(String codigo) throws Exception;
    public ArrayList<Producto> obtener () throws Exception;

   
     
}
