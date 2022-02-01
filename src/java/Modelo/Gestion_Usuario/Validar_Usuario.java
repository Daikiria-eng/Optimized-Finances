
package Modelo.Gestion_Usuario;

import Modelo.Usuario;


public interface Validar_Usuario {
    
        public int validar(Usuario persona);
    
        public Usuario listarID(String id);
}