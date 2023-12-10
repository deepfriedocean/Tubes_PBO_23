import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class PlayerInput implements KeyListener {
    private PlayerPlane plane;

    public PlayerInput(PlayerPlane plane) {
        this.plane = plane;
    }
    @Override
    public void keyPressed(KeyEvent e) {
        plane.keyPressed(e);
    }

    @Override
    public void keyReleased(KeyEvent e) {
        plane.keyReleased(e);
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }
}