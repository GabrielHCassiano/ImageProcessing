package PackageRGB;

import java.awt.image.BufferedImage;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		BufferedImage imageBase = ImageControl.loadImage();	
	
		BufferedImage[] imagens = 
		{
		    imageBase,
		    RGBControl.updatePixel(imageBase),
		    RGBControl.scaleR(imageBase),
		    RGBControl.scaleG(imageBase),
		    RGBControl.scaleB(imageBase),
		    RGBControl.negativeFilter(imageBase),
		    RGBControl.grayScaleR(imageBase),
		    RGBControl.grayScaleG(imageBase),
		    RGBControl.grayScaleB(imageBase),
		    RGBControl.grayScaleFilter(imageBase),
		    RGBControl.binarizationFilter(imageBase, 117),
		    RGBControl.increaseTone(imageBase, "red", 50),
		    RGBControl.increaseTone(imageBase, "green", 50),
		    RGBControl.increaseTone(imageBase, "blue", 50),
		    RGBControl.brightnessAdd(imageBase, 50),
		    RGBControl.brightnessMtt(imageBase, 0.5f),
		    RGBControl.yiq2rgb(RGBControl.rgb2yiq(imageBase)),
		    RGBControl.brightnessAddY(RGBControl.rgb2yiq(imageBase), 50),
		    RGBControl.brightnessMttY(RGBControl.rgb2yiq(imageBase), 0.5f), 
		    RGBControl.negativeFilterY(RGBControl.rgb2yiq(imageBase))
		};

		System.out.println("Altura:"+ ImageControl.getHeight(imageBase));
		System.out.println("Lagura:"+ ImageControl.getWidth(imageBase));
		System.out.println("Total Pixel:"+ ImageControl.totalPixel(imageBase));
				
		ImageControl.displayImage(imagens);
		ImageControl.saveImage(imagens);
	}
}
