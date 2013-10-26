package megaman;

import org.eclipse.swt.graphics.Point;
import org.eclipse.ui.application.ActionBarAdvisor;
import org.eclipse.ui.application.IActionBarConfigurer;
import org.eclipse.ui.application.IWorkbenchWindowConfigurer;
import org.eclipse.ui.application.WorkbenchWindowAdvisor;

public class ApplicationWorkbenchWindowAdvisor extends WorkbenchWindowAdvisor {

    public ApplicationWorkbenchWindowAdvisor(IWorkbenchWindowConfigurer configurer) {
        super(configurer);
    }

    public ActionBarAdvisor createActionBarAdvisor(IActionBarConfigurer configurer) {
        return new ApplicationActionBarAdvisor(configurer);
    }
    
    public void preWindowOpen() {
        IWorkbenchWindowConfigurer iworkbenchwindowconfigurer = getWindowConfigurer();
        iworkbenchwindowconfigurer.setInitialSize( new Point( 40, 30) );
        iworkbenchwindowconfigurer.setShowCoolBar( false );
        iworkbenchwindowconfigurer.setShowStatusLine( true );
    }
}
