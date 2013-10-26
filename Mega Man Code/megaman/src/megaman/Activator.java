package megaman;

import javax.media.opengl.GLProfile;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

/**
 * The activator class controls the plug-in life cycle
 */
public class Activator extends AbstractUIPlugin {

    // The plug-in ID
    public static final String PLUGIN_ID = "megaman"; //$NON-NLS-1$

    // The shared instance
    private static Activator plugin;
    
    // Needed to set up threading properly for JOGL on Linux systems. This
    // has to be done before any X11 calls, so it goes here in the class
    // Eclipse loads first.
    // NOTE: If you don't put this early enough, you'll probably get SIGSEGV
    // in libpthread.so (or other sorts of multithreading errors) when you
    // try to run the program.
    static {
        GLProfile.initSingleton();
    }

    /**
     * The constructor
     */
    public Activator() {
    }

    /*
     * (non-Javadoc)
     * @see org.eclipse.ui.plugin.AbstractUIPlugin#start(org.osgi.framework.BundleContext)
     */
    public void start(BundleContext context) throws Exception {
        super.start(context);
        plugin = this;
    }

    /*
     * (non-Javadoc)
     * @see org.eclipse.ui.plugin.AbstractUIPlugin#stop(org.osgi.framework.BundleContext)
     */
    public void stop(BundleContext context) throws Exception {
        plugin = null;
        super.stop(context);
    }

    /**
     * Returns the shared instance
     *
     * @return the shared instance
     */
    public static Activator getDefault() {
        return plugin;
    }

    /**
     * Returns an image descriptor for the image file at the given
     * plug-in relative path
     *
     * @param path the path
     * @return the image descriptor
     */
    public static ImageDescriptor getImageDescriptor(String path) {
        return imageDescriptorFromPlugin(PLUGIN_ID, path);
    }

    //================================================================
    /**
     * Opens an error dialog box and logs the error.
     * @param sDialogTitle Title of dialog box.
     * @param istatus Status object to get message from.
     */
    public static void openError( String sDialogTitle, IStatus istatus ) {
        ErrorDialog.openError( PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(),
                               sDialogTitle,
                               null,
                               istatus );
        Activator.getDefault().log( sDialogTitle + " : " + istatus.getMessage() );
    }

    //================================================================
    /**
     * Opens an "internal error" dialog box and logs the error.
     * @param exception Exception containing the message to put in the dialog box.
     */
    public static void openError( Exception exception ) {
        openError( "Internal error", new Status( Status.ERROR,
                                                 Activator.PLUGIN_ID,
                                                   exception.getMessage() != null
                                                 ? exception.getMessage()
                                                 : exception.getClass().toString() ) );
        Activator.getDefault().log( exception.getMessage(), exception );
    }

    //================================================================
    /**
     * Opens an error dialog box and logs the error.
     * @param sDialogTitle Dialog box title.
     * @param sMessage Message to put in dialog box.
     */
    public static void openError( String sDialogTitle, String sMessage ) {
        openError( sDialogTitle, new Status( Status.ERROR, Activator.PLUGIN_ID, sMessage ) );
        Activator.getDefault().log( sDialogTitle + " : " + sMessage );
    }

    //================================================================
    /**
     * Prints a message to the Eclipse log.
     *
     * @param sMessage Message to print.
     */
    public void log( String sMessage ) {
        log( sMessage, null );
    }

    //================================================================
    /**
     * Prints a message to the Eclipse log.
     *
     * @param sMessage Message to print.
     * @param exception Exception we're logging.
     */
    public void log( String sMessage, Exception exception ) {
        getLog().log( new Status( Status.INFO, PLUGIN_ID, Status.OK, sMessage, exception ) );
    }
}
