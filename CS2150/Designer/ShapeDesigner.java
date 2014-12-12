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
        	//drawUnitBirdWings();
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
   	
        	Vertex v1 = new Vertex(0.0f, 0.0f,0.0f);
        	Vertex v2 = new Vertex(0.2f, 0.0f,0.0f);
        	Vertex v3 = new Vertex(0.2f, 0.0f,0.2f);
        	Vertex v4 = new Vertex(0.0f, 0.0f,0.2f);
        	Vertex v5 = new Vertex(0.0f, 0.8f,0.2f);
        	Vertex v6 = new Vertex(0.0f, 0.8f,0.0f);
        	Vertex v7 = new Vertex(0.2f, 0.8f,0.0f);
        	Vertex v8 = new Vertex(0.2f, 0.8f,0.2f);
        	
       
        	//bottom of pin
        	GL11.glBegin(GL11.GL_POLYGON);
            {
               new Normal(v1.toVector(),v2.toVector(),v3.toVector(),v4.toVector()).submit();
                
                GL11.glTexCoord2f(1.0f,0.0f);
                v1.submit();
                
               GL11.glTexCoord2f(0.0f,0.0f);
                v2.submit();
                
               GL11.glTexCoord2f(0.0f,1.0f);
                v3.submit();
                
               GL11.glTexCoord2f(1.0f,1.0f);
                v4.submit();
            }
            GL11.glEnd();
        	
            //left side of pin
            GL11.glBegin(GL11.GL_POLYGON);
            {
               new Normal(v1.toVector(),v6.toVector(),v7.toVector(),v2.toVector()).submit();
                
                
                GL11.glTexCoord2f(1.0f,0.0f);
                v1.submit();
                
                GL11.glTexCoord2f(0.0f,0.0f);
                v6.submit();
                
                GL11.glTexCoord2f(0.0f,1.0f);
                v7.submit();
                
                GL11.glTexCoord2f(1.0f,1.0f);
                v2.submit();
            }
            GL11.glEnd();
            
            //front of pin
            GL11.glBegin(GL11.GL_POLYGON);
            {
                new Normal(v1.toVector(),v4.toVector(),v5.toVector(),v6.toVector()).submit();
                
                
                GL11.glTexCoord2f(1.0f,0.0f);
                v1.submit();
                
                GL11.glTexCoord2f(0.0f,0.0f);
                v4.submit();
                
                GL11.glTexCoord2f(0.0f,1.0f);
                v5.submit();
                
              GL11.glTexCoord2f(1.0f,1.0f);
                v6.submit();
            }
            GL11.glEnd();
            
            //right side of pin
            GL11.glBegin(GL11.GL_POLYGON);
            {
                new Normal(v4.toVector(),v3.toVector(),v8.toVector(),v5.toVector()).submit();
                
                
                GL11.glTexCoord2f(1.0f,0.0f);
                v4.submit();
                
                GL11.glTexCoord2f(0.0f,0.0f);
                v3.submit();
                
                GL11.glTexCoord2f(0.0f,1.0f);
               	v8.submit();
                
               	GL11.glTexCoord2f(1.0f,1.0f);
                v5.submit();
            }
            GL11.glEnd();
        
        
        	//back of pin
            GL11.glBegin(GL11.GL_POLYGON);
            {
                new Normal(v3.toVector(),v2.toVector(),v7.toVector(),v8.toVector()).submit();
                
                
              GL11.glTexCoord2f(1.0f,0.0f);
                v3.submit();
                
               GL11.glTexCoord2f(0.0f,0.0f);
                v2.submit();
                
               GL11.glTexCoord2f(0.0f,1.0f);
                v7.submit();
                
               GL11.glTexCoord2f(1.0f,1.0f);
                v8.submit();
            }
            GL11.glEnd();
    }   
	    
    
    
}