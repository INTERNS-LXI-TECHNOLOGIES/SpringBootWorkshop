
package com.lxisoft.vegetablestore.vegetable;

import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import java.util.Base64;

@Entity
@Table(name = "vegetablestore")
public class Vegetable {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
private int id;

	@Column(name = "name")
private String name;

	@Column(name = "price")
private String price;

	@Column(name = "stock")
private String stock;

	@Column(name = "minOrderQuantity")
private String orderQuantity;

	@Transient
private String base64Image;

@Lob
@Column(name = "image",columnDefinition = "blob")
private byte[]image;
@Transient
	private MultipartFile imageFile;

public Vegetable() {


}


public Vegetable(String name,String price,String stock, String orderQuantity) {

this.name = name;
this.price = price;
this.stock = stock;
this.orderQuantity = orderQuantity;


}

public Vegetable(int id,String name,String price,String stock, String orderQuantity) {

	this.id = id;
	this.name = name;
	this.price = price;
	this.stock = stock;
	this.orderQuantity = orderQuantity;
	
	
	}
public Vegetable(int id,String name,String price,String stock, String orderQuantity,String base64Image) {

	
this.id = id;
this.name = name;
this.price = price;
this.stock = stock;
this.orderQuantity = orderQuantity;
this.base64Image = base64Image;

}




public int getId() {

	 return id;
	}
	public void setId(int id)  {

	this.id = id;
	}     


public String getName() {

 return name;
}
public void setName(String name)  {

this.name = name;
}     


public String getPrice() {

 return price;
}
public void setPrice(String price)  {

this.price = price;
}  


public String getStock() {

 return stock;
}
public void setStock(String stock)  {
 
this.stock = stock;
}  


public String getOrderQuantity() {

 return orderQuantity;
}
public void setOrderQuantity(String orderQuantity)  {

this.orderQuantity = orderQuantity;  
}  
 
 
    public String getBase64Image() {

	base64Image = Base64.getEncoder().encodeToString(this.image);

        return base64Image;
    }
 
    public void setBase64Image(String base64Image) {
        this.base64Image = base64Image;
    }


	public byte[] getImage() {

		return image;
	}
	public void setImage(byte[] image)  {

		this.image= image;
	}


	public MultipartFile getImageFile() {
		return imageFile;
	}

	public void setImageFile(MultipartFile imageFile) {
		this.imageFile = imageFile;
	}
}