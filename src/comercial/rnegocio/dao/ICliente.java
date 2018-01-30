/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comercial.rnegocio.dao;

import comercial.rnegocio.entidades.*;
import java.util.*;

public interface ICliente {

    public int insertar(Cliente cliente) throws Exception;

    public Cliente obtener(String codigo) throws Exception;

    public ArrayList<Cliente> obtener() throws Exception;

}
