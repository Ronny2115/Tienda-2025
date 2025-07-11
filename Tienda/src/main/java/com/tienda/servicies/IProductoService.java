
package com.tienda.servicies;

import com.tienda.entities.Producto;
import java.util.List;
import java.util.Optional;


public interface IProductoService {
    public List<Producto> findAll ();
    public Producto save (Producto producto);
    public Optional <Producto> getById (Long Id);
    public Optional <Producto> delete (Long Id);     
    public Optional <Producto> update (Long Id, Producto producto);
}
