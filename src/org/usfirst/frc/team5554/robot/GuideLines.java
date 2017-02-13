package org.usfirst.frc.team5554.robot;

import org.opencv.core.Scalar;

public class GuideLines 
{
	private int glXLeft;
	private int glXRight;
	private int glYUp;
	private int glYDown;
	private Scalar glColor;
	private int glThickness;
	
	public GuideLines(int xLeft , int xRight , int yUp , int yDown , Scalar color, int thickness)
	{
		glXLeft = xLeft;
		glXRight = xRight;
		glYUp = yUp;
		glYDown = yDown;
		glColor = color;
		glThickness = thickness;
	}
	
	public void NarrowWidth(int narrow)
	{
		glXLeft = glXLeft+narrow;
		glXRight = glXRight-narrow;
	}
	
	public void DialateWidth(int dialate)
	{
		glXLeft = glXLeft-dialate;
		glXRight = glXRight+dialate;
	}
	
	public int GetLeftX()
	{
		return glXLeft;
	}
	
	public int GetRightX()
	{
		return glXRight;
	}
	
	public int GetUpY()
	{
		return glYUp;
	}
	
	public int GetDownY()
	{
		return glYDown;
	}
	
	public int GetThickness()
	{
		return glThickness;
	}
	
	public Scalar GetColor()
	{
		return glColor;
	}
	
}
