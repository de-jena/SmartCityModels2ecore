/**
 * Copyright (c) 2012 - 2018 Data In Motion and others.
 * All rights reserved. 
 * 
 * This program and the accompanying materials are made available under the terms of the 
 * Eclipse Public License v1.0 which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Data In Motion - initial API and implementation
 */
package org.gecko.smartmodels.command;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emfcloud.jackson.databind.EMFContext;
import org.gecko.smartmodels.apis.ecore.EcoreSmartModelGenerator;
import org.gecko.smartmodels.officiallist.model.officiallist.ModelRepo;
import org.gecko.smartmodels.officiallist.model.officiallist.OfficialListPackage;
import org.gecko.smartmodels.officiallist.model.officiallist.OfficialModelList;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(service=YamlToEcoreCommand.class, property= {
        "osgi.command.scope=yamltoecore",
        "osgi.command.function=generateEcore",
        "osgi.command.function=generateMultipleEcore",
        "osgi.command.function=downloadYamlModels"
        })
public class YamlToEcoreCommand {
	
	@Reference(target = "(component.name=EcoreSmartModelGeneratorFromYaml)")
	private EcoreSmartModelGenerator ecoreSmartModelGen;
	
	@Reference
	private OfficialListPackage officialModelListPackage;
	
	@Reference
	private ResourceSet resourceSet;
	
	private static final String BASE_PATH = System.getProperty("base.path");
	private static final String DATA_FOLDER = "/data/";
	private static final String YAML_FOLDER = "yaml/";
	private static final String WGET_COMMAND = "wget https://raw.githubusercontent.com/smart-data-models/";
	
	public void generateEcore(String pathToYamlInputFile, String pathToEcoreOutputFile) {
		ecoreSmartModelGen.generateEcoreSmartModel(BASE_PATH + DATA_FOLDER + pathToYamlInputFile, BASE_PATH + DATA_FOLDER + pathToEcoreOutputFile);
	}
	
	public void generateMultipleEcore(String pathToYamlInFolder, String pathToEcoreOutFolder) {
		ecoreSmartModelGen.generateEcoreSmartModels(BASE_PATH + pathToYamlInFolder, BASE_PATH + pathToEcoreOutFolder);
	}
	
	public void downloadYamlModels(String pathToOfficialModelList) {
		EClass eclass = (EClass) officialModelListPackage.getEClassifier("OfficialModelList");
		Resource inRes = resourceSet.createResource(URI.createFileURI(BASE_PATH + DATA_FOLDER + pathToOfficialModelList));
		try {
			Map<Object, Object> loadOptions = new HashMap<Object, Object>();
			loadOptions.put(EMFContext.Attributes.ROOT_ELEMENT, eclass);
			inRes.load(loadOptions);
			if(inRes.getContents() != null && !inRes.getContents().isEmpty()) {
				OfficialModelList officialModelList = (OfficialModelList) inRes.getContents().get(0);
				for(ModelRepo modelRepo : officialModelList.getOfficialList()) {
					String repoName = modelRepo.getRepoName();
					for(String dataModel : modelRepo.getDataModels()) {
						String fullGitFilePath = WGET_COMMAND + repoName + "/master/" + dataModel + "/model.yaml";
						String command = fullGitFilePath + " -O " + BASE_PATH + DATA_FOLDER + YAML_FOLDER + dataModel + ".yaml";
						System.out.println(command);
						executeShellCommand(command);
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}	
	}
	
	private void executeShellCommand(String command) {
		ProcessBuilder processBuilder = new ProcessBuilder();

		// -- Linux --

		// Run a shell command
		processBuilder.command("bash", "-c", command);

		// Run a shell script
		//processBuilder.command("path/to/hello.sh");

		// -- Windows --

		// Run a command
		//processBuilder.command("cmd.exe", "/c", "dir C:\\Users\\mkyong");

		// Run a bat file
		//processBuilder.command("C:\\Users\\mkyong\\hello.bat");

		try {

			Process process = processBuilder.start();

			StringBuilder output = new StringBuilder();

			BufferedReader reader = new BufferedReader(
					new InputStreamReader(process.getInputStream()));

			String line;
			while ((line = reader.readLine()) != null) {
				output.append(line + "\n");
			}

			int exitVal = process.waitFor();
			if (exitVal == 0) {
				System.out.println("Success!");
				System.out.println(output);
			} else {
				System.err.format("Something went wrong with %s" , command);
			}

		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}
}
