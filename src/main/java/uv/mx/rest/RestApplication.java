package uv.mx.rest;

import javax.xml.datatype.DatatypeConfigurationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import xx.mx.uv.consumo.wsdl.AgregarProductoAlCarritoResponse;
import xx.mx.uv.consumo.wsdl.GenerarOrdenCompraResponse;
import xx.mx.uv.consumo.wsdl.SeguimientoCompraResponse;

@RestController
@SpringBootApplication
public class RestApplication {

    @Autowired
    private ClaseCliente cliente;

    public static void main(String[] args) {
        SpringApplication.run(RestApplication.class, args);
    }

    @RequestMapping(value = "/api/agregarProducto/{id}/{cantidad}", produces = MediaType.APPLICATION_JSON_VALUE)
    public AgregarProductoAlCarritoResponse agregar(@PathVariable int id, @PathVariable int cantidad) {
        return cliente.agregarProductos(id, cantidad);
    }

    @RequestMapping(value = "/api/generarOrden/{id}/{tutor}/{fecha}", produces = MediaType.APPLICATION_JSON_VALUE)
    public GenerarOrdenCompraResponse generar(@PathVariable int id, @PathVariable String tutor,
            @PathVariable String fecha) throws DatatypeConfigurationException {
        return cliente.generarOrden(id, tutor, fecha);
    }

    @RequestMapping(value = "/api/seguimiento/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public SeguimientoCompraResponse seguimiento(@PathVariable int id) {
        return cliente.seguimiento(id);
    }
}