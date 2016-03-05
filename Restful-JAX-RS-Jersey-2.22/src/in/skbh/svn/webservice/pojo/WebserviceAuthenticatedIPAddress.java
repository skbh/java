package in.skbh.svn.webservice.pojo;

import java.io.Serializable;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Cacheable
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@Table(name="ebiz.webservice_authenticated_ip_address")
public class WebserviceAuthenticatedIPAddress  implements Serializable{
		
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer Id;
	
	@Column(name="ip_address")
	private String ipAddress;
	
	@Column(name="active_or_inactive_status")
	private Boolean  activeOrInactiveStatus;
	
	@Column(name="ip_identification_organization_detail")
	private String ipIdentificationOrganizationDetail;
	
	@Column(name="ip_location")
	private String ipLocation;
	
	@Column(name="latitude")
	private String latitude;
	
	@Column(name="longitude")
	private String longitude;
	
	

	public WebserviceAuthenticatedIPAddress() {
	
	}

	public Integer getId() {
		return Id;
	}

	public void setId(Integer id) {
		Id = id;
	}

	public String getIpAddress() {
		return ipAddress;
	}

	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}

	public Boolean getActiveOrInactiveStatus() {
		return activeOrInactiveStatus;
	}

	public void setActiveOrInactiveStatus(Boolean activeOrInactiveStatus) {
		this.activeOrInactiveStatus = activeOrInactiveStatus;
	}

	public String getIpIdentificationOrganizationDetail() {
		return ipIdentificationOrganizationDetail;
	}

	public void setIpIdentificationOrganizationDetail(
			String ipIdentificationOrganizationDetail) {
		this.ipIdentificationOrganizationDetail = ipIdentificationOrganizationDetail;
	}

	public String getIpLocation() {
		return ipLocation;
	}

	public void setIpLocation(String ipLocation) {
		this.ipLocation = ipLocation;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
	

	
}
