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
    private final int windmillBodyList = 1;
    private final int windmillBladeList = 2;
    private final int planeList = 3;
    private Texture groundTexture;
    private Texture skyTexture;
    private Texture windmillWallTexture;
    private Texture windmillBladeTexture;
    private Texture windmillTopTexture;
    private Texture centreOfWindmillTexture;
    private float bladeRotationAngle = 0.0f;
	//TODO: Feel free to change the window title and default animation scale here
    public static void main(String args[])
    {   new CS2150Coursework().run(WINDOWED,"CS2150 Coursework Submission",0.01f);
    	
    }

    protected void initScene() throws Exception
    {//TODO: Initialise your resources here - might well call other methods you write.
    	//global ambient lighting
    	float globalAmbient[] = {1.2f, 1.2f, 1.2f, 1.0f};
    	GL11.glLightModel(GL11.GL_LIGHT_MODEL_AMBIENT,
    			FloatBuffer.wrap(globalAmbient));
    	GL11.glEnable(GL11.GL_LIGHTING);
    	GL11.glEnable(GL11.GL_NORMALIZE);
    	groundTexture = loadTexture("coursework/username/textures/golf_course.jpg");
    	skyTexture = loadTexture("coursework/username/textures/sky.png");
    	windmillWallTexture = loadTexture("coursework/username/textures/WindmillWallTexture.png");
    	windmillBladeTexture = loadTexture("coursework/username/textures/windmill arm.png");
    	windmillTopTexture = loadTexture("coursework/username/textures/WindmillWallWindowTexture.png");
    	centreOfWindmillTexture = loadTexture("coursework/username/textures/CentreWindmill.png");
    	GL11.glNewList(windmillBodyList, GL11.GL_COMPILE);
    	{	
    		drawUnitWindmill();
    	}
    	GL11.glEndList();
    	GL11.glNewList(windmillBladeList, GL11.GL_COMPILE);
    	{
    		drawUnitBlades();
    	}
    	GL11.glEndList();
    	GL11.glNewList(planeList,GL11.GL_COMPILE);
        {  
        	drawUnitPlane();
        }
        GL11.glEndList();
    	GL11.glDisable(GL11.GL_CULL_FACE);
    	GL11.glPolygonMode(GL11.GL_FRONT_AND_BACK, GL11.GL_FILL);
    }
    protected void checkSceneInput()
    {//TODO: Check for keyboard and mouse input here
    	
//    	// Rotate if the r key is pressed
    	if(Keyboard.isKeyDown(Keyboard.KEY_R))
    	{
    		bladeRotationAngle += -0.05f;
    	}

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
    	
    //	GL11.glRotatef(-90.0f, 1.0f, 0.0f, 0.0f);
    //	new Cylinder().draw(1.0f, 6.0f, 2.5f, 10, 10);
    	bladeRotationAngle += -0.01f;
    	
        GL11.glPushMatrix();
        {
        	// disable lighting calculations so that they don't affect
            // the appearance of the texture 
            GL11.glPushAttrib(GL11.GL_LIGHTING_BIT);
            GL11.glDisable(GL11.GL_LIGHTING);
            // change the geometry colour to white so that the texture
            // is bright and details can be seen clearly
            Colour.WHITE.submit();
            // enable texturing and bind an appropriate texture
            GL11.glEnable(GL11.GL_TEXTURE_2D);
            GL11.glBindTexture(GL11.GL_TEXTURE_2D,skyTexture.getTextureID());
            
            // position, scale and draw the back plane using its display list
            GL11.glTranslatef(0.0f,4.0f,-20.0f);
            GL11.glRotatef(90.0f, 1.0f, 0.0f, 0.0f);
            GL11.glScalef(25.0f, 1.0f, 10.0f);
            GL11.glCallList(planeList);
            
            // disable textures and reset any local lighting changes
            GL11.glDisable(GL11.GL_TEXTURE_2D);
            GL11.glPopAttrib();
        }
        GL11.glPopMatrix();
  
        // draw the ground plane
        GL11.glPushMatrix();
        {
        	 // disable lighting calculations so that they don't affect
            // the appearance of the texture 
            GL11.glPushAttrib(GL11.GL_LIGHTING_BIT);
            GL11.glDisable(GL11.GL_LIGHTING);
            // change the geometry colour to white so that the texture
            // is bright and details can be seen clearly
            Colour.WHITE.submit();
            // enable texturing and bind an appropriate texture
            GL11.glEnable(GL11.GL_TEXTURE_2D);
            GL11.glBindTexture(GL11.GL_TEXTURE_2D,groundTexture.getTextureID());
            
            // position, scale and draw the ground plane using its display list
            GL11.glTranslatef(0.0f,-1.0f,-10.0f);
            GL11.glScalef(70.0f, 1.0f, 70.0f);
            GL11.glCallList(planeList);
            GL11.glScalef(1/70.0f, 1/1.0f, 1/70.0f);
            GL11.glTranslatef(0.0f, 1.0f, 10.0f);
            
            // disable textures and reset any local lighting changes
            GL11.glDisable(GL11.GL_TEXTURE_2D);
            GL11.glPopAttrib();
        
        
        
	        //windmill body list
	        GL11.glPushMatrix();
	        {
	        	GL11.glPushAttrib(GL11.GL_LIGHTING_BIT);
	            GL11.glDisable(GL11.GL_LIGHTING);
	            // change the geometry colour to white so that the texture
	            // is bright and details can be seen clearly
	        //    Colour.WHITE.submit();
	            // enable texturing and bind an appropriate texture
	        	GL11.glTranslatef(0.0f, -0.5f, -5.0f);
		        GL11.glScalef(0.2f, 0.2f, 0.2f);	
		        GL11.glCallList(windmillBodyList);
		        
		        GL11.glDisable(GL11.GL_TEXTURE_2D);
	            GL11.glPopAttrib();
        
       
        
		        //windmill blades list
		        GL11.glPushMatrix();
		        {
		        	GL11.glPushAttrib(GL11.GL_LIGHTING_BIT);
		            GL11.glDisable(GL11.GL_LIGHTING);
		            // change the geometry colour to white so that the texture
		            // is bright and details can be seen clearly
		        //    Colour.WHITE.submit();
		            // enable texturing and bind an appropriate texture
		
		            GL11.glTranslatef(0.0f, 5.7f, 0.4f);
			        
			        GL11.glRotatef(bladeRotationAngle, 0.0f, 0.0f, 1.0f);
			        GL11.glCallList(windmillBladeList);
			        GL11.glDisable(GL11.GL_TEXTURE_2D);
		            GL11.glPopAttrib();
		        
		       
		    
		        
			        //bird draw list
			        GL11.glPushMatrix();
		        	{
		        	
		        	
		        	}GL11.glPopMatrix();
		        	}
	        	GL11.glPopMatrix();
	        }
        	GL11.glPopMatrix();
        }	
        GL11.glPopMatrix();
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
    	Vertex v3 = new Vertex(-1.5f, 0.0f, 4.0f);
    	Vertex v4 = new Vertex(1.5f, 0.0f, 4.0f);
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
			
			new Normal(v1.toVector(),v7.toVector(),v8.toVector(),v2.toVector()).submit();
			
			GL11.glTexCoord2f(0.0f,0.0f);
			v1.submit();
            
            GL11.glTexCoord2f(1.0f,0.0f);
            v7.submit();
            
            GL11.glTexCoord2f(1.0f,1.0f);
            v8.submit();
            
            GL11.glTexCoord2f(0.0f,1.0f);
			v2.submit();
			
		}
		
		//near right side
		GL11.glBegin(GL11.GL_POLYGON);{
			
			new Normal(v1.toVector(),v5.toVector(),v6.toVector(),v7.toVector()).submit();
			
			v1.submit();
			v5.submit();
			v6.submit();
			v7.submit();
		}
		GL11.glEnd();
	    
		GL11.glEnable(GL11.GL_TEXTURE_2D);
        GL11.glBindTexture(GL11.GL_TEXTURE_2D,windmillWallTexture.getTextureID());
		//far left side
		GL11.glBegin(GL11.GL_POLYGON);{
			
			new Normal(v2.toVector(),v8.toVector(),v9.toVector(),v3.toVector()).submit();
			
			GL11.glTexCoord2f(0.0f,0.0f);
			v2.submit();
            
            GL11.glTexCoord2f(1.0f,0.0f);
            v8.submit();
            
            GL11.glTexCoord2f(1.0f,1.0f);
            v9.submit();
            
            GL11.glTexCoord2f(0.0f,1.0f);
			v3.submit();	
		}
		GL11.glEnd();
	    
		//far right side
		GL11.glBegin(GL11.GL_POLYGON);{
			
			new Normal(v5.toVector(),v4.toVector(),v10.toVector(),v6.toVector()).submit();
			
			GL11.glTexCoord2f(0.0f,0.0f);
			v5.submit();
            
            GL11.glTexCoord2f(1.0f,0.0f);
            v4.submit();
            
            GL11.glTexCoord2f(1.0f,1.0f);
            v10.submit();
            
            GL11.glTexCoord2f(0.0f,1.0f);
			v6.submit();	
		}
		GL11.glEnd();
	    
		//back
		GL11.glBegin(GL11.GL_POLYGON);{
			
			new Normal(v4.toVector(),v3.toVector(),v9.toVector(),v10.toVector()).submit();
			
			GL11.glTexCoord2f(0.0f,0.0f);
			v4.submit();
            
            GL11.glTexCoord2f(1.0f,0.0f);
            v3.submit();
            
            GL11.glTexCoord2f(1.0f,1.0f);
            v9.submit();
            
            GL11.glTexCoord2f(0.0f,1.0f);
			v10.submit();
		}
		GL11.glEnd();
	    
		//high left
		GL11.glBegin(GL11.GL_POLYGON);{
			
			new Normal(v8.toVector(),v7.toVector(),v15.toVector(),v14.toVector()).submit();
			
			v8.submit();
			v7.submit();
			v15.submit();
			v14.submit();
		}
		GL11.glEnd();
	    
		//high right
		GL11.glBegin(GL11.GL_POLYGON);{
			
			new Normal(v7.toVector(),v6.toVector(),v11.toVector(),v15.toVector()).submit();
			
			v7.submit();
			v6.submit();
			v11.submit();
			v15.submit();
		}
		GL11.glEnd();
		
		GL11.glEnable(GL11.GL_TEXTURE_2D);
        GL11.glBindTexture(GL11.GL_TEXTURE_2D,windmillTopTexture.getTextureID());
		
        //high far right
		GL11.glBegin(GL11.GL_POLYGON);{
			
			new Normal(v6.toVector(),v10.toVector(),v12.toVector(),v11.toVector()).submit();
			
			GL11.glTexCoord2f(0.0f,0.0f);
			v6.submit();
            
            GL11.glTexCoord2f(1.0f,0.0f);
            v10.submit();
            
            GL11.glTexCoord2f(1.0f,1.0f);
            v12.submit();
            
            GL11.glTexCoord2f(0.0f,1.0f);
			v11.submit();
		}
		GL11.glEnd();
	    
		//high far left
		GL11.glBegin(GL11.GL_POLYGON);{
			
			new Normal(v8.toVector(),v14.toVector(),v13.toVector(),v9.toVector()).submit();
			
			GL11.glTexCoord2f(0.0f,1.0f);
			v8.submit();
            
            GL11.glTexCoord2f(0.0f,0.0f);
            v14.submit();
            
            GL11.glTexCoord2f(1.0f,0.0f);
            v13.submit();
            
            GL11.glTexCoord2f(1.0f,1.0f);
			v9.submit();
		}
		GL11.glEnd();
	    
		//high back
		GL11.glBegin(GL11.GL_POLYGON);{
			
			new Normal(v9.toVector(),v13.toVector(),v12.toVector(),v10.toVector()).submit();
			
			GL11.glTexCoord2f(0.0f,1.0f);
			v9.submit();;
            
            GL11.glTexCoord2f(0.0f,0.0f);
            v13.submit();
            
            GL11.glTexCoord2f(1.0f,0.0f);
            v12.submit();
            
            GL11.glTexCoord2f(1.0f,1.0f);
			v10.submit();
		}
		GL11.glEnd();
	    
		//top near right
		GL11.glBegin(GL11.GL_TRIANGLES);{
			
			new Normal(v15.toVector(),v16.toVector(),v11.toVector()).submit();
			
			v15.submit();
			v16.submit();
			v11.submit();
		}
		GL11.glEnd();
		
		//top far right		
		GL11.glBegin(GL11.GL_TRIANGLES);{
					
			new Normal(v11.toVector(),v16.toVector(),v12.toVector()).submit();
			
					v11.submit();
					v16.submit();
					v12.submit();
				}
		GL11.glEnd();
				
		//top back
		GL11.glBegin(GL11.GL_TRIANGLES);{
					
			new Normal(v12.toVector(),v13.toVector(),v16.toVector()).submit();
			
					v12.submit();
					v13.submit();
					v16.submit();
				}
		GL11.glEnd();
			
		//top near left
		GL11.glBegin(GL11.GL_TRIANGLES);{
			
			new Normal(v15.toVector(),v14.toVector(),v16.toVector()).submit();
				
				v15.submit();
				v14.submit();
				v16.submit();
			
				}
		GL11.glEnd();
		
		//top far left
		GL11.glBegin(GL11.GL_TRIANGLES);{
			
			new Normal(v14.toVector(),v13.toVector(),v16.toVector()).submit();
			
				v14.submit();
				v13.submit();
				v16.submit();
				}
		GL11.glEnd();
    }
    
    private void drawUnitBlades(){
    	 GL11.glEnable(GL11.GL_TEXTURE_2D);
         GL11.glBindTexture(GL11.GL_TEXTURE_2D,windmillBladeTexture.getTextureID());
    	
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
		
		GL11.glEnable(GL11.GL_TEXTURE_2D);
         GL11.glBindTexture(GL11.GL_TEXTURE_2D,centreOfWindmillTexture.getTextureID());
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
		 GL11.glEnable(GL11.GL_TEXTURE_2D);
         GL11.glBindTexture(GL11.GL_TEXTURE_2D,centreOfWindmillTexture.getTextureID());
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
    private void drawUnitPlane()
    {
        Vertex v1 = new Vertex(-0.5f, 0.0f,-0.5f); // left,  back
        Vertex v2 = new Vertex( 0.5f, 0.0f,-0.5f); // right, back
        Vertex v3 = new Vertex( 0.5f, 0.0f, 0.5f); // right, front
        Vertex v4 = new Vertex(-0.5f, 0.0f, 0.5f); // left,  front
        
        // draw the plane geometry. order the vertices so that the plane faces up
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
        
//        // if the user is viewing an axis, then also draw this plane
//        // using lines so that axis aligned planes can still be seen
//        if(isViewingAxis())
//        {
//            // also disable textures when drawing as lines
//            // so that the lines can be seen more clearly
//            GL11.glPushAttrib(GL11.GL_TEXTURE_2D);
//            GL11.glDisable(GL11.GL_TEXTURE_2D);
//            GL11.glBegin(GL11.GL_LINE_LOOP);
//            {
//                v4.submit();
//                v3.submit();
//                v2.submit();
//                v1.submit();
//            }
//            GL11.glEnd();
//            GL11.glPopAttrib();
//        	}
    	}
    }