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
		new ShapeDesigner().run( WINDOWED, "Designer", 0.1f);
    }
	 private static final int cubeList = 1;
	 private static final int prismList = 2;
	/** Draw the shape **/
    protected void drawUnitShape()
    {
    	//GL11.glNewList(cubeList,GL11.GL_COMPILE);
        //{   
        	drawUnitCube(Colour.RED,Colour.RED,Colour.RED,Colour.RED,Colour.GREEN,Colour.GREEN);
        //}
        //GL11.glEndList();
        
        //GL11.glNewList(prismList, GL11.GL_COMPILE);
        //{
        	drawUnitPrism(Colour.RED,Colour.RED,Colour.RED,Colour.RED,Colour.GREEN);
        //}
        //GL11.glEndList();
		}
    private void drawUnitCube(Colour near, Colour far, Colour left, Colour right, Colour top, Colour bottom)
    {
        // the vertices for the cube (note that all sides have a length of 1)
        Vertex v1 = new Vertex(-0.5f, -0.5f,  0.5f);
        Vertex v2 = new Vertex(-0.5f,  0.5f,  0.5f);
        Vertex v3 = new Vertex( 0.5f,  0.5f,  0.5f);
        Vertex v4 = new Vertex( 0.5f, -0.5f,  0.5f);
        Vertex v5 = new Vertex(-0.5f, -0.5f, -0.5f);
        Vertex v6 = new Vertex(-0.5f,  0.5f, -0.5f);
        Vertex v7 = new Vertex( 0.5f,  0.5f, -0.5f);
        Vertex v8 = new Vertex( 0.5f, -0.5f, -0.5f);

        // draw the near face:
        GL11.glBegin(GL11.GL_POLYGON);
        {
            near.submit();

            v3.submit();
            v2.submit();
            v1.submit();
            v4.submit();
        }
        GL11.glEnd();

        // draw the left face:
        GL11.glBegin(GL11.GL_POLYGON);
        {
            left.submit();

            v2.submit();
            v6.submit();
            v5.submit();
            v1.submit();
        }
        GL11.glEnd();

        // draw the right face:
        GL11.glBegin(GL11.GL_POLYGON);
        {
            right.submit();

            v7.submit();
            v3.submit();
            v4.submit();
            v8.submit();
        }
        GL11.glEnd();

        // draw the top face:
        GL11.glBegin(GL11.GL_POLYGON);
        {
            top.submit();

            v7.submit();
            v6.submit();
            v2.submit();
            v3.submit();
        }
        GL11.glEnd();

        // draw the bottom face:
        GL11.glBegin(GL11.GL_POLYGON);
        {
            bottom.submit();

            v4.submit();
            v1.submit();
            v5.submit();
            v8.submit();
        }
        GL11.glEnd();

        // draw the far face:
        GL11.glBegin(GL11.GL_POLYGON);
        {
            far.submit();

            v6.submit();
            v7.submit();
            v8.submit();
            v5.submit();
        }
        GL11.glEnd();
    }

    private void drawUnitPrism(Colour near, Colour end, Colour left, Colour right, Colour bottom){
    	//Vertices to be drawn
    	
    	Vertex v1 = new Vertex(0.5f, -0.5f, 0.5f);
    	Vertex v2 = new Vertex(0.0f, 0.5f, 0.5f);
    	Vertex v3 = new Vertex(-0.5f, -0.5f, 0.5f);
    	Vertex v4 = new Vertex(0.0f, 0.5f, -0.5f);
    	Vertex v5 = new Vertex(-0.5f, -0.5f,-0.5f);
    	Vertex v6 = new Vertex(0.5f, -0.5f, -0.5f);
    	
    	//draw the near face
    	
    	 GL11.glBegin(GL11.GL_POLYGON);
         {
             near.submit();

             v1.submit();
             v2.submit();
             v3.submit();
           
         }
         GL11.glEnd();
         
         //draw right side
         
         GL11.glBegin(GL11.GL_POLYGON);
         {
             right.submit();

             v4.submit();
             v2.submit();
             v1.submit();
             v6.submit();
         }
         GL11.glEnd();
    
         //draw left side
         
         GL11.glBegin(GL11.GL_POLYGON);
         {
             left.submit();

             v4.submit();
             v5.submit();
             v3.submit();
             v2.submit();
         }
         GL11.glEnd();
         
         //draw end 
         
         GL11.glBegin(GL11.GL_POLYGON);
         {
        	 end.submit();

             v4.submit();
             v6.submit();
             v5.submit();
           
         }
         GL11.glEnd();
         
         //draw bottom
         
         GL11.glBegin(GL11.GL_POLYGON);
         {
             bottom.submit();

             v3.submit();
             v5.submit();
             v6.submit();
             v1.submit();
             
         }
         GL11.glEnd();
    }

		
		//back of the laser
		/*GL11.glBegin(GL11.GL_POLYGON);
		{
			new Normal(v1.toVector(), v9.toVector(), v3.toVector(),
					v11.toVector()).submit();



			v1.submit();
			v9.submit();
			v3.submit();
			v11.submit();
			v7.submit();
			v15.submit();

			GL11.glEnd();

		}

		//bottom of the laser
		GL11.glBegin(GL11.GL_POLYGON);
		{
			new Normal(v3.toVector(), v11.toVector(), v4.toVector(),
					v12.toVector()).submit();

			v3.submit();
			v11.submit();
			v4.submit();
			v12.submit();
			v5.submit();
			v13.submit();
			v15.submit();
			v7.submit();

			GL11.glEnd();

		}

		//nozzle of the laser
		GL11.glBegin(GL11.GL_POLYGON);
		{
			new Normal(v2.toVector(), v10.toVector(), v4.toVector(),
					v12.toVector()).submit();

			v2.submit();
			v10.submit();
			v4.submit();
			v12.submit();

			GL11.glEnd();

		}

		//handle of the laser
		GL11.glBegin(GL11.GL_POLYGON);
		{
			new Normal(v6.toVector(), v14.toVector(), v8.toVector(),
					v16.toVector()).submit();

			v6.submit();
			v14.submit();
			v8.submit();
			v16.submit();

			GL11.glEnd();

		}        */
		
    }

