package megaman;

import javax.media.opengl.GL2;
import javax.media.opengl.GLAutoDrawable;
import javax.media.opengl.glu.GLU;

public class Bullet {

    public GLU glu = Main.glu;
    private float dist;
    private float rotAngle;
    private float startX;
    private float startZ;

    public Bullet( float dist, float rotAngle, float startX, float startZ ) {
        this.dist = dist;
        this.rotAngle = rotAngle;
        this.startX = startX;
        this.startZ = startZ;
    }

    public float getDist() {
        return dist;
    }

    public float getRotAngle() {
        return rotAngle;
    }
    
    public float getStartX() {
        return startX;
    }
    
    public float getStartZ() {
        return startZ;
    }

    public float setDist( float newDist ) {
        float oldDist = dist;
        dist = newDist;
        return oldDist;
    }

    public float setRotAngle( float newRotAngle ) {
        float oldRotAngle = rotAngle;
        rotAngle = newRotAngle;
        return oldRotAngle;
    }

    public void updateBullets( GLAutoDrawable drawable ) {
        GL2 gl = drawable.getGL().getGL2();
        gl.glColor3f( 1.0f, 1.0f, 1.0f );
        gl.glPushMatrix();

        gl.glTranslatef( startX - Main.movedX, 0, startZ - Main.movedZ );
        gl.glRotatef( rotAngle, 0.0f, 1.0f, 0.0f );
        gl.glTranslatef( - 5.0f / 6.0f * Main.torsoRad, Main.shoulderH, Main.elbowToBlaster + Main.blasterLen1 + Main.blasterLen2 + dist);
        Main.drawSphere(Main.blasterRad2 );
        gl.glPopMatrix();
        dist += Main.bulletSpeed;
    }
}
