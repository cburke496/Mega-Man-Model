package megaman;

import javax.media.opengl.GL2;
import javax.media.opengl.GLAutoDrawable;
import javax.media.opengl.glu.GLU;

public class Enemy {

    public GLU glu = Main.glu;
    private float xCoor;
    private float zCoor;
    private float angle;

    public Enemy( float xCoor, float zCoor, float angle) {
        this.xCoor = xCoor;
        this.zCoor = zCoor;
        this.angle = angle;
    }

    
    public float getXCoor() {
        return xCoor;
    }
    
    public float getZCoor() {
        return zCoor;
    }
    
    //public float getRad() {
    //    return rad;
    //}
    
    public void drawEnemy( GLAutoDrawable drawable ) {
        GL2 gl = drawable.getGL().getGL2();

        gl.glPushMatrix();
        gl.glTranslatef( xCoor, 0, zCoor );
        gl.glRotatef( angle, 0.0f, 1.0f, 0.0f );
        // Torso
        gl.glColor3f( 1.0f, 0.5f, 0.0f );
        Main.drawCylinder( drawable, Main.torsoRad, Main.torsoH );

        // Head
        gl.glPushMatrix();
        gl.glTranslatef( 0.0f, Main.torsoH + Main.headOffset, 0.0f );
        gl.glColor3f( 1.0f, 0.0f, 0.0f );
        gl.glRotatef( 90f, -1.0f, 0.0f, 0.0f );
        gl.glRotatef( 180f, 0.0f, 1.0f, 0.0f );
        Main.drawSphere( Main.headRad);
        gl.glPopMatrix();

        // Pelvis
        gl.glPushMatrix();
        gl.glColor3f( 1.0f, 0.0f, 0.0f );
        Main.drawSphere( Main.torsoRad - 0.01f );
        gl.glPopMatrix();

        // Legs
        gl.glPushMatrix();
        gl.glRotatef( 180f, 0.0f, 0.0f, 1.0f );

        // Left Leg
        gl.glPushMatrix();
        gl.glColor3f( 1.0f, 0.5f, 0.0f );
        gl.glTranslatef( Main.torsoRad / -3.0f, 0.0f, 0.0f );
        gl.glRotatef( 5f, 0.0f, 0.0f, 1.0f );
        Main.drawCylinder( drawable, Main.limbRad, Main.thighLen );
        gl.glColor3f( 1.0f, 0.5f, 0.0f );
        gl.glTranslatef( 0.0f, Main.thighLen, 0.0f );
        Main.drawSphere( Main.limbRad + 0.005f );
        gl.glColor3f( 1.0f, 0.0f, 0.0f );
        gl.glRotatef( -5f, 0.0f, 0.0f, 1.0f );
        Main.drawCylinder( drawable, Main.limbRad, Main.calfLen );
        gl.glColor3f( 1.0f, 0.0f, 0.0f );
        gl.glPopMatrix();

        // Right Leg
        gl.glPushMatrix();
        gl.glColor3f( 1.0f, 0.5f, 0.0f );
        gl.glTranslatef( Main.torsoRad / 3.0f, 0.0f, 0.0f );
        gl.glRotatef( -5f, 0.0f, 0.0f, 1.0f );
        Main.drawCylinder( drawable, Main.limbRad, Main.thighLen );
        gl.glColor3f( 1.0f, 0.5f, 0.0f );
        gl.glTranslatef( 0.0f, Main.thighLen, 0.0f );
        Main.drawSphere( Main.limbRad + 0.005f );
        gl.glColor3f( 1.0f, 0.0f, 0.0f );
        gl.glRotatef( 5f, 0.0f, 0.0f, 1.0f );
        Main.drawCylinder( drawable, Main.limbRad, Main.calfLen );
        gl.glColor3f( 1.0f, 0.0f, 0.0f );
        gl.glPopMatrix();

        gl.glPopMatrix();

        // Arms
        gl.glPushMatrix();
        gl.glTranslatef( 0.0f, Main.shoulderH, 0.0f );

        // Blaster Arm
        gl.glPushMatrix();
        gl.glColor3f( 1.0f, 0.5f, 0.0f );
        gl.glTranslatef( -5.0f / 6.0f * Main.torsoRad, 0.0f, 0.0f );
        gl.glRotatef( 135f, 0.0f, 0.0f, 1.0f );
        Main.drawCylinder( drawable, Main.limbRad, Main.upperArmLen );
        gl.glColor3f( 1.0f, 0.5f, 0.0f );
        gl.glTranslatef( 0.0f, Main.upperArmLen, 0.0f );
        Main.drawSphere( Main.limbRad + 0.005f );
        gl.glColor3f( 1.0f, 0.0f, 0.0f );
        gl.glRotatef( 15.0f, 0.0f, 0.0f, 1.0f );
        Main.drawCylinder( drawable, Main.limbRad, Main.elbowToBlaster );
        gl.glColor3f( 1.0f, 0.0f, 0.0f );
        gl.glTranslatef( 0.0f, Main.elbowToBlaster, 0.0f );
        Main.drawCylinder( drawable, Main.blasterRad1, Main.blasterLen1 );
        gl.glColor3f( 1.0f, 0.0f, 0.0f );
        gl.glColor3f( 1.0f, 0.0f, 0.0f );
        Main.drawCylinder( drawable, Main.blasterRad2, Main.blasterLen1 + 0.01f );
        gl.glColor3f( 1.0f, 0.0f, 0.0f );
        gl.glTranslatef( 0.0f, Main.blasterLen1 + 0.001f, 0.0f );
        gl.glColor3f( 1.0f, 0.0f, 0.0f );
        Main.drawInverseCylinder( drawable, Main.limbRad, Main.blasterRad2, Main.blasterLen2 );
        gl.glColor3f( 1.0f, 0.0f, 0.0f );
        gl.glPopMatrix();

        // Fist Arm
        gl.glPushMatrix();
        gl.glColor3f( 1.0f, 0.5f, 0.0f );
        gl.glTranslatef( 5.0f / 6.0f * Main.torsoRad, 0.0f, 0.0f );
        gl.glRotatef( 135f, 0.0f, 0.0f, -1.0f );
        Main.drawCylinder( drawable, Main.limbRad, Main.upperArmLen );
        gl.glColor3f( 1.0f, 0.5f, 0.0f );
        gl.glTranslatef( 0.0f, Main.upperArmLen, 0.0f );
        Main.drawSphere( Main.limbRad + .005f );
        gl.glColor3f( 1.0f, 0.0f, 0.0f );
        gl.glRotatef( Main.LelbowAngle2, 0.0f, 0.0f, -1.0f );
        Main.drawCylinder( drawable, Main.limbRad, Main.forearmLen );
        gl.glColor3f( 1.0f, 0.0f, 0.0f );
        gl.glTranslatef( 0.0f, Main.forearmLen, 0.0f );
        Main.drawSphere( Main.fistRad );
        gl.glPopMatrix();

        gl.glPopMatrix();
        gl.glPopMatrix();
    }
}
