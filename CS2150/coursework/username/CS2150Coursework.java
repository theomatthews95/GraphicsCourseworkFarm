/* CS2150Coursework.java
 * TODO: put your university username and full name here
 *
 * Scene Graph:
 *  Scene origin
 *  |
 *
 *  TODO: Provide a scene graph for your submission
 */
package coursework.username;

import org.lwjgl.opengl.GL11;
import org.lwjgl.util.glu.Cylinder;
import org.lwjgl.util.glu.GLU;
import org.lwjgl.input.Keyboard;
import org.newdawn.slick.opengl.Texture;

import GraphicsLab.*;

/**
 * TODO: Briefly describe your submission here
 *
 * <p>Controls:
 * <ul>
 * <li>Press the escape key to exit the application.
 * <li>Hold the x, y and z keys to view the scene along the x, y and z axis, respectively
 * <li>While viewing the scene along the x, y or z axis, use the up and down cursor keys
 *      to increase or decrease the viewpoint's distance from the scene origin
 * </ul>
 * TODO: Add any additional controls for your sample to the list above
 *
 */
public class CS2150Coursework extends GraphicsLab
{
    private final int windmillList = 1;
	
	//TODO: Feel free to change the window title and default animation scale here
    public static void main(String args[])
    {   new CS2150Coursework().run(WINDOWED,"CS2150 Coursework Submission",0.01f);
    	
    }

    protected void initScene() throws Exception
    {//TODO: Initialise your resources here - might well call other methods you write.
    	
    	GL11.glNewList(windmillList, GL11.GL_COMPILE);
    	{	
    		drawUnitWindmill();
    		drawUnitBlades();

        	
    		 
 
    	}
    	GL11.glEndList();
    	
    }
    protected void checkSceneInput()
    {//TODO: Check for keyboard and mouse input here
    }
    protected void updateScene()
    {
        //TODO: Update your scene variables here - remember to use the current animation scale value
        //        (obtained via a call to getAnimationScale()) in your modifications so that your animations
        //        can be made faster or slower depending on the machine you are working on
    }
    protected void renderScene()
    {//TODO: Render your scene here - remember that a scene graph will help you write this method! 
     //      It will probably call a number of other methods you will write.
    	GL11.glTranslatef(0.0f, -0.5f, -5.0f);
    	GL11.glPolygonMode(GL11.GL_FRONT_AND_BACK, GL11.GL_LINE);
    	GL11.glScalef(0.2f, 0.2f, 0.2f);
    //	GL11.glRotatef(-90.0f, 1.0f, 0.0f, 0.0f);
    	new Cylinder().draw(1.0f, 6.0f, 2.5f, 10, 10);
    	GL11.glCallList(windmillList);
    	
    }
    protected void setSceneCamera()
    {
        // call the default behaviour defined in GraphicsLab. This will set a default perspective projection
        // and default camera settings ready for some custom camera positioning below...  
        super.setSceneCamera();
        //TODO: If it is appropriate for your scene, modify the camera's position and orientation here
        //        using a call to GL11.gluLookAt(...)
   }

    protected void cleanupScene()
    {//TODO: Clean up your resources here
    }
   
    
    private void drawUnitWindmill(){
    //Colour bottom, Colour nearRight, Colour nearLeft, Colour farRight, Colour farLeft, Colour back, Colour highNearRight, Colour highNearLeft, Colour highFarRight, Colour highFarLeft, Colour highBack, Colour topNearRight, Colour topNearLeft, Colour topFarRight, Colour topFarLeft, Colour topBack
    //the vertices for the windmill 
    	
    	Vertex v1 = new Vertex(0.0f, 0.0f, 0.0f);
    	Vertex v2 = new Vertex(-3.0f, 0.0f, 2.0f);
    	Vertex v3 = new Vertex(-1.5f, 0.0f, 5.0f);
    	Vertex v4 = new Vertex(1.5f, 0.0f, 5.0f);
    	Vertex v5 = new Vertex(3.0f, 0.0f, 2.0f);
    	Vertex v6 = new Vertex(1.5f, 5.0f, 2.5f);
    	Vertex v7 = new Vertex(0.0f, 5.0f, 1.0f);
    	Vertex v8 = new Vertex(-1.5f, 5.0f, 2.5f);
    	Vertex v9 = new Vertex(-0.5f, 5.0f, 4.0f);
    	Vertex v10 = new Vertex(0.5f, 5.0f, 4.0f);
    	Vertex v11 = new Vertex(1.5f, 7.0f, 2.5f);
    	Vertex v12 = new Vertex(0.5f, 7.0f, 4.0f);
    	Vertex v13 = new Vertex(-0.5f, 7.0f, 4.0f);
    	Vertex v14 = new Vertex(-1.5f, 7.0f, 2.5f);
    	Vertex v15 = new Vertex(0.0f, 7.0f, 1.0f);
    	Vertex v16 = new Vertex(0.0f, 8.0f, 2.5f);
    	
    	
    	//bottom
    	GL11.glBegin(GL11.GL_POLYGON);
		{
			//bottom.submit();
			v1.submit();
			v2.submit();
			v3.submit();
			v4.submit();
			v5.submit();
		}
		
		//near left side
		GL11.glBegin(GL11.GL_POLYGON);{
			
			v1.submit();
			v7.submit();
			v8.submit();
			v2.submit();
			
		}
		
		//near right side
		GL11.glBegin(GL11.GL_POLYGON);{
			v1.submit();
			v5.submit();
			v6.submit();
			v7.submit();
		}
		GL11.glEnd();
	    
		
		//far left side
		GL11.glBegin(GL11.GL_POLYGON);{
			v2.submit();
			v8.submit();
			v9.submit();
			v3.submit();	
		}
		GL11.glEnd();
	    
		//far right side
		GL11.glBegin(GL11.GL_POLYGON);{
			v5.submit();
			v4.submit();
			v10.submit();
			v6.submit();	
		}
		GL11.glEnd();
	    
		//back
		GL11.glBegin(GL11.GL_POLYGON);{
			v4.submit();
			v3.submit();
			v9.submit();
			v10.submit();
		}
		GL11.glEnd();
	    
		//high left
		GL11.glBegin(GL11.GL_POLYGON);{
			v8.submit();
			v7.submit();
			v15.submit();
			v14.submit();
		}
		GL11.glEnd();
	    
		//high right
		GL11.glBegin(GL11.GL_POLYGON);{
			v7.submit();
			v6.submit();
			v11.submit();
			v15.submit();
		}
		GL11.glEnd();
	    
		//high far right
		GL11.glBegin(GL11.GL_POLYGON);{
			v6.submit();
			v10.submit();
			v12.submit();
			v11.submit();
		}
		GL11.glEnd();
	    
		//high far left
		GL11.glBegin(GL11.GL_POLYGON);{
			v8.submit();
			v14.submit();
			v13.submit();
			v9.submit();
		}
		GL11.glEnd();
	    
		//high back
		GL11.glBegin(GL11.GL_POLYGON);{
			v9.submit();
			v13.submit();
			v12.submit();
			v10.submit();
		}
		GL11.glEnd();
	    
		//top near right
		GL11.glBegin(GL11.GL_TRIANGLES);{
			v15.submit();
			v16.submit();
			v11.submit();
		}
		GL11.glEnd();
		
		//top far right		
		GL11.glBegin(GL11.GL_TRIANGLES);{
					v11.submit();
					v16.submit();
					v12.submit();
				}
		GL11.glEnd();
				
		//top back
		GL11.glBegin(GL11.GL_TRIANGLES);{
					v12.submit();
					v13.submit();
					v16.submit();
				}
		GL11.glEnd();
			
		//top near left
		GL11.glBegin(GL11.GL_TRIANGLES);{
				v15.submit();
				v14.submit();
				v16.submit();
			
				}
		GL11.glEnd();
		
		//top far left
		GL11.glBegin(GL11.GL_TRIANGLES);{
				v14.submit();
				v13.submit();
				v16.submit();
				}
		GL11.glEnd();
    }
    
    private void drawUnitBlades(){
    	Vertex v1 = new Vertex(0.0f, 6.0f, 4.1f);
    	Vertex v2 = new Vertex(0.2f, 7.5f, 4.1f);
    	Vertex v3 = new Vertex(-0.2f, 7.5f, 4.1f);
    	Vertex v4 = new Vertex(-0.2f, 4.5f, 4.1f);
    	Vertex v5 = new Vertex(0.2f, 4.5f, 4.1f);
    	Vertex v6 = new Vertex(1.5f, 6.2f, 4.1f);
    	Vertex v7 = new Vertex(1.5f, 5.8f, 4.1f);
    	Vertex v8 = new Vertex(-1.5f, 6.2f, 4.1f);
    	Vertex v9 = new Vertex(-1.5f, 5.8f, 4.1f);
    	
    	//first vertical blade
    	GL11.glBegin(GL11.GL_POLYGON);
    	{
			v2.submit();
			v3.submit();
			v4.submit();
			v5.submit();
		}
		GL11.glEnd();
		
		GL11.glBegin(GL11.GL_POLYGON);
    	{
			v8.submit();
			v9.submit();
			v7.submit();
			v6.submit();
		}
		GL11.glEnd();
	    
    }
}