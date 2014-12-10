package Designer;

import org.lwjgl.opengl.GL11;

import GraphicsLab.Colour;
import GraphicsLab.Normal;
import GraphicsLab.Vertex;

/**
 * The shape designer is a utility class which assits you with the design of 
 * a new 3D object. Replace the content of the drawUnitShape() method with
 * your own code to creates vertices and draw the faces of your object.
 * 
 * You can use the following keys to change the view:
 *   - TAB		switch between vertex, wireframe and full polygon modes
 *   - UP		move the shape away from the viewer
 *   - DOWN     move the shape closer to the viewer
 *   - X        rotate the camera around the x-axis (clockwise)
 *   - Y or C   rotate the camera around the y-axis (clockwise)
 *   - Z        rotate the camera around the z-axis (clockwise)
 *   - SHIFT    keep pressed when rotating to spin anti-clockwise
 *   - A 		Toggle colour (only if using submitNextColour() to specify colour)
 *   - SPACE	reset the view to its initial settings
 *  
 * @author Remi Barillec
 *
 */
public class ShapeDesigner extends AbstractDesigner {
	
	/** Main method **/
	public static void main(String args[])
    {   
		new ShapeDesigner().run( WINDOWED, "Designer", 0.01f);
    }
	 private static final int cubeList = 1;
	 private static final int prismList = 2;
	/** Draw the shape **/
    protected void drawUnitShape()
    {
    	GL11.glNewList(cubeList,GL11.GL_COMPILE);
        {   
        	drawUnitCube();
        	//drawUnitBlades();
        }
        GL11.glEndList();
        
        //GL11.glNewList(prismList, GL11.GL_COMPILE);
        //{
        	//drawUnitPrism(Colour.RED,Colour.RED,Colour.RED,Colour.RED,Colour.GREEN);
        //}
        //GL11.glEndList();
		}
    /*Colour.RED,Colour.RED,Colour.RED,Colour.RED,Colour.GREEN,Colour.GREEN
    Colour near, Colour far, Colour left, Colour right, Colour top, Colour bottom*/
    private void drawUnitCube()
    {
//    	GL11.glEnable(GL11.GL_TEXTURE_2D);
//        GL11.glBindTexture(GL11.GL_TEXTURE_2D,windmillBladeTexture.getTextureID());
   	
    	Vertex v1 = new Vertex(-0.4f, -0.4f, 4.1f);
    	Vertex v2 = new Vertex(0.4f, -0.4f, 4.1f);
    	Vertex v3 = new Vertex(0.4f, 0.4f, 4.1f);
    	Vertex v4 = new Vertex(-0.4f, 0.4f, 4.1f);
    	Vertex v5 = new Vertex(-0.4f, 3.5f, 4.1f);
    	Vertex v6 = new Vertex(0.4f, 3.5f, 4.1f);
    	Vertex v7 = new Vertex(-0.4f, -3.5f, 4.1f);
    	Vertex v8 = new Vertex(0.4f, -3.5f, 4.1f);
    	Vertex v9 = new Vertex(3.5f, 0.4f, 4.1f);
    	Vertex v10 = new Vertex(3.5f, -0.4f, 4.1f);
    	Vertex v11 = new Vertex(-3.5f, 0.4f, 4.1f);
    	Vertex v12 = new Vertex(-3.5f, -0.4f, 4.1f);
    	Vertex v13 = new Vertex(-0.4f, -0.4f, 3.9f);
    	Vertex v14 = new Vertex(0.4f, -0.4f, 3.9f);
    	Vertex v15 = new Vertex(0.4f, 0.4f, 3.9f);
    	Vertex v16 = new Vertex(-0.4f, 0.4f, 3.9f);
    	Vertex v17 = new Vertex(-0.4f, 3.5f, 3.9f);
    	Vertex v18 = new Vertex(0.4f, 3.5f, 3.9f);
    	Vertex v19 = new Vertex(-0.4f, -3.5f, 3.9f);
    	Vertex v20= new Vertex(0.4f, -3.5f, 3.9f);
    	Vertex v21 = new Vertex(3.5f, 0.4f, 3.9f);
    	Vertex v22 = new Vertex(3.5f, -0.4f, 3.9f);
    	Vertex v23 = new Vertex(-3.5f, 0.4f, 3.9f);
    	Vertex v24 = new Vertex(-3.5f, -0.4f, 3.9f);
    	
    	//up vertical blade
    	GL11.glBegin(GL11.GL_POLYGON);
    	{
    		new Normal(v4.toVector(),v5.toVector(),v6.toVector(),v3.toVector()).submit();
    		
    		GL11.glTexCoord2f(1.0f,0.0f);
    		v4.submit();
            
            GL11.glTexCoord2f(1.0f,1.0f);
            v5.submit();
            
            GL11.glTexCoord2f(0.0f,1.0f);
            v6.submit();
           
            GL11.glTexCoord2f(0.0f,0.0f);
            v3.submit();
		}
		GL11.glEnd();
		
		//right horizontal blade
		GL11.glBegin(GL11.GL_POLYGON);
    	{
    		new Normal(v3.toVector(),v9.toVector(),v10.toVector(),v2.toVector()).submit();
    		
    		GL11.glTexCoord2f(1.0f,0.0f);
    		v3.submit();
            
            GL11.glTexCoord2f(1.0f,1.0f);
            v9.submit();
            
            GL11.glTexCoord2f(0.0f,1.0f);
            v10.submit();
            
            GL11.glTexCoord2f(0.0f,0.0f);
			v2.submit();
		}
		GL11.glEnd();
	    
		
		//down vertical blade
		GL11.glBegin(GL11.GL_POLYGON);
    	{
    		new Normal(v1.toVector(),v2.toVector(),v8.toVector(),v7.toVector()).submit();
    		
    		GL11.glTexCoord2f(0.0f,0.0f);
    		v1.submit();
            
            GL11.glTexCoord2f(1.0f,0.0f);
            v2.submit();
            
            GL11.glTexCoord2f(1.0f,1.0f);
            v8.submit();
            
            GL11.glTexCoord2f(0.0f,1.0f);
			v7.submit();
		}
		GL11.glEnd();
		
		//left horizontal blade
		GL11.glBegin(GL11.GL_POLYGON);
    	{
    		new Normal(v4.toVector(),v1.toVector(),v12.toVector(),v11.toVector()).submit();
    		
    		GL11.glTexCoord2f(0.0f,0.0f);
    		v4.submit();
            
            GL11.glTexCoord2f(1.0f,0.0f);
            v1.submit();
            
            GL11.glTexCoord2f(1.0f,1.0f);
            v12.submit();
            
            GL11.glTexCoord2f(0.0f,1.0f);
			v11.submit();
		}
		GL11.glEnd();
		
//		GL11.glEnable(GL11.GL_TEXTURE_2D);
//         GL11.glBindTexture(GL11.GL_TEXTURE_2D,centreOfWindmillTexture.getTextureID());
		//centre
		GL11.glBegin(GL11.GL_POLYGON);
    	{
    		new Normal(v4.toVector(),v3.toVector(),v2.toVector(),v1.toVector()).submit();
    		GL11.glTexCoord2f(0.0f,0.0f);
    		v4.submit();
            
            GL11.glTexCoord2f(1.0f,0.0f);
            v3.submit();
            
            GL11.glTexCoord2f(1.0f,1.0f);
            v2.submit();
            
            GL11.glTexCoord2f(0.0f,1.0f);
			v1.submit();
    		
		}
		GL11.glEnd();
		
		//rear up vertical blade
    	GL11.glBegin(GL11.GL_POLYGON);
    	{
    		new Normal(v16.toVector(),v17.toVector(),v18.toVector(),v15.toVector()).submit();
    		
    		GL11.glTexCoord2f(1.0f,0.0f);
    		v16.submit();
            
            GL11.glTexCoord2f(1.0f,1.0f);
            v17.submit();
            
            GL11.glTexCoord2f(0.0f,1.0f);
            v18.submit();
           
            GL11.glTexCoord2f(0.0f,0.0f);
            v15.submit();
		}
		GL11.glEnd();
		
		//rear right horizontal blade
		GL11.glBegin(GL11.GL_POLYGON);
    	{
    		new Normal(v15.toVector(),v21.toVector(),v22.toVector(),v14.toVector()).submit();
    		
    		GL11.glTexCoord2f(1.0f,0.0f);
    		v15.submit();
            
            GL11.glTexCoord2f(1.0f,1.0f);
            v21.submit();
            
            GL11.glTexCoord2f(0.0f,1.0f);
            v22.submit();
            
            GL11.glTexCoord2f(0.0f,0.0f);
			v14.submit();
		}
		GL11.glEnd();
	    
		
		//rear down vertical blade
		GL11.glBegin(GL11.GL_POLYGON);
    	{
    		new Normal(v13.toVector(),v14.toVector(),v20.toVector(),v19.toVector()).submit();
    		
    		GL11.glTexCoord2f(0.0f,0.0f);
    		v13.submit();
            
            GL11.glTexCoord2f(1.0f,0.0f);
            v14.submit();
            
            GL11.glTexCoord2f(1.0f,1.0f);
            v20.submit();
            
            GL11.glTexCoord2f(0.0f,1.0f);
			v19.submit();
		}
		GL11.glEnd();
		
		//rear left horizontal blade
		GL11.glBegin(GL11.GL_POLYGON);
    	{
    		new Normal(v16.toVector(),v13.toVector(),v24.toVector(),v23.toVector()).submit();
    		
    		GL11.glTexCoord2f(0.0f,0.0f);
    		v16.submit();
            
            GL11.glTexCoord2f(1.0f,0.0f);
            v13.submit();
            
            GL11.glTexCoord2f(1.0f,1.0f);
            v24.submit();
            
            GL11.glTexCoord2f(0.0f,1.0f);
			v23.submit();
		}
		GL11.glEnd();
//		 GL11.glEnable(GL11.GL_TEXTURE_2D);
//         GL11.glBindTexture(GL11.GL_TEXTURE_2D,centreOfWindmillTexture.getTextureID());
		//centre
		GL11.glBegin(GL11.GL_POLYGON);
    	{
    		new Normal(v16.toVector(),v15.toVector(),v14.toVector(),v13.toVector()).submit();
    		GL11.glTexCoord2f(0.0f,0.0f);
    		v16.submit();
            
            GL11.glTexCoord2f(1.0f,0.0f);
            v15.submit();
            
            GL11.glTexCoord2f(1.0f,1.0f);
            v14.submit();
            
            GL11.glTexCoord2f(0.0f,1.0f);
			v13.submit();
    		
		}
		GL11.glEnd();
		
		//right far edge
		GL11.glBegin(GL11.GL_POLYGON);
    	{
    		new Normal(v10.toVector(),v22.toVector(),v21.toVector(),v9.toVector()).submit();
    		GL11.glTexCoord2f(0.0f,0.0f);
    		v10.submit();
            
            GL11.glTexCoord2f(1.0f,0.0f);
            v22.submit();
            
            GL11.glTexCoord2f(1.0f,1.0f);
            v21.submit();
            
            GL11.glTexCoord2f(0.0f,1.0f);
			v9.submit();
    		
		}
		GL11.glEnd();
		
		//right up edge
		GL11.glBegin(GL11.GL_POLYGON);
    	{
    		new Normal(v15.toVector(),v3.toVector(),v9.toVector(),v21.toVector()).submit();
    		GL11.glTexCoord2f(0.0f,0.0f);
    		v15.submit();
            
            GL11.glTexCoord2f(1.0f,0.0f);
            v3.submit();
            
            GL11.glTexCoord2f(1.0f,1.0f);
            v9.submit();
            
            GL11.glTexCoord2f(0.0f,1.0f);
			v21.submit();
    		
		}
		GL11.glEnd();
		
		//right bottom edge
		GL11.glBegin(GL11.GL_POLYGON);
    	{
    		new Normal(v2.toVector(),v14.toVector(),v22.toVector(),v10.toVector()).submit();
    		GL11.glTexCoord2f(0.0f,0.0f);
    		v2.submit();
            
            GL11.glTexCoord2f(1.0f,0.0f);
            v14.submit();
            
            GL11.glTexCoord2f(1.0f,1.0f);
            v22.submit();
            
            GL11.glTexCoord2f(0.0f,1.0f);
			v10.submit();
    		
		}
		GL11.glEnd();
		
		//top top edge
		GL11.glBegin(GL11.GL_POLYGON);
    	{
    		new Normal(v17.toVector(),v5.toVector(),v6.toVector(),v18.toVector()).submit();
    		GL11.glTexCoord2f(0.0f,0.0f);
    		v17.submit();
            
            GL11.glTexCoord2f(1.0f,0.0f);
            v5.submit();
            
            GL11.glTexCoord2f(1.0f,1.0f);
            v6.submit();
            
            GL11.glTexCoord2f(0.0f,1.0f);
			v18.submit();
    		
		}
		GL11.glEnd();
		
		//top right edge
		GL11.glBegin(GL11.GL_POLYGON);
    	{
    		new Normal(v3.toVector(),v15.toVector(),v18.toVector(),v6.toVector()).submit();
    		GL11.glTexCoord2f(0.0f,0.0f);
    		v3.submit();
            
            GL11.glTexCoord2f(1.0f,0.0f);
            v15.submit();
            
            GL11.glTexCoord2f(1.0f,1.0f);
            v18.submit();
            
            GL11.glTexCoord2f(0.0f,1.0f);
			v6.submit();
    		
		}
		GL11.glEnd();
		
		
		//top left edge
		GL11.glBegin(GL11.GL_POLYGON);
    	{
    		new Normal(v16.toVector(),v4.toVector(),v5.toVector(),v17.toVector()).submit();
    		GL11.glTexCoord2f(0.0f,0.0f);
    		v16.submit();
            
            GL11.glTexCoord2f(1.0f,0.0f);
            v4.submit();
            
            GL11.glTexCoord2f(1.0f,1.0f);
            v5.submit();
            
            GL11.glTexCoord2f(0.0f,1.0f);
			v17.submit();
    		
		}
		GL11.glEnd();
		
		
		//left far edge
		GL11.glBegin(GL11.GL_POLYGON);
    	{
    		new Normal(v11.toVector(),v23.toVector(),v24.toVector(),v12.toVector()).submit();
    		GL11.glTexCoord2f(0.0f,0.0f);
    		v11.submit();
            
            GL11.glTexCoord2f(1.0f,0.0f);
            v23.submit();
            
            GL11.glTexCoord2f(1.0f,1.0f);
            v24.submit();
            
            GL11.glTexCoord2f(0.0f,1.0f);
			v12.submit();
    		
		}
		GL11.glEnd();
		
		//left top edge
		GL11.glBegin(GL11.GL_POLYGON);
    	{
    		new Normal(v23.toVector(),v11.toVector(),v4.toVector(),v16.toVector()).submit();
    		GL11.glTexCoord2f(0.0f,0.0f);
    		v23.submit();
            
            GL11.glTexCoord2f(1.0f,0.0f);
            v11.submit();
            
            GL11.glTexCoord2f(1.0f,1.0f);
            v4.submit();
            
            GL11.glTexCoord2f(0.0f,1.0f);
			v16.submit();
    		
		}
		GL11.glEnd();
		
		
		//left bottom edge
		GL11.glBegin(GL11.GL_POLYGON);
    	{
    		new Normal(v12.toVector(),v24.toVector(),v13.toVector(),v1.toVector()).submit();
    		GL11.glTexCoord2f(0.0f,0.0f);
    		v12.submit();
            
            GL11.glTexCoord2f(1.0f,0.0f);
            v24.submit();
            
            GL11.glTexCoord2f(1.0f,1.0f);
            v13.submit();
            
            GL11.glTexCoord2f(0.0f,1.0f);
			v1.submit();
    		
		}
		GL11.glEnd();
		
		//bottom far edge
		GL11.glBegin(GL11.GL_POLYGON);
    	{
    		new Normal(v7.toVector(),v19.toVector(),v20.toVector(),v8.toVector()).submit();
    		GL11.glTexCoord2f(0.0f,0.0f);
    		v7.submit();
            
            GL11.glTexCoord2f(1.0f,0.0f);
            v19.submit();
            
            GL11.glTexCoord2f(1.0f,1.0f);
            v20.submit();
            
            GL11.glTexCoord2f(0.0f,1.0f);
			v8.submit();
    		
		}
		GL11.glEnd();
		
		//bottom right edge
		GL11.glBegin(GL11.GL_POLYGON);
    	{
    		new Normal(v8.toVector(),v20.toVector(),v14.toVector(),v2.toVector()).submit();
    		GL11.glTexCoord2f(0.0f,0.0f);
    		v8.submit();
            
            GL11.glTexCoord2f(1.0f,0.0f);
            v20.submit();
            
            GL11.glTexCoord2f(1.0f,1.0f);
            v14.submit();
            
            GL11.glTexCoord2f(0.0f,1.0f);
			v2.submit();
    		
		}
		GL11.glEnd();
		
		//bottom left edge
		GL11.glBegin(GL11.GL_POLYGON);
    	{
    		new Normal(v19.toVector(),v7.toVector(),v1.toVector(),v13.toVector()).submit();
    		GL11.glTexCoord2f(0.0f,0.0f);
    		v19.submit();
            
            GL11.glTexCoord2f(1.0f,0.0f);
            v7.submit();
            
            GL11.glTexCoord2f(1.0f,1.0f);
            v1.submit();
            
            GL11.glTexCoord2f(0.0f,1.0f);
			v13.submit();
    		
		}
		GL11.glEnd();
    }
	    
    

//    private void drawUnitBlades(){
//    	Vertex v1 = new Vertex(0.0f, 6.0f, 4.1f);
//    	Vertex v2 = new Vertex(0.2f, 9.5f, 4.1f);
//    	Vertex v3 = new Vertex(-0.2f, 9.5f, 4.1f);
//    	Vertex v4 = new Vertex(-0.2f, 2.5f, 4.1f);
//    	Vertex v5 = new Vertex(0.2f, 2.5f, 4.1f);
//    	Vertex v6 = new Vertex(3.5f, 6.2f, 4.1f);
//    	Vertex v7 = new Vertex(3.5f, 5.8f, 4.1f);
//    	Vertex v8 = new Vertex(-3.5f, 6.2f, 4.1f);
//    	Vertex v9 = new Vertex(-3.5f, 5.8f, 4.1f);
//    	
//    	//first vertical blade
//    	GL11.glBegin(GL11.GL_POLYGON);
//    	{
//			v2.submit();
//			v3.submit();
//			v4.submit();
//			v5.submit();
//		}
//		GL11.glEnd();
//		
//		//second horizontal blade
//		GL11.glBegin(GL11.GL_POLYGON);
//    	{
//			v8.submit();
//			v9.submit();
//			v7.submit();
//			v6.submit();
//		}
//		GL11.glEnd();
//	    
//    }
    }

