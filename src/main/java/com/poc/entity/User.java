package com.poc.entity;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Past;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Pattern;

import org.hibernate.annotations.ColumnDefault;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "user")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int user_id;
	
	@NotBlank(message = "Please Enter Valid First Name")
	@Pattern(regexp = "^[A-Za-z]*$", message = "Please Enter First Name")
	private String first_name;
	
	@Pattern(regexp = "^[A-Za-z]*$", message = "Please Enter Middle Name")
	private String middle_name;
	
	@NotBlank(message = "Please Enter Valid Last Name")
	@Pattern(regexp = "^[A-Za-z]*$", message = "Please Enter Valid Last Name")
	private String last_name;
	
	@Pattern(regexp = "^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$", message = "Please Enter Valid Email")
	@NotBlank(message = "Please Enter Valid Email")
	private String email;
	
	@NotBlank(message = "Please Select Gender")
	private String gender;
	@Past(message = "Select Valid Date of Birth")
	private Date dob;
	
	@Column(name = "joining_date")
	@PastOrPresent(message = "Select Valid Date of Joining")
	private Date doj;
	
	@Pattern(regexp = "^[6-9]\\d{9}$", message = "Please Enter Valid Mobile Number")
	@NotBlank(message = "Please Enter Valid Mobile Number")
	private String mobile_no;
	
	@Pattern(regexp = "^[A-Za-z]*$", message = "Please Enter Valid Country")
	@NotBlank(message = "Please Enter Valid Country")
	private String country;
	
	@Pattern(regexp = "^[A-Za-z]*$", message = "Please Enter Valid State")
	@NotBlank(message = "Please Enter Valid State")
	private String state;
	
	@Pattern(regexp = "^[A-Za-z]*$", message = "Please Enter Valid City")
	@NotBlank(message = "Please Enter Valid City")
	private String city;
	
	@Pattern(regexp = "^[1-9][0-9]{5}$", message = "Please Enter Valid PinCode")
	@NotBlank(message = "Please Enter Valid PinCode")
	private String pincode;
	
	@ColumnDefault(value = "0")
	private boolean deleted;

	
	

}
