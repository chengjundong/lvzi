<%@ page language="java" import="java.awt.image.*,java.awt.*,javax.imageio.ImageIO, java.util.concurrent.ThreadLocalRandom" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%><%
// 设置文件类型
response.setHeader("Content-Type", "img/png");
// 禁止缓存
response.setHeader("Cache-Control", "no-cache");
response.setHeader("Expires", "0");
// 图片宽高
int width = 70;
int height = 21;
// 生成图片
BufferedImage img = new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);
// 生成画笔
Graphics g = img.getGraphics();
// 画笔颜色
int red = ThreadLocalRandom.current().nextInt(150,200);
int blue = ThreadLocalRandom.current().nextInt(150,200);
int yellow = ThreadLocalRandom.current().nextInt(150,200);
g.setColor(new Color(red,blue,yellow));
// 画出矩形
g.fillRect(0, 0, width, height);

// 画出验证码
String src = "ABCDEFGHJKLMNPQRSTUVWXYZ123456789";
String vcode = "";
for(int i=0;i<4;i++)
{
	char c = src.charAt(ThreadLocalRandom.current().nextInt(0, src.length()));
	g.setColor(new Color(ThreadLocalRandom.current().nextInt(50,100),ThreadLocalRandom.current().nextInt(50,100),ThreadLocalRandom.current().nextInt(50,100)));
	g.setFont(new Font("黑体",Font.PLAIN,ThreadLocalRandom.current().nextInt(14,22)));
	int charX = 2+18*i;
	int charY = 20;
	g.drawString(String.valueOf(c), charX, charY);
	vcode += c;
}

// 保存进Session
session.setAttribute("adminVcode", vcode);

// 输出
ImageIO.write(img, "png", response.getOutputStream());
// 销毁画笔
g.dispose();
%>