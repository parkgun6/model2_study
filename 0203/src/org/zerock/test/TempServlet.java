package org.zerock.test;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class TempServlet
 */
@WebServlet("/temp")
public class TempServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TempServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		
		response.setContentType("image/jpeg");
		OutputStream os = response.getOutputStream();
		
		int value = (int)(Math.random()*10000);
		
		session.setAttribute("captcha", value);
		
		BufferedImage image = new BufferedImage(300, 300, 
				BufferedImage.TYPE_INT_RGB);
	
		Graphics g = image.getGraphics();
		g.setColor(Color.pink);
		
		g.fillRect(0, 0, 300, 300);
		
		g.setColor(Color.black);
		
		Font f = new Font("Gothic",Font.ITALIC, 50);
		g.setFont(f);
		
		g.drawString(""+value, 50, 140);
		
		ImageIO.write(image, "jpeg", os);
		
		
	}

}
