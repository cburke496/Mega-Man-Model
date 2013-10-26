package megaman;

import org.eclipse.ui.IPageLayout;
import org.eclipse.ui.IPerspectiveFactory;

public class Perspective implements IPerspectiveFactory {

    /*
     * Puts the single JOGL view in the editor area.
     * @see org.eclipse.ui.IPerspectiveFactory#createInitialLayout(org.eclipse.ui.IPageLayout)
     */
    public void createInitialLayout(IPageLayout layout) {
        // editor area invisible to avoid empty editor frame below our view  
        layout.setEditorAreaVisible( false );
        layout.addView( "megaman.joglview", IPageLayout.TOP,
                        IPageLayout.RATIO_MAX, IPageLayout.ID_EDITOR_AREA);
        }
}
