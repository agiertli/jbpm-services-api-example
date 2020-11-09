package org.jbpm.example;

import org.jbpm.kie.services.impl.KModuleDeploymentUnit;
import org.jbpm.services.api.model.DeploymentUnit;
import org.jbpm.test.services.AbstractKieServicesTest;

import java.util.List;

public class ServiceAPIExample extends AbstractKieServicesTest {

    public static void main(String args[]) {

        ServiceAPIExample example = new ServiceAPIExample();
        example.configureServices();
        System.out.println("Services configured succesfully");
        KModuleDeploymentUnit deploymentUnit = new KModuleDeploymentUnit("com.myspace", "Test", "1.0.0-SNAPSHOT");
        example.deploymentService.deploy(deploymentUnit);
        System.out.println("Deployment finished");
        Long pid  = example.processService.startProcess(deploymentUnit.getIdentifier(),"Test.testProcess");
        System.out.println("Process started:"+pid); // it never gets here
        System.exit(-1);

    }

    protected DeploymentUnit prepareDeploymentUnit() throws Exception {
        return null;
    }

    protected List<String> getProcessDefinitionFiles() {
        return null;
    }
}
