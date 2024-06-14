package uv.mx.rest;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.XMLGregorianCalendar;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.stereotype.Service;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

import xx.mx.uv.consumo.wsdl.AgregarProductoAlCarritoResponse;
import xx.mx.uv.consumo.wsdl.GenerarOrdenCompraRequest;
import xx.mx.uv.consumo.wsdl.GenerarOrdenCompraResponse;
import xx.mx.uv.consumo.wsdl.SeguimientoCompraRequest;
import xx.mx.uv.consumo.wsdl.SeguimientoCompraResponse;
import xx.mx.uv.consumo.wsdl.AgregarProductoAlCarritoRequest;

@Service
@Configuration
public class ClaseCliente extends WebServiceGatewaySupport {
    private static final String URI = "https://webservice-compras-production.up.railway.app/ws/compras.wsdl";

    @Bean
    public Jaxb2Marshaller marshaller() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setContextPath("xx.mx.uv.consumo.wsdl");
        return marshaller;
    }

    @Bean
    public ClaseCliente cliente(Jaxb2Marshaller marshaller) {
        ClaseCliente client = new ClaseCliente();
        client.setDefaultUri(URI);
        client.setMarshaller(marshaller);
        client.setUnmarshaller(marshaller);
        return client;
    }

    public AgregarProductoAlCarritoResponse agregarProductos(int id, int cantidad) {
        AgregarProductoAlCarritoRequest request = new AgregarProductoAlCarritoRequest();
        request.setProductoId(id);
        request.setCantidad(cantidad);
        return (AgregarProductoAlCarritoResponse) getWebServiceTemplate()
                .marshalSendAndReceive(URI, request,
                        new SoapActionCallback("http://tempuri.org/AgregarProductoAlCarritoRequest"));
    }

    public GenerarOrdenCompraResponse ordenCompra(int id, String cliente, String fecha)
            throws DatatypeConfigurationException {
        GenerarOrdenCompraRequest request = new GenerarOrdenCompraRequest();
        request.setIdCarritoque(id);
        request.setCliente(cliente);
        XMLGregorianCalendar xmlFecha = DateUtil.toXMLGregorianCalendar(fecha);
        request.setFechaOrden(xmlFecha);
        return (GenerarOrdenCompraResponse) getWebServiceTemplate()
                .marshalSendAndReceive(URI, request,
                        new SoapActionCallback("http://tempuri.org/GenerarOrdenCompraRequest"));
    }

    public GenerarOrdenCompraResponse generarOrden(int id, String cliente, String fecha)
            throws DatatypeConfigurationException {
        GenerarOrdenCompraRequest request = new GenerarOrdenCompraRequest();
        request.setIdCarritoque(id);
        request.setCliente(cliente);
        XMLGregorianCalendar xmlFecha = DateUtil.toXMLGregorianCalendar(fecha);
        request.setFechaOrden(xmlFecha);
        return (GenerarOrdenCompraResponse) getWebServiceTemplate()
                .marshalSendAndReceive(URI, request,
                        new SoapActionCallback("http://tempuri.org/GenerarOrdenCompraRequest"));
    }

    public SeguimientoCompraResponse seguimiento(int id) {
        SeguimientoCompraRequest request = new SeguimientoCompraRequest();
        request.setIdOrden(id);
        return (SeguimientoCompraResponse) getWebServiceTemplate().marshalSendAndReceive(
                URI, request,
                new SoapActionCallback("http://tempuri.org/SeguimientoCompraRequest"));
    }
}
