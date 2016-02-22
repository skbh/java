package gov.nic.uwp.webservice.pojo.adaptor;

import java.util.HashMap;
import java.util.Map.Entry;

import javax.xml.bind.annotation.adapters.XmlAdapter;

public final class LinNumberAdaptor  extends XmlAdapter <LinMappable,HashMap<String, String>> {

	@Override
	public LinMappable marshal(HashMap<String, String> arg0)
			throws Exception {
		LinMappable linMappable=new LinMappable();
		 for(Entry<String, String> entry : arg0.entrySet()) {
			 LinNumber linNumber = new LinNumber();
			 linNumber.linNumber = entry.getKey();
			 linNumber.EstablishmentName = entry.getValue();
			 linMappable.Lins.add(linNumber);
	      }
		return linMappable;
	}

	@Override
	public HashMap<String, String> unmarshal(LinMappable arg0)
			throws Exception {
		HashMap<String, String> hashMap = new HashMap<String, String>();
	      for(LinNumber myEntryType : arg0.Lins) {
	         hashMap.put(myEntryType.linNumber, myEntryType.EstablishmentName);
	      }
	      return hashMap;
	
	} 

}
