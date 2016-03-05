package gov.nic.uwp.webservice.pojo.adaptor;


import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="Lins")
public class LinNumber {
	@XmlAttribute String linNumber;
	@XmlAttribute String EstablishmentName;
	

}
