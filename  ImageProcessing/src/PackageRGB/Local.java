package PackageRGB;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.*;

import javax.imageio.ImageIO;

public class Local {
	
	public static BufferedImage mediaLocal(BufferedImage image, int tamanho)
	{		
		BufferedImage newImage = new BufferedImage(image.getWidth(), image.getHeight(), image.getType());

	
		for (int w = 0; w < ImageControl.getWidth(image); w++){
			for (int h = 0; h < ImageControl.getHeight(image); h++) {
											
				boolean borda = false;
				int tamanhoBorda = 0;
				
				for (int i = 0; i < tamanho -(2 + i); i++) {
					if (h == i || w == i || h == ImageControl.getHeight(image) -(1 + i) || w == ImageControl.getWidth(image) -(1 + i)) {
						int rgb = image.getRGB(w, h);
						newImage.setRGB(w, h, rgb);
						borda = true;
					}
					else
						tamanhoBorda = tamanho -(2 + i);
				}
				
				if (borda == true)
					continue;
				
				int[] pixel = new int[tamanho * tamanho];
				int count = 0;
				
				for (int l = -tamanhoBorda; l <= tamanhoBorda; l++){
					for (int c = -tamanhoBorda; c <= tamanhoBorda; c++) {								
						Color colorRGB = new Color(image.getRGB(w + c, h + l));
						pixel[count++] = colorRGB.getRed();
					}
				}
				
				int media = Arrays.stream(pixel).sum() / (tamanho * tamanho);
				
				Color newColor = new Color(media, media, media);
				
				newImage.setRGB(w, h, newColor.getRGB());
			}
		}
		
		return newImage;
	}
	
	public static BufferedImage medianaLocal(BufferedImage image, int tamanho)
	{		
		if (tamanho % 2 == 0) {
			System.out.print("Tamanho invalido!");
			return image;
		}
		
		BufferedImage newImage = new BufferedImage(image.getWidth(), image.getHeight(), image.getType());
		
		for (int w = 0; w < ImageControl.getWidth(image); w++){
			for (int h = 0; h < ImageControl.getHeight(image); h++) {
				
				boolean borda = false;
				int tamanhoBorda = 0;
				
				for (int i = 0; i < tamanho -(2 + i); i++) {
					if (h == i || w == i || h == ImageControl.getHeight(image) -(1 + i) || w == ImageControl.getWidth(image) -(1 + i)) {
						int rgb = image.getRGB(w, h);
						newImage.setRGB(w, h, rgb);
						borda = true;
					}
					else
						tamanhoBorda = tamanho -(2 + i);
				}
				
				if (borda == true)
					continue;
								
				int[] pixel = new int[tamanho * tamanho];
				int count = 0;
				
				for (int l = -tamanhoBorda ; l <= tamanhoBorda; l++){
					for (int c = -tamanhoBorda; c <= tamanhoBorda; c++) {								
						Color colorRGB = new Color(image.getRGB(w + c, h + l));
						pixel[count++] = colorRGB.getRed();
					}
				}
								
				Arrays.sort(pixel);
				int mediana = pixel[tamanho * tamanho / 2];
				
				Color newColor = new Color(mediana, mediana, mediana);
				
				newImage.setRGB(w, h, newColor.getRGB());
			}
		}
		
		return newImage;
	}
	
	public static BufferedImage gaussianoLocal(BufferedImage image, float[] kernel)
	{		
		BufferedImage newImage = new BufferedImage(image.getWidth(), image.getHeight(), image.getType());
		
		for (int w = 0; w < ImageControl.getWidth(image); w++){
			for (int h = 0; h < ImageControl.getHeight(image); h++) {
								
				if (h == 0 || w == 0 || h ==  ImageControl.getHeight(image) -1 || w == image.getWidth() -1) {
					int rgb = image.getRGB(w, h);
					newImage.setRGB(w, h, rgb);
					continue;
				}
				
				int[] pixel = new int[9];
				int count = 0;
				
				for (int l = -1; l <= 1; l++){
					for (int c = -1; c <= 1; c++) {								
						Color colorRGB = new Color(image.getRGB(w + c, h + l));
						pixel[count++] = colorRGB.getRed();
						pixel[count-1] *= kernel[count-1];
					}
				}
		
				int soma = Arrays.stream(pixel).sum();
				
				Color newColor = new Color((int)soma, (int)soma, (int)soma);
				
				newImage.setRGB(w, h, newColor.getRGB());
			}
		}
		
		return newImage;
	}
	
	public static BufferedImage convolucao(BufferedImage image, int[] kernel)
	{		
		BufferedImage newImage = new BufferedImage(image.getWidth(), image.getHeight(), image.getType());
		
		for (int w = 0; w < ImageControl.getWidth(image); w++){
			for (int h = 0; h < ImageControl.getHeight(image); h++) {
								
				if (h == 0 || w == 0 || h ==  ImageControl.getHeight(image) -1 || w == image.getWidth() -1) {
					int rgb = image.getRGB(w, h);
					newImage.setRGB(w, h, rgb);
					continue;
				}
				
				int[] pixel = new int[9];
				int count = 0;
				
				for (int l = -1; l <= 1; l++){
					for (int c = -1; c <= 1; c++) {								
						Color colorRGB = new Color(image.getRGB(w + c, h + l));
						pixel[count++] = colorRGB.getRed();
						pixel[count-1] *= kernel[count-1];
					}
				}
		
				int soma = Arrays.stream(pixel).sum();
				
				if (soma > 255) soma = 255;
				else if (soma < 0) soma = 0;
				
				Color newColor = new Color(soma, soma, soma);
				
				newImage.setRGB(w, h, newColor.getRGB());
			}
		}
		
		return newImage;
	}
}
