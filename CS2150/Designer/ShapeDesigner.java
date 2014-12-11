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
   	
    	Vertex v38 = new Vertex(0.0f, 0.0f,0.0f);
    	Vertex v37 = new Vertex(0.2f, 0.0f,0.0f);
    	Vertex v36 = new Vertex(0.2f, 0.0f,0.2f);
    	Vertex v35 = new Vertex(0.0f, 0.0f,0.2f);
    	Vertex v34 = new Vertex(0.0f, 0.8f,0.2f);
    	Vertex v33 = new Vertex(0.0f, 0.8f,0.0f);
    	Vertex v32 = new Vertex(0.2f, 0.8f,0.0f);
    	Vertex v31 = new Vertex(0.2f, 0.8f,0.2f);
    	Vertex v12 = new Vertex(0.6f, 0.8f,0.4f);
    	Vertex v7 = new Vertex(-0.2f, 0.8f,0.4f);
    	Vertex v10 = new Vertex(-0.2f, 0.8f,-0.2f);
    	Vertex v11 = new Vertex(0.6f, 0.8f,-0.2f);
    	Vertex v14 = new Vertex(0.6f, 1.8f,-0.2f);
    	Vertex v9 = new Vertex(-0.2f, 1.8f,-0.2f);
    	Vertex v8 = new Vertex(-0.2f, 1.8f,0.4f);
    	Vertex v13 = new Vertex(0.6f, 1.8f,0.4f);
    	Vertex v6 = new Vertex(-0.6f, 2.1f,0.4f);
    	Vertex v5 = new Vertex(-0.6f, 2.1f,-0.2f);
    	Vertex v2 = new Vertex(-0.8f, 2.3f,0.4f);
    	Vertex v1 = new Vertex(-0.8f, 2.3f,-0.2f);
    	Vertex v4 = new Vertex(-0.6f, 2.5f,-0.2f);
    	Vertex v3 = new Vertex(-0.6f, 2.5f,0.4f);
    	
    	//bottom of feet
    	GL11.glBegin(GL11.GL_POLYGON);
        {
            new Normal(v38.toVector(),v37.toVector(),v36.toVector(),v35.toVector()).submit();
            
            GL11.glTexCoord2f(1.0f,0.0f);
            v38.submit();
            
            GL11.glTexCoord2f(0.0f,0.0f);
            v37.submit();
            
            GL11.glTexCoord2f(0.0f,1.0f);
            v36.submit();
            
            GL11.glTexCoord2f(1.0f,1.0f);
            v35.submit();
        }
        GL11.glEnd();
    	
        //left side of leg
        GL11.glBegin(GL11.GL_POLYGON);
        {
            new Normal(v38.toVector(),v33.toVector(),v32.toVector(),v37.toVector()).submit();
            
            GL11.glTexCoord2f(1.0f,0.0f);
            v38.submit();
            
            GL11.glTexCoord2f(0.0f,0.0f);
            v33.submit();
            
            GL11.glTexCoord2f(0.0f,1.0f);
            v32.submit();
            
            GL11.glTexCoord2f(1.0f,1.0f);
            v37.submit();
        }
        GL11.glEnd();
        
        //front of leg
        GL11.glBegin(GL11.GL_POLYGON);
        {
            new Normal(v38.toVector(),v35.toVector(),v34.toVector(),v33.toVector()).submit();
            
            GL11.glTexCoord2f(1.0f,0.0f);
            v38.submit();
            
            GL11.glTexCoord2f(0.0f,0.0f);
            v35.submit();
            
            GL11.glTexCoord2f(0.0f,1.0f);
            v34.submit();
            
            GL11.glTexCoord2f(1.0f,1.0f);
            v33.submit();
        }
        GL11.glEnd();
        
        //right side of leg
        GL11.glBegin(GL11.GL_POLYGON);
        {
            new Normal(v35.toVector(),v36.toVector(),v31.toVector(),v34.toVector()).submit();
            
            GL11.glTexCoord2f(1.0f,0.0f);
            v35.submit();
            
            GL11.glTexCoord2f(0.0f,0.0f);
            v36.submit();
            
            GL11.glTexCoord2f(0.0f,1.0f);
            v31.submit();
            
            GL11.glTexCoord2f(1.0f,1.0f);
            v34.submit();
        }
        GL11.glEnd();
    
    
    	//back of leg
        GL11.glBegin(GL11.GL_POLYGON);
        {
            new Normal(v36.toVector(),v37.toVector(),v32.toVector(),v31.toVector()).submit();
            
            GL11.glTexCoord2f(1.0f,0.0f);
            v36.submit();
            
            GL11.glTexCoord2f(0.0f,0.0f);
            v37.submit();
            
            GL11.glTexCoord2f(0.0f,1.0f);
            v32.submit();
            
            GL11.glTexCoord2f(1.0f,1.0f);
            v31.submit();
        }
        GL11.glEnd();
        
        //bottom of bird
        GL11.glBegin(GL11.GL_POLYGON);
        {
            new Normal(v10.toVector(),v11.toVector(),v12.toVector(),v7.toVector()).submit();
            
            GL11.glTexCoord2f(1.0f,0.0f);
            v10.submit();
            
            GL11.glTexCoord2f(0.0f,0.0f);
            v11.submit();
            
            GL11.glTexCoord2f(0.0f,1.0f);
            v12.submit();
            
            GL11.glTexCoord2f(1.0f,1.0f);
            v7.submit();
        }
        GL11.glEnd();
        
        //left side of body
        GL11.glBegin(GL11.GL_POLYGON);
        {
            new Normal(v10.toVector(),v9.toVector(),v14.toVector(),v11.toVector()).submit();
            
            GL11.glTexCoord2f(1.0f,0.0f);
            v10.submit();
            
            GL11.glTexCoord2f(0.0f,0.0f);
            v9.submit();
            
            GL11.glTexCoord2f(0.0f,1.0f);
            v14.submit();
            
            GL11.glTexCoord2f(1.0f,1.0f);
            v11.submit();
        }
        GL11.glEnd();
        
        //front of body
        GL11.glBegin(GL11.GL_POLYGON);
        {
            new Normal(v9.toVector(),v10.toVector(),v7.toVector(),v8.toVector()).submit();
            
            GL11.glTexCoord2f(1.0f,0.0f);
            v9.submit();
            
            GL11.glTexCoord2f(0.0f,0.0f);
            v10.submit();
            
            GL11.glTexCoord2f(0.0f,1.0f);
            v7.submit();
            
            GL11.glTexCoord2f(1.0f,1.0f);
            v8.submit();
        }
        GL11.glEnd();
        
        //right side of body
        GL11.glBegin(GL11.GL_POLYGON);
        {
            new Normal(v8.toVector(),v7.toVector(),v12.toVector(),v13.toVector()).submit();
            
            GL11.glTexCoord2f(1.0f,0.0f);
            v8.submit();
            
            GL11.glTexCoord2f(0.0f,0.0f);
            v7.submit();
            
            GL11.glTexCoord2f(0.0f,1.0f);
            v12.submit();
            
            GL11.glTexCoord2f(1.0f,1.0f);
            v13.submit();
        }
        GL11.glEnd();
    
    //back of body
        GL11.glBegin(GL11.GL_POLYGON);
        {
            new Normal(v13.toVector(),v12.toVector(),v11.toVector(),v14.toVector()).submit();
            
            GL11.glTexCoord2f(1.0f,0.0f);
            v13.submit();
            
            GL11.glTexCoord2f(0.0f,0.0f);
            v12.submit();
            
            GL11.glTexCoord2f(0.0f,1.0f);
            v11.submit();
            
            GL11.glTexCoord2f(1.0f,1.0f);
            v14.submit();
        }
        GL11.glEnd();
        
   //top of body
        GL11.glBegin(GL11.GL_POLYGON);
        {
            new Normal(v9.toVector(),v8.toVector(),v13.toVector(),v14.toVector()).submit();
            
            GL11.glTexCoord2f(1.0f,0.0f);
            v9.submit();
            
            GL11.glTexCoord2f(0.0f,0.0f);
            v8.submit();
            
            GL11.glTexCoord2f(0.0f,1.0f);
            v13.submit();
            
            GL11.glTexCoord2f(1.0f,1.0f);
            v14.submit();
        }
        GL11.glEnd();
    
    //top of neck
        GL11.glBegin(GL11.GL_POLYGON);
        {
            new Normal(v5.toVector(),v6.toVector(),v8.toVector(),v9.toVector()).submit();
            
            GL11.glTexCoord2f(1.0f,0.0f);
            v5.submit();
            
            GL11.glTexCoord2f(0.0f,0.0f);
            v6.submit();
            
            GL11.glTexCoord2f(0.0f,1.0f);
            v8.submit();
            
            GL11.glTexCoord2f(1.0f,1.0f);
            v9.submit();
        }
        GL11.glEnd();
        
   //bottom of neck
        GL11.glBegin(GL11.GL_POLYGON);
        {
            new Normal(v6.toVector(),v5.toVector(),v10.toVector(),v7.toVector()).submit();
            
            GL11.glTexCoord2f(1.0f,0.0f);
            v6.submit();
            
            GL11.glTexCoord2f(0.0f,0.0f);
            v5.submit();
            
            GL11.glTexCoord2f(0.0f,1.0f);
            v10.submit();
            
            GL11.glTexCoord2f(1.0f,1.0f);
            v7.submit();
        }
        GL11.glEnd();
        
        //left side of neck
        GL11.glBegin(GL11.GL_TRIANGLES);
        {
            new Normal(v6.toVector(),v7.toVector(),v8.toVector()).submit();
            
            GL11.glTexCoord2f(1.0f,0.0f);
            v6.submit();
            
            GL11.glTexCoord2f(0.0f,0.0f);
            v7.submit();
            
            GL11.glTexCoord2f(0.0f,1.0f);
            v8.submit();
            
        }
        GL11.glEnd();
        
        //right side of neck
        GL11.glBegin(GL11.GL_TRIANGLES);
        {
            new Normal(v5.toVector(),v9.toVector(),v10.toVector()).submit();
            
            GL11.glTexCoord2f(1.0f,0.0f);
            v5.submit();
            
            GL11.glTexCoord2f(0.0f,0.0f);
            v9.submit();
            
            GL11.glTexCoord2f(0.0f,1.0f);
            v10.submit();
            
        }
        GL11.glEnd();
        
        //back of head
        GL11.glBegin(GL11.GL_POLYGON);
        {
            new Normal(v6.toVector(),v5.toVector(),v4.toVector(),v3.toVector()).submit();
            
            GL11.glTexCoord2f(1.0f,0.0f);
            v6.submit();
            
            GL11.glTexCoord2f(0.0f,0.0f);
            v5.submit();
            
            GL11.glTexCoord2f(0.0f,1.0f);
            v4.submit();
            
            GL11.glTexCoord2f(1.0f,1.0f);
            v3.submit();
        }
        GL11.glEnd();
        
        //top front of head
        GL11.glBegin(GL11.GL_POLYGON);
        {
            new Normal(v4.toVector(),v3.toVector(),v2.toVector(),v1.toVector()).submit();
            
            GL11.glTexCoord2f(1.0f,0.0f);
            v4.submit();
            
            GL11.glTexCoord2f(0.0f,0.0f);
            v3.submit();
            
            GL11.glTexCoord2f(0.0f,1.0f);
            v2.submit();
            
            GL11.glTexCoord2f(1.0f,1.0f);
            v1.submit();
        }
        GL11.glEnd();
        
        //bottom front of head
        GL11.glBegin(GL11.GL_POLYGON);
        {
            new Normal(v1.toVector(),v2.toVector(),v6.toVector(),v5.toVector()).submit();
            
            GL11.glTexCoord2f(1.0f,0.0f);
            v1.submit();
            
            GL11.glTexCoord2f(0.0f,0.0f);
            v2.submit();
            
            GL11.glTexCoord2f(0.0f,1.0f);
            v6.submit();
            
            GL11.glTexCoord2f(1.0f,1.0f);
            v5.submit();
        }
        GL11.glEnd();
        
        //right side of head
        GL11.glBegin(GL11.GL_TRIANGLES);
        {
            new Normal(v2.toVector(),v6.toVector(),v3.toVector()).submit();
            
            GL11.glTexCoord2f(1.0f,0.0f);
            v2.submit();
            
            GL11.glTexCoord2f(0.0f,0.0f);
            v6.submit();
            
            GL11.glTexCoord2f(0.0f,1.0f);
            v3.submit();
            
        }
        GL11.glEnd();
        
        //left side of head
        GL11.glBegin(GL11.GL_TRIANGLES);
        {
            new Normal(v1.toVector(),v4.toVector(),v5.toVector()).submit();
            
            GL11.glTexCoord2f(1.0f,0.0f);
            v1.submit();
            
            GL11.glTexCoord2f(0.0f,0.0f);
            v4.submit();
            
            GL11.glTexCoord2f(0.0f,1.0f);
            v5.submit();
            
        }
        GL11.glEnd();
    }
    
    private void drawUnitBirdWings(){
    	Vertex v1 = new Vertex(0.0f, 0.0f,0.0f);
    	Vertex v2 = new Vertex(0.5f, 0.0f,0.0f);
    	Vertex v3 = new Vertex(0.5f, 0.1f,0.0f);
    	Vertex v4 = new Vertex(0.0f, 0.1f,0.0f);
    	Vertex v5 = new Vertex(0.0f, 0.1f,1.0f);
    	Vertex v6 = new Vertex(0.0f, 0.0f,1.0f);
    	Vertex v7 = new Vertex(0.5f, 0.0f,1.0f);
    	Vertex v8 = new Vertex(0.5f, 0.1f,1.0f);
    	
    	//top of wing
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
        
        //right side of wing
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
        
        //bottom of wing
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
    	
        
        //left side of wing
        GL11.glBegin(GL11.GL_POLYGON);
        {
            new Normal(v5.toVector(),v6.toVector(),v1.toVector(),v4.toVector()).submit();
            
            GL11.glTexCoord2f(1.0f,0.0f);
            v5.submit();
            
            GL11.glTexCoord2f(0.0f,0.0f);
            v6.submit();
            
            GL11.glTexCoord2f(0.0f,1.0f);
            v1.submit();
            
            GL11.glTexCoord2f(1.0f,1.0f);
            v4.submit();
        }
        GL11.glEnd();
        
        //far edge of wing
        GL11.glBegin(GL11.GL_POLYGON);
        {
            new Normal(v5.toVector(),v8.toVector(),v7.toVector(),v6.toVector()).submit();
            
            GL11.glTexCoord2f(1.0f,0.0f);
            v5.submit();
            
            GL11.glTexCoord2f(0.0f,0.0f);
            v8.submit();
            
            GL11.glTexCoord2f(0.0f,1.0f);
            v7.submit();
            
            GL11.glTexCoord2f(1.0f,1.0f);
            v6.submit();
        }
        GL11.glEnd();
        
        //close edge of wing
        GL11.glBegin(GL11.GL_POLYGON);
        {
            new Normal(v4.toVector(),v1.toVector(),v2.toVector(),v3.toVector()).submit();
            
            GL11.glTexCoord2f(1.0f,0.0f);
            v4.submit();
            
            GL11.glTexCoord2f(0.0f,0.0f);
            v1.submit();
            
            GL11.glTexCoord2f(0.0f,1.0f);
            v2.submit();
            
            GL11.glTexCoord2f(1.0f,1.0f);
            v3.submit();
        }
        GL11.glEnd();
    }   
	    
    

}