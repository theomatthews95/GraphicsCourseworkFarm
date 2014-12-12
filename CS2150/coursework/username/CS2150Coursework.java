/* CS2150Coursework.java
 * TODO: put your university username and full name here
 *
 * Scene Graph:
 *  Scene origin
 *  |
 *	+--[Ry(groundRotationAngle) T(0, groundVerticalValue, groundForwardValue)] Ground Plane
 *		|
 *		+--[T(0,0,-20) Rx(90) S(50,2,20)] Front Sky plane
 *		|
 *		+--[T(20,0,0) Rx(90) Rz(90) S(50,2,20)] Right sky plane
 *		|
 *		+--[T(-20,0,0) Rx(90) Rz(270) S(50,2,20)] Left sky plane
 *		|
 *		+--[T(20,0,0) Rx(90) Rz(180) S(50,2,20)] Back sky plane
 *		|
 *		+--[T(20,0,0) Rx(180) S(50,2,100)] Top sky plane
 *		| 
 *		+--[T(0,0,-10) S(150,1,70) S(1/150,1,1/70) T(0,0,10)] Ground plane
 *			| 
 *			+--[S(0.5,0.5,0.5)] Windmill body
 *				| 
 *				+--[T(0.1,-4.1,5.8) Rx(270) T(0,5.7,1) Rz(bladeRotationAngle)] Windmill blades
 *					|
 *					+--[T(0.4,3,4.1) Rz(270) Ry(90) S(0.5, 0.5, 0.5)] Bird body
 *						|
 *						+--[T(0.4,1.2,-0.2) Ry(180) Rx(wingRotationAngle)] Bird's right wing
 *						|
 *						+--[T(-0.1,1.2,0.4) Rx(wingRotationAngle)] Bird's left wing
 *
 */
package coursework.username;

import org.lwjgl.opengl.GL11;
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
    private final int birdBodyList = 4;
    private final int birdWingsList = 5;
    private Texture groundTexture;
    private Texture skyTexture;
    private Texture windmillWallTexture;
    private Texture windmillBladeTexture;
    private Texture windmillTopTexture;
    private Texture centreOfWindmillTexture;
    private Texture windmillBackTexture;
    private Texture windmillRoofTexture;
    private Texture chickenLegsTexture;
    private Texture featheredTexture;
    private Texture skyRoof;
    private Texture windmillPinTexture;
    private Texture birdFace;
    private Texture birdHead;
    private float bladeRotationAngle = 0.0f;
    private float wingRotationAngle = 0.0f;
    private float groundRotationAngle = 45.0f;
    private float groundForwardValue = 0.0f;
    private float groundVerticalValue = 0.0f;
	
    
    public static void main(String args[])
    {   new CS2150Coursework().run(WINDOWED,"CS2150 Coursework Submission",0.01f);
    	
    }

    protected void initScene() throws Exception
    {//TODO: Initialise your resources here - might well call other methods you write.
    	
    	float globalAmbient[] = {0.5f, 0.5f, 0.5f, 1.0f};
    	 
        // the first light for the scene is white...
        float diffuse0[]  = { 0.6f,  0.6f, 0.6f, 1.0f};
        // ...with a dim ambient contribution...
        float ambient0[]  = { 0.6f,  0.6f, 0.6f, 1.0f};
        // ...and is positioned above and behind the viewpoint
        float position0[] = { 0.0f, 10.0f, 010.0f, 1.0f}; 

        // supply OpenGL with the properties for the first light
        GL11.glLight(GL11.GL_LIGHT0, GL11.GL_AMBIENT, FloatBuffer.wrap(ambient0));
        GL11.glLight(GL11.GL_LIGHT0, GL11.GL_DIFFUSE, FloatBuffer.wrap(diffuse0));
  		GL11.glLight(GL11.GL_LIGHT0, GL11.GL_SPECULAR, FloatBuffer.wrap(diffuse0));
        GL11.glLight(GL11.GL_LIGHT0, GL11.GL_POSITION, FloatBuffer.wrap(position0));
        // enable the first light
        GL11.glEnable(GL11.GL_LIGHT0);
    	// set the global ambient lighting
    	GL11.glLightModel(GL11.GL_LIGHT_MODEL_AMBIENT, FloatBuffer.wrap(globalAmbient));
    	// enable lighting calculations
    	GL11.glEnable(GL11.GL_LIGHTING);
    	// ensure that all normals are automatically re-normalised
    	// after transformations
    	GL11.glEnable(GL11.GL_NORMALIZE);

        
    	groundTexture = loadTexture("coursework/username/textures/Grass.jpg");
    	skyTexture = loadTexture("coursework/username/textures/sky.png");
    	windmillWallTexture = loadTexture("coursework/username/textures/WindmillWallTexture.png");
    	windmillBladeTexture = loadTexture("coursework/username/textures/windmill arm.png");
    	windmillTopTexture = loadTexture("coursework/username/textures/WindmillWallWindowTexture.png");
    	centreOfWindmillTexture = loadTexture("coursework/username/textures/CentreWindmill.png");
    	windmillBackTexture = loadTexture("coursework/username/textures/wallWithDoor.png");
    	windmillRoofTexture = loadTexture("coursework/username/textures/WindmillRoof.jpg");
    	chickenLegsTexture = loadTexture("coursework/username/textures/ChickenLegs.png");
    	featheredTexture = loadTexture("coursework/username/textures/featherTexture.jpg");
    	skyRoof = loadTexture("coursework/username/textures/SkyRoof.png");
    	windmillPinTexture = loadTexture("coursework/username/textures/pinTexture.png");
    	birdFace = loadTexture("coursework/username/textures/birdFace.png");
    	birdHead = loadTexture("coursework/username/textures/birdHead.png");
    	GL11.glNewList(windmillBodyList, GL11.GL_COMPILE);
    	{	
    		drawUnitWindmill();

    		GL11.glRotatef(90.0f, 1.0f, 0.0f, 0.0f);
    		GL11.glTranslatef(-0.1f, 3.8f, -5.8f);
    		drawUnitWindmillPin();
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
        GL11.glNewList(birdBodyList,GL11.GL_COMPILE);
        {  
        	drawUnitBirdBody();
        }
        GL11.glEndList();
        GL11.glNewList(birdWingsList, GL11.GL_COMPILE);
        {
        	drawUnitBirdWings();
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
    		if (bladeRotationAngle < -360.0f) // Wrap the angle back around into 0-360 degrees.
            {  bladeRotationAngle = 0.0f;
            }
    	}
    	if(Keyboard.isKeyDown(Keyboard.KEY_F))
    			{
    		wingRotationAngle += -0.1f;
    		if (wingRotationAngle < -45.0f) // Wrap the angle back around into 0-360 degrees.
            {  wingRotationAngle = 45.0f;
            }
    		
    			}
    	if(Keyboard.isKeyDown(Keyboard.KEY_LEFT))
    	{
    		groundRotationAngle += 0.01f;
    		
    	}
    	if(Keyboard.isKeyDown(Keyboard.KEY_RIGHT))
    	{
    		groundRotationAngle += -0.01f;
    		
    	}
    	if(Keyboard.isKeyDown(Keyboard.KEY_UP))
    	{
    		if(groundForwardValue > 8.0f){groundForwardValue += 0.0f;}else{
        	groundForwardValue += 0.001f;}
    		
    	}
    	if(Keyboard.isKeyDown(Keyboard.KEY_DOWN))
    	{
    		if(groundForwardValue < -8.0f){groundForwardValue += 0.0f;}else{
        	groundForwardValue += -0.001f;}
    		
    	}
    	if(Keyboard.isKeyDown(Keyboard.KEY_U))
    	{
    		if(groundVerticalValue < -5.0f){groundVerticalValue += 0.0f;}else{

        		groundVerticalValue += -0.001f;}
    		
    	}
    	if(Keyboard.isKeyDown(Keyboard.KEY_D))
    	{
    		if(groundVerticalValue > 2.5f){groundVerticalValue += 0.0f;}else{
    			groundVerticalValue += 0.001f;}
    		
    	}
    	if(Keyboard.isKeyDown(Keyboard.KEY_SPACE)){
    	
    	   groundRotationAngle = 0.0f;
    	   groundForwardValue = 0.0f;
    	   groundVerticalValue = 0.0f;
    	   bladeRotationAngle = 0.0f;
    	   wingRotationAngle = 0.0f;
    		
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
    	bladeRotationAngle += -0.03f;
    	
    	//whole scene
    	GL11.glPushMatrix();{
      	  GL11.glRotatef(groundRotationAngle, 0.0f, 1.0f, 0.0f);
      	 
      	  GL11.glTranslatef(0.0f,groundVerticalValue,groundForwardValue);
      	//draw the back sky plane
	    	GL11.glPushMatrix();
	        {
	        	
	            // enable texturing and bind an appropriate texture
	            GL11.glEnable(GL11.GL_TEXTURE_2D);
	            GL11.glBindTexture(GL11.GL_TEXTURE_2D,skyTexture.getTextureID());
	            
	            // position, scale and draw the back plane using its display list
	            GL11.glTranslatef(0.0f,0.0f,-20.0f);
	            GL11.glRotatef(90.0f, 1.0f, 0.0f, 0.0f);
	            GL11.glScalef(50.0f, 2.0f, 20.0f);
	            GL11.glCallList(planeList);
	            
	            // disable textures and reset any local lighting changes
	            GL11.glDisable(GL11.GL_TEXTURE_2D);
	            GL11.glPopAttrib();
	        }
	        GL11.glPopMatrix();
	    	
	        //draw right sky plane
	        GL11.glPushMatrix();
	        {
	        	
	            // enable texturing and bind an appropriate texture
	            GL11.glEnable(GL11.GL_TEXTURE_2D);
	            GL11.glBindTexture(GL11.GL_TEXTURE_2D,skyTexture.getTextureID());
	            
	            // position, scale and draw the back plane using its display list
	            GL11.glTranslatef(20.0f,0.0f,0.0f);
	            GL11.glRotatef(90.0f, 1.0f, 0.0f, 0.0f);
	            GL11.glRotatef(90.0f, 0.0f, 0.0f, 1.0f);
	            GL11.glScalef(50.0f, 2.0f, 20.0f);
	            GL11.glCallList(planeList);
	            
	            // disable textures and reset any local lighting changes
	            GL11.glDisable(GL11.GL_TEXTURE_2D);
	            GL11.glPopAttrib();
	        }
	        GL11.glPopMatrix();
	      //draw left sky plane
	        GL11.glPushMatrix();
	        {
	        	
	            // enable texturing and bind an appropriate texture
	            GL11.glEnable(GL11.GL_TEXTURE_2D);
	            GL11.glBindTexture(GL11.GL_TEXTURE_2D,skyTexture.getTextureID());
	       
	            // position, scale and draw the back plane using its display list
	            GL11.glTranslatef(-20.0f,0.0f,0.0f);
	            GL11.glRotatef(90.0f, 1.0f, 0.0f, 0.0f);
	            GL11.glRotatef(270.0f, 0.0f, 0.0f, 1.0f);
	            GL11.glScalef(50.0f, 2.0f, 20.0f);
	            GL11.glCallList(planeList);
	            
	            // disable textures and reset any local lighting changes
	            GL11.glDisable(GL11.GL_TEXTURE_2D);
	            GL11.glPopAttrib();
	        }
	        GL11.glPopMatrix();
	        
	        //draw back sky plane
	        GL11.glPushMatrix();
	        {
	        	
	            // enable texturing and bind an appropriate texture
	            GL11.glEnable(GL11.GL_TEXTURE_2D);
	            GL11.glBindTexture(GL11.GL_TEXTURE_2D,skyTexture.getTextureID());
	            
	            // position, scale and draw the back plane using its display list
	            GL11.glTranslatef(0.0f,0.0f,20.0f);
	            GL11.glRotatef(90.0f, 1.0f, 0.0f, 0.0f);
	            GL11.glRotatef(180.0f, 0.0f, 0.0f, 1.0f);
	            GL11.glScalef(50.0f, 2.0f, 20.0f);
	            GL11.glCallList(planeList);
	            
	            // disable textures and reset any local lighting changes
	            GL11.glDisable(GL11.GL_TEXTURE_2D);
	            GL11.glPopAttrib();
	        }
	        GL11.glPopMatrix();
	        
	        //draw top sky plane
	        GL11.glPushMatrix();
	        {
	        	
	            // enable texturing and bind an appropriate texture
	            GL11.glEnable(GL11.GL_TEXTURE_2D);
	            GL11.glBindTexture(GL11.GL_TEXTURE_2D,skyRoof.getTextureID());
	            
	            // position, scale and draw the back plane using its display list
	            GL11.glTranslatef(0.0f,10.0f,0.0f);
	            GL11.glRotatef(180.0f, 1.0f, 0.0f, 0.0f);
	           
	            GL11.glScalef(50.0f, 2.0f, 100.0f);
	            GL11.glCallList(planeList);
	            
	            // disable textures and reset any local lighting changes
	            GL11.glDisable(GL11.GL_TEXTURE_2D);
	            GL11.glPopAttrib();
	        }
	        GL11.glPopMatrix();
	        // draw the ground plane
	        GL11.glPushMatrix();
	        {
	        	
	            // enable texturing and bind an appropriate texture
	            GL11.glEnable(GL11.GL_TEXTURE_2D);
	            GL11.glBindTexture(GL11.GL_TEXTURE_2D,groundTexture.getTextureID());
	            
	            // position, scale and draw the ground plane using its display list
	            GL11.glTranslatef(0.0f,0.0f,-10.0f);
	            GL11.glScalef(150.0f, 1.0f, 70.0f);
	            GL11.glCallList(planeList);
	            GL11.glScalef(1/150.0f, 1.0f, 1/70.0f);
	            GL11.glTranslatef(0.0f, 0.0f, 10.0f);
	            
	            // disable textures and reset any local lighting changes
	            GL11.glDisable(GL11.GL_TEXTURE_2D);
	            GL11.glPopAttrib();
	        
	        
	        
		        //windmill body list
		        GL11.glPushMatrix();
		        {
		        	
		            // enable texturing and bind an appropriate texture
		        	GL11.glEnable(GL11.GL_TEXTURE_2D);
		            GL11.glBindTexture(GL11.GL_TEXTURE_2D,windmillWallTexture.getTextureID());
			        GL11.glScalef(0.5f, 0.5f, 0.5f);	
			        GL11.glCallList(windmillBodyList);
	
			        GL11.glDisable(GL11.GL_TEXTURE_2D);
		            GL11.glPopAttrib();
	        
	       
	        
			        //windmill blades list
			        GL11.glPushMatrix();
			        {
			        	 // how shiny are the blades (specular exponent)
			            float bladeFrontShininess  = 100.0f;
			            // specular reflection of the blades
			            float bladeFrontSpecular[] = {100.8f, 100.8f, 100.8f, 1.0f};
			            // diffuse reflection of the blades
			            float bladeFrontDiffuse[]  = {0.8f, 0.8f, 0.8f, 1.0f};
			            
			            // set the material properties for the house using OpenGL
			            GL11.glMaterialf(GL11.GL_FRONT, GL11.GL_SHININESS, bladeFrontShininess);
			            GL11.glMaterial(GL11.GL_FRONT, GL11.GL_SPECULAR, FloatBuffer.wrap(bladeFrontSpecular));
			            GL11.glMaterial(GL11.GL_FRONT, GL11.GL_DIFFUSE, FloatBuffer.wrap(bladeFrontDiffuse));
			            GL11.glMaterial(GL11.GL_FRONT, GL11.GL_AMBIENT, FloatBuffer.wrap(bladeFrontDiffuse));
	
	            // enable texturing and bind an appropriate texture
			            GL11.glTranslatef(0.1f, -4.1f, 5.8f);
			            GL11.glRotatef(270.0f, 1.0f, 0.0f, 0.0f);
			            GL11.glTranslatef(0.0f, 5.7f, 1.0f);
	
				       
				        GL11.glRotatef(bladeRotationAngle, 0.0f, 0.0f, 1.0f);
				        GL11.glCallList(windmillBladeList);
				        GL11.glDisable(GL11.GL_TEXTURE_2D);
			            GL11.glPopAttrib();
			        
			       
			    
			        
				        //bird draw list
				        GL11.glPushMatrix();
			        	{
			        		
			        		GL11.glTranslatef(0.4f, 3.0f, 4.1f);
			        		GL11.glRotatef(270.0f, 0.0f, 0.0f, 1.0f);
			        		GL11.glRotatef(90.0f, 0.0f, 1.0f, 0.0f);
			        		GL11.glScalef(0.5f, 0.5f, 0.5f);
			        	    GL11.glCallList(birdBodyList);
			        	
			        	    //Draw right wing
			        	    GL11.glPushMatrix();
			        	    	{	
			        	    		GL11.glPushAttrib(GL11.GL_LIGHTING_BIT);
			        	            GL11.glDisable(GL11.GL_LIGHTING);
			    		            GL11.glEnable(GL11.GL_TEXTURE_2D);
			    		            GL11.glBindTexture(GL11.GL_TEXTURE_2D, featheredTexture.getTextureID());
			    		          
			        	         GL11.glTranslatef(0.4f, 1.2f, -0.2f);
			        	    		GL11.glRotatef(180.0F, 0.0f, 1.0f, 0.0f);
			        	    		
			        	    		GL11.glRotatef(wingRotationAngle, 1.0f, 0.0f, 0.0f);
			        	    		
			        	    		GL11.glCallList(birdWingsList);
			        	    		 GL11.glDisable(GL11.GL_TEXTURE_2D);
			        	             GL11.glPopAttrib();
			        	    	}
			        	    GL11.glPopMatrix();
			        	
			        	    //draw left wing
			        	    GL11.glPushMatrix();
			        	    {		
			        	    	GL11.glPushAttrib(GL11.GL_LIGHTING_BIT);
			                    GL11.glDisable(GL11.GL_LIGHTING);
					            GL11.glEnable(GL11.GL_TEXTURE_2D);
					            GL11.glBindTexture(GL11.GL_TEXTURE_2D, featheredTexture.getTextureID());
					          
			        	    		GL11.glTranslatef(-0.1f, 1.2f, 0.4f);
			        	    		GL11.glRotatef(wingRotationAngle, 1.0f, 0.0f, 0.0f);
			        	    		
			        	    		GL11.glCallList(birdWingsList);
			        	    		 GL11.glDisable(GL11.GL_TEXTURE_2D);
			        	             GL11.glPopAttrib();
			        	    }
			        	    GL11.glPopMatrix();
			        		}
			        	GL11.glPopMatrix();
			        	}
		        	GL11.glPopMatrix();
		        }
	        	GL11.glPopMatrix();
	        }	
	        GL11.glPopMatrix();
	    }
   GL11.glPopMatrix();}
    protected void setSceneCamera()
    {
        // call the default behaviour defined in GraphicsLab. This will set a default perspective projection
        // and default camera settings ready for some custom camera positioning below...  
        super.setSceneCamera();
        //TODO: If it is appropriate for your scene, modify the camera's position and orientation here
        //        using a call to GL11.gluLookAt(...)
        GLU.gluLookAt(0.0f,5.0f,12.0f,0.0f,0.0f,0.0f,0.0f,1.0f,0.0f);

   }

    protected void cleanupScene()
    {//TODO: Clean up your resources here
    }
   
    
    private void drawUnitWindmill(){
   
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
			
			GL11.glTexCoord2f(1.0f,1.0f);
			v1.submit();
            
            GL11.glTexCoord2f(1.0f,0.0f);
            v7.submit();
            
            GL11.glTexCoord2f(0.0f,0.0f);
            v8.submit();
            
            GL11.glTexCoord2f(0.0f,1.0f);
			v2.submit();
			
		}
//		
		//near right side
		GL11.glBegin(GL11.GL_POLYGON);{
			
			new Normal(v1.toVector(),v5.toVector(),v6.toVector(),v7.toVector()).submit();
			GL11.glTexCoord2f(1.0f,1.0f);
			v1.submit();
            
            GL11.glTexCoord2f(1.0f,0.0f);
            v5.submit();
            
            GL11.glTexCoord2f(0.0f,0.0f);
			v6.submit();
            
            GL11.glTexCoord2f(0.0f,1.0f);
			v7.submit();
		}
		GL11.glEnd();
	    
//		GL11.glEnable(GL11.GL_TEXTURE_2D);
//        GL11.glBindTexture(GL11.GL_TEXTURE_2D,windmillWallTexture.getTextureID());
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
//	
//		GL11.glEnable(GL11.GL_TEXTURE_2D);
//        GL11.glBindTexture(GL11.GL_TEXTURE_2D,windmillWallTexture.getTextureID());
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
	    
		
		GL11.glEnable(GL11.GL_TEXTURE_2D);
        GL11.glBindTexture(GL11.GL_TEXTURE_2D,windmillBackTexture.getTextureID());
		GL11.glBegin(GL11.GL_POLYGON);{
			//back
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

		GL11.glEnable(GL11.GL_TEXTURE_2D);
        GL11.glBindTexture(GL11.GL_TEXTURE_2D,windmillTopTexture.getTextureID());
		//high left
		GL11.glBegin(GL11.GL_POLYGON);{
			
			new Normal(v8.toVector(),v7.toVector(),v15.toVector(),v14.toVector()).submit();
			
			GL11.glTexCoord2f(0.0f,0.0f);
			v8.submit();
            
            GL11.glTexCoord2f(1.0f,0.0f);
			v7.submit();
            
            GL11.glTexCoord2f(1.0f,1.0f);
			v15.submit();
            
            GL11.glTexCoord2f(0.0f,1.0f);
			v14.submit();
		}
		GL11.glEnd();
	    
		//high right
		GL11.glBegin(GL11.GL_POLYGON);{
			
			new Normal(v7.toVector(),v6.toVector(),v11.toVector(),v15.toVector()).submit();
			GL11.glTexCoord2f(0.0f,0.0f);
			v7.submit();
            
            GL11.glTexCoord2f(1.0f,0.0f);
            v6.submit();
            
            GL11.glTexCoord2f(1.0f,1.0f);
            v11.submit();
            
            GL11.glTexCoord2f(0.0f,1.0f);
			v15.submit();
		}
		GL11.glEnd();
		
		
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
	    
		GL11.glEnable(GL11.GL_TEXTURE_2D);
        GL11.glBindTexture(GL11.GL_TEXTURE_2D,windmillRoofTexture.getTextureID());
		//top near right
		GL11.glBegin(GL11.GL_TRIANGLES);{
			
			new Normal(v15.toVector(),v16.toVector(),v11.toVector()).submit();
			GL11.glTexCoord2f(0.0f,0.0f);
			v15.submit();
			
			GL11.glTexCoord2f(1.0f,0.0f);
			v16.submit();
			
			GL11.glTexCoord2f(0.5f,1.0f);
			v11.submit();
		}
		GL11.glEnd();
		
		//top far right		
		GL11.glBegin(GL11.GL_TRIANGLES);{
					
			new Normal(v11.toVector(),v16.toVector(),v12.toVector()).submit();
					
			GL11.glTexCoord2f(0.0f,0.0f);
			v11.submit();
			
			GL11.glTexCoord2f(1.0f,0.0f);
			v16.submit();
			
			GL11.glTexCoord2f(0.5f,1.0f);
			v12.submit();
				}
		GL11.glEnd();
				
		//top back
		GL11.glBegin(GL11.GL_TRIANGLES);{
					
			new Normal(v12.toVector(),v13.toVector(),v16.toVector()).submit();
			
			GL11.glTexCoord2f(0.0f,0.0f);
			v12.submit();
			
			GL11.glTexCoord2f(1.0f,0.0f);
			v13.submit();
			
			GL11.glTexCoord2f(0.5f,1.0f);
			v16.submit();
				}
		GL11.glEnd();
			
		//top near left
		GL11.glBegin(GL11.GL_TRIANGLES);{
			
			new Normal(v15.toVector(),v14.toVector(),v16.toVector()).submit();
				
			GL11.glTexCoord2f(0.0f,0.0f);
			v15.submit();
			
			GL11.glTexCoord2f(1.0f,0.0f);
			v14.submit();
			
			GL11.glTexCoord2f(0.5f,1.0f);
			v16.submit();
			
				}
		GL11.glEnd();
		
		//top far left
		GL11.glBegin(GL11.GL_TRIANGLES);{
			
			new Normal(v14.toVector(),v13.toVector(),v16.toVector()).submit();
			
			GL11.glTexCoord2f(0.0f,0.0f);
			v14.submit();
			
			GL11.glTexCoord2f(1.0f,0.0f);
			v13.submit();
			
			GL11.glTexCoord2f(0.5f,1.0f);
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
		
		
		//right far edge
		GL11.glBegin(GL11.GL_POLYGON);
    	{
    		new Normal(v10.toVector(),v22.toVector(),v21.toVector(),v9.toVector()).submit();
    		//GL11.glTexCoord2f(0.0f,0.0f);
    		v10.submit();
            
         //   GL11.glTexCoord2f(1.0f,0.0f);
            v22.submit();
            
        //    GL11.glTexCoord2f(1.0f,1.0f);
            v21.submit();
            
         //   GL11.glTexCoord2f(0.0f,1.0f);
			v9.submit();
    		
		}
		GL11.glEnd();
		
		//right up edge
		GL11.glBegin(GL11.GL_POLYGON);
    	{
    		new Normal(v15.toVector(),v3.toVector(),v9.toVector(),v21.toVector()).submit();
    	//	GL11.glTexCoord2f(0.0f,0.0f);
    		v15.submit();
            
       //     GL11.glTexCoord2f(1.0f,0.0f);
            v3.submit();
            
      //      GL11.glTexCoord2f(1.0f,1.0f);
            v9.submit();
            
      //      GL11.glTexCoord2f(0.0f,1.0f);
			v21.submit();
    		
		}
		GL11.glEnd();
		
		//right bottom edge
		GL11.glBegin(GL11.GL_POLYGON);
    	{
    		new Normal(v2.toVector(),v14.toVector(),v22.toVector(),v10.toVector()).submit();
    //		GL11.glTexCoord2f(0.0f,0.0f);
    		v2.submit();
            
      //      GL11.glTexCoord2f(1.0f,0.0f);
            v14.submit();
            
     //       GL11.glTexCoord2f(1.0f,1.0f);
            v22.submit();
            
     //       GL11.glTexCoord2f(0.0f,1.0f);
			v10.submit();
    		
		}
		GL11.glEnd();
		
		//top top edge
		GL11.glBegin(GL11.GL_POLYGON);
    	{
    		new Normal(v17.toVector(),v5.toVector(),v6.toVector(),v18.toVector()).submit();
    	//	GL11.glTexCoord2f(0.0f,0.0f);
    		v17.submit();
            
        //    GL11.glTexCoord2f(1.0f,0.0f);
            v5.submit();
            
        //    GL11.glTexCoord2f(1.0f,1.0f);
            v6.submit();
            
       //     GL11.glTexCoord2f(0.0f,1.0f);
			v18.submit();
    		
		}
		GL11.glEnd();
		
		//top right edge
		GL11.glBegin(GL11.GL_POLYGON);
    	{
    		new Normal(v3.toVector(),v15.toVector(),v18.toVector(),v6.toVector()).submit();
    	//	GL11.glTexCoord2f(0.0f,0.0f);
    		v3.submit();
            
       //     GL11.glTexCoord2f(1.0f,0.0f);
            v15.submit();
            
       //     GL11.glTexCoord2f(1.0f,1.0f);
            v18.submit();
            
        //    GL11.glTexCoord2f(0.0f,1.0f);
			v6.submit();
    		
		}
		GL11.glEnd();
		
		
		//top left edge
		GL11.glBegin(GL11.GL_POLYGON);
    	{
    		new Normal(v16.toVector(),v4.toVector(),v5.toVector(),v17.toVector()).submit();
    	//	GL11.glTexCoord2f(0.0f,0.0f);
    		v16.submit();
            
         //   GL11.glTexCoord2f(1.0f,0.0f);
            v4.submit();
            
      //     GL11.glTexCoord2f(1.0f,1.0f);
            v5.submit();
            
       //     GL11.glTexCoord2f(0.0f,1.0f);
			v17.submit();
    		
		}
		GL11.glEnd();
		
		
		//left far edge
		GL11.glBegin(GL11.GL_POLYGON);
    	{
    		new Normal(v11.toVector(),v23.toVector(),v24.toVector(),v12.toVector()).submit();
    		//GL11.glTexCoord2f(0.0f,0.0f);
    		v11.submit();
            
           // GL11.glTexCoord2f(1.0f,0.0f);
            v23.submit();
            
        //    GL11.glTexCoord2f(1.0f,1.0f);
            v24.submit();
            
       //     GL11.glTexCoord2f(0.0f,1.0f);
			v12.submit();
    		
		}
		GL11.glEnd();
		
		//left top edge
		GL11.glBegin(GL11.GL_POLYGON);
    	{
    		new Normal(v23.toVector(),v11.toVector(),v4.toVector(),v16.toVector()).submit();
    		//GL11.glTexCoord2f(0.0f,0.0f);
    		v23.submit();
            
       //     GL11.glTexCoord2f(1.0f,0.0f);
            v11.submit();
            
       //     GL11.glTexCoord2f(1.0f,1.0f);
            v4.submit();
            
     //       GL11.glTexCoord2f(0.0f,1.0f);
			v16.submit();
    		
		}
		GL11.glEnd();
		
		
		//left bottom edge
		GL11.glBegin(GL11.GL_POLYGON);
    	{
    		new Normal(v12.toVector(),v24.toVector(),v13.toVector(),v1.toVector()).submit();
    	//	GL11.glTexCoord2f(0.0f,0.0f);
    		v12.submit();
            
       //     GL11.glTexCoord2f(1.0f,0.0f);
            v24.submit();
            
       //     GL11.glTexCoord2f(1.0f,1.0f);
            v13.submit();
            
    //        GL11.glTexCoord2f(0.0f,1.0f);
			v1.submit();
    		
		}
		GL11.glEnd();
		
		//bottom far edge
		GL11.glBegin(GL11.GL_POLYGON);
    	{
    		new Normal(v7.toVector(),v19.toVector(),v20.toVector(),v8.toVector()).submit();
    //		GL11.glTexCoord2f(0.0f,0.0f);
    		v7.submit();
            
       //     GL11.glTexCoord2f(1.0f,0.0f);
            v19.submit();
            
      //      GL11.glTexCoord2f(1.0f,1.0f);
            v20.submit();
            
      //      GL11.glTexCoord2f(0.0f,1.0f);
			v8.submit();
    		
		}
		GL11.glEnd();
		
		//bottom right edge
		GL11.glBegin(GL11.GL_POLYGON);
    	{
    		new Normal(v8.toVector(),v20.toVector(),v14.toVector(),v2.toVector()).submit();
    //		GL11.glTexCoord2f(0.0f,0.0f);
    		v8.submit();
            
     //       GL11.glTexCoord2f(1.0f,0.0f);
            v20.submit();
            
     //       GL11.glTexCoord2f(1.0f,1.0f);
            v14.submit();
            
   //         GL11.glTexCoord2f(0.0f,1.0f);
			v2.submit();
    		
		}
		GL11.glEnd();
		
		//bottom left edge
		GL11.glBegin(GL11.GL_POLYGON);
    	{
    		new Normal(v19.toVector(),v7.toVector(),v1.toVector(),v13.toVector()).submit();
    //		GL11.glTexCoord2f(0.0f,0.0f);
    		v19.submit();
            
      //      GL11.glTexCoord2f(1.0f,0.0f);
            v7.submit();
            
     //       GL11.glTexCoord2f(1.0f,1.0f);
            v1.submit();
            
     //       GL11.glTexCoord2f(0.0f,1.0f);
			v13.submit();
    		
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
    }
    
    private void drawUnitWindmillPin(){
    	
    	Vertex v1 = new Vertex(0.0f, 0.0f,0.0f);
    	Vertex v2 = new Vertex(0.2f, 0.0f,0.0f);
    	Vertex v3 = new Vertex(0.2f, 0.0f,0.2f);
    	Vertex v4 = new Vertex(0.0f, 0.0f,0.2f);
    	Vertex v5 = new Vertex(0.0f, 0.8f,0.2f);
    	Vertex v6 = new Vertex(0.0f, 0.8f,0.0f);
    	Vertex v7 = new Vertex(0.2f, 0.8f,0.0f);
    	Vertex v8 = new Vertex(0.2f, 0.8f,0.2f);
    	
    	GL11.glEnable(GL11.GL_TEXTURE_2D);
        GL11.glBindTexture(GL11.GL_TEXTURE_2D,windmillPinTexture.getTextureID());
        
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
    
    private void drawUnitBirdBody(){
    	
    	Vertex v1 = new Vertex(-0.8f, 2.3f,-0.2f);
    	Vertex v2 = new Vertex(-0.8f, 2.3f,0.4f);
    	Vertex v3 = new Vertex(-0.6f, 2.5f,0.4f);
    	Vertex v4 = new Vertex(-0.6f, 2.5f,-0.2f);
    	Vertex v5 = new Vertex(-0.6f, 2.1f,-0.2f);
    	Vertex v6 = new Vertex(-0.6f, 2.1f,0.4f);
    	Vertex v7 = new Vertex(-0.2f, 0.8f,0.4f);
    	Vertex v8 = new Vertex(-0.2f, 1.8f,0.4f);
    	Vertex v9 = new Vertex(-0.2f, 1.8f,-0.2f);
    	Vertex v10 = new Vertex(-0.2f, 0.8f,-0.2f);
    	Vertex v11 = new Vertex(0.6f, 0.8f,-0.2f);
    	Vertex v12 = new Vertex(0.6f, 0.8f,0.4f);
    	Vertex v13 = new Vertex(0.6f, 1.8f,0.4f);
    	Vertex v14 = new Vertex(0.6f, 1.8f,-0.2f);
    	Vertex v31 = new Vertex(0.2f, 0.8f,0.2f);
    	Vertex v32 = new Vertex(0.2f, 0.8f,0.0f);
    	Vertex v33 = new Vertex(0.0f, 0.8f,0.0f);
    	Vertex v34 = new Vertex(0.0f, 0.8f,0.2f);
    	Vertex v35 = new Vertex(0.0f, 0.0f,0.2f);
    	Vertex v36 = new Vertex(0.2f, 0.0f,0.2f);
    	Vertex v37 = new Vertex(0.2f, 0.0f,0.0f);
    	Vertex v38 = new Vertex(0.0f, 0.0f,0.0f);
    	
    	
    	
   	 GL11.glEnable(GL11.GL_TEXTURE_2D);
     GL11.glBindTexture(GL11.GL_TEXTURE_2D,	chickenLegsTexture.getTextureID());
   
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
        
       
        GL11.glEnable(GL11.GL_TEXTURE_2D);
        GL11.glBindTexture(GL11.GL_TEXTURE_2D, featheredTexture.getTextureID());
      
        
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
       
        GL11.glEnable(GL11.GL_TEXTURE_2D);
        GL11.glBindTexture(GL11.GL_TEXTURE_2D,birdHead.getTextureID());
        //bottom front of head
        GL11.glBegin(GL11.GL_POLYGON);
        {
            new Normal(v1.toVector(),v2.toVector(),v6.toVector(),v5.toVector()).submit();
            
            GL11.glTexCoord2f(0.0f,1.0f);
            v1.submit();
            
            GL11.glTexCoord2f(1.0f,1.0f);
            v2.submit();
            
            GL11.glTexCoord2f(1.0f,0.0f);
            v6.submit();
            
            GL11.glTexCoord2f(0.0f,0.0f);
            v5.submit();
        }
        GL11.glEnd();
        
        //right side of head
        GL11.glBegin(GL11.GL_TRIANGLES);
        {
            new Normal(v2.toVector(),v6.toVector(),v3.toVector()).submit();
            
            GL11.glTexCoord2f(1.0f,1.0f);
            v2.submit();
            
            GL11.glTexCoord2f(0.0f,0.0f);
            v6.submit();
            
            GL11.glTexCoord2f(1.0f,0.0f);
            v3.submit();
            
        }
        GL11.glEnd();
        
        //left side of head
        GL11.glBegin(GL11.GL_TRIANGLES);
        {
            new Normal(v1.toVector(),v4.toVector(),v5.toVector()).submit();
            
            GL11.glTexCoord2f(1.0f,1.0f);
            v1.submit();
            
            GL11.glTexCoord2f(0.0f,0.0f);
            v4.submit();
            
            GL11.glTexCoord2f(1.0f,0.0f);
            v5.submit();
            
        }
        GL11.glEnd();
        
        GL11.glEnable(GL11.GL_TEXTURE_2D);
        GL11.glBindTexture(GL11.GL_TEXTURE_2D,birdFace.getTextureID());
        
        //top front of head
        GL11.glBegin(GL11.GL_POLYGON);
        {
            new Normal(v4.toVector(),v3.toVector(),v2.toVector(),v1.toVector()).submit();
            
            GL11.glTexCoord2f(1.0f,1.0f);
            v4.submit();
            
            GL11.glTexCoord2f(0.0f,1.0f);
            v3.submit();
            
            GL11.glTexCoord2f(0.0f,.0f);
            v2.submit();
            
            GL11.glTexCoord2f(1.0f,0.0f);
            v1.submit();
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