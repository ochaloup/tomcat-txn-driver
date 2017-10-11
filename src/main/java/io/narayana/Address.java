package io.narayana;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "address")
public class Address {
  
	
  @Id
  private Integer id;
  private String street;
  
  /**
   * @return the id
   */
  public Integer getId() {
    return id;
  }
  /**
   * @param id the id to set
   */
  public void setId(Integer id) {
    this.id = id;
  }
  /**
   * @return the street
   */
  public String getStreet() {
    return street;
  }
  /**
   * @param street the street to set
   */
  public void setStreet(String street) {
    this.street = street;
  }
  
}
