package com.gymmanagement.dto;

import org.springframework.beans.BeanUtils;
import org.springframework.web.multipart.MultipartFile;

import com.gymmanagement.entity.Trainer;

public class AddTrainerRequestDto {
	
    private String name;
	
	private int age;
	
	private String emailId;
	
	private String contact;

	private String address;
	
	private int experience;
	
	private String password;
	
	private MultipartFile pic;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getExperience() {
		return experience;
	}

	public void setExperience(int experience) {
		this.experience = experience;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public MultipartFile getPic() {
		return pic;
	}

	public void setPic(MultipartFile pic) {
		this.pic = pic;
	}
	
	public static Trainer toEntity(AddTrainerRequestDto dto) {
		Trainer entity=new Trainer();
		BeanUtils.copyProperties(dto, entity, "pic");		
		return entity;
	}

	@Override
	public String toString() {
		return "AddTrainerRequestDto [name=" + name + ", age=" + age + ", emailId=" + emailId + ", contact=" + contact
				+ ", address=" + address + ", experience=" + experience + ", password=" + password + "]";
	}
	
}
