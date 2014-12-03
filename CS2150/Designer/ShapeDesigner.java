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
        	drawUnitBlades();
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

    	Vertex v1 = new Vertex(0.0f, 0.0f, 0.0f);
    	Vertex v2 = new Vertex(-3.0f, 0.0f, 2.0f);
    	Vertex v3 = new Vertex(-1.5f, 0.0f, 4.3f);
    	Vertex v4 = new Vertex(1.5f, 0.0f, 4.3f);
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
		
		//second horizontal blade
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

