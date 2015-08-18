package net.azib.ipscan.gui.menu;

import dagger.Module;
import dagger.Provides;
import net.azib.ipscan.config.Platform;
import net.azib.ipscan.gui.actions.HelpMenuActions;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Decorations;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.Shell;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;

/**
 * @author Andriy Kryvtsun
 */
@Singleton
public class HelpMenu extends AbstractMenu {

	@Inject
	public HelpMenu(Shell parent,
					HelpMenuActions.GettingStarted gettingStarted,
					HelpMenuActions.Website website,
					HelpMenuActions.FAQ faq,
					HelpMenuActions.Plugins plugins,
					HelpMenuActions.CommandLineUsage commandLineUsage,
					HelpMenuActions.CheckVersion checkVersion,
					HelpMenuActions.About about) {

		super(parent, SWT.DROP_DOWN);

		initMenuItem(this, "menu.help.gettingStarted", !Platform.MAC_OS ? "F1" : null, Platform.MAC_OS ? SWT.HELP : SWT.F1, gettingStarted);
		initMenuItem(this, null, null, null, null);
		initMenuItem(this, "menu.help.website", null, null, website);
		initMenuItem(this, "menu.help.faq", null, null, faq);
		initMenuItem(this, "menu.help.plugins", null, null, plugins);
		initMenuItem(this, null, null, null, null);
		initMenuItem(this, "menu.help.cmdLine", null, null, commandLineUsage);

		if (!Platform.MAC_OS) {
			// mac will have these in the 'application' menu
			initMenuItem(this, null, null, null, null);
			initMenuItem(this, "menu.help.checkVersion", null, null, checkVersion);
			initMenuItem(this, null, null, null, null);
			initMenuItem(this, "menu.help.about", null, null, about);
		}
	}
}