package TI.rabbitmq.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Pedido {
	String updateExistingContact;
	String userContactID;
	List<CustomAttributeList> customAttributeList;

	@JsonProperty("userContactID")
	public String getUserContactID() {
		return this.userContactID;
	}

	public void setUserContactID(String userContactID) {
		this.userContactID = userContactID;
	}

	@JsonProperty("updateExistingContact")
	public String getUpdateExistingContact() {
		return this.updateExistingContact;
	}

	public void setUpdateExistingContact(String updateExistingContact) {
		this.updateExistingContact = updateExistingContact;
	}

	@JsonProperty("customAttributeList")
	public List<CustomAttributeList> getCustomAttributeList() {
		return this.customAttributeList;
	}

	public void setCustomAttributeList(List<CustomAttributeList> customAttributeList) {
		this.customAttributeList = customAttributeList;
	}

	@Override
	public String toString() {
		return "{ \"userContactID\" : " + "\"" + userContactID + "\"" + ", \"updateExistingContact\" : " + "\""
				+ updateExistingContact + "\"" + ", \"customAttributeList\":" + customAttributeList + "}";
	}

}
