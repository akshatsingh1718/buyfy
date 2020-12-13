package com.buyfy.dao;

import com.buyfy.model.Image;

public interface ImageDAO {
	// method for saving an image of the user or product
	long saveImage(Image image);
	
	// method for deleting an user or product image by imageId
	boolean deleteImage(long imageId);
}
