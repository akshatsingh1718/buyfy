package com.buyfy.controllers;

import java.util.HashSet;
import java.util.Set;

import com.buyfy.dao.ImageDAO;
import com.buyfy.dao.ImageDAOImpl;
import com.buyfy.model.Image;

public class ImageController {
	private static ImageDAO dao = new ImageDAOImpl();
	
	public static long saveImage(Image img) {
		return dao.saveImage(img);
	}
	
	public static Set<Image> saveAllImages(Set<Image> images) {
		Set<Image> savedImages = new HashSet<Image>();
		for(Image img: images) {
			if(dao.saveImage(img) == -1) {
				return null;
			}else {
				savedImages.add(img);
				System.out.println(img);
			}
		}
		return savedImages;
	}
}
