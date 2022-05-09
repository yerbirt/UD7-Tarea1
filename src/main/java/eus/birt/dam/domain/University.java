package eus.birt.dam.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="university")
public class University implements Serializable{

private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	
	private String city;
	
	private String addressLine1;
	
	private String addressLine2;
	
	private String zipCode;
	
	@JsonManagedReference
	@OneToMany
	@JoinColumn (name= "university_id")
	List <Student> students = new ArrayList<>();
	
	public University(String name, String city, String addressLine1, String addressLine2, String zipCode) {
		super();
		this.name = name;
		this.city = city;
		this.addressLine1 = addressLine1;
		this.addressLine2 = addressLine2;
		this.zipCode = zipCode;
	}
}
