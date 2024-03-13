package PackageRGB;

import java.awt.image.BufferedImage;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		BufferedImage imageBase = ImageControl.loadImage();	
		
		BufferedImage[] imagens = {imageBase, RGBControl.updatePixel(imageBase), RGBControl.scaleR(imageBase), RGBControl.scaleG(imageBase), RGBControl.scaleB(imageBase),
					  			   RGBControl.negativeFilter(imageBase), RGBControl.grayScaleR(imageBase), RGBControl.grayScaleG(imageBase), RGBControl.grayScaleB(imageBase),
					  			   RGBControl.grayScaleFilter(imageBase)};
		
		System.out.println("Altura:"+ ImageControl.getHeight(imageBase));
		System.out.println("Lagura:"+ ImageControl.getWidth(imageBase));
		System.out.println("Total Pixel:"+ ImageControl.totalPixel(imageBase));
			
		ImageControl.displayImage(imagens);
		ImageControl.saveImage(imagens);
	}
}
