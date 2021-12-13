package TI.rabbitmq.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CustomAttributeList {
	String attributeValue;
	
	@JsonProperty("attributeName")
	public String getAttributeName() {
		return this.attributeName;
	}

	public void setAttributeName(String attributeName) {
		this.attributeName = attributeName;
	}

	String attributeName;

	@JsonProperty("attributeValue")
	public String getAttributeValue() {
		return this.attributeValue;
	}

	public void setAttributeValue(String attributeValue) {
		this.attributeValue = attributeValue;
	}

	@Override
	public String toString() {
		return "{ \"attributeValue\" :" + "\"" + attributeValue + "\"" + ",  \"attributeName\" : " +  "\"" + attributeName + "\"}";
	}
	
	
	

}
