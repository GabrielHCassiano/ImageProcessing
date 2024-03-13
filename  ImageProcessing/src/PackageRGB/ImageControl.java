package PackageRGB;

import java.awt.FlowLayout;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.WindowConstants;

public class ImageControl {
	
	public static BufferedImage loadImage()
	{		
		try {
			File file = new File("Imagens\\CelesteWall.jpg");
			BufferedImage image = ImageIO.read(file);
			return image;			
		}catch (IOException e){
			System.out.print("Error ao carregar a imagem");
			throw new RuntimeException(e);
		}
		
	}
	
	public static void saveImage(BufferedImage... image)
	{		
		try {
			int i = 0;
			for (BufferedImage img : image)
			{
				i++;
				File saveFile = new File("Imagens\\CelesteWall - copia " + i + ".png");
				ImageIO.write(img, "png", saveFile);
			}

		}catch (IOException e){
			System.out.print("Error ao salva a imagem");
			throw new RuntimeException(e);
		}

	}
	
	public static void displayImage(BufferedImage... image)
	{
		JFrame window = new JFrame();
		window.setTitle("Image");
		window.getContentPane().setLayout(new FlowLayout());
				
		for (BufferedImage img : image)
		{
			window.getContentPane().add(new JLabel(new ImageIcon(img)));
		}
		window.pack();
		window.setVisible(true);
		window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	}
	
	public static int getHeight(BufferedImage image)
	{
		return image.getHeight();
		
	}
	public static int getWidth(BufferedImage image)
	{
		return image.getWidth();
	}
	
	public static int totalPixel(BufferedImage image)
	{
		return getHeight(image) * getWidth(image);
	}
}
