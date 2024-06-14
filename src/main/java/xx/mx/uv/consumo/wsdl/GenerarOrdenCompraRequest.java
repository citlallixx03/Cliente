
package xx.mx.uv.consumo.wsdl;

import javax.xml.datatype.XMLGregorianCalendar;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlSchemaType;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para anonymous complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="idCarritoque" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="cliente" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="fechaOrden" type="{http://www.w3.org/2001/XMLSchema}date"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "idCarritoque",
    "cliente",
    "fechaOrden"
})
@XmlRootElement(name = "GenerarOrdenCompraRequest")
public class GenerarOrdenCompraRequest {

    protected int idCarritoque;
    @XmlElement(required = true)
    protected String cliente;
    @XmlElement(required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar fechaOrden;

    /**
     * Obtiene el valor de la propiedad idCarritoque.
     * 
     */
    public int getIdCarritoque() {
        return idCarritoque;
    }

    /**
     * Define el valor de la propiedad idCarritoque.
     * 
     */
    public void setIdCarritoque(int value) {
        this.idCarritoque = value;
    }

    /**
     * Obtiene el valor de la propiedad cliente.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCliente() {
        return cliente;
    }

    /**
     * Define el valor de la propiedad cliente.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCliente(String value) {
        this.cliente = value;
    }

    /**
     * Obtiene el valor de la propiedad fechaOrden.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getFechaOrden() {
        return fechaOrden;
    }

    /**
     * Define el valor de la propiedad fechaOrden.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setFechaOrden(XMLGregorianCalendar value) {
        this.fechaOrden = value;
    }

}
