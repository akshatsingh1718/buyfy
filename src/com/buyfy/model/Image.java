// model package 
package com.buyfy.model;

//Import Files Used In this Program
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/*
 * Image Entity
 */
@Entity
@Table(name = "images")
public class Image implements Serializable
{
	// serial version uid
	private static final long serialVersionUID = -1017191854960904441L;

	/* **** Image Attributes ***** */
	/* Image Primary Key (IMAGE_ID)
	 * Image Id will be Generated by Sequence Strategy  IMAGE_SQE_GEN
	 * */
	@Id
	@Column(name = "image_id")
	@GeneratedValue(strategy = GenerationType.AUTO)	
	private long id;
	
	//variable for photo name
	@Column(name="Photo_Name")
	private String name;
	
	//variable for photo path
	@Column(name="Photo_Path")
	private String path;
	
	// No Argument Image Constructor
	public Image()  {}

	// Parameterized Image Constructor
	public Image(String name, String path) {
		super();
		this.name = name;
		this.path = path;
	}

	/*
	 * Image Getters and Setters 
	 */
	// getter for id
	public long getId() {
		return id;
	}

	// setter for id
	public void setId(long id) {
		this.id = id;
	}

	// getter for image name
	public String getName() {
		return name;
	}

	// setter for image name
	public void setName(String name) {
		this.name = name;
	}

	// getter for image path
	public String getPath() {
		return path;
	}

	// setter for image path
	public void setPath(String path) {
		this.path = path;
	}

	/*
	 * Overriding toString for Image
	 */
	@Override
	public String toString() {
		return "Image [id=" + id + ", name=" + name + ", path=" + path + "]";
	}
}
