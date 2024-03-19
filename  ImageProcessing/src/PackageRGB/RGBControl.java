package PackageRGB;

import java.awt.Color;
import java.awt.image.BufferedImage;

public class RGBControl {
	
	public static void getAllPixel(BufferedImage image)
	{		
		
		for (int a = 0; a < ImageControl.getWidth(image); a++){
			for (int l = 0; l < ImageControl.getHeight(image); l++) {
				Color rgb = new Color(image.getRGB(a, l));
				System.out.println(rgb);
			}
		}
	}
	
	public static BufferedImage updatePixel(BufferedImage image)
	{		
		BufferedImage newImage = new BufferedImage(image.getWidth(), image.getHeight(), BufferedImage.TYPE_INT_ARGB);
		
		Color red = new Color(255, 0, 0);
		Color green = new Color(0, 255, 0);
		Color blue = new Color(0, 0, 255);
		
		for (int a = 0; a < ImageControl.getWidth(image); a++){
			for (int l = 0; l < ImageControl.getHeight(image); l++) {
				Color rgb = new Color(image.getRGB(a, l));
				newImage.setRGB(a, l, rgb.getRGB());
			}
		}
		
		newImage.setRGB(0, 0, blue.getRGB());	
		newImage.setRGB(ImageControl.getWidth(image) / 2, ImageControl.getHeight(image) / 2, green.getRGB());	
		newImage.setRGB(ImageControl.getWidth(image) - 1, ImageControl.getHeight(image) - 1, red.getRGB());	

		getAllPixel(newImage);
		
		return newImage;
	}
	
	public static BufferedImage scaleR(BufferedImage image)
	{		
		BufferedImage newImage = new BufferedImage(image.getWidth(), image.getHeight(), BufferedImage.TYPE_INT_ARGB);
		
		for (int a = 0; a < ImageControl.getWidth(image); a++){
			for (int l = 0; l < ImageControl.getHeight(image); l++) {
				Color rgb = new Color(image.getRGB(a, l));
				Color newRed = new Color(rgb.getRed(), 0, 0);
				
				newImage.setRGB(a, l, newRed.getRGB());
			}
		}
		
		return newImage;
	}
	
	public static BufferedImage scaleG(BufferedImage image)
	{	
		BufferedImage newImage = new BufferedImage(image.getWidth(), image.getHeight(), BufferedImage.TYPE_INT_ARGB);
		
		for (int a = 0; a < ImageControl.getWidth(image); a++){
			for (int l = 0; l < ImageControl.getHeight(image); l++) {
				Color rgb = new Color(image.getRGB(a, l));
				Color newGreen = new Color(0, rgb.getGreen(), 0);
				
				newImage.setRGB(a, l, newGreen.getRGB());
			}
		}

		return newImage;
	}
	
	public static BufferedImage scaleB(BufferedImage image)
	{		
		BufferedImage newImage = new BufferedImage(image.getWidth(), image.getHeight(), BufferedImage.TYPE_INT_ARGB);
		
		for (int a = 0; a < ImageControl.getWidth(image); a++){
			for (int l = 0; l < ImageControl.getHeight(image); l++) {
				Color rgb = new Color(image.getRGB(a, l));
				Color newBlue = new Color(0, 0, rgb.getBlue());
				
				newImage.setRGB(a, l, newBlue.getRGB());
			}
		}
		
		return newImage;
	}
	
	public static BufferedImage negativeFilter(BufferedImage image)
	{		
		BufferedImage newImage = new BufferedImage(image.getWidth(), image.getHeight(), BufferedImage.TYPE_INT_ARGB);
		
		for (int a = 0; a < ImageControl.getWidth(image); a++){
			for (int l = 0; l < ImageControl.getHeight(image); l++) {
				Color rgb = new Color(image.getRGB(a, l));
				Color negativeColor = new Color(255 - rgb.getRed(), 255 - rgb.getGreen(), 255 - rgb.getBlue()); 
				
				newImage.setRGB(a, l, negativeColor.getRGB());
			}
		}
		
		return newImage;
	}
	
	public static BufferedImage grayScaleR(BufferedImage image)
	{		
		BufferedImage newImage = new BufferedImage(image.getWidth(), image.getHeight(), BufferedImage.TYPE_INT_ARGB);
		
		for (int a = 0; a < ImageControl.getWidth(image); a++){
			for (int l = 0; l < ImageControl.getHeight(image); l++) {
				Color rgb = new Color(image.getRGB(a, l));
				Color grayRed = new Color(rgb.getRed(), rgb.getRed(), rgb.getRed()); 
				
				newImage.setRGB(a, l, grayRed.getRGB());
			}
		}
		
		return newImage;
	}
	
	public static BufferedImage grayScaleG(BufferedImage image)
	{		
		BufferedImage newImage = new BufferedImage(image.getWidth(), image.getHeight(), BufferedImage.TYPE_INT_ARGB);
		
		for (int a = 0; a < ImageControl.getWidth(image); a++){
			for (int l = 0; l < ImageControl.getHeight(image); l++) {
				Color rgb = new Color(image.getRGB(a, l));
				Color grayGreen = new Color(rgb.getGreen(), rgb.getGreen(), rgb.getGreen()); 
				
				newImage.setRGB(a, l, grayGreen.getRGB());
			}
		}
		
		return newImage;
	}
	
	public static BufferedImage grayScaleB(BufferedImage image)
	{		
		BufferedImage newImage = new BufferedImage(image.getWidth(), image.getHeight(), BufferedImage.TYPE_INT_ARGB);
		
		for (int a = 0; a < ImageControl.getWidth(image); a++){
			for (int l = 0; l < ImageControl.getHeight(image); l++) {
				Color rgb = new Color(image.getRGB(a, l));
				Color grayBlue = new Color(rgb.getBlue(), rgb.getBlue(), rgb.getBlue()); 
				
				newImage.setRGB(a, l, grayBlue.getRGB());
			}
		}
		
		return newImage;
	}
	
	public static BufferedImage grayScaleFilter(BufferedImage image)
	{		
		BufferedImage newImage = new BufferedImage(image.getWidth(), image.getHeight(), BufferedImage.TYPE_INT_ARGB);
		
		for (int a = 0; a < ImageControl.getWidth(image); a++){
			for (int l = 0; l < ImageControl.getHeight(image); l++) {
				Color rgb = new Color(image.getRGB(a, l));
				int grayAverage =  (rgb.getRed() + rgb.getGreen() + rgb.getBlue()) / 3; 
				Color grayScale = new Color(grayAverage, grayAverage, grayAverage); 
				
				newImage.setRGB(a, l, grayScale.getRGB());
			} 
		}
		
		return newImage;
	}
	
	public static BufferedImage BinarizationFilter(BufferedImage image, int thresholding)
	{		
		BufferedImage newImage = new BufferedImage(image.getWidth(), image.getHeight(), BufferedImage.TYPE_INT_ARGB);
		
		for (int a = 0; a < ImageControl.getWidth(image); a++){
			for (int l = 0; l < ImageControl.getHeight(image); l++) {
				Color rgb = new Color(image.getRGB(a, l));
				Color thresholdingColor = new Color(thresholding, thresholding, thresholding);
				Color black = new Color(0, 0, 0);
				
				if (rgb.getRGB() > thresholdingColor.getRGB())
				{
					newImage.setRGB(a, l, rgb.getRGB());
				}
				else if (rgb.getRGB() <= thresholdingColor.getRGB())
				{
					newImage.setRGB(a, l, black.getRGB());
				}
			} 
		}
		
		return newImage;
	}
	
	public static BufferedImage IncreaseTone(BufferedImage image, String  tone, int addTone)
	{		
		BufferedImage newImage = new BufferedImage(image.getWidth(), image.getHeight(), BufferedImage.TYPE_INT_ARGB);
		
		for (int a = 0; a < ImageControl.getWidth(image); a++){
			for (int l = 0; l < ImageControl.getHeight(image); l++) {
				Color rgb = new Color(image.getRGB(a, l));
				Color toneAdd = rgb;
				
				
				if((tone == "red" || tone == "Red" || tone == "RED"))
					toneAdd = new Color(Math.min(255, rgb.getRed() + addTone), rgb.getGreen(), rgb.getBlue());
				else if((tone == "green" || tone == "Green" || tone == "GREEN"))
					toneAdd = new Color(rgb.getRed(), Math.min(255, rgb.getGreen() + addTone), rgb.getBlue());
				else if((tone == "blue" || tone == "Blue" || tone == "BLUE"))
					toneAdd = new Color(rgb.getRed(), rgb.getGreen(), Math.min(255, rgb.getBlue() + addTone));
				else
					System.out.print("Error");

				newImage.setRGB(a, l, toneAdd.getRGB());
			} 
			
		}
		
		return newImage;
	}
	
	public static BufferedImage BrightnessAdd(BufferedImage image, int brightness)
	{		
		BufferedImage newImage = new BufferedImage(image.getWidth(), image.getHeight(), BufferedImage.TYPE_INT_ARGB);
		
		for (int a = 0; a < ImageControl.getWidth(image); a++){
			for (int l = 0; l < ImageControl.getHeight(image); l++) {
				Color rgb = new Color(image.getRGB(a, l));
				Color brightnessColor = new Color(Math.min(255, rgb.getRed() + brightness), Math.min(255, rgb.getGreen() + brightness), Math.min(255, rgb.getBlue() + brightness));
				
				newImage.setRGB(a, l, brightnessColor.getRGB());
			} 
		}
		
		return newImage;
	}
	
	public static BufferedImage BrightnessMtt(BufferedImage image, double brightness)
	{		
		BufferedImage newImage = new BufferedImage(image.getWidth(), image.getHeight(), BufferedImage.TYPE_INT_ARGB);
		
		for (int a = 0; a < ImageControl.getWidth(image); a++){
			for (int l = 0; l < ImageControl.getHeight(image); l++) {
				Color rgb = new Color(image.getRGB(a, l));		
				int red = (int)Math.min(255, rgb.getRed());
				int green = (int)Math.min(255, rgb.getGreen());
				int blue = (int)Math.min(255, rgb.getBlue());

				
				Color brightnessColor = new Color(red, green, blue);
				
				newImage.setRGB(a, l, brightnessColor.getRGB());
			} 
		}
		
		return newImage;
	}
	
	
	
}
