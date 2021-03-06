package de.jcup.yamleditor.preferences;
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

/**
 * Constant definitions for plug-in preferences
 */
public enum YamlEditorSyntaxColorPreferenceConstants implements PreferenceIdentifiable, PreferenceLabeled{
	COLOR_NORMAL_TEXT("colorNormalText","Normal text color"),
	
	COLOR_RESERVED_KEYWORD("colorYamlKeywords", "Yaml keywords"),
	COLOR_BOOLEANS("colorBooleans","Booleans"),

	COLOR_GSTRING("colorDoubleStrings", "Double quoted strings"),
	COLOR_SINGLE_STRING("colorSingleStrings", "Quoted strings"),
	COLOR_COMMENT("colorComments", "Comment"),
	COLOR_MAPPINGS("colorMappings","Mappings"),
	COLOR_BLOCK("colorBlock","Block"),
	COLOR_TEMPLATE_VARIABLE("colorTemplateVariable","Template variable"),
	
	;

	private String id;
	private String labelText;

	private YamlEditorSyntaxColorPreferenceConstants(String id, String labelText) {
		this.id = id;
		this.labelText=labelText;
	}

	public String getLabelText() {
		return labelText;
	}
	
	public String getId() {
		return id;
	}

}
