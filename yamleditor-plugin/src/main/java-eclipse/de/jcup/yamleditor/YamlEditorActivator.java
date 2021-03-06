/*
 * Copyright 2017 Albert Tregnaghi
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *		http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions
 * and limitations under the License.
 *
 */
package de.jcup.yamleditor;

import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

import de.jcup.eclipse.commons.PluginContextProvider;
import de.jcup.eclipse.commons.tasktags.AbstractConfigurableTaskTagsSupportProvider;
import de.jcup.eclipse.commons.templates.TemplateSupportProvider;
import de.jcup.eclipse.commons.ui.PluginContextProviderRegistry;
import de.jcup.yamleditor.templates.YamlEditorTemplateSupportConfig;

/**
 * The activator class controls the plug-in life cycle
 */
public class YamlEditorActivator extends AbstractUIPlugin implements PluginContextProvider {

	// The plug-in COMMAND_ID
	public static final String PLUGIN_ID = "de.jcup.yamleditor"; //$NON-NLS-1$

	// The shared instance
	private static YamlEditorActivator plugin;
	private ColorManager colorManager;
	private AbstractConfigurableTaskTagsSupportProvider taskSupportProvider;

    private TemplateSupportProvider templateSupportProvider;
	/**
	 * The constructor
	 */
	public YamlEditorActivator() {
		colorManager = new ColorManager();
		taskSupportProvider = new YamlTaskTagsSupportProvider(this) ;
		PluginContextProviderRegistry.register(this);
		templateSupportProvider = new TemplateSupportProvider(new YamlEditorTemplateSupportConfig(),this);
	}

	public ColorManager getColorManager() {
		return colorManager;
	}
	
	public AbstractConfigurableTaskTagsSupportProvider getTaskSupportProvider() {
		return taskSupportProvider;
	}

	public void start(BundleContext context) throws Exception {
		super.start(context);
		plugin = this;
		taskSupportProvider.getTodoTaskSupport().install();
	}

	public void stop(BundleContext context) throws Exception {
		plugin = null;
		colorManager.dispose();
		taskSupportProvider.getTodoTaskSupport().uninstall();
		super.stop(context);
	}

	/**
	 * Returns the shared instance
	 *
	 * @return the shared instance
	 */
	public static YamlEditorActivator getDefault() {
		return plugin;
	}

	@Override
	public AbstractUIPlugin getActivator() {
		return this;
	}

	@Override
	public String getPluginID() {
		return PLUGIN_ID;
	}

    public TemplateSupportProvider getTemplateSupportProvider() {
        return templateSupportProvider;
    }

}
